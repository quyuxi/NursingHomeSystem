package server.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import server.interceptor.AuthenticationInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor)// 注册拦截器
                .excludePathPatterns("/NursingHomeSystem/user/login")
                .excludePathPatterns("/swagger-ui.html")
                .addPathPatterns("/NursingHomeSystem/user/**")
                .addPathPatterns("/NursingHomeSystem/ring/**")
                .addPathPatterns("/NursingHomeSystem/elder/**");
    }


}
