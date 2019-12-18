package com.lakshya;

import java.util.Queue;

public class FibonacciClient implements Observer, Runnable{
    Queue<Task> tasks;
    Queue<Task> completedTasks;
    volatile boolean taskAvailable = false;
    volatile boolean execute = true;

    public FibonacciClient(Queue<Task> tasks, Queue<Task> completedTasks){
            this.tasks = tasks;
            this.completedTasks = completedTasks;
    }

    @Override
    public void update() {
        this.taskAvailable = true;
    }

    @Override
    public void run() {
        while(execute){
            while(!taskAvailable);
            Task currTask;
            synchronized (tasks){
                if(tasks.isEmpty()){
                   continue;
                }
                currTask = tasks.remove();
            }
            currTask.run();
            synchronized (completedTasks){
                completedTasks.add(currTask);
            }
        }
    }

    @Override
    public void stopExecution(){
        this.execute = false;
    }
}
