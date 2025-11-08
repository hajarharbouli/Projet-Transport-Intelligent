package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Logger simple en singleton pour garder l'historique.
 */
public class LoggerSystem {
    private static LoggerSystem instance;
    private List<String> logs = new ArrayList<>();

    private LoggerSystem() {}

    public static synchronized LoggerSystem getInstance() {
        if (instance == null) instance = new LoggerSystem();
        return instance;
    }

    public void record(String entry) {
        logs.add(entry);
        System.out.println("[LOG] " + entry);
    }

    public void showAll() {
        System.out.println("---- LOG HISTORY ----");
        for (String s : logs) System.out.println(s);
    }
}

