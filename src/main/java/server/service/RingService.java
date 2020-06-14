package server.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.cache.RingDataCache;
import server.dao.RingDao;
import server.pojo.PhysicalData;
import server.pojo.Position;
import server.pojo.RingRecord;

import java.util.*;

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


    public boolean insertRingData(int id, Position position, int battery, PhysicalData physiological, double lat, double lng, String dateTime,String acceleration,String palstance ) {
        boolean r1 = ringDao.insertPosition(lat,lng,id,dateTime);
        boolean r2 = ringDao.insertPosture(acceleration,palstance,id,dateTime);
        boolean r3 = ringDao.insertPhysiological(physiological.getHeartRate(),physiological.getBloodPressuer(),physiological.getTemperature(),id,dateTime);
        boolean r4 = ringDao.updateRingInfo(id,battery,dateTime);
        RingRecord ringRecord = new RingRecord();

        ringRecord.setId(id);
        ringRecord.setBattery(battery);
        ringRecord.setPhysical(physiological);
        ringRecord.setPosition(position);

        RingDataCache.CACHE.put(id, ringRecord);
        return r1 && r2 && r3 && r4;

    }


    public List<Map<String, String>> queryDataByTime(int id, String startTime, String endTime) {
        return ringDao.queryDataByTime(id, startTime, endTime);
    }


    public RingRecord queryLastRingData(int ringId) {

        Map<String, Object> posture = ringDao.queryLastPosture(ringId);
        PhysicalData physiological = ringDao.queryLastPhysiological(ringId);
        Map<String, Object> ringInfo = ringDao.queryLastRingInfo(ringId);
        Position position = ringDao.queryLastPosition(ringId);

        HashMap<String, Object> map = new HashMap<>();
        RingRecord ringRecord = new RingRecord();

        ringRecord.setId(ringId);
        ringRecord.setBattery(Integer.parseInt(ringInfo.get("battery").toString()));
        ringRecord.setPhysical(physiological);
        ringRecord.setPosition(position);


        return ringRecord;

    }


    public List<server.pojo.Position> getSafeArea(int id) {
        JSONArray array = JSON.parseArray(ringDao.getSafeArea(id));
        ArrayList<Position> positions = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            JSONObject tmp = array.getJSONObject(i);
            positions.add(new Position(tmp.getDouble("lng"), tmp.getDouble("lat")));

        }
        return positions;
    }

    public boolean createRingInfo(int ringId, String startTime) {
        return ringDao.createRingInfo(ringId, 100,startTime);
    }
}
