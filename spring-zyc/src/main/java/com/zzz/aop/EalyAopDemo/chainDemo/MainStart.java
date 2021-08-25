package com.zzz.aop.EalyAopDemo.chainDemo;

import com.zzz.aop.EalyAopDemo.TulingLogBeforeAdvice;
import com.zzz.aop.EalyAopDemo.TulingLogInterceptor;
import com.zzz.aop.TulingCalculate;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 * 早期AOP责任链实现原理
 * 一个集合，一个递归或者循环
 * 一个增强类需要写一个ProxyFactoryBean，增强是通过责任链来调用的
 */
public class MainStart {

    public static void main(String[] args) throws Throwable {
        // 把一条链上的都初始化
        List<MethodInterceptor> list=new ArrayList<>();
        // 责任链统一抽象
        list.add(new MethodBeforeAdviceInterceptor(new TulingLogBeforeAdvice()));
        list.add(new TulingLogInterceptor());

        // 递归依次调用
        MyMethodInvocation invocation=new MyMethodInvocation(list);
        invocation.proceed();
    }

    public static class MyMethodInvocation implements MethodInvocation{
        protected List<MethodInterceptor> list;
        protected final TulingCalculate target;

        public MyMethodInvocation(List<MethodInterceptor> list) {
            this.list = list;
            this.target = new TulingCalculate();
        }
        int i=0;
        @Override
        public Object proceed() throws Throwable {
            if(i==list.size()){
                return target.add(2,2);
            }
            MethodInterceptor mi = list.get(i);
            i++;
            // 传入this，继续调用proceed
           return  mi.invoke(this);
        }

        @Override
        public Object getThis() {
            return target;
        }

        @Override
        public AccessibleObject getStaticPart() {
            return null;
        }


        @Override
        public Method getMethod() {
            try {

                return target.getClass().getMethod("add",int.class,int.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public Object[] getArguments() {
            return new Object[0];
        }
    }

}
