package service;

import java.util.ArrayList;
import java.util.List;
import model.Sensor;
import model.Vehicle;
import network.Line;
import utils.LoggerSystem;
import user.User;

/**
 * Singleton implémentant Mediator.
 * Centralise la supervision et alerte via NotificationService.
 */
public class SupervisionCenter implements Mediator {
    private static SupervisionCenter instance;
    private List<Line> lines = new ArrayList<>();
    private NotificationService notificationService = new NotificationService();
    private LoggerSystem logger = LoggerSystem.getInstance();

    private SupervisionCenter() {}

    public static synchronized SupervisionCenter getInstance() {
        if (instance == null) {
            instance = new SupervisionCenter();
        }
        return instance;
    }

    public void registerLine(Line l) {
        lines.add(l);
    }

    public void collectData() {
        for (Line l : lines) {
            for (Vehicle v : l.getVehicles()) {
                v.readSensors();
            }
        }
    }

    @Override
    public void notifyVehicleStateChange(Vehicle v) {
        String msg = "State changed: " + v;
        logger.record(msg);
        notificationService.notifyAllUsers(msg);
    }

    @Override
    public void notifyVehiclePosition(Vehicle v) {
        String msg = "Position update: " + v;
        logger.record(msg);
        notificationService.notifyAllUsers(msg);
    }

    @Override
    public void receiveSensorData(Vehicle v, Sensor s, double value) {
        String msg = String.format("Sensor data from %s: sensor=%s value=%.2f", v, s.getType(), value);
        logger.record(msg);
        // Détection simple d'incident si valeur élevée
        if (value > 90) {
            String incident = "Incident detected on vehicle " + v.getId() + " sensor " + s.getType();
            logger.record(incident);
            notificationService.notifyAllUsers(incident);
        }
    }

    public NotificationService getNotificationService() { return notificationService; }

    public void addUser(User u) { notificationService.register(u); }
}

