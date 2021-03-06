package net.igorok.domain.entity;

public abstract class Bike {
    String brand;
    int weight;
    String color;
    int price;
    boolean isLightsInstalled;

    public Bike() {

    }


    public String printFromCatalog() {
        return catalogString();
    }

    public void setFoldingBikeGearsQuantity(int gearsQuantity) {
        setGearsQty(gearsQuantity);
    }

    public String createLineWithBikeData() {
        return createLine();
    }

    public void setElectroMaxSpeed(int maxSpeed) {
        setMaxSpeed(maxSpeed);
    }

    public void setElectroBatteryCapacity(int batteryCapacity) {
        setBatteryCapacity(batteryCapacity);
    }

    protected abstract String createLine();
    protected abstract String catalogString();
    public abstract void setWheelsSize(int wheelsSize);
    protected abstract void setGearsQty(int gearsQuantity);
    protected abstract void setMaxSpeed(int maxSpeed);
    protected abstract void setBatteryCapacity(int batteryCapacity);

    public Bike(String brand, int weight, String color, int price, boolean isLightsInstalled) {
        this.brand = brand;
        this.weight = weight;
        this.color = color;
        this.price = price;
        this.isLightsInstalled = isLightsInstalled;
    }

    public abstract String getBrand();

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String printIsLightsInstalled(boolean isLightsInstalled) {
        return isLightsInstalled ? "" : "no ";
    }
    public void setLightsInstalled(boolean lightsInstalled) {
        isLightsInstalled = lightsInstalled;
    }
}
