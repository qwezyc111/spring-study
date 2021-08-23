package com.zzz.aop.EalyAopDemo;

import com.zzz.aop.Calculate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Created by xsls on 2019/6/10.
 */
public class TulingMainClass {

	public static void main(String[] args) {

       /*
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EalyAopMainConfig.class);
        Calculate tulingCalculate = ctx.getBean("tulingCalculate",Calculate.class);
        tulingCalculate.div(1,1);
*/
		/*
		 * ProxyFactoryBean
		 */
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EalyAopMainConfig.class);
		// 从spring容器中拿到calculate动态代理对象
		Calculate calculateProxy = ctx.getBean("calculateProxy1", Calculate.class);
		System.out.println("TulingMainClass main calculateProxy getClass :" + calculateProxy.getClass());
		int add = calculateProxy.add(1, 1);
		System.out.println("method result " + add);

	}
}
