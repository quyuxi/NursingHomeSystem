package server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import server.iot.bootstrap.IotServerBootStrap;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.concurrent.Executors;

/**
 * quyuxi
 */

@MapperScan(basePackages = "server.dao")
@SpringBootApplication
@EnableCaching
@ServletComponentScan
@EnableSwagger2
public class Application {

    public static void main(String[] args) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                IotServerBootStrap bootStrap = new IotServerBootStrap();
                bootStrap.start();
            }
        });
        SpringApplication.run(Application.class, args);
    }

}
