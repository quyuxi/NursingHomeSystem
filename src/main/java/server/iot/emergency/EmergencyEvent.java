package server.iot.emergency;

import server.iot.observer.Event;
import server.iot.pojo.RingRecord;

public class EmergencyEvent implements Event {
    EmergencyType type = EmergencyType.INVALID;
    private RingRecord record;

    public EmergencyEvent(EmergencyType type, RingRecord record) {
        this.record = record;
        this.type = type;
    }

    public RingRecord getRecord() {
        return record;
    }

    public void setRecord(RingRecord record) {
        this.record = record;
    }

    public EmergencyType getType() {
        return type;
    }

    public void setType(EmergencyType type) {
        this.type = type;
    }

    public int getElderId() {
        return record.getId();
    }
}
