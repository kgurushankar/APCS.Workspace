public class grader {
	public static void main(String[] args) {
		String fileLoc = "test";
		Life l = new Life(fileLoc + ".in");
		l.step(100);
		Life l2 = new Life(fileLoc + ".out");
		System.out.println((l.equals(l2) ? 1.0f : 0.0f));
	}
}