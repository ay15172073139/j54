package org.java.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHhandler  {

    @ExceptionHandler(value = Exception.class)
    public String ExceptionHandle(HttpServletRequest req,Exception ex){
        String msg=ex.getMessage();
        req.setAttribute("msg",msg);
        return "/err";
    }

}
