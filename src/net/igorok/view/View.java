package net.igorok.view;

import net.igorok.domain.entity.Bike;

public class View {
    public void showMainMenu() {
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
    }

    public void valueNotANumberButTheText(int maxMenuNumber) {
        System.out.println(
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                        "░  The entered value is not a number, but the text. ░\n" +
                        "░    Please choose the right number from 1 to " + maxMenuNumber + "     ░\n" +
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
    }

    public void printBikeRowFromCatalog(int i, String string) {
        System.out.println(i + " - " + string);
    }

    public void addFoldingBike() {
        System.out.println("You are going to add a new Folding Bike. \nPlease, follow the instruction:");
    }

    public void addSpeedelecBike() {
        System.out.println("You are going to add a new Speedelec Bike. \nPlease, follow the instruction:");
    }

    public void addEBike() {
        System.out.println("You are going to add a new Speedelec Bike. \nPlease, follow the instruction:");
    }

    public void setBrand() {
        System.out.println("A brand");
    }
    public void setMaxSpeed() {
        System.out.println("A maximum speed");
    }
    public void setBatteryCapacity() {
        System.out.println("A battery capacity");
    }

    public void setWheelsSize() {
        System.out.println("The size of the wheels (in inch)");
    }

    public void setGearsNumbere() {
        System.out.println("The number of gears");
    }

    public void setWeight() {
        System.out.println("The weight of the bike (in grams)");
    }

    public void setLightsAvailability() {
        System.out.println("The availability of lights at front and back (true/false)");
    }

    public void setColor() {
        System.out.println("A color");
    }

    public void setPrice() {
        System.out.println("The price");
    }

    public void commandSaveFileDeclined() {
        System.out.println("There is no new information for storing. The command declined.");
    }

    public void unsaveDataWarning() {
        System.out.println("You are going to close the application, but it has unsaved data.\n" +
                "Would you like to save it? (y/n): ");
    }

    public void goodBye() {
        System.out.println("Thank you for using our software. See you next time.");
    }

    public void wrongMenyNumber(int maxMenuNumber) {
        System.out.println(
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                        "░           Your number menu doesn`t exist.         ░\n" +
                        "░      Please choose the right one from 1 to " + maxMenuNumber + "      ░\n" +
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
    }

    public void operationCompletesSuccessfully() {
        System.out.println("Operation completes sucessfully!");
    }

    public void operationCompletesUnsuccessfully() {
        System.out.println("Operation completes sucessfully!");
    }

    public void findFirstBikeByBrand() {
        System.out.println("You are chosen to find the first bike of a particular brand.\n" +
                "Please, enter the brand you are looking for: ");
    }

    public void showTheBikeInfo(Bike bike) {
        bike.toString();
    }
}
