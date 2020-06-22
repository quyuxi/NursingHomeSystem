package server.iot.emergency;

import server.utils.PositionJudge;
import server.pojo.Position;
import server.pojo.RingRecord;
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
