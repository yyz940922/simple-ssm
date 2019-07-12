package com.shsxt.handler;

import com.shsxt.exception.BusinessException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 异常处理第二种方式 手动操作, 具有业务灵活性 (不想要异常处理，将@Componet注释掉就ok)
@Component
public class MyHandlerResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object target, Exception ex) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("error"); // 默认视图
        mv.addObject("ex",ex.getMessage());  // 默认错误信息

        if(ex instanceof BusinessException){
            BusinessException e = (BusinessException) ex;
            mv.setViewName("business_error"); // 设置业务异常视图
            mv.addObject("ex", e.getMsg());  // 业务异常信息
            // 其他java操作
        }

        return mv;
    }
}
