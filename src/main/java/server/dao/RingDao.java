package server.dao;

import org.springframework.stereotype.Component;
import server.entity.Physiological;
import server.entity.Position;
import server.entity.Posture;
import server.entity.RingInfo;

import java.util.List;
import java.util.Map;

@Component
public interface RingDao {


    boolean insertPosition(Position position);

    boolean insertPosture(Posture posture);

    boolean insertPhysiological(Physiological physiological);

    boolean insertRingInfo(RingInfo ringInfo);

    List<Map<String, String>> queryDataByTime(String elderId, String startTime, String endTime);

    Posture queryLastPosture(String elderId);

    Physiological queryLastPhysiological(String elderId);

    RingInfo queryLastRingInfo(String elderId);

    Position queryLastPosition(String elderId);
}
