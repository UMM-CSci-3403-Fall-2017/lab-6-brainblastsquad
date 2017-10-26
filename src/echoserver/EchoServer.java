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
        
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();
        
        PrintWriter writer = new PrintWriter(out, true);
        byte b;
        while ((b = (byte) in.read()) != -1) {
        	writer.println(b);
        }
        
        
        client.close();
      }
    } catch (IOException ioe) {
      System.err.println(ioe);
    }
  }
}