//package cn.csu.ykf.inkin.console.controller;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
//import cn.csu.ykf.inkin.console.exception.NotLoggedInException;
//
//@ControllerAdvice
//public class ExceptionController {
//
//    @ExceptionHandler(NotLoggedInException.class)
//    public ModelAndView handleNotLoggedInException(NotLoggedInException e) {
//        return e.getModelAndView();
//    }
//}