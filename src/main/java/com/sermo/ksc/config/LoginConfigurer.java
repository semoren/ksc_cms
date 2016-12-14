package com.sermo.ksc.config;

import com.sermo.ksc.constant.Globals;
import com.sermo.ksc.doman.Menu;
import com.sermo.ksc.runner.MenuRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author sermo
 * @version 2016/12/13.
 */
@Configuration
public class LoginConfigurer extends WebMvcConfigurerAdapter{

    @Resource
    private MenuRunner runner;

    @Value("#{'${excludeSuffixs}'.split(',')}")
    private List<String> excludeSuffixs;

    @Value("${login}")
    private String loginUrl;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                String requestUri = request.getRequestURI();
                String contextPath = request.getContextPath();
                String url = requestUri.substring(contextPath.length());
                if (isExcludeRequest(url)) {
                    List<Menu> menus = runner.process(url);
                    request.setAttribute("menus", menus);
                    return true;
                }else {
                    Object object = request.getSession().getAttribute(Globals.USER_SESSION);
                    if (object == null) {
                        response.sendRedirect(loginUrl);
                    }else {
                        List<Menu> menus = runner.process(url);
                        request.setAttribute("menus", menus);
                        return true;
                    }
                }

                return false;
            }
        });
    }

    private boolean isExcludeRequest (String path) {
        for (String suffix : excludeSuffixs) {
            if (path.endsWith(suffix)) {
                return true;
            }
        }
        return false;
    }
}
