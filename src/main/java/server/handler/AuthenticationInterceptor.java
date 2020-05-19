package server.handler;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import server.annotation.Admin;
import server.constant.Constant;
import server.service.SystemUserService;
import server.utils.HttpServletRequestUtils;
import server.utils.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * quyuxi
 */
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    SystemUserService systemUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //验证token
        if (hasPermission(request)) {
            return false;
        }

        // 验证admin权限
        if (verityAdmin(handler,request)) {
            return true;
        }
        // 如果没有权限，返回异常
        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "NOPERMISSION");
        return false;
    }

    private boolean hasPermission(HttpServletRequest request) {
        String token = request.getHeader("token");
        String userName = JwtUtils.verity(token);
        //token无效
        if (StringUtils.isEmpty(userName)){
            return true;
        }
        return false;
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
            String userName = JwtUtils.verity(token);
            String role = systemUserService.queryRole(userName);
            if (!Constant.ADMIN.equals(role)){
                return false;
            }
        }
        return true;
    }


}