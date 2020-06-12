package server.pojo;


import lombok.Data;

@Data
//位置
public class Position {


    private double lng;
    private double lat;

    public Position() {
    }


    @Override
    public String toString() {
        String position = "{Position = " + super.toString()
                + ", lng = " + lng
                + ", lat = " + lat + "}";
        return position;
    }

}
