package app;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("run...");
		}
		
	}
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable());
		t1.start();
		
		
		
		
		// oder las Lambda Ausduck
		Thread t2= new Thread( ()->{
			
		}  );
		
		t2.start();
		
	}

}
