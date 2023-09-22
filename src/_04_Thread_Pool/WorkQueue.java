package _04_Thread_Pool;

import java.lang.Thread.State;
import java.util.ArrayDeque;

public class WorkQueue implements Runnable{
	private Thread[] threads;
	private ArrayDeque<Job> jobQueue = new ArrayDeque<Job>();
	private volatile boolean isRunning = true;
	
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
		if(!doJob()) {
		synchronized(jobQueue){
			try {
				jobQueue.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
	}

	}
	public int getThreadCount() {
		return threads.length;
	}
	public void addJob(Job j) {
		synchronized(jobQueue) {
		jobQueue.add(j);
		jobQueue.notify();
		}
	}
	public void completeAllJobs() {
			while(!jobQueue.isEmpty()) {
				doJob();
			}
			for (int i = 0; i < threads.length; i++) {
				if(threads[i].getState() != State.WAITING) {
					i = -1;
				}
			}
	}
	public boolean doJob() {
		Job j = null;
		synchronized(jobQueue) {
		if(!jobQueue.isEmpty()) {
			j = jobQueue.remove();
					j.perform();
			if(j != null) {
				j.perform();
				return true;
			}
		}
		}
		return false;
	}
	public void shutdown() {
		completeAllJobs();
		isRunning = false;
		synchronized(jobQueue) {
			jobQueue.notifyAll();
		}
	}

}
