package edu.monmouth.clientserver;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		final int PORT= 3000;
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Waiting on port "+PORT + " for connection...");
			Socket clientSocket=serverSocket.accept();
			System.out.println("Accept returned!");
			//determine port#s and IP
			//write to client
			InetAddress clientInetAddress = clientSocket.getInetAddress();
			int remotePort = clientSocket.getPort();
			int localPort = clientSocket.getLocalPort();
			
			OutputStream os = clientSocket.getOutputStream();
			PrintWriter writer = new PrintWriter(os,true);
			writer.append("Hi this Brandon pleased to meet you! I see you are coming from " +clientInetAddress
					+ "using your remote port "+remotePort+ " accessing my port " +localPort);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Cannot create server socket "+ e.getMessage());
			System.exit(-1);
		}

	}

}
