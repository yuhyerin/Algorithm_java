package com.cs.thread;

public class RamenProgram {

	public static void main(String[] args) {
		try {
			RamenCook ramenCook = new RamenCook(10);
			new Thread(ramenCook, "A").start();
			new Thread(ramenCook, "B").start();
			new Thread(ramenCook, "C").start();
			new Thread(ramenCook, "D").start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}// end RamenProgram class

class RamenCook implements Runnable {

	private int ramenCount;
	private String[] burners = { "_", "_", "_", "_" };

	public RamenCook(int count) {
		ramenCount = count;
	}

	@Override
	public void run() {
		while (ramenCount > 0) {
			
			// synchronized 블록을 사용해서 한번에 하나의 쓰레드들만 건들일 수 있도록 한다! 
			synchronized (this) {
				ramenCount--;
				System.out.println(Thread.currentThread().getName() + ": " + ramenCount + "개 남음");
			}

			for (int i = 0; i < burners.length; i++) {
				if (!burners[i].equals("_"))
					continue;

				synchronized (this) {// 둘이상의 쓰레드가 하나의 버너를 키지 못하도록 synchronized!
					burners[i] = Thread.currentThread().getName();
					System.out.println("\t\t" + Thread.currentThread().getName() + " : [" + (i + 1) + "]번 버너 ON");
					showBurners();
				}

				try {
					Thread.sleep(2000); //라면 끓이는 시간 
				} catch (Exception e) {
					e.printStackTrace();
				}

				synchronized (this) {
					burners[i] = "_";
					System.out.println("\t\t\t\t" + Thread.currentThread().getName() + " : [" + (i + 1) + "]번 버너 OFF");
					showBurners();
				}
				break;
			} // end for
			try {
				//다음 라면을 끌이기까지 0~1.0초 사이 랜덤으로 시간이 걸리도록 한다. 
				Thread.sleep(Math.round(1000 * Math.random()));
			} catch (Exception e) {
				e.printStackTrace();
			}

		} // end while
		
	}// end run method

	private void showBurners() {
		String stringToPrint = "";
		for (int i = 0; i < burners.length; i++) {
			stringToPrint += (" " + burners[i]);
		}
		System.out.println(stringToPrint);
	}
}