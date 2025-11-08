package network;

import model.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente une ligne contenant plusieurs véhicules (composant feuille).
 */
public class Line implements LineComponent {
    private int id;
    private String name;
    private String itinerary;
    private List<Vehicle> vehicles = new ArrayList<>();

    public Line(int id, String name, String itinerary) {
        this.id = id;
        this.name = name;
        this.itinerary = itinerary;
    }

    @Override
    public void add(LineComponent c) {
        throw new UnsupportedOperationException("Line n'accepte pas d'autres LineComponent directement.");
    }

    @Override
    public void remove(LineComponent c) {
        throw new UnsupportedOperationException("remove non supporté pour Line (utiliser removeVehicle).");
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void removeVehicle(Vehicle v) {
        vehicles.remove(v);
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getItinerary() {
        return itinerary;
    }

    @Override
    public String toString() {
        return "Line{" + "id=" + id + ", name='" + name + '\'' + ", vehicles=" + vehicles + '}';
    }
}

