package server.iot.emergency;

import server.iot.pojo.Position;
import server.iot.pojo.RingRecord;
import server.iot.tools.PositionJudge;
import server.utils.IotUitls;

public class OverstepEmergencyListener extends EmergencyListener {

    @Override
    protected boolean abnormal(RingRecord record) {
        Position[] polygon = getSafeArea(record.getId());
        PositionJudge judge = new PositionJudge(record.getPosition(), polygon);
        return judge.judge();
    }

    @Override
    protected EmergencyEvent newEmergency(RingRecord record) {
        return new EmergencyEvent(EmergencyType.OVERSTEP, record);
    }
    
    private Position[] getSafeArea(int elderId) {
        return IotUitls.getSafeArea(elderId);
    }
}
