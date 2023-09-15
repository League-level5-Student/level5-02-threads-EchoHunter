package _04_Thread_Pool;

public class WorkQueue implements Runnable{
	private Thread[] threads;
	private boolean isRunning = true;
	
	public WorkQueue() {
		int totalThreads = Runtime.getRuntime().availableProcessors()-1;
		threads = new Thread[totalThreads];
		for(int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(this);
			threads[i].start();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	while(isRunning) {
		
	}

	}
	public int getThreadCount() {
		return threads.length;
	}

}