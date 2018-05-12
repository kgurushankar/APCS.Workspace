import java.io.IOException;

public class ServerMain {
	public static void main(String[] args) {
		Server s = null;
		try {
			s = new Server(8888);
		} catch (IOException e0) {
			// try {
			// s.close();
			// } catch (NullPointerException e1) {
			// } catch (IOException e) {
			// }
			e0.printStackTrace(System.out);
			System.exit(0);
		}

	}
}
