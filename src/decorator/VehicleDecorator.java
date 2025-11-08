package decorator;

import model.Vehicle;
import service.Mediator;
import model.Sensor;
import java.util.List;

/**
 * Decorator de base pour Vehicle.
 * Remarque : ici on étend Vehicle pour garder l'API, mais on délègue la plupart des appels.
 */
public abstract class VehicleDecorator extends Vehicle {
    protected Vehicle decorated;

    public VehicleDecorator(Vehicle decorated) {
        super(decorated.getId(), decorated.getType());
        this.decorated = decorated;
        // ne pas réaffecter la liste directement
        this.state = decorated.getState();
        this.position = decorated.getPosition();
        // supprimer: this.sensors = decorated.getSensors();
    }

    @Override
    public void setMediator(Mediator m) {
        super.setMediator(m);
        decorated.setMediator(m);
    }

    // délégations de méthodes liées aux capteurs si nécessaire
    @Override
    public void addSensor(Sensor s) {
        decorated.addSensor(s);
    }

    @Override
    public void removeSensor(Sensor s) {
        decorated.removeSensor(s);
    }

    // si tu veux exposer la liste des sensors par délégation (optionnel)
    public List<Sensor> getDecoratedSensors() {
        return decorated.getSensors(); // nécessite getSensors() public dans Vehicle
    }

    // délégation par défaut des services
    @Override public void startService() { decorated.startService(); }
    @Override public void stopService()  { decorated.stopService(); }

    @Override
    public String toString() {
        return decorated.toString();
    }
}


