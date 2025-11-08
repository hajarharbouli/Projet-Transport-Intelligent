package main;

import service.Facade.SystemFacade;
import model.*;
import network.Line;
import user.User;
import service.payment.*;

public class Main {
    public static void main(String[] args) {
        SystemFacade facade = new SystemFacade("CityNet");

        // create lines
        Line lineA = facade.createLine(1, "Ligne A", "Station1 -> Station2 -> Station3");
        Line lineB = facade.createLine(2, "Ligne B", "StationX -> StationY");

        // create vehicles
        Vehicle bus1 = facade.createVehicle("Bus", 101);
        bus1.setPosition("Station1");
        bus1.addSensor(new BasicSensor(1, "Occupancy"));
        facade.addVehicleToLine(lineA, bus1);

        Vehicle tram1 = facade.createVehicle("Tramway", 201);
        tram1 = facade.addGPSDecorator(tram1);
        tram1.setPosition("StationX");
        tram1.addSensor(new BasicSensor(2, "Temperature"));
        facade.addVehicleToLine(lineB, tram1);

        // attach legacy sensor
        OldSensor legacy = new OldSensor(77, "LegacyMotion");
        facade.attachOldSensor(bus1, legacy);

        // register users
        User alice = new User("u01", "Alice");
        User bob = new User("u02", "Bob");
        facade.registerUser(alice);
        facade.registerUser(bob);

        // start services
        bus1.startService();
        tram1.startService();

        // supervision collects data (sensors read)
        facade.getCenter().collectData();

        // simulate a payment flow
        PaymentRequest req = new PaymentRequest("u01", 2.5);
        PaymentProcessor processor = new PaymentProcessor();
        AccessVerifier verifier = new AccessVerifier();
        SecurityChecker checker = new SecurityChecker();
        processor.setNext(verifier).setNext(checker);
        processor.handle(req);

        // update position to trigger notification
        bus1.setPosition("Station2");

        // show network status
        facade.getNetwork().printStatus();
    }
}

