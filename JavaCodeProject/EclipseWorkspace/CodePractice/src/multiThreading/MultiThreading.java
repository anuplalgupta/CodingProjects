package multiThreading;
class ThreadRunner implements Runnable{
	int i =0;
	
	@Override
	public void run() {
		System.out.println("Runnint thread number "+Thread.currentThread().getId());
		executeSyncLogic();
	}
	
	public void executeSyncLogic() {
		
		synchronized (this) {
				++i;
		}
		System.out.println(i);
		executeSyncFunc();
		System.out.println(i);
		
	}
	
	synchronized public void executeSyncFunc() {
		--i;
	}
	
}

public class MultiThreading {

	public static void main(String[] args) {
		int n = 6;
		for(int i=0;i<n;i++) {
			Thread t = new Thread(new ThreadRunner());
			t.start();
		}
	}
}
