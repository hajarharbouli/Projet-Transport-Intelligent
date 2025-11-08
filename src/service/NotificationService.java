package service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service de notification qui garde la liste des observateurs (usagers).
 */
public class NotificationService implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyAllUsers(String message) {
        for (Observer o : observers) {
            try {
                o.update(message);
            } catch (Exception ex) {
                System.err.println("Erreur lors de la notification: " + ex.getMessage());
            }
        }
    }

    // méthodes utilitaires pratiques
    public void register(user.User u) { register((Observer) u); }
    public void unregister(user.User u) { unregister((Observer) u); }
}

