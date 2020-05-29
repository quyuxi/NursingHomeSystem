package server.webserver;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import server.cache.RingDataCache;
import server.service.RingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/ring")
public class RingController {


	@Autowired
	RingService ringService;

	private static final Logger LOGGER = LoggerFactory.getLogger(RingController.class);


	@RequestMapping(value="/queryRingDataByTime/{elderID}/{startTime}/{endTime}",method=RequestMethod.GET)
	public List<Map<String, String>> quertDataByTime(String elderId, String startTime, String endTime){
		LOGGER.info("查询手环数据，开始时间：{}，结束时间{}，老人id：{}",startTime,endTime,elderId);
		return ringService.queryDataByTime(elderId, startTime, endTime);
	}

	@GetMapping("/queryLastRingData/{elderID}")
	public Map<String, Object> queryLastRingData(String elderId){
		LOGGER.info("查询最新手环数据，老人id：{}",elderId);
		Map<String, Object> map = RingDataCache.getRingDataByElderId(elderId);
		if (null == map ){
			return ringService.queryLastRingData(elderId);
		}
		return map;

	}

}
