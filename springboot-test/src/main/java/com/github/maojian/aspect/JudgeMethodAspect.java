package com.github.maojian.aspect;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log
public class JudgeMethodAspect implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Pointcut("@annotation(com.github.maojian.anno.JudgeMethod)")
    public void judgeMethodPointCut(){
    }

    @Around("judgeMethodPointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        String method = proceedingJoinPoint.getSignature().getName();
        Object[] params = proceedingJoinPoint.getArgs();
        Class<?> targetClass = proceedingJoinPoint.getTarget().getClass();
        String className = targetClass.getName();
    }
}
