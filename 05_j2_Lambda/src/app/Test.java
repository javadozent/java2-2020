package app;

@FunctionalInterface
interface MyInterface1{
	void m(int a);
}


interface MyInterfaceB{
	
	int m(String s, int n);
}



public class Test {
	
	public static void main(String[] args) {
		// Anonym
		MyInterface1 mi1 = new MyInterface1() {
			
			@Override
			public void m(int a) {
				
				
			}
		};
		
		//Lambda
		MyInterface1 mi2 = a -> {};
		
		
		MyInterfaceB miB = (s,n)-> s.length() * n;
		
		System.out.println(miB.m("Hallo", 3));
		
		
		
		
	}

}
