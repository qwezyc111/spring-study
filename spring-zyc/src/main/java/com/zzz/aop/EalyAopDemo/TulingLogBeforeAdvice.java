package com.zzz.aop.EalyAopDemo;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 前置通知
 */
public class TulingLogBeforeAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("TulingLogBeforeAdvice before 方法");
		System.out.println(new Gson().toJson(method.getName()));
		System.out.println(new Gson().toJson(args));
		System.out.println(new Gson().toJson(target));
	}

}
