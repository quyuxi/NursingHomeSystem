package server.monitor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import server.cache.RingDataCache;
import server.entity.RingData;
import server.entity.SystemUser;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@EnableScheduling
public class Monitor {



    private static final long ringTimeOut = 60*1000;


    @Scheduled(fixedRate = 60 * 1000)
    public void task(){


        ConcurrentHashMap.KeySetView<String, RingData> keySet = RingDataCache.cache.keySet();
        for (String elderId : keySet) {

            RingData ringData = RingDataCache.cache.get(elderId);
            Date dateTime = ringData.getPosition().getDateTime();

            if ((System.currentTimeMillis()-dateTime.getTime())>ringTimeOut){
                //TODO 告警
            }


        }
        

    }
}
