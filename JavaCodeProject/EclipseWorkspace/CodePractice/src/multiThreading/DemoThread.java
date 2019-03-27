package multiThreading;

class MyThread implements Runnable{

	public static int tid =0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Running thread"+tid);
		tid++;
		
	}
	
}

public class DemoThread {
	public static void main(String[] args) {
		MyThread mt1 = new MyThread();
		MyThread mt2 = new MyThread();
		
		mt1.run();
		mt2.run();
	}
}
