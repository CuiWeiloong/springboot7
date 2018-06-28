package com.cralor.ch3.conf;

import com.cralor.ch3.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cc.
 * 2018/6/13 14:08
 **/
@Configuration
public class MyMvcConfigurer implements WebMvcConfigurer {

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //增加一个拦截器，检查会话，URL以admin开头的都是用此拦截器
        registry.addInterceptor(new SessionHandlerInterceptor()).addPathPatterns("/admin/**");
    }

    //跨域访问配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    //格式化
    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    //URL到视图的映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }
}

class SessionHandlerInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {

            User user=(User)request.getSession().getAttribute("user");
            if(user==null){
                //没有登陆重定向到login.html
                response.sendRedirect("/login.html");
                return false;
            }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //controller 方法处理完，调用此方法。在页面渲染之前
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //页面渲染完调用，通常用来清除资源，类似java的finally
    }
}