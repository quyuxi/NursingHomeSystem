package server.pojo;


import lombok.Data;

@Data
public class PhysicalData {

    private int heartRate;
    private int bloodPressuer;
    private double temperature;


    @Override
    public String toString() {
        String physical = "{PhysicalData = " + super.toString()
                + ", heartRate = " + heartRate
                + ", bloodPressuer = " + bloodPressuer
                + ", temperature = " + temperature + "}";
        return physical;
    }
}
