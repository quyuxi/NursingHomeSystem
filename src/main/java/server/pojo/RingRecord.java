package server.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import server.iot.tools.DateAndTime;

public class RingRecord {
    private int id;
    private int battery;
    private PhysicalData physical;
    private Position position;

    //api json不要
    private Kinestate kinestat;
    //json不要
    //api json不要
    private KeyEvent keyEvent;


    @JsonIgnore
    private String time;

    public RingRecord() {
        setTime(DateAndTime.getCurrentTimeAsStr());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public PhysicalData getPhysical() {
        return physical;
    }

    public void setPhysical(PhysicalData physical) {
        this.physical = physical;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Kinestate getKinestat() {
        return kinestat;
    }

    public void setKinestat(Kinestate kinestat) {
        this.kinestat = kinestat;
    }

    public KeyEvent getKeyEvent() {
        return keyEvent;
    }

    public void setKeyEvent(KeyEvent keyEvent) {
        this.keyEvent = keyEvent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        String record = "{RingRecord:" + super.toString()
                + ", id = " + id + ", battery = " + battery
                + ", physical = " + physical.toString()
                + ", position = " + position.toString()
                + ", kinestat = " + kinestat.toString()
                + ", keyEvent = " + keyEvent.toString()
                + ", time = " + time + "}";
        return record;
    }
}
