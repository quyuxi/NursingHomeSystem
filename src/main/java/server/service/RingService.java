package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.cache.RingDataCache;
import server.dao.RingDao;
import server.pojo.PhysicalData;
import server.pojo.Position;
import server.pojo.RingRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @创建人 quyuxi
 * @创建时间 2020/5/21
 */


@Service
public class RingService {


    @Autowired
    RingDao ringDao;


    @Autowired
    ElderService elderService;


    public boolean insertRingData(int id, Position position, int battery, PhysicalData physiological, double lat, double lng, String dateTime, String acceleration, String palstance) {
        boolean r1 = ringDao.insertPosition(lat, lng, id, dateTime);
        boolean r2 = ringDao.insertPosture(acceleration, palstance, id, dateTime);
        boolean r3 = ringDao.insertPhysiological(physiological.getHeartRate(), physiological.getBloodPressure(), physiological.getTemperature(), id, dateTime);
        boolean r4 = ringDao.updateRingInfo(id, battery, dateTime);
        RingRecord ringRecord = new RingRecord();

        ringRecord.setId(id);
        ringRecord.setBattery(battery);
        ringRecord.setPhysical(physiological);
        ringRecord.setPosition(position);

        RingDataCache.CACHE.put(id, ringRecord);
        return r1 && r2 && r3 && r4;

    }


    public List<RingRecord> queryDataByTime(int id, String startTime, String endTime) {
        List<Map<String, Object>> lst = ringDao.queryDataByTime(id, startTime, endTime);


        List<RingRecord> ringRecords = new ArrayList<>();
        for (Map<String, Object> map : lst) {
            RingRecord ringRecord = new RingRecord();
            ringRecord.setTime(map.get("time").toString());
            ringRecord.setId(Integer.parseInt(map.get("ring_id").toString()));
            ringRecord.setPosition(new Position(Double.parseDouble(map.get("lng").toString()), Double.parseDouble(map.get("lat").toString())));
            ringRecord.setPhysical(new PhysicalData(
                    Integer.parseInt(map.get("heartRate").toString()),
                    Integer.parseInt(map.get("bloodPressuer").toString()),
                    Double.parseDouble(map.get("temperature").toString())
            ));
            ringRecord.setBattery(Integer.parseInt(map.get("battery").toString()));
            ringRecords.add(ringRecord);
        }
        return ringRecords;
    }


    public RingRecord queryLastRingData(int ringId) {

//        Map<String, Object> posture = ringDao.queryLastPosture(ringId);
        PhysicalData physiological = ringDao.queryLastPhysiological(ringId);
        Map<String, Object> ringInfo = ringDao.queryLastRingInfo(ringId);
        Position position = ringDao.queryLastPosition(ringId);


        RingRecord ringRecord = new RingRecord();
        ringRecord.setId(ringId);
        ringRecord.setBattery(Integer.parseInt(ringInfo.get("battery").toString()));
        ringRecord.setPhysical(physiological);
        ringRecord.setPosition(position);
        ringRecord.setTime(ringInfo.get("date_time").toString());

        return ringRecord;

    }


    public List<server.pojo.Position> getSafeArea(int id) {
        // 格式如  111,222ra111,222,ra
        String area = ringDao.getSafeArea(id);
        String[] areaArr = area.split("ra");

        ArrayList<Position> positions = new ArrayList<>();
        for (String s : areaArr) {
            String[] split = s.split(",");
            positions.add(new Position(Double.parseDouble(split[0]), Double.parseDouble(split[1])));
        }
        return positions;
    }

    public boolean createRingInfo(int ringId, String startTime) {
        return ringDao.createRingInfo(ringId, 100, startTime);
    }

    public boolean deleteByElderId(int id) {
        return ringDao.deleteByElderId(id);
    }
}
