package service.Facade;

import factory.VehicleFactory;
import builder.VehicleBuilder;
import decorator.GPSDecorator;
import adapter.OldSensorAdapter;
import model.*;
import network.*;
import service.SupervisionCenter;
import user.User;

/**
 * Façade simplifiant l'utilisation du système.
 */
public class SystemFacade {
    private TransportNetwork network;
    private SupervisionCenter center = SupervisionCenter.getInstance();

    public SystemFacade(String networkName) {
        this.network = new TransportNetwork(networkName);
    }

    public Vehicle createVehicle(String type, int id) {
        return VehicleFactory.createVehicle(type, id);
    }

    public Vehicle buildVehicleWithBuilder(Vehicle v, Sensor... sensors) {
        VehicleBuilder b = new VehicleBuilder(v);
        for (Sensor s : sensors) b.withSensor(s);
        return b.build();
    }

    public Vehicle addGPSDecorator(Vehicle v) {
        return new GPSDecorator(v);
    }

    public void attachOldSensor(Vehicle v, OldSensor legacy) {
        OldSensorAdapter adapter = new OldSensorAdapter(legacy);
        v.addSensor(adapter);
    }

    public Line createLine(int id, String name, String itinerary) {
        Line line = new Line(id, name, itinerary);
        network.addLine(line);
        center.registerLine(line);
        return line;
    }

    public void addVehicleToLine(Line line, Vehicle v) {
        v.setMediator(center);
        line.addVehicle(v);
    }

    public void registerUser(User u) {
        center.addUser(u);
    }

    public TransportNetwork getNetwork() { return network; }
    public SupervisionCenter getCenter() { return center; }
}
