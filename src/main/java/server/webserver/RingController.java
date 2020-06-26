package server.webserver;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.pojo.RingRecord;
import server.service.RingService;

import java.util.List;

import static server.cache.RingDataCache.CACHE;

@RestController
@RequestMapping(value = "/NursingHomeSystem/ring")
public class RingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RingController.class);
    @Autowired
    RingService ringService;


    @RequestMapping(value = "/listByTime/{id}/{startTime}/{endTime}", method = RequestMethod.GET)
    public String quertDataByTime(@PathVariable int id, @PathVariable String startTime, @PathVariable String endTime) {
        LOGGER.info("查询手环数据，开始时间：{}，结束时间{}，老人id：{}", startTime, endTime, id);
        List<RingRecord> ringRecords = ringService.queryDataByTime(id, startTime, endTime);
        return JSON.toJSONString(ringRecords);
    }

    @GetMapping("/lastRecord/{id}")
    public String queryLastRingData(@PathVariable int id) {
        LOGGER.info("查询最新手环数据，老人id：{}", id);
        RingRecord ringRecord = CACHE.get(id);
        if (null == ringRecord) {
            LOGGER.debug("缓存中没有数据，从数据库中查找");
            ringRecord = ringService.queryLastRingData(id);
            CACHE.put(id, ringRecord);
        }
        LOGGER.debug(JSON.toJSONString(ringRecord));
        return JSON.toJSONString(ringRecord);


    }

}
