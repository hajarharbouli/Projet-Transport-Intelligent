package adapter;

import model.*;

/**
 * Adapter pour rendre un OldSensor compatible avec l'interface Sensor.
 */
public class OldSensorAdapter implements Sensor {
    private model.OldSensor legacy;
    private Vehicle owner;

    public OldSensorAdapter(model.OldSensor legacy) {
        this.legacy = legacy;
    }

    @Override
    public double readData() {
        return legacy.legacyRead();
    }

    @Override
    public String getType() {
        return "Adapted-" + legacy.getLegacyType();
    }

    @Override
    public void setOwner(Vehicle v) {
        this.owner = v;
    }

    @Override
    public Vehicle getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "OldSensorAdapter{" + legacy.getLegacyType() + "}";
    }
}

