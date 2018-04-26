package kgurushankar.crypt;

public class Main {
	public static void main(String[] args) {
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(1);

			}
		});
		long t = System.currentTimeMillis();
		Crypt3 a = new Crypt3();

		a.encrypt("data.in", "data.out", "crypt");

		// a.decrypt("data.out", "data.in", "crypt");
		long e = System.currentTimeMillis();
		System.out.println(e - t);
	}
}
