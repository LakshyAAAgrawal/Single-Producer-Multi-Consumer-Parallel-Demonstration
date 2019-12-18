package com.lakshya;

import java.util.HashMap;

public class FibonacciNumber {
    private static HashMap<Integer, FibonacciNumber> FibInstances = new HashMap<Integer, FibonacciNumber>();
    private int fiboNum;

    static{
        synchronized (FibInstances) {
            FibInstances.put(0, new FibonacciNumber(0));
            FibInstances.put(1, new FibonacciNumber(1));
        }
    }

    private FibonacciNumber(int inp){
        if(inp < 2){
            this.fiboNum = inp;
        }
        else {
            this.fiboNum = calculateFibonacci(inp);
        }
    }

    private FibonacciNumber(int inp, int val){
        this.fiboNum = val;
    }

    public static FibonacciNumber getInstance(int inp){
        if(!FibInstances.containsKey(inp)){
            synchronized (FibInstances){
                FibInstances.put(inp, new FibonacciNumber(inp));
            }
        }
        return FibInstances.get(inp);
    }

    public int getCalcFibo(){
        return this.fiboNum;
    }

    private static int calculateFibonacci(int inp){
        if(!FibInstances.containsKey(inp)){
            synchronized (FibInstances){
                FibInstances.put(inp, new FibonacciNumber(inp, calculateFibonacci(inp - 1) + calculateFibonacci(inp - 2)));
            }
        }
        return FibInstances.get(inp).getCalcFibo();
    }
}
