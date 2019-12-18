package com.lakshya;

import java.util.ArrayList;

public interface Subject {
    ArrayList<Observer> observers = null;
    private void notifyObservers() {
        for (Observer currObserver: observers) {
            currObserver.update();
        }
    }
}
