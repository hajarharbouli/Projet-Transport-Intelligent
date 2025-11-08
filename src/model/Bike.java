package model;

public class Bike extends Vehicle {
    public Bike(int id) { super(id, "Bike"); }

    @Override public void startService() { setState("enService"); }
    @Override public void stopService() { setState("horsService"); }
}

