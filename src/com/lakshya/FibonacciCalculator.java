package com.lakshya;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FibonacciCalculator implements FibonacciInterface, Subject{
    ArrayList<Thread> clientThreads;
    ArrayList<Observer> observers;
    volatile Queue<Task> tasks;
    volatile Queue<Task> completedTasks;
    public FibonacciCalculator(int numThreads){
        clientThreads = new ArrayList<Thread>(numThreads);
        observers = new ArrayList<Observer>(numThreads);
        tasks = new LinkedList<Task>();
        completedTasks = new LinkedList<Task>();
        for(int xx = 0; xx < numThreads; xx++){
            FibonacciClient tempClient = new FibonacciClient(tasks, completedTasks);
            Thread tempThread = new Thread(tempClient);
            clientThreads.add(tempThread);
            observers.add(tempClient);
            tempThread.start();
        }
    }

    @Override
    public void displayCalculations() {
        while(!completedTasks.isEmpty()){
            Task dequeued = completedTasks.remove();
            System.out.println(dequeued);
        }
    }

    @Override
    public void addTask(int number) {
        Task task = new Task(number);
        synchronized (tasks){
            tasks.add(task);
        }
        this.notifyObservers();
    }

    private void notifyObservers(){
        for (Observer currObserver: observers) {
            currObserver.update();
        }
    }

    public void terminate(){
        while(!tasks.isEmpty());
        for (Observer currClient: observers) {
            currClient.stopExecution();
        }
        for(Thread currThread: clientThreads){
            try {
                currThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.displayCalculations();
    }
}
