package decorator;

import model.BasicSensor;
import model.Vehicle;

/**
 * Décorateur ajoutant un capteur GPS simulé.
 */
public class GPSDecorator extends VehicleDecorator {

    public GPSDecorator(Vehicle decorated) {
        super(decorated);
        // ajout d'un capteur GPS (id arbitraire)
        decorated.addSensor(new BasicSensor(9999, "GPS"));
    }

    @Override
    public String toString() {
        return decorated.toString() + " +GPS";
    }
}

