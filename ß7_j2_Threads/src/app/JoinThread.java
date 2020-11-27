package app;

public class JoinThread extends Thread{
	int count = 0;
	
	@Override
	public void run() {
		++count;
	//System.out.println(" -->"+count);
	}
	

	public static void main(String[] args) {
		
		JoinThread t1 = new JoinThread();
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println(t1.count);

	}

}
