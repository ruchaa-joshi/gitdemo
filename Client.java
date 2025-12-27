import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345); // Connect to server on localhost:12345
        System.out.println("Connected to server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Send messages to server
        out.println("Hello from client!");

        // Receive messages from server
        String response;
        while ((response = in.readLine()) != null) {
            System.out.println("Server response: " + response);
        }

        socket.close(); // Close the socket
    }
}