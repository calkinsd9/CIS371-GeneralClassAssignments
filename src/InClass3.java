import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class InClass3 {
    public static void main(String[] args) {
        final int DEFAULT_PORT = 8080; // For security reasons, only root can use ports < 1024.
        int portNumber = args.length > 1 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
            
            //read incoming data and print to standard output until blank line
            String s;
            while((s = in.readLine()) != null){
                if (s.isEmpty()){
                    break;
                }
                System.out.println(s);
            }
            
            String generalMessage = "HTTP/1.1 200 OK\n"
                    + "Content-Type: text/plain\n"
                    + "Content-Length: 70\n"
                    + "Connection: close\n\n"
                    + "This is not the real content because this server is not yet complete.";
            
            out.println(generalMessage);

         } catch (IOException e) {
            System.err.println("Oops!  " + e);
         }
        
    }
    
}
