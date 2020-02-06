package net.igorok.controller;

import net.igorok.domain.entity.Bike;
import net.igorok.domain.entity.EBike;
import net.igorok.domain.entity.FoldingBike;
import net.igorok.domain.entity.Speedelec;
import net.igorok.model.Model;
import net.igorok.view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    Bike foldingBike = new FoldingBike();
    Bike speedelec = new Speedelec();
    Bike eBike = new EBike();

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void readingInputFile(String[] args) {

        model.readInputFile(args);
        model.calculateQuantityOfLinesInInputFile();
        model.createBikesCatalog();
    }

    public void showMenu() {

        do {
            view.showMainMenu();
            Scanner userScannerInput = new Scanner(System.in);
            while (!userScannerInput.hasNextInt()) {
                view.valueNotANumberButTheText(model.getMAX_MENU_NUMBER());
                userScannerInput.nextInt();
            }

            int userInput = userScannerInput.nextInt();

            try {
                switch (userInput) {
                    case 1:
                        model.showEntireEcoBikeCatalog();
                        break;
                    case 2:
                        view.addFoldingBike();
                        view.setBrand();
                        userScannerInput.nextLine();
                        foldingBike.setBrand(userScannerInput.nextLine());
                        view.setWheelsSize();
                        foldingBike.setWheelsSize(userScannerInput.nextInt());
                        view.setGearsNumbere();
                        foldingBike.setFoldingBikeGearsQuantity(userScannerInput.nextInt());
                        view.setWeight();
                        foldingBike.setWeight(userScannerInput.nextInt());
                        view.setLightsAvailability();
                        foldingBike.setLightsInstalled(userScannerInput.nextBoolean());
                        view.setColor();
                        foldingBike.setColor(userScannerInput.next());
                        view.setPrice();
                        foldingBike.setPrice(userScannerInput.nextInt());
                        model.addBikeToCatalog(foldingBike);
                        model.addLineToLinesArrayList(foldingBike);
                        model.setItIsRequiredToSaveTheFile(true);
                        break;
                    case 3:
                        view.addSpeedelecBike();
                        view.setBrand();
                        userScannerInput.nextLine();
                        speedelec.setBrand(userScannerInput.nextLine());
                        view.setMaxSpeed();
                        speedelec.setElectroMaxSpeed(userScannerInput.nextInt());
                        view.setBatteryCapacity();
                        speedelec.setElectroBatteryCapacity(userScannerInput.nextInt());
                        view.setWeight();
                        speedelec.setWeight(userScannerInput.nextInt());
                        view.setLightsAvailability();
                        speedelec.setLightsInstalled(userScannerInput.nextBoolean());
                        view.setColor();
                        speedelec.setColor(userScannerInput.next());
                        view.setPrice();
                        speedelec.setPrice(userScannerInput.nextInt());
                        model.addBikeToCatalog(speedelec);
                        model.addLineToLinesArrayList(speedelec);
                        model.setItIsRequiredToSaveTheFile(true);
                        break;
                    case 4:
                        view.addEBike();
                        view.setBrand();
                        userScannerInput.nextLine();
                        eBike.setBrand(userScannerInput.nextLine());
                        view.setMaxSpeed();
                        eBike.setElectroMaxSpeed(userScannerInput.nextInt());
                        view.setBatteryCapacity();
                        eBike.setElectroBatteryCapacity(userScannerInput.nextInt());
                        view.setWeight();
                        eBike.setWeight(userScannerInput.nextInt());
                        view.setLightsAvailability();
                        eBike.setLightsInstalled(userScannerInput.nextBoolean());
                        view.setColor();
                        eBike.setColor(userScannerInput.next());
                        view.setPrice();
                        eBike.setPrice(userScannerInput.nextInt());
                        model.addBikeToCatalog(eBike);
                        model.addLineToLinesArrayList(eBike);
                        model.setItIsRequiredToSaveTheFile(true);
                        break;
                    case 5:
                        view.findFirstBikeByBrand();
                        if (model.findFirstBikeByBrand(userScannerInput.next())) {

                            view.operationCompletesSuccessfully();
                        } else {
                            view.operationCompletesUnsuccessfully();
                        }


                        break;
                    case 6:
                        if (model.getItIsRequiredToSaveTheFile() == true) {
                            model.saveFile();
                            model.setItIsRequiredToSaveTheFile(false);
                            break;
                        }
                        view.commandSaveFileDeclined();
                        break;
                    case 7:
                        if (model.getItIsRequiredToSaveTheFile() == true) {
                            view.unsaveDataWarning();
                            if (userScannerInput.next() == "y") {
                                model.saveFile();
                            }
                        }
                        view.goodBye();
                        model.closeApplication();
                        break;
                    default:
                        view.wrongMenyNumber(model.getMAX_MENU_NUMBER());
                }
            } catch (
                    NumberFormatException e) {
            }
        }
        while (true);
    }
}