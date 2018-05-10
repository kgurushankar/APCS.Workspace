import java.net.*;
import java.io.*;

public class Client implements AutoCloseable {
	Socket s;
	private BufferedReader in;
	private BufferedWriter out;

	public Client(String ip, int port) {
		try {
			s = new Socket(ip, port);
			System.out.println(s);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			sendData(Integer.toString((int) (Math.random() * Integer.MAX_VALUE)));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendData(String s) {
		try {
			out.append(s + '\n');
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void listen() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					String inputLine;
					while ((inputLine = in.readLine()) != null) {
						System.out.println(inputLine);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}).run();
		return;
	}

	public void close() throws IOException {
		s.close();
	}
}
