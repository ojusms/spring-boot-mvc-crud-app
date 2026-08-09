package com.SpringBoot.MvcCrudApp.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

// annotated with @Aspect to declare as an Aspect for AOP and with @Componenet to indicate it is a component
// and enable component scanning
@Aspect
@Component
public class LoggingAspect {

    // set up logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // set up pointcut expressions for Controller, DAO, and Service.

    // The expression matches to any method (with 0 or more parameters of any type) of any return type
    // inside any class within the respective package mentioned in the qualified name
    @Pointcut("execution(* com.SpringBoot.MvcCrudApp.Controller.*.*(..))")
    private void forController() {}

    @Pointcut("execution(* com.SpringBoot.MvcCrudApp.DAO.*.*(..))")
    private void forDAO() {}

    @Pointcut("execution(* com.SpringBoot.MvcCrudApp.Service.*.*(..))")
    private void forService() {}

    // create a combined expression
    @Pointcut("forController() || forDAO() || forService()")
    private void forAppFlow() {}
}
