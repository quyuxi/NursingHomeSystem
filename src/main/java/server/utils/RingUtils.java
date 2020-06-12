package server.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.pojo.RingRecord;
import server.service.RingService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RingUtils {

    private static final Logger LOG = LoggerFactory.getLogger(RingUtils.class);

    public static void persistence(RingRecord record) {

        RingService ringService = SpringUtils.getBean(RingService.class);

        boolean result = ringService.insertRingData(
                record.getId(),
                record.getPosition(),
                record.getBattery(),
                record.getPhysical(),
                record.getPosition().getLat()
                ,record.getPosition().getLng(),
                record.getTime(),JSON.toJSONString(record.getKinestat().getAcc()),JSON.toJSONString(record.getKinestat().getPal()));
        LOG.info("插入手环数据," + result);
    }


    private static Date formatTime(String datetime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
}
