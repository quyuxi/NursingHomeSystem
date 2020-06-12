package server.cache;

import com.alibaba.fastjson.JSONObject;
import server.pojo.RingRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author quyuxi
 * 2020-05-29
 */

public class RingDataCache {


    public static ConcurrentHashMap<Integer, RingRecord> CACHE = new ConcurrentHashMap<Integer, RingRecord>();

}
