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
        
        int b;
        while((b = in.read()) != -1) {
        	out.write(b);
        	out.flush();
        }
        
        in.close();
        out.close();
        client.close();
        
      }
    } catch (IOException ioe) {
      System.err.println(ioe);
    }
  }
}