package model;

public interface Sensor {
    double readData();
    String getType();
    void setOwner(Vehicle v);
    Vehicle getOwner();
}

