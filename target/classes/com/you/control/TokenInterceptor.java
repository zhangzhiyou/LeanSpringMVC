package com.you.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by zhiyou on 16-4-11.
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {
     private static final Logger LOGGER = LoggerFactory.getLogger(TokenInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token annotation = method.getAnnotation(Token.class );
            if (annotation != null ) {

                boolean flag = TokenHelper.validToken(request);

                /**todo 为什么判断!flag的值
                 * 如果flag=falfe
                 * if(!flag)就不满足条件
                 */

                if (!flag) {
                    LOGGER.error("表单重复提交！");
                    return false ;
                }
            }
            return true ;
        } else {
            return super.preHandle(request, response, handler);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
