import java.io.*;
import java.net.*;
import java.util.*;

public class Server implements AutoCloseable {
	private Vector<Connection> connections = new Vector<Connection>();
	private ServerSocket s;

	public Server(int port) throws IOException {
		s = new ServerSocket(port);
		System.out.println(s);
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (!s.isClosed()) {
					try {
						Socket c = s.accept();
						connections.add(new Connection(c));
						System.out.println(c);

					} catch (IOException e) {
						e.printStackTrace(System.out);
					}
				}

			}

		}, "Connections").run();
	}

	public void broadcast(String s, Connection n) {
		new Thread(new Runnable() {
			public void run() {
				System.out.print(s);
				for (Connection c : connections) {
					c.sendData(s);
				}
			}
		}).run();

	}

	public void close() throws IOException {
		s.close();
		for (Connection c : connections) {
			c.close();
		}
	}

	private class Connection implements AutoCloseable {
		private Socket s;
		private BufferedReader in;
		private BufferedWriter out;

		public Connection(Socket s) throws IOException {
			this.s = s;
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			listen();
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
			Connection me = this;
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						String inputLine;
						while ((inputLine = in.readLine()) != null) {
							System.out.println(inputLine);
							broadcast(inputLine, me);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).run();
		}

		public void close() throws IOException {
			s.close();
		}
	}

}
