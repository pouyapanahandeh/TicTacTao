import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

	private ServerSocket serverSock;
	private BlockingDeque<Human> players;

 	public Player(Socket socket, char mark) {
            this.socket = socket;
            this.mark = mark;
            try {
                input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
                output.println("WELCOME " + mark);
                output.println("MESSAGE Waiting for opponent to connect");
            } catch (IOException e) {
                System.out.println("Player died: " + e);
            }
        }

	public Server(int port) {
		try {
			serverSock = new ServerSocket(port);
			players = new LinkedBlockingDeque<>();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void waitForPlayers() {
		int playerCount = 2;
		int curPlayerIndex = 1;
		while (players.size() < playerCount) {
			try {
				Socket sock = serverSock.accept();
				players.add(new Human(curPlayerIndex++, sock));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}