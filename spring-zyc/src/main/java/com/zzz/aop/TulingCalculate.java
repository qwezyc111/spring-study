package com.zzz.aop;


import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;


/**
 * Created by xsls on 2019/6/10.
 */
@Component
public class TulingCalculate implements Calculate {

    public int add(int numA, int numB) {

        System.out.println("TulingCalculate.add");
        return numA+numB;
    }

    public int sub(int numA, int numB) {
        System.out.println("TulingCalculate.reduce");
        return numA-numB;
    }

    public int div(int numA, int numB) {
        System.out.println("TulingCalculate.div");
        return numA/numB;
    }

    public int multi(int numA, int numB) {
        System.out.println("TulingCalculate.multi");

        return numA*numB;
    }

    public int mod(int numA,int numB){
        System.out.println("TulingCalculate.mod");

		int retVal = ((Calculate)AopContext.currentProxy()).add(numA,numB);
        //int retVal = this.add(numA,numB);

        return retVal%numA;

        //return numA%numB;
    }

}
