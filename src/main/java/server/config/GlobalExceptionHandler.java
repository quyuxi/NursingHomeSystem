package server.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,String> handler1(Exception e){
        LOGGER.error("===服务端异常===",e);
        Map<String, String> map = new HashMap<>();
        map.put("status", "error");
        map.put("errorMsg", e.getMessage());
        return map;
    }

}