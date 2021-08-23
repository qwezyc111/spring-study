package com.zzz.aop;

import com.zzz.aop.Introductions.ProgramCalculate;
import com.zzz.aop.Introductions.SimpleProgramCalculate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import java.util.Arrays;

// 切面
@Aspect
@Order
@Component
public class TulingLogAspect {

    /*引入:

     */
    @DeclareParents(value="com.zzz.aop.TulingCalculate",   // 动态实现的类，增强的哪个类
            defaultImpl = SimpleProgramCalculate.class)  // 引入的接口的默认实现
    public static ProgramCalculate programCalculate;    // 引入的接口



	/**
	 * 切点
	 */
    @Pointcut("execution(* com.zzz.aop.TulingCalculate.*(..))")
    public void pointCut(){};

    @Before(value = "pointCut()")
    public void methodBefore(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("TulingLogAspect【"+methodName+"】的<methodBefore>,入参"+ Arrays.asList(joinPoint.getArgs()));
    }

    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("TulingLogAspect【"+methodName+"】的<methodAfter>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void methodReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("TulingLogAspect【"+methodName+"】的<methodReturning>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

    @AfterThrowing(value = "pointCut()")
    public void methodAfterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("TulingLogAspect【"+methodName+"】的<methodAfterThrowing>,入参"+Arrays.asList(joinPoint.getArgs()));
    }

}
