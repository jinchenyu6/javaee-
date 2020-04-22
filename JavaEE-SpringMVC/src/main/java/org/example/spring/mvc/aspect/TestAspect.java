package org.example.spring.mvc.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author DELL
 */
@Aspect
@Component

public class TestAspect {

    @Pointcut("execution(* org.example.spring.mvc.service.*.*(..))")
    public void service(){

    }

    @Before("service()")
    public void beforeService(){
        System.out.println("Before service.");
    }

    @After("service()")
    public void afterService(){
        System.out.println("After service.");
    }

    @Around("service()")
    public Object aroundService(ProceedingJoinPoint jp){
        Object object = null;
        try{
            System.out.println("Before Around Service");

            object = jp.proceed();

            //日志输出，请求参数、相应参数的记录

            System.out.println("After Around Service");
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return object;
    }



}
