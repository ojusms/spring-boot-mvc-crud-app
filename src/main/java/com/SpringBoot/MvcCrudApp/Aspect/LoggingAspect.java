package com.SpringBoot.MvcCrudApp.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

// annotated with @Aspect to declare as an Aspect for AOP practices and with @Componenet to indicate it is a component
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

    // add @Before advice. Uses the Pointcut expression above and the method has a parameter for a JoinPoint object
    // which provides access to data about the target function
    @Before("forAppFlow()")
    private void before(JoinPoint joinPoint) {
        // display method being called
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====> in @Before: calling method: "+method);

        // display arguments of target method
        // get the arguments
        Object[] args = joinPoint.getArgs();
        // iterate over the array of arguments and display
        for (Object tempArg : args) {
            logger.info("=====> argument: "+tempArg);
        }
    }
}
