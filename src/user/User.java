package user;

import service.Observer;

/**
 * Représente un usager abonné aux notifications.
 * Implémente Observer.
 */
public class User implements Observer {
    private String id;
    private String name;

    public User(String id, String name) { this.id = id; this.name = name; }

    @Override
    public void update(String message) {
        System.out.println("[User " + name + "] received: " + message);
    }

    public String getId() { return id; }
    public String getName() { return name; }
}

