package Java_class_008.Thread;

public class ThreadMain {

	public static void main(String[] args) {
		Thread th = new Thread();
		Thread1 th1 = new Thread1("Thread1");
		Thread2 th2 = new Thread2("Thread2");
		
//		th.start();
//		th1.start();
//		th2.run();
		
		/* Runnable */
		Thread2 r1 = new Thread2("r1");
		Thread2 r2 = new Thread2("r2");
		Thread2 r3 = new Thread2("r3");
		
		Thread th3 = new Thread(r1);
		Thread th4 = new Thread(r2);
		Thread th5 = new Thread(r3);
		th3.start();
		th4.start();
		th5.start();
		
	}

}
