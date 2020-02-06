package net.igorok.domain.entity;

public class FoldingBike extends Bike {
    int wheelsSize;
    int gearsQuantity;

    public FoldingBike(String[] array) {
        super(array[0], Integer.parseInt(array[3]), array[5], Integer.parseInt(array[6]), Boolean.parseBoolean(array[4]));
        this.wheelsSize = Integer.parseInt(array[1]);
        this.gearsQuantity = Integer.parseInt(array[2]);
    }

    public FoldingBike() {
        super();
    }

    public void setWheelsSize(int wheelsSize) {
        this.wheelsSize = wheelsSize;
    }

    public void setGearsQty(int gearsNumber) {
        this.gearsQuantity = gearsNumber;
    }

    @Override
    protected void setMaxSpeed(int maxSpeed) {
        // Not used
    }

    @Override
    protected void setBatteryCapacity(int batteryCapacity) {
        // Not used
    }

    @Override
    protected String createLine() {
        return brand + "; " + wheelsSize + "; " + gearsQuantity + "; " + weight + "; " + isLightsInstalled + "; " + color + "; " + price;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String catalogString() {
        return brand + " with " + gearsQuantity + " gear(s) and " + printIsLightsInstalled(isLightsInstalled) + "head/tail light.\nPrice: " + price + " euros.";
    }

    @Override
    public String toString() {
        return "FoldingBike{" +
                "brand='" + brand + '\'' +
                ", wheelsSize=" + wheelsSize +
                ", gearsQuantity=" + gearsQuantity +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", isLightsInstalled=" + isLightsInstalled +
                '}';
    }
}