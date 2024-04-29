package com.talk.comm.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAop {

    private static final Logger log = LoggerFactory.getLogger(LogAop.class);

    //api이하의 패키지의 모든 Api 클래스 이하 모든 메서드에 적용
    @Pointcut("execution(* com.talk.comm.api.*Api.*(..))")
    private void pointCut(){
    }

    @Pointcut("@annotation(com.talk.comm.aop.annotation.LogAspect)")
    private void annotaionPointCut(){
    }

    @Around("annotationPointCut()")
    public Object around (ProceedingJoinPoint joinPoint) throws Throwable{
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        String className = codeSignature.getDeclaringTypeName();
        String methodName = codeSignature.getName();
        String[] parameterNames = codeSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();

        for(int i = 0; i < parameterNames.length; i++){
            log.info("<<<< Parameter Info >>>> {}.{} >>> [{}: {}]", className, methodName, parameterNames[i], args[i]);
        }

        Object result = joinPoint.proceed();

        log.info("<<<< Return >>>> {}.{} >>> [{}]", className, methodName);

        return result;
    }


}
