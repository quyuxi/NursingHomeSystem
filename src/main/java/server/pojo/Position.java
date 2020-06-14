package server.pojo;


import lombok.Data;

@Data
//位置
public class Position {


    private double lng;
    private double lat;

    public Position() {
    }

    public Position(double lng, double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    @Override
    public String toString() {
        String position = "{Position = " + super.toString()
                + ", lng = " + lng
                + ", lat = " + lat + "}";
        return position;
    }

}
