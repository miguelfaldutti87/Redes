import java.net.*;
import java.io.*;
import java.util.*;

public class datosFiables {
	public static void main(String argv[]) throws Exception
	{
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca la frase");
		String frase = entrada.nextLine();
		Socket socketCliente = new Socket("localhost", 6789);
		DataOutputStream salidaAServidor = new DataOutputStream(
			socketCliente.getOutputStream());
		BufferedReader entradaDesdeServidor = 
				new BufferedReader(new InputStreamReader(
					socketCliente.getInputStream()));
		for(int i=0; i<frase.length(); i++){
			salidaAServidor.writeByte(i);
			int ack = entradaDesdeServidor.read();
			if (i == ack){
				System.out.println("ACK: " + ack);
			}
		}
	}
	
}