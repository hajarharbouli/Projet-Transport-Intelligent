package builder;

import model.Vehicle;
import model.Sensor;

/**
 * Builder simple qui permet d'ajouter des capteurs et positionner le véhicule.
 * Utilise un Vehicle déjà instancié (par la Factory par exemple).
 */
public class VehicleBuilder {
    private Vehicle vehicle;

    public VehicleBuilder(Vehicle v) {
        this.vehicle = v;
    }

    public VehicleBuilder withSensor(Sensor s) {
        vehicle.addSensor(s);
        return this;
    }

    public VehicleBuilder withPosition(String pos) {
        vehicle.setPosition(pos);
        return this;
    }

    public Vehicle build() {
        return vehicle;
    }
}
