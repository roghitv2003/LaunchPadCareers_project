package com.launchPad.jobs;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect  //Logging
@Component
public class LoggingAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(public * com.launchPad.jobs.controller.getAllPosts())")  //loging
    public void logBefore()
    {
        LOGGER.info("Spring AOP :Methode called from aspect");
    }

    //@After -> After(final)

    @AfterReturning("execution(public * com.launchPad.jobs.controller.getAllPosts())")  //After Full execution
    public void logAfter()
    {
        LOGGER.info("Spring AOP :Methode Executed");
    }

    @AfterThrowing("execution(public * com.launchPad.jobs.controller.getAllPosts())")  //Error comes mean it throw log
    public void logException()
    {
        LOGGER.info("Issue");
    }
}
