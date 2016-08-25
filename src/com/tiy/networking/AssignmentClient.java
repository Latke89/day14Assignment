package com.tiy.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Brett on 8/25/16.
 */
public class AssignmentClient {

	public static void main(String[] args) {
			try {
				// connect to the server on the target port
				Socket clientSocket = new Socket("localhost", 8005);

				// once we connect to the server, we also have an input and output stream
				PrintWriter outputToServer = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader inputFromServer= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

				// send the server an arbitrary message
				outputToServer.println("Words words words");
				// read what the server returns
				String serverResponse = inputFromServer.readLine();

				// close the connection
				clientSocket.close();
			} catch (IOException clientException) {
				clientException.printStackTrace();
			}
		}
	}

