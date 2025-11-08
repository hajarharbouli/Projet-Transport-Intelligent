package network;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente le réseau contenant plusieurs lignes.
 */
public class TransportNetwork {
    private String name;
    private List<Line> lines = new ArrayList<>();

    public TransportNetwork(String name) {
        this.name = name;
    }

    public void addLine(Line l) { lines.add(l); }
    public void removeLine(Line l) { lines.remove(l); }
    public List<Line> getLines() { return lines; }

    public void printStatus() {
        System.out.println("Transport Network: " + name);
        for (Line l : lines) {
            System.out.println(l);
        }
    }
}

