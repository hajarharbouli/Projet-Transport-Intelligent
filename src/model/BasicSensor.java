package model;

import java.util.concurrent.ThreadLocalRandom;

public class BasicSensor implements Sensor {
    private int id;
    private String type;
    private Vehicle owner;

    public BasicSensor(int id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public double readData() {
        return ThreadLocalRandom.current().nextDouble(0,100);
    }

    @Override public String getType() { return type; }
    @Override public void setOwner(Vehicle v) { owner = v; }
    @Override public Vehicle getOwner() { return owner; }

    @Override
    public String toString() { return "Sensor{" + id + "," + type + "}"; }
}
