package service;

import model.Sensor;
import model.Vehicle;

/**
 * Interface Mediator pour coordonner les échanges.
 */
public interface Mediator {
    void notifyVehicleStateChange(Vehicle v);
    void notifyVehiclePosition(Vehicle v);
    void receiveSensorData(Vehicle v, Sensor s, double value);
}
