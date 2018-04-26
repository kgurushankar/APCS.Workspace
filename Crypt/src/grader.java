
public class grader {

	public static void main(String[] args) {
		String infile = "in.txt";
		String outfile = "out.txt";
		String keyword = "crypt";
		(new Crypt()).decrypt(infile, outfile, keyword);
	}

}
