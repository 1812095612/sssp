package com.qiaosoftware.sssp.base.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class ExceptionAdviceHandler {

    @ExceptionHandler(value = { java.lang.ArithmeticException.class })
    public ModelAndView handleException1(Exception ex) {
        System.out.println("出现算术异常啦:" + ex);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        return mv;
    }

    @ExceptionHandler(value = { java.lang.RuntimeException.class })
    public ModelAndView handleException2(Exception ex) {
        System.out.println("出现运行时异常啦:" + ex);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        return mv;
    }

}
