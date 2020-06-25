package server.interceptor;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import server.annotation.Admin;
import server.utils.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

import static server.cache.LoginCache.TOKEN_CACHE;
import static server.constant.LoginConstant.ADMIN;
import static server.constant.LoginConstant.TOKEN_INVALID;


/**
 * @author quyuxi
 * @since 2020/5/20
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {


    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //验证token
        if (!hasPermission(request)) {
            response.setStatus(403);
            response.getWriter().print(TOKEN_INVALID);
            return false;
        }

        // 验证admin权限
        if (verityAdmin(handler, request)) {
            return true;
        }
        // 如果没有权限，返回异常
        response.setStatus(403);
        response.getWriter().print("NOPERMISSION");
        return false;
    }

    private boolean hasPermission(HttpServletRequest request) {
        String token = request.getHeader("token");
        LOGGER.debug("开始校验token :"+token);
        if (StringUtils.isEmpty(token)) {
            LOGGER.error("没有在请求中发现token");
            return false;
        }
        ;
        Collection<String> values = TOKEN_CACHE.values();
        if (!values.contains(token)) {
            LOGGER.error("该token无效，token: " + token);
            return false;
        }
        return null != JwtUtils.verity(token);
    }


    private boolean verityAdmin(Object handler, HttpServletRequest request) {


        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法上的注解
            Admin admin = handlerMethod.getMethod().getAnnotation(Admin.class);
            // 获取类的注解
            if (admin == null) {
                admin = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Admin.class);
            }

            if (admin == null) {
                return true;
            }

            // 如果加了@Admin注解，比如用户有admin权限
            String token = request.getHeader("token");
            Integer role = JwtUtils.verity(token);
            if (null == role) {
                return false;
            }
            return ADMIN == role;
        }
        return true;
    }


}