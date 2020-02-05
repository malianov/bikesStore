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

    public void setFoldingBikeWheelsSize(int wheelsSize) {
        setWheelsSize(wheelsSize);
    }

    public void setFoldingBikeGearsQuantity(int gearsQuantity) {
        setGearsQty(gearsQuantity);
    }

    public String createLineWithBikeData() {
        return createLine();
    }

    protected abstract String createLine();
    protected abstract String catalogString();
    protected abstract void setWheelsSize(int wheelsSize);
    protected abstract void setGearsQty(int gearsQuantity);

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

    public double getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isLightsInstalled() {
        return isLightsInstalled;
    }
    public String printIsLightsInstalled(boolean isLightsInstalled) {
        return isLightsInstalled ? "" : "no ";
    }
    public void setLightsInstalled(boolean lightsInstalled) {
        isLightsInstalled = lightsInstalled;
    }
}
