package net.igorok.domain.entity;

public class EBike extends Bike {
    int maxSpeed;
    int batteryCapacity;

    public EBike() {
        super();
    }

    @Override
    protected String createLine() {
        return getBrand() + "; " + maxSpeed + "; " + weight + ";" + isLightsInstalled + "; " + batteryCapacity + "; " + color + "; " + price;
    }

    @Override
    public String catalogString() {
        return brand + " with " + batteryCapacity + " mAh battery and " + printIsLightsInstalled(isLightsInstalled) + "head/tail light.\nPrice: " + price + " euros.";
    }

    @Override
    public void setWheelsSize(int wheelsSize) {
        //not used
    }


    @Override
    protected void setGearsQty(int gearsQuantity) {
        // Not used
    }

    @Override
    public String getBrand() {
        return brand;
    }

//    public EBike(String brand, int maxSpeed, int weight, boolean isLightsInstalled, int batteryCapacity, String colour, int price) {
//        super(brand, weight, colour, price, isLightsInstalled);
//        this.maxSpeed = maxSpeed;
//        this.batteryCapacity = batteryCapacity;
//    }

    public EBike(String[] array) {
        super(array[0], Integer.parseInt(array[2]), array[5], Integer.parseInt(array[6]), Boolean.parseBoolean(array[3]));
        this.maxSpeed = Integer.parseInt(array[1]);
        this.batteryCapacity = Integer.parseInt(array[4]);
    }

//    public double getMaxSpeed() {
//        return maxSpeed;
//    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

//    public double getBatteryCapacity() {
//        return batteryCapacity;
//    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return "EBike{" +
                "model='" + brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", batteryCapacity=" + batteryCapacity +
                ", weight=" + weight +
                ", colour='" + color + '\'' +
                ", price='" + price + '\'' +
                ", isLightsInstalled=" + isLightsInstalled +
                '}';
    }
}