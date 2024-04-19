package com.example.aspect.timer;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {
    Logger logger = LoggerFactory.getLogger(UserAspect.class);
    @Pointcut("@annotation(com.example.aspect.timer.TrackExecutionTime)")
    public void userServiceMethod(){}

    @SneakyThrows
    @Around("userServiceMethod()")
    public Object timeExecutedMethods(ProceedingJoinPoint proceedingJoinPoint){
        long startExecution = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        long endExecution = System.currentTimeMillis();
        logger.info("Method name: "+proceedingJoinPoint.getSignature()+", execution time = "+(endExecution - startExecution));
        return object;
    }
}
