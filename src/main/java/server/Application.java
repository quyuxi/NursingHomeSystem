package server;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import server.iot.bootstrap.IotServerBootStrap;
import server.utils.SpringUtils;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                IotServerBootStrap bootStrap = new IotServerBootStrap();
                LOGGER.info("启动IOT服务端...");
                bootStrap.start();
            }
        });
        SpringUtils.applicationContext = SpringApplication.run(Application.class, args);
        LOGGER.info("服务启动已启动...");
    }



}
