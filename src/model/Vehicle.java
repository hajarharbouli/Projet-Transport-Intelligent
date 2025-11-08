package model;

import java.util.ArrayList;
import java.util.List;

import service.Mediator; 

public abstract class Vehicle {
    protected int id;
    protected String type;
    protected String state;
    protected String position;
    protected List<Sensor> sensors = new ArrayList<>();
    protected Mediator mediator;

    public Vehicle(int id, String type) {
        this.id = id;
        this.type = type;
        this.state = "horsService";
        this.position = "inconnue";
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public String getState() { return state; }
    public String getPosition() { return position; }

    public void setMediator(Mediator m) { this.mediator = m; }

    public void setState(String s) {
        this.state = s;
        if (mediator != null) mediator.notifyVehicleStateChange(this);
    }

    public void setPosition(String p) {
        this.position = p;
        if (mediator != null) mediator.notifyVehiclePosition(this);
    }

    public void addSensor(Sensor s) {
        sensors.add(s);
        s.setOwner(this);
    }

    public void removeSensor(Sensor s) { sensors.remove(s); }

    public void readSensors() {
        for (Sensor s : sensors) {
            double v = s.readData();
            if (mediator != null) mediator.receiveSensorData(this, s, v);
        }
    }
    
    public List<Sensor> getSensors() {
        return sensors;
    }

    public abstract void startService();
    public abstract void stopService();

    @Override
    public String toString() {
        return "[" + type + " id:" + id + " état:" + state + " pos:" + position + "]";
    }
}
