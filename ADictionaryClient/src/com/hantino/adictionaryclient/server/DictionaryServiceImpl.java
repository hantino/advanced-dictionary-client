package com.hantino.adictionaryclient.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hantino.adictionaryclient.client.DictionaryService;
import com.hantino.adictionaryclient.client.HostPort;

@SuppressWarnings("serial")
public class DictionaryServiceImpl extends RemoteServiceServlet implements DictionaryService {
	
	private static Socket socket;
	private static PrintWriter out;
	private static BufferedReader in;
	
	public ArrayList<String> getDictionaries(HostPort hostport) {
		// TODO Auto-generated method stub
		openCommand(hostport.getHost(), hostport.getPort());
		String fromServer;
		String fromUser = "SHOW DB";
		ArrayList<String> dicts = new ArrayList<String>();
		try {
			out.println(fromUser);
			while ((fromServer = in.readLine()) != null) {
				// check to see if it is a status code
				boolean isResponseCode = (fromServer.trim().length() > 2 
						&& Character.isDigit(fromServer.trim().charAt(0))
						&& Character.isDigit(fromServer.trim().charAt(1))
						&& Character.isDigit(fromServer.trim().charAt(2)));
		
				if (!isResponseCode) {
					//System.out.println(fromServer);
					dicts.add(fromServer);
				}
				else if (fromServer.trim().contains("250 ok")) {
					break;	
				}
			}
		} catch (IOException e) {
    			System.err.println("Caught IOException: " + e.getMessage());
		} catch (NullPointerException e) {
			System.err.println("Caught NullPointerException: " + e.getMessage());
		} finally {
			closeCommand();
		}
		return dicts;
	}
	
	// Command to open connection to server
		static void openCommand(String host, String port) {

			String hostName = host;
			int portNumber = Integer.parseInt(port);


			try {			
				socket = new Socket(hostName, portNumber);
				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new 
						InputStreamReader(socket.getInputStream()));

				// default dictionary
				
				//System.out.println("Connected");
			} catch(IOException e) {
				System.out.println("920 Control connection to " + 
						hostName +" on port "+ 
						portNumber +" failed to open.");
			}
		}
		
		// Command to close connection 
		public static void closeCommand() {
			try {
				out.close();
				in.close();
				socket.close();
			} catch (IOException e) {
				System.out.println("");
			}
		}
	
}
