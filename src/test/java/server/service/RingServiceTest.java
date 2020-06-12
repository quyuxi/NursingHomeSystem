package server.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import server.Application;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class RingServiceTest {

    @Autowired
    RingService ringService;

    private final String elerid = "93010001";


    @Test
    public void insertRingdata() throws InterruptedException {


    }

    @Test
    public void quertByTime() throws InterruptedException {
        List<Map<String, String>> maps = ringService.queryDataByTime(elerid, "2020-05-30 11:35:34", "2020-05-30 11:54:12");
//        LOG.info.println(JSON.toJSONString(maps,true));

    }

}