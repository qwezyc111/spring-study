package com.zzz.aop;

import com.zzz.aop.Introductions.ProgramCalculate;
import com.zzz.aop.Introductions.SimpleProgramCalculate;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import java.util.Arrays;

/*
注解方式AOP的实现原理
找到所有添加了@AspectJ的类，每一个加了@Before、@After等的通知，都会被转换成一个Advisor对象
每个Advisor都包含一个advice和pointcut
在第一个BeanPostProcessor就会解析，如何解析？
拿到所有的bd，然后一个一个判断，类上是否标记了@Aj注解
之后再createBean的时候创建动态代理，创建动态代理的过程是什么？
拿到之前解析到的advisors，循环所有额advisors,拿到每个advisor的pointcut
pc会调用matchs方法匹配，匹配成功就可以创建动态代理。
创建每一个bean的时候调用初始化后的那个BeanPostProcessor
 */
// 切面
@Aspect
@Order
@Component
public class TulingLogAspect {

	/*
	引入
	 */
	@DeclareParents(value = "com.zzz.aop.TulingCalculate",   // 动态实现的类，增强的哪个类
			defaultImpl = SimpleProgramCalculate.class)  // 引入的接口的默认实现
	public static ProgramCalculate programCalculate;    // 引入的接口


	/*
	  切点
	 */
	@Pointcut("execution(* com.zzz.aop.TulingCalculate.*(..))")
	public void pointCut() {
	}

	;

	/*
	每一个通知都会封装成一个Advisor
	 */
	@Before(value = "pointCut()")
	public void methodBefore(JoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("TulingLogAspect【" + methodName + "】的<methodBefore>,入参" + Arrays.asList(joinPoint.getArgs()));
	}

	/*
	每一个通知都会封装成一个Advisor
	 */
	@After(value = "pointCut()")
	public void methodAfter(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("TulingLogAspect【" + methodName + "】的<methodAfter>,入参" + Arrays.asList(joinPoint.getArgs()));
	}

	/*
	每一个通知都会封装成一个Advisor
	 */
	@AfterReturning(value = "pointCut()", returning = "result")
	public void methodReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("TulingLogAspect【" + methodName + "】的<methodReturning>,入参" + Arrays.asList(joinPoint.getArgs()));
	}

	/*
	每一个通知都会封装成一个Advisor
	 */
	@AfterThrowing(value = "pointCut()")
	public void methodAfterThrowing(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("TulingLogAspect【" + methodName + "】的<methodAfterThrowing>,入参" + Arrays.asList(joinPoint.getArgs()));
	}

}
