package app;

import java.util.ArrayList;

/*
 * synchronized sperrt Zugriff auf Daten gegenüber anderen Threads
 * -> Threadsicher
 */
public class Example2 {
	
	private int count =0;
	
	
	//Threadsicher
	public  void make() {
		synchronized (this) {//Threadsicher
			setCount(getCount() + 1);
		
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
