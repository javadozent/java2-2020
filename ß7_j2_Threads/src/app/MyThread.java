package app;

public class MyThread extends Thread{
	
	
	private boolean stop = false;

	@Override
	public void run() {
		
		while(!stop ) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName());
		}
		
	}// Thread Ende
	
	
	public void stopThread() {
		stop=true;
	}

	public static void main(String[] args) {

		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		t1.start();// ein Thread kann nur EINMAL gestartet werden
		t2.start();
		t3.start();
		t1.stopThread();
	//	t1.stop(); NICHT verwenden
		
	}

}
