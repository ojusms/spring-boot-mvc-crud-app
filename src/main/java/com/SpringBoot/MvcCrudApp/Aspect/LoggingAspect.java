package com.SpringBoot.MvcCrudApp.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

// annotated with @Aspect to declare as an Aspect for AOP and with @Componenet to indicate it is a component
// and enable component scanning
@Aspect
@Component
public class LoggingAspect {

    // set up logger
    private Logger logger = Logger.getLogger(getClass().getName());
}
