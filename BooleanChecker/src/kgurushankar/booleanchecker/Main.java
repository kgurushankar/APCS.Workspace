package kgurushankar.booleanchecker;

public class Main {
	public static void main(String[] args) {
		Checker c = new Checker((short) 2) {

			public boolean one(boolean[] b) {
				return b[0] && b[1];
			}

			public boolean two(boolean[] b) {
				return b[1] && b[0];
			}

		};
		System.out.println(c.equal());
	}
}
