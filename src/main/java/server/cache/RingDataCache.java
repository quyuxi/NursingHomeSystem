package server.cache;

import server.pojo.RingRecord;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author quyuxi
 * 2020-05-29
 */

public class RingDataCache {


    public static ConcurrentHashMap<Integer, RingRecord> CACHE = new ConcurrentHashMap<Integer, RingRecord>();

}
