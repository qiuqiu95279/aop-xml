package com.qf.demo;

import com.qf.demo.service.Calculator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Calculator calculator = (Calculator) ctx.getBean("calculator");
        calculator.add(3,2);
        calculator.minus(5,2);
    }
}
