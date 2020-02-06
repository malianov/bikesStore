package net.igorok.model;

import net.igorok.domain.entity.Bike;
import net.igorok.domain.entity.EBike;
import net.igorok.domain.entity.FoldingBike;
import net.igorok.domain.entity.Speedelec;
import net.igorok.domain.valueobjects.Vendor;
import net.igorok.view.View;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Model {

    private final int MAX_MENU_NUMBER = 7;
    private String inputFile;
    private List<String> rawLinesInOriginalFile = null;
    private int quantityOfLines;
    private List<Bike> bikesCatalog = null;
    private int ROWS_PER_PAGE = 100;


    boolean isItRequiredToSaveTheFile = false;
    Optional<Bike> firstBikeBasedOnSearch;

    View view = new View();

/*
    private void addFoldingBike() {
    }

    private void addSpeedelec() {
    }

    private void EBike() {
    }
*/


    public String getInputFile() {
        return inputFile;
    }

    public int getMAX_MENU_NUMBER() {
        return MAX_MENU_NUMBER;
    }

    protected void pressAnyKeyToContinue(int k, int quantityOfPages) {
        System.out.println("\nPage " + k + " from " + quantityOfPages + ". \nPress Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    public void showEntireEcoBikeCatalog() {
        int quantityOfPages = (int) Math.ceil(bikesCatalog.size() / ROWS_PER_PAGE);

        for (int k = 1; k <= quantityOfPages; k++) {
            for (int i = 0 * ROWS_PER_PAGE; i < k * ROWS_PER_PAGE; i++) {
                if (bikesCatalog.get(i).getBrand().startsWith(Vendor.FOLDING_BIKE.getName())) {
                    view.printBikeRowFromCatalog(i, bikesCatalog.get(i).printFromCatalog());
                }
                if (bikesCatalog.get(i).getBrand().startsWith(Vendor.SPEEDELEC.getName())) {
                    view.printBikeRowFromCatalog(i, bikesCatalog.get(i).printFromCatalog());

                }
                if (bikesCatalog.get(i).getBrand().startsWith(Vendor.E_BIKE.getName())) {
                    view.printBikeRowFromCatalog(i, bikesCatalog.get(i).printFromCatalog());
                }
            }
            pressAnyKeyToContinue(k, quantityOfPages);
        }
    }

    public void createBikesCatalog() {
        bikesCatalog = new ArrayList<>(quantityOfLines);

        rawLinesInOriginalFile.stream()
                .forEach(row -> {
                    if (row.startsWith(Vendor.FOLDING_BIKE.getName())) {
                        String[] foldingBikeArray = row.split("; ");
                        Bike foldingBike = new FoldingBike(foldingBikeArray);
                        bikesCatalog.add(foldingBike);
                    }
                    if (row.startsWith(Vendor.SPEEDELEC.getName())) {
                        String[] speedelecArray = row.split("; ");
                        Bike speedelec = new Speedelec(speedelecArray);
                        bikesCatalog.add(speedelec);
                    }
                    if (row.startsWith(Vendor.E_BIKE.getName())) {
                        String[] eBikeArray = row.split("; ");
                        Bike eBike = new EBike(eBikeArray);
                        bikesCatalog.add(eBike);
                    }
                });
    }

    public void calculateQuantityOfLinesInInputFile() {
        quantityOfLines = rawLinesInOriginalFile.size();
    }

    public void readInputFile(String[] args) {
        inputFile = "ecobike.txt";
        if (args.length > 0) {
            inputFile = args[0];
        }

        try {
            rawLinesInOriginalFile = Files.readAllLines(Path.of(inputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean addBikeToCatalog(Bike bike) {
        int oldCatalogSize = bikesCatalog.size();
        bikesCatalog.add(bike);
        if(bikesCatalog.size() > oldCatalogSize) {
            view.operationCompletesSuccessfully();
            return true;
        }
        view.operationCompletesUnsuccessfully();
        return false;
    }

    public boolean getItIsRequiredToSaveTheFile() {
        return isItRequiredToSaveTheFile;
    }

    public void setItIsRequiredToSaveTheFile(boolean predicate) {
        isItRequiredToSaveTheFile = predicate;
    }

    public void saveFile() {
        try {
            Files.write(Path.of(inputFile), rawLinesInOriginalFile);
            view.operationCompletesSuccessfully();
        } catch (IOException e) {
            e.printStackTrace();
        }
        isItRequiredToSaveTheFile = false;
    }

    public void addLineToLinesArrayList(Bike bike) {
        rawLinesInOriginalFile.add(bike.createLineWithBikeData());
    }

    public void closeApplication() {
        Runtime.getRuntime().exit(0);
    }

    public boolean findFirstBikeByBrand(String brandNameToFind) {
        firstBikeBasedOnSearch =
                bikesCatalog.stream()
                        .filter(x -> x.getBrand().equals(brandNameToFind))
                        .findFirst();
        if(firstBikeBasedOnSearch != null) {
            view.showTheBikeInfo(firstBikeBasedOnSearch.get());
            return true;
        } else {
            return false;
        }
    }
}
