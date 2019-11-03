package Booking;

import Flight.Flight;

public class Booking {
    private Flight flight;
    private int date;
    private int price;
    private int serialNumber;
    private boolean Class;

    public boolean isClass() {
        return Class;
    }

    public void setClass(boolean aClass) {
        Class = aClass;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
