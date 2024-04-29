package com.talk.comm.aop;

import com.talk.comm.exception.CustomValidationExcetion;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class ValidationAop {

    @Pointcut("@annotation(com.talk.comm.aop.annotation.ValidAspect)")
    private void annotationPointcut(){
    }

    @Around("annotationPointcut()")
    public Object around (ProceedingJoinPoint joinPoint) throws  Throwable{

        Object[] args = joinPoint.getArgs();

        //Validation 규칙에 어긋나는 데이터를 전송하면 인터페이스의 구현체가 파라미터로 전달
        //어떤 예외가 발생했는지, 몇 개의 필드에 대한 검증이 실패했는지, 검증 종류에 따른 기본 에러 메세지 출력
        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args){
            if(arg.getClass() == BeanPropertyBindingResult.class){
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<String, String>();

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors){
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            //에러출럭
            throw new CustomValidationExcetion("Validation Error", errorMap);
        }

        Object result = null;
        result = joinPoint.proceed();
        return result;
    }
}
