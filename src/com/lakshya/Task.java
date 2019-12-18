package com.lakshya;

public class Task implements Runnable{
    long calculationTime = -1;
    FibonacciNumber fibonacciNumber;
    int input;

    public Task(int inp){
        this.input = inp;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        this.fibonacciNumber = FibonacciNumber.getInstance(this.input);
        long finishTime = System.nanoTime();
        this.calculationTime = finishTime - startTime;
    }

    public FibonacciNumber getResult(){
        return this.fibonacciNumber;
    }

    @Override
    public String toString(){
        if(calculationTime == -1) return "Not calculated yet";
        return "Index: " + input + ", Fibonacci Number: " + fibonacciNumber.getCalcFibo() + ", Calculation time(in nanosec): " + calculationTime;
    }
}
