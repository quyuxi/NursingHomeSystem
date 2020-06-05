package server.utils;

import org.springframework.context.ApplicationContext;

public class SpringUtils {

    public static ApplicationContext applicationContext = null;


    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }


}
