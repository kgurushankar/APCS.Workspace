package kgurushankar.booleanchecker;

public abstract class Checker {
	private short vars;

	public Checker(short numVars) {
		this.vars = numVars;
	}

	public abstract boolean one(boolean[] b);

	public abstract boolean two(boolean[] b);

	public boolean equal() {
		boolean[] b = new boolean[vars];
		for (long i = 0; i < Math.pow(2, vars); i++) {
			if (one(b) != two(b)) {
				return false;
			}
		}
		return true;
	}

	public boolean[] toBoolean(long l, byte size) {
		boolean[] out = new boolean[size];
		char[] c = Long.toBinaryString(l).toCharArray();
		for (byte i = 0; i < c.length; i++) {
			out[i] = c[i] == '1';
		}
		return out;
	}
}
