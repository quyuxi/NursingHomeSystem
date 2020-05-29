package server.cache;

import com.alibaba.fastjson.JSONObject;
import server.entity.RingData;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author quyuxi
 * 2020-05-29
 */

public class RingDataCache {


    public static ConcurrentHashMap<String, RingData> cache = new ConcurrentHashMap<String, RingData>();



    public static Map<String,Object> getRingDataByElderId(String elderId){
        if (cache.contains(elderId)) {

            HashMap<String, Object> map = new HashMap<>();
            RingData ringData = cache.get(elderId);;
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(ringData);
            Set<String> keySet = jsonObject.keySet();

            for (String key : keySet) {
                JSONObject tmp = jsonObject.getJSONObject(key);
                map.putAll(tmp);
            }
            return map;

        }
        return null;
    }
    public static void put(String elderid,RingData ringData){
        cache.put(elderid,ringData);
    }

}
