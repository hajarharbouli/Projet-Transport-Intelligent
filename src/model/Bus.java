package model;

public class Bus extends Vehicle {
    public Bus(int id) { super(id, "Bus"); }

    @Override public void startService() { setState("enService"); }
    @Override public void stopService() { setState("horsService"); }
}

