package com.tiy.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Brett on 8/25/16.
 */
public class ConnectionHandler implements Runnable {

	Socket connection;

	public ConnectionHandler(Socket incomingConnection) {
		this.connection = incomingConnection;
	}

	public void run() {
		handleIncomingConnections(connection);
	}


	private void handleIncomingConnections(Socket inputSocket) {
		try {
		// display information about who just connected to our server
		System.out.println("Incoming connection from " + inputSocket.getInetAddress().getHostAddress());

		// this is how we read from the client
		BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(inputSocket.getInputStream()));
		// this is how we write back to the client
		PrintWriter outputToClient = new PrintWriter(inputSocket.getOutputStream(), true);

		// read from the input until the client disconnects
		String inputLine;
		while ((inputLine = inputFromClient.readLine()) != null) {
			System.out.println("Received message: " + inputLine + " from " + inputSocket.toString());
			outputToClient.println("Message received loud and clear");
		}
		}catch (IOException exception){
			exception.printStackTrace();
		}
	}
}

