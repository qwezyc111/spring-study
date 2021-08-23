package com.zzz.aop;

import com.zzz.aop.Introductions.ProgramCalculate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xsls on 2019/6/10.
 */
public class TulingMainClass {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);

		/*
		 * AOP
		 * 接口-jdk动态代理实现 修改字节码 基于jdk自己提供的方式
		 * 没有接口-cglib实现 ASM 动态修改字节码 3.2版本之后已经包括cglib和ASM了
		 * AOP依赖IOC 只能增强Bean方法 如果bean没有注入IOC 就不能增强
		 *
		 * AspectJ给spring提供了哪些支持
		 * 切点表达式 @Aspect注解 @Before注解 都是AspectJ发明的 只是spring把它发扬光大了
		 *
		 *
		 */
		Calculate calculate = (Calculate) ctx.getBean("tulingCalculate");
		int retVal = calculate.div(4, 2);
		System.out.println(retVal);



		/*
		 * 动态引入

		ProgramCalculate pcalculate = (ProgramCalculate) ctx.getBean("tulingCalculate");
		System.out.println(pcalculate.toBinary(15));
*/

	}

}
