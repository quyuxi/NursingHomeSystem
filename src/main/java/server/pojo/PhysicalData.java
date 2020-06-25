package server.pojo;


import lombok.Data;

@Data
public class PhysicalData {

    private int heartRate;
    private int bloodPressure;
    private double temperature;

    public PhysicalData(int heartRate, int bloodPressuer, double temperature) {

        this.heartRate = heartRate;
        this.bloodPressure = bloodPressuer;
        this.temperature = temperature;
    }

    public PhysicalData() {
    }

    @Override
    public String toString() {
        String physical = "{PhysicalData = " + super.toString()
                + ", heartRate = " + heartRate
                + ", bloodPressure = " + bloodPressure
                + ", temperature = " + temperature + "}";
        return physical;
    }
}
