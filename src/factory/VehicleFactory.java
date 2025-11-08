package factory;

import model.*;

public class VehicleFactory {

    /**
     * Crée un véhicule concret selon le type.
     * Lance IllegalArgumentException si le type n'est pas supporté.
     */
    public static Vehicle createVehicle(String type, int id) {
        switch (type.toLowerCase()) {
            case "bus": return new Bus(id);
            case "tramway": return new Tramway(id);
            case "taxi": return new Taxi(id);
            case "bike": return new Bike(id);
            default:
                throw new IllegalArgumentException("Type de véhicule inconnu: " + type);
        }
    }
}

