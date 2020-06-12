package server.iot.emergency;


import lombok.Data;
import server.iot.observer.Event;
import server.pojo.RingRecord;

@Data
public class EmergencyEvent implements Event {
    EmergencyType type = EmergencyType.INVALID;
    private RingRecord record;


    public EmergencyEvent(EmergencyType type, RingRecord record) {
        this.record = record;
        this.type = type;
    }

    public EmergencyEvent() {
    }
}
