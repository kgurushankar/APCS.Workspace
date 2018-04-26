
public class Main {
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		Crypt a = new Crypt();

//		 a.encrypt("data.in", "data.out", "crypt");

		a.decrypt("data.out", "data.in", "crypt");
		long e = System.currentTimeMillis();
		System.out.println(e - t);
	}
}
