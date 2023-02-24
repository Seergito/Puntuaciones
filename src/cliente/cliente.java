package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket sck=null;
		
		try {
			Scanner entrada=new Scanner(System.in);
			sck=new Socket("localhost",55);
			DataInputStream input=new DataInputStream(sck.getInputStream());
			DataOutputStream output=new DataOutputStream(sck.getOutputStream());
			
			while(true) {
				
				System.out.println("Escribe un mensaje");
				String mensaje=entrada.nextLine();
				output.writeUTF(mensaje);
				String respuesta=input.readUTF();
				
				if(respuesta.equals("fin")) {break;}
			}
			
		} catch (Exception e) {e.printStackTrace();}

	}

}
