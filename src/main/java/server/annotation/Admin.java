package server.annotation;



import java.lang.annotation.*;

/**
 * 加上此注解的类或者方法只有admin权限才能访问
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Admin {
}