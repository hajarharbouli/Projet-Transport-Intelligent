package model;

public class OldSensor {
    private int code;
    private String legacyType;

    public OldSensor(int code, String legacyType) {
        this.code = code;
        this.legacyType = legacyType;
    }

    public double legacyRead() { return Math.random() * 50; }
    public String getLegacyType() { return legacyType; }
    public int getCode() { return code; }
}

