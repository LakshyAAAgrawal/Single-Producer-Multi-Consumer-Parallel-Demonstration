package com.lakshya;

public class FibonacciTester {
    public static void main(String[] args) throws InterruptedException {
        FibonacciCalculator fibCalc = new FibonacciCalculator(5);
        fibCalc.addTask(45);
        for(int i = 0; i < 45; i++){
            fibCalc.addTask(i);
        }
        fibCalc.addTask(0);
        fibCalc.terminate();
    }
}
