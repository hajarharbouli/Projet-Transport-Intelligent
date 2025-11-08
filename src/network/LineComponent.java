package network;

import model.Vehicle;
import java.util.List;

/**
 * Interface pour le pattern Composite.
 * Ici on définit uniquement les opérations nécessaires.
 */
public interface LineComponent {
    void add(LineComponent c);
    void remove(LineComponent c);
    List<Vehicle> getVehicles();
    String getName();
}

