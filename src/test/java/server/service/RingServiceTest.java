package server.service;


import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import server.Application;
import server.entity.Physiological;
import server.entity.Position;
import server.entity.Posture;
import server.entity.RingInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class RingServiceTest {

    @Autowired
    RingService ringService;

    private String elerid="93010001";

    


    @Test
    public void insertRingdata() throws InterruptedException {

        for (int i = 0; i <1000 ; i++) {
            Thread.sleep(1000);

            Date date = new Date();
            Position position = new Position(null,"test"+i,"test"+i,elerid,date);
            Posture posture = new Posture(null,"test"+i,"test"+i,elerid,date );
            Physiological physiological = new Physiological(null,"test"+i,100,87.4,elerid,date);
            RingInfo ringInfo = new RingInfo(null,"1111",99,elerid,date);

            System.out.println(ringService.insertRingData(position,posture,physiological,ringInfo));
        }

    }

    @Test
    public void quertByTime() throws InterruptedException {
        List<Map<String, String>> maps = ringService.queryDataByTime(elerid, "2020-05-30 11:35:34", "2020-05-30 11:54:12");
//        System.out.println(JSON.toJSONString(maps,true));

    }

}