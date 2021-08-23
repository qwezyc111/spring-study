package com.zzz.aop.EalyAopDemo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class TulingLogInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("TulingLogInterceptor invoke 方法，before proceed");
        Object ret=invocation.proceed();
        System.out.println("TulingLogInterceptor invoke 方法，after proceed");
        return ret;
    }

}
