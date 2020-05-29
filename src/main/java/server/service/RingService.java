package server.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.cache.RingDataCache;
import server.dao.*;
import server.entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**

 *@创建人 quyuxi
 *@创建时间 2020/5/21
 *
 */


@Service
public class RingService {




    @Autowired
    RingDao ringDao;


    @Autowired
    ElderService elderService;


    public boolean insertRingData(Position position,Posture posture,Physiological physiological,RingInfo ringInfo){
        boolean r1 = ringDao.insertPosition(position);
        boolean r2 = ringDao.insertPosture(posture);
        boolean r3 = ringDao.insertPhysiological(physiological);
        boolean r4 = ringDao.insertRingInfo(ringInfo);
        //缓存
        RingDataCache.put(position.getElderId(),new RingData(physiological,posture,position,ringInfo));
        return r1 && r2 && r3 && r4;

    }



    public List<Map<String,String>> queryDataByTime(String elderId, String startTime, String endTime) {
        return ringDao.queryDataByTime(elderId,startTime,endTime);
    }




    public HashMap<String, Object> queryLastRingData(String elderId) {
        Posture posture = ringDao.queryLastPosture(elderId );
        Physiological physiological = ringDao.queryLastPhysiological(elderId);
        RingInfo ringInfo = ringDao.queryLastRingInfo(elderId);
        Position position = ringDao.queryLastPosition(elderId);

        HashMap<String, Object> map = new HashMap<>();
        RingData ringData = new RingData(physiological, posture, position, ringInfo);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(ringData);
        Set<String> keySet = jsonObject.keySet();

        for (String key : keySet) {
            JSONObject tmp = jsonObject.getJSONObject(key);
            map.putAll(tmp);
        }

        return map;

    }








}
