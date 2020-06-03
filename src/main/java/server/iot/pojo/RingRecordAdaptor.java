package server.iot.pojo;

import server.iot.observer.Event;

public class RingRecordAdaptor implements Event {
    private RingRecord record;
    
    public RingRecordAdaptor(RingRecord record) {
        this.record = record;
    }
    
    public RingRecord getRecord() {
        return record;
    }
}
