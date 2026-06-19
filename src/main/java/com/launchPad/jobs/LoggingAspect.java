package com.launchPad.jobs;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect  //Logging
@Component
public class LoggingAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution(public * com.launchPad.jobs.controller.getAllPosts())")  //loging
    public void log()
    {
        System.out.println("Spring AOP Methode called");
    }
}
