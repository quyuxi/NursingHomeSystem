package server.iot.pojo;

public enum KeyType {
    SOS("SOS");
    //TODO add other types
    private final String name;

    KeyType(String keyType) {
        this.name = keyType;
    }

    public String getName() {
        return name;
    }
}
