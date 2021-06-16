package com.epam.esm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@ControllerAdvice
//@EnableWebMvc
public class ExceptionController {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ModelAndView handleNotFoundException() {
        ModelAndView model = new ModelAndView();
        model.setViewName("error404");
        return model;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleInternalServerException() {
        ModelAndView model = new ModelAndView();
        model.setViewName("error500");
        return model;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAnyException() {
        ModelAndView model = new ModelAndView();
        model.setViewName("error");
        return model;
    }
}
