package server.utils;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.entity.Physiological;
import server.entity.Position;
import server.entity.Posture;
import server.entity.RingInfo;
import server.iot.pojo.RingRecord;
import server.service.RingService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RingUtils {

    private static final Logger LOG = LoggerFactory.getLogger(RingUtils.class);

    public static void persistence(RingRecord record) {

        RingService ringService = SpringUtils.getBean(RingService.class);

        Position position = new Position(null, String.valueOf(record.getPosition().getLat()), String.valueOf(record.getPosition().getLng()), Integer.toString(record.getId()), formatTime(record.getTime()));

        Posture posture = new Posture(null, JSON.toJSONString(record.getKinestat().getAcc()), JSON.toJSONString(record.getKinestat().getPal()), Integer.toString(record.getId()), formatTime(record.getTime()));
        Physiological physiological = new Physiological(null, String.valueOf(record.getPhysical().getHeartRate()), record.getPhysical().getBloodPressuer(), record.getPhysical().getTemperature(), Integer.toString(record.getId()), formatTime(record.getTime()));
        RingInfo ringInfo = new RingInfo(Integer.toString(record.getId()), record.getBattery(), formatTime(record.getTime()));

        boolean result = ringService.insertRingData(Integer.toString(record.getId()),position, posture, physiological, ringInfo);
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
