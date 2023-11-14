package edu.monmouth.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Supply IP or name of server");
		}
		try {
			InetAddress mu = InetAddress.getByName("Monmouth.edu");
			Socket socket = new Socket(mu,3000);
			System.out.println("Socket Established");
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			br.readLine();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Cannot attach to server "+ e.getMessage());
		}

	}

}
