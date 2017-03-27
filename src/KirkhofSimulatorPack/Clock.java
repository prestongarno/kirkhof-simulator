package KirkhofSimulatorPack;

import KirkhofSimulatorPack.LinkedList.CustomLinkedList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** **************************************************
 * @author Roger Ferguson
 * ***************************************************/
public class Clock {
	
	
	/** list of objects that need	to be informed the clock has changed. */
	private CustomLinkedList<ClockListener> listeners;
	/** The max number of listeners*/
	private int MAX = 100;
	
	private final Timer CLOCK_TIMER;
	private int currentTime;
	
	public Clock() {
		listeners = new CustomLinkedList<>();
		this.currentTime = 0;
		CLOCK_TIMER = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Clock.this.tick(currentTime++);
				System.out.println("TICK - " + currentTime);
			}
		});
	}
	
	public void startClock() {
		CLOCK_TIMER.start();
	}
	
	public void add(ClockListener cl) {
		this.listeners.add(cl);
	}
	
	public ClockListener[] getMyListeners() {
		ClockListener[] arr = new ClockListener[this.listeners.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = listeners.get(i);
		}
		return arr;
	}
	
	public void setMyListeners(ClockListener[] myListeners) {
		listeners.clear();
		listeners.addAll(myListeners);
	}
	
	public int getNumListeners() {
		return listeners.size();
	}
	
	public int getMAX() {
		return MAX;
	}
	
	public void tick(int time) {
		for (int i = 0; i < this.listeners.size(); i++) {
			listeners.get(i).event(time); // <-- don't know what the event() parameters are supposed to be
		}
	}
	
	public void stopClock() {
		this.CLOCK_TIMER.stop();
		for (ActionListener listener : CLOCK_TIMER.getActionListeners()) {
			CLOCK_TIMER.removeActionListener(listener);
		}
	}
	
	public int getTickCount() {
		return currentTime;
	}
}



