package com.zzz.iocbeanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

// 配置类注解，会生成当前类的cglib动态代理
@Configuration
@ComponentScan(basePackages = {"com.zzz.iocbeanlifecycle"},
excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class})})
public class MainConfig {
//	@Bean
//	public Car car(){
//		Car car = new Car();
//		car.setName("温大");
//		// 如果是增强类，会先从ioc容器中获取tank
//		car.setTank(tank());
//		return car;
//	}
//
//	@Bean
//	public Tank tank(){
//		return new Tank();
//	}
}
