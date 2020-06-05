package server.iot.pojo;

public enum KeyEvent {
    NON(0), SOS(1);

    private final int value;

    KeyEvent(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean normal() {
        return this == NON;
    }
}
