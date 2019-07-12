package com.shsxt.base;

import com.shsxt.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    // 异常处理方式3 有侵入性 需要controller类继承BaseController类, 不推荐
    // 全局异常处理
   @ExceptionHandler
    public String exceptionHandler(HttpServletRequest request,
                                   HttpServletResponse response,
                                   Exception ex){
        request.setAttribute("ex", ex.getMessage()); // 默认错误信息

        if(ex instanceof BusinessException){
            BusinessException e = (BusinessException) ex;
            request.setAttribute("ex", e.getMsg());
            return "business_error";
        }

        return "error";
    }
}
