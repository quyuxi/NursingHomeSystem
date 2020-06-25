package server.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import server.pojo.PhysicalData;
import server.pojo.Position;

import java.util.List;
import java.util.Map;

@Component
public interface RingDao {


    boolean insertPosition(@Param("lat") double lat, @Param("lng") double lng, @Param("ringId") int ringId, @Param("dateTime") String dateTime);

    boolean insertPosture(@Param("acceleration") String acceleration, @Param("palstance") String palstance, @Param("ringId") int ringId, @Param("dateTime") String dateTime);


    boolean insertPhysiological(@Param("heartRate") int heartRate, @Param("bloodPressuer") int bloodPressuer, @Param("temperature") double temperature, @Param("ringId") int ringId, @Param("dateTime") String dateTime);

    boolean insertRingInfo(@Param("ringId") int ringId, @Param("battery") int battery, @Param("dateTime") String dateTime);

    List<Map<String, Object>> queryDataByTime(@Param("ringId") int ringId, String startTime, String endTime);

    Map<String, Object> queryLastPosture(@Param("ringId") int ringId);

    PhysicalData queryLastPhysiological(@Param("ringId") int ringId);

    Map<String, Object> queryLastRingInfo(@Param("ringId") int ringId);

    Position queryLastPosition(@Param("ringId") int ringId);


    boolean updateRingInfo(@Param("ringId") int ringId, @Param("battery") int battery, @Param("dateTime") String dateTime);

    String getSafeArea(@Param("ringId") int ringId);

    boolean createRingInfo(@Param("ringId") int ringId, @Param("battery") int battery, @Param("dateTime") String dateTime);

    boolean deleteByElderId(int id);
}
