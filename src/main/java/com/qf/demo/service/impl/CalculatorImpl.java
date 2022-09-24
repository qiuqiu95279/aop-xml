package com.qf.demo.service.impl;

import com.qf.demo.MyAction;
import com.qf.demo.service.Calculator;
@MyAction
public class CalculatorImpl implements Calculator {
    @Override

    public int add(int a, int b) {
        System.out.println("a+b="+(a+b));
        return a+b;
    }

    @Override

    public void minus(int a, int b) {
       // int s=1/0;
        System.out.println("a-b="+(a-b));
    }
}
