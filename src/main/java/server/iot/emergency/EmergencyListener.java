package server.iot.emergency;

import server.iot.observer.Event;
import server.iot.observer.EventListener;
import server.pojo.RingRecord;
import server.pojo.RingRecordAdaptor;

public abstract class EmergencyListener implements EventListener {

    @Override
    public void notify(Event e) {
        RingRecord record = ((RingRecordAdaptor) e).getRecord();
        if (abnormal(record)) {
            EmergencyCache.instance().cacheEvent(newEmergency(record));
        }
    }

    protected abstract boolean abnormal(RingRecord record);

    protected abstract EmergencyEvent newEmergency(RingRecord record);

}
