package server.webserver;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.pojo.RingRecord;
import server.service.RingService;

import java.util.List;
import java.util.Map;

import static server.cache.RingDataCache.CACHE;

@RestController
@RequestMapping(value = "/ring")
public class RingController {


    private static final Logger LOGGER = LoggerFactory.getLogger(RingController.class);
    @Autowired
    RingService ringService;

    @RequestMapping(value = "/queryRingDataByTime/{id}/{startTime}/{endTime}", method = RequestMethod.GET)
    public List<Map<String, String>> quertDataByTime(int id, String startTime, String endTime) {
        LOGGER.info("查询手环数据，开始时间：{}，结束时间{}，老人id：{}", startTime, endTime, id);
        return ringService.queryDataByTime(id, startTime, endTime);
    }

    @GetMapping("/queryLastRingData/{id}")
    public RingRecord queryLastRingData(int id) {
        LOGGER.info("查询最新手环数据，老人id：{}", id);
        RingRecord ringRecord = CACHE.get(id);
        if (null == ringRecord)
            return ringService.queryLastRingData(id);
        return ringRecord;


    }

}
