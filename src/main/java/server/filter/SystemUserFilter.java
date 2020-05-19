package server.filter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import server.utils.JwtUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * quyuxi
 */
@Order(1)
@WebFilter(filterName = "SystemUserFilter", urlPatterns = {"/*"})
public class SystemUserFilter  implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemUserFilter.class) ;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {



    }
}
