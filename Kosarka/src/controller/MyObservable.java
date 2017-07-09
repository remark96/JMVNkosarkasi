package controller;

import java.util.ArrayList;

public class MyObservable {
	protected ArrayList<MyObserver> observers;
	
	public MyObservable() {
		observers = new ArrayList<MyObserver>();
	}
	
	public void addObserver(MyObserver observer) { observers.add(observer); }
	public void removeObserver(MyObserver observer) { observers.remove(observer); }
	
	public void notifyObservers() {
		for (MyObserver myObserver : observers) {
			myObserver.update(this, null);
		}
	}
	
	public void notifyObservers(Object obj) {
		for (MyObserver myObserver : observers) {
			myObserver.update(this, obj);
		}
	}
}
