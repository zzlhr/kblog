package com.zzlhr.kblog;

import com.zzlhr.kblog.exception.KBlogException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
      
      //比如404的异常就会被这个方法捕获
      @ExceptionHandler(NoHandlerFoundException.class)
      @ResponseStatus(HttpStatus.NOT_FOUND)
       public ModelAndView handle404Error(HttpServletRequest req, HttpServletResponse rsp, Exception e) throws Exception {
             return handleError(req, rsp, e);
       }    
      

    @ExceptionHandler(KBlogException.class)
    public ModelAndView handleError(HttpServletRequest req, HttpServletResponse rsp, Exception e) throws Exception {
        return handleError(req, rsp, e);
    }

  }