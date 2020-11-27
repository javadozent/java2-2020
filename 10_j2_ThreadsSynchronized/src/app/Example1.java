package app;


/*
 * synchronized sperrt Zugriff auf Daten gegen�ber anderen Threads
 * -> Threadsicher
 */
public class Example1 {
	
	private int count =0;
	
	
	//Threadsicher
	public synchronized void make() {
		setCount(getCount() + 1);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
