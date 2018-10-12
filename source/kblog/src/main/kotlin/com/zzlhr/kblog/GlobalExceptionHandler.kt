package com.zzlhr.kblog

import com.zzlhr.kblog.exception.KBlogException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.NoHandlerFoundException

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class GlobalExceptionHandler {

    //比如404的异常就会被这个方法捕获
    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @Throws(Exception::class)
    fun handle404Error(req: HttpServletRequest, rsp: HttpServletResponse, e: Exception): ModelAndView {
        return handleError(req, rsp, e)
    }


    @ExceptionHandler(KBlogException::class)
    @Throws(Exception::class)
    fun handleError(req: HttpServletRequest, rsp: HttpServletResponse, e: Exception): ModelAndView {
        return handleError(req, rsp, e)
    }

}