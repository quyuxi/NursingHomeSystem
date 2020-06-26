package server.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import server.Application;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class RingServiceTest {



    @Test
    public void insertRingdata() throws InterruptedException, IOException {

        Random random = new Random();

        Socket c = new Socket("121.196.47.181",1514);
        OutputStream outputStream = c.getOutputStream();

        for (int i = 0; i < 2 ; i++) {
            outputStream.write(String.format("{\"id\": 93010003,\"battery\": %d,\"physical\": {\"heartRate\": %d,\"bloodPressure\": %d,\"temperature\": %d},\"position\": {\"lng\": 108.33265,\"lat\": 34.21254},\"kinestat\": {\"acc\":{\"x\":10,\"y\":20,\"z\":30},\"pal\":{\"x\":0,\"y\":0,\"z\":0}},\"keyEvent\":0}\n", random.nextInt(99),random.nextInt(99),random.nextInt(99),random.nextInt(99)).getBytes("utf-8"));
            outputStream.flush();
            Thread.sleep(100);
        }

        c.close();

    }


}