package service;

/**
 * Interface du pattern Observer — sujet observable.
 */
public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyAllUsers(String message);
}

