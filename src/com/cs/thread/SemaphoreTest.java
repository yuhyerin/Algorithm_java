package com.cs.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	/** synchronized의 경우 오직 하나의 쓰레드만 수행가능하게 했다면,
	 * 세마포어는 동시에 실행할 수 있는 쓰레드의 수를 제어할 수 있다.
	 * */
	public static void main(String[] args) {
		
		final SomeResource resource = new SomeResource(3);
		for(int i=1; i<=10; i++) {
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					resource.use();
				}
			});
			t.start();
		}
	}
	
}

class SomeResource{
	private final Semaphore semaphore;
	private final int maxThread;
	
	public SomeResource(int maxThread) {
		this.maxThread = maxThread;
		this.semaphore = new Semaphore(maxThread);
		
	}
	
	public void use() {
		try {
			semaphore.acquire(); // 쓰레드가 세마포어에게 시작을 알림.
			System.out.println("["+Thread.currentThread().getName()+"]"
					+(maxThread - semaphore.availablePermits())+"쓰레드가 점유중 ");
			System.out.println("availpermits: "+semaphore.availablePermits());
			// semaphore.availablePermits()는 사용가능한 쓰레드의 숫자.
			
			Thread.sleep((long)(Math.random()*10000));
			semaphore.release(); // 쓰레드가 세마포어에게 종료를 알림.
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
