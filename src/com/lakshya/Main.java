package com.lakshya;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Number of consumer threads to be launched: ");
        int numConsumer = scan.nextInt();
        FibonacciCalculator fibCalc = new FibonacciCalculator(numConsumer);
        while(true){
            System.out.println("Type \"exit\" to exit");
            System.out.println("Type \"display\" to display calculated results");
            System.out.println("Type number to calculate Fibonacci");
            String inp = scan.next();
            if(inp.equals("exit")){
                fibCalc.terminate();
                break;
            }else if(inp.equals("display")){
                fibCalc.displayCalculations();
            }else{
                int input;
                try{
                    input = Integer.valueOf(inp);
                    if(input < 0) throw new NumberFormatException();
                }catch(NumberFormatException e){
                    System.out.println("Enter valid input");
                    continue;
                }
                fibCalc.addTask(input);
            }
        }
    }
}
