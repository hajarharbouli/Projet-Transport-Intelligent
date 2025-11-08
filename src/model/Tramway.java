package model;

public class Tramway extends Vehicle {
    public Tramway(int id) { super(id, "Tramway"); }

    @Override public void startService() { setState("enService"); }
    @Override public void stopService() { setState("horsService"); }
}

