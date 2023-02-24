package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Hilo extends Thread {

	Socket sck;
	int cliente;
	
		public Hilo(Socket sck,int cliente) {
			this.sck=sck;
			this.cliente=cliente;
		}

		@Override
		public void run() {
			
			try {
				Scanner entrada=new Scanner(System.in);
				DataInputStream input =new DataInputStream(sck.getInputStream());
				DataOutputStream output=new DataOutputStream(sck.getOutputStream());
				System.out.println(cliente+"Cliente conectado");
				
				while(true) {
					String recibir=input.readUTF();
					System.out.println(cliente+":"+recibir);
					output.writeUTF(recibir);
					
					if(recibir.equals("fin")) { 
						String respuesta="fin";
						output.writeUTF(respuesta);
								}
					
				}
				
				
			} catch (Exception e) {e.printStackTrace();}
				
		}

}

