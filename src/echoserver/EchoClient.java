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
		      Socket socket = new Socket("Reliant.morris.umn.edu", 6013);
		      // You can change 127.0.0.1 to a machine name if you want to try this across
		      // the network to another machine.
		      // Socket socket = new Socket("some.machine.edu", 6013);
		      
		      InputStream input = socket.getInputStream();
		      
		      BufferedReader read = new BufferedReader(new InputStreamReader(input));
		      
		      byte in;
		      while ((in = (byte) read.read()) != -1) {
		        System.out.println(in);
		      }
		      
		      socket.close();
		    } catch (IOException ioe) {
		      System.out.println("We caught an exception");
		      System.err.println(ioe);
		    }
		  }
}