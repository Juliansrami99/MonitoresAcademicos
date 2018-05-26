
package webSockets;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import Clases.monitor;

public class websockets {
	
//	public static void main(String[] args) {
//		String hostName = "localhost";
//		
//		int portNumber = 9002;
//		Socket echoSocket;
//		byte[] msgByte = new byte[1024];
//		String msg = "como estas?";
//		try {
//		    echoSocket = new Socket(hostName, portNumber);
//
//		    
//		    PrintWriter out =
//		        new PrintWriter(echoSocket.getOutputStream(), true);
//		    
//		    BufferedReader in =
//		        new BufferedReader(
//		            new InputStreamReader(echoSocket.getInputStream()));
//		    
//		    
//		    out.println("julian/3543645.0/87/90/Macroeconomía 1");
//		    out.flush();
//		    
//		    ArrayList<monitor> lista=new ArrayList<monitor>();
//		    
//		    while(msg!="Hello from server") {
//		    	msg = in.readLine();
//			    System.out.println(msg);
//			    monitor a=new monitor();
//			    a.leerLineaMonitor(msg);
//			    lista.add(a);
//		    }
//
//		    
//		    echoSocket.close();
//			}
//		catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			
//			
//		}
//
//	}
//	
//	
//
//
}
