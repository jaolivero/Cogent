package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    //before this method is called with two parameter apply log berfore
    @Before("execution(* aos.ProductService.multiply(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before called");
    }
    @After("execution(* aos.ProductService.multiply(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After the method");
    }}
