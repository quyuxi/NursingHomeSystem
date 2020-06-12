package server.pojo;

public enum RegisterResult {
    SUCCESS(0), FAILD_NULL(1), FAILD_REPEATED(2);
    private final int value;

    RegisterResult(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
