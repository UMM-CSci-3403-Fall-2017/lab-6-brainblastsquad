package echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.*;
import java.io.*;

public class EchoClient {
	 public static void main(String[] args) {
		    try {
		      Socket socket = new Socket("127.0.0.1", 6013);
		      // You can change 127.0.0.1 to a machine name if you want to try this across
		      // the network to another machine.
		      // Socket socket = new Socket("some.machine.edu", 6013);
		      
		      // Variables for getting input from server and output to the server
		      InputStream inServ = socket.getInputStream();
		      OutputStream outServ = socket.getOutputStream();
		      
		      // Variable b which takes in the data from the keyboard.
		      // If no errors occur, reads until end of input.
		      // writes b to outServ.
		      // Prints out and writes inKey
		      int b;
		      while((b = System.in.read()) != -1) {
		    	  outServ.write(b);
		    	  System.out.write(inServ.read());
		    	  outServ.flush();
		      }
		      
		      
		      
		     // Flush and close the outputs/inputs so there is no unwritten data
		      
		      System.out.flush();
		      inServ.close();
		      outServ.close();
		      socket.close();
		    } catch (IOException ioe) {
		      System.out.println("We caught an exception");
		      System.err.println(ioe);
		    }
		  }
}