package model;

public class Taxi extends Vehicle {
    public Taxi(int id) { super(id, "Taxi"); }

    @Override public void startService() { setState("enService"); }
    @Override public void stopService() { setState("horsService"); }
}
