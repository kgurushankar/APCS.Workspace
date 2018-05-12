import java.net.*;

import java.io.*;

public class Client implements AutoCloseable, Runnable {
	Socket s;
	private BufferedReader in;
	private BufferedWriter out;

	public Client(String ip, int port) {
		try {
			s = new Socket(ip, port);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendData(String s) {
		try {

			out.write(s);
			out.newLine();
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			String line = null;

			// while reader line is not empty
			while ((line = in.readLine()) != null) {

				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() throws IOException {
		s.close();
	}
}
