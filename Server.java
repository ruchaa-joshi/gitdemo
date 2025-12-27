import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Server socket listening on port 12345
        System.out.println("Server started. Waiting for clients...");

        // Accept three client connections
        for (int i = 0; i < 3; i++) {
            Socket clientSocket = serverSocket.accept(); // Accept client connection
            System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
            new ServerThread(clientSocket).start(); // Start a new thread to handle client
        }

        serverSocket.close(); // Close the server socket
    }
}

class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client says: " + inputLine);
                out.println("Server received: " + inputLine); // Echo back to client
            }

            socket.close(); // Close the client socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}