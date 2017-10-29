package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
  public static void main(String[] args) {
    try {
      ServerSocket sock = new ServerSocket(6013);
      
      while (true) {
        
        Socket client = sock.accept();
        System.out.println("Got a request!");
        
     // Variables for getting input from client and output to the client
        InputStream inClient = client.getInputStream();
        OutputStream outClient = client.getOutputStream();
        
        // Variable b which reads the data from the client
	    // If no errors occur, reads until end of input.
	    // writes b to outClient.
        
        int b;
        while((b = inClient.read()) != -1) {
        	outClient.write(b);
        	outClient.flush();
        }
        
        // Flush and close the outputs/inputs so there is no unwritten data
        
        inClient.close();
        outClient.close();
        client.close();
        
      }
    } catch (IOException ioe) {
      System.err.println(ioe);
    }
  }
}