package server.pojo;


import lombok.Data;

@Data
public class PhysicalData {

    private int heartRate;
    private int bloodPressuer;
    private double temperature;

    public PhysicalData(int heartRate, int bloodPressuer, double temperature) {

        this.heartRate = heartRate;
        this.bloodPressuer = bloodPressuer;
        this.temperature = temperature;
    }

    public PhysicalData() {
    }

    @Override
    public String toString() {
        String physical = "{PhysicalData = " + super.toString()
                + ", heartRate = " + heartRate
                + ", bloodPressuer = " + bloodPressuer
                + ", temperature = " + temperature + "}";
        return physical;
    }
}
