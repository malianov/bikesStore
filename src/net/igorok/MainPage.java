package net.igorok;

import net.igorok.domain.entity.Bike;
import net.igorok.domain.entity.EBike;
import net.igorok.domain.entity.FoldingBike;
import net.igorok.domain.entity.Speedelec;
import net.igorok.domain.valueobjects.Vendor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MainPage {
    public static void main(String[] args) throws IOException {
        boolean isItRequiredToSaveTheFile = false;

        String inputFile = "ecobike.txt";
        int ROWS_PER_PAGE = 100;

        if (args.length > 0) {
            inputFile = args[0];
        }

        List<String> rawLinesInOriginalFile = Files.readAllLines(Path.of(inputFile));
        int quantityOfLines = rawLinesInOriginalFile.size();
        List<Bike> bikesCatalog = new ArrayList<>(quantityOfLines);

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

        final int MAX_MENU_NUMBER = 7;

        do {
            System.out.println(
                    "╔═══════════════════════════════════════════════╗\n" +
                            "║           Please make your choice:            ║\n" +
                            "╟╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╶╢\n" +
                            "║ 1 - Show the entire EcoBike catalog           ║\n" +
                            "║ 2 – Add a new folding bike                    ║\n" +
                            "║ 3 – Add a new speedelec                       ║\n" +
                            "║ 4 – Add a new e-bike                          ║\n" +
                            "║ 5 – Find the first item of a particular brand ║\n" +
                            "║ 6 – Write to file                             ║\n" +
                            "║ 7 – Stop the program                          ║\n" +
                            "╚═══════════════════════════════════════════════╝\n" +
                            "Enter from 1 to 7: ");

            Scanner userScannerInput = new Scanner(System.in);

            while (!userScannerInput.hasNextInt()) {
                System.out.println(
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                                "░  The entered value is not a number, but the text. ░\n" +
                                "░    Please choose the right number from 1 to " + MAX_MENU_NUMBER + "     ░\n" +
                                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                userScannerInput.nextInt();
            }

            int userInput = userScannerInput.nextInt();

            try {
                switch (userInput) {
                    case 1:
                        int quantityOfPages = (int) Math.ceil(bikesCatalog.size() / ROWS_PER_PAGE);

                        for (int k = 1; k <= quantityOfPages; k++) {
                            for (int i = 0 * ROWS_PER_PAGE; i < k * ROWS_PER_PAGE; i++) {
                                if (bikesCatalog.get(i).getBrand()
                                        .startsWith(Vendor.FOLDING_BIKE.getName())) {
                                    System.out.println(i + " - " + bikesCatalog.get(i).printFromCatalog());
                                }
                                if (bikesCatalog.get(i).getBrand()
                                        .startsWith(Vendor.SPEEDELEC.getName())) {
                                    System.out.println(i + " - " + bikesCatalog.get(i).printFromCatalog());

                                }
                                if (bikesCatalog.get(i).getBrand()
                                        .startsWith(Vendor.E_BIKE.getName())) {
                                    System.out.println(i + " - " + bikesCatalog.get(i).printFromCatalog());
                                }
                            }
                            pressAnyKeyToContinue(k, quantityOfPages);
                        }
                        break;
                    case 2:
                        System.out.println("2");
                        System.out.println("You are going to add a new Folding Bike. \nPlease, follow the invitation:");

                        Bike newFoldingBike = new FoldingBike();

                        System.out.println("A brand");
                        newFoldingBike.setBrand(userScannerInput.next());

                        System.out.println("The size of the wheels (in inch)");
                        newFoldingBike.setFoldingBikeWheelsSize(userScannerInput.nextInt());

                        System.out.println("The number of gears");
                        newFoldingBike.setFoldingBikeGearsQuantity(userScannerInput.nextInt());

                        System.out.println("The weight of the bike (in grams)");
                        newFoldingBike.setWeight(userScannerInput.nextInt());

                        System.out.println("The availability of lights at front and back (true/false)");
                        newFoldingBike.setLightsInstalled(userScannerInput.nextBoolean());

                        System.out.println("A color");
                        newFoldingBike.setColor(userScannerInput.next());

                        System.out.println("The price");
                        newFoldingBike.setPrice(userScannerInput.nextInt());


                        System.out.println("size - " + rawLinesInOriginalFile.size());
                        bikesCatalog.add(newFoldingBike);
                        rawLinesInOriginalFile.add(newFoldingBike.createLineWithBikeData());
                        isItRequiredToSaveTheFile = true;
                        break;
                    case 3:
                        System.out.println("3");
                        break;
                    case 4:
                        System.out.println("4");
                        break;
                    case 5:
                        System.out.println("5");
                        String value = "";
                        Map<String, String> values = new HashMap<>();

                        System.out.println("You are going to find the first item of a particular brand (and additional parameters, if required).\n" +
                                "Please, enter the brand you are looking for: ");
                        userScannerInput.nextLine();
                        String brandNameForFind = userScannerInput.nextLine();

                        Optional<Bike> firstBikeBasedOnSearch;

                        System.out.println("brandNameForFind = " + brandNameForFind);

                        // The feature below not complete. I go to sleep.
//                        System.out.println("Are you going to add additional parameters for search? (y/n)");
//                        if (userScannerInput.next() == "n") {
                        firstBikeBasedOnSearch =
                                bikesCatalog.stream()
                                        .filter(x -> x.getBrand().equals(brandNameForFind))
                                        .findFirst();
//                        } else {
//                            if(brandNameForFind.startsWith(Vendor.FOLDING_BIKE.getName())) {
//                                String[] filter = new String[]{"wheelsSize", "gearsQuantity", "weight", "isLightsInstalled", "color", "price"};
//                                for(String searchValue : filter) {
//                                    System.out.println("Put the value for search (or leave the blank): " + searchValue);
//                                    if(userScannerInput.hasNext()) {
//                                        value = userScannerInput.next();
//                                        values.put(searchValue, value);
//                                    }
//                                }
//                                System.out.println("values = " + values);
//                            }
//                            if(brandNameForFind.startsWith(Vendor.SPEEDELEC.getName())) {
//                                String[] filter = new String[]{"maxSpeed", "weight", "isLightsInstalled", "batteryCapacity", "color", "price"};
//                            }
//                            if(brandNameForFind.startsWith(Vendor.E_BIKE.getName())) {
//                                String[] filter = new String[]{"maxSpeed", "weight", "isLightsInstalled", "batteryCapacity", "color", "price"};
//                            }
//                            firstBikeBasedOnSearch = null;
                        //                       }

//                        if (firstBikeBasedOnSearch.isPresent()) {
                        System.out.println(firstBikeBasedOnSearch.get().printFromCatalog());
//                        } else {
//                            System.out.println("Such Bike doesn't exist inside catalog");
//                        }


                        break;
                    case 6:
                        System.out.println("6");
                        if (isItRequiredToSaveTheFile == true) {
                            Files.write(Path.of(inputFile), rawLinesInOriginalFile);
                            isItRequiredToSaveTheFile = false;
                            break;
                        }
                        System.out.println("There is no new information for storing. The command declined.");
                        break;
                    case 7:
                        System.out.println("7");
                        if (!isItRequiredToSaveTheFile) {
                            System.out.println("You are going to close the application, but it has unsaved data.\n" +
                                    "Would you like to save it? (y/n): ");
                            if (userScannerInput.next() == "y") {
                                Files.write(Path.of(inputFile), rawLinesInOriginalFile);
                            }
                            System.out.println("Thank you for using our software. See you next time.");
                            Runtime.getRuntime().exit(0);
                            break;
                        }

                        break;
                    default:
                        System.out.println(
                                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                                        "░           Your number menu doesn`t exist.         ░\n" +
                                        "░      Please choose the right one from 1 to " + MAX_MENU_NUMBER + "      ░\n" +
                                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                }
            } catch (
                    NumberFormatException e) {
            }
        }
        while (true);
    }

    protected static void pressAnyKeyToContinue(int k, int quantityOfPages) {
        System.out.println("\nPage " + k + " from " + quantityOfPages + ". \nPress Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}