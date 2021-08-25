package com.zzz.aop.EalyAopDemo;

import com.google.gson.Gson;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 后置通知
 */

public class TulingLogAfterAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("TulingLogAfterAdvice afterReturning");
	}
}
