import java.net.*;
import java.io.*;
import java.util.*;

public class datosFiables {
	public static void main(String argv[]) throws Exception
	{
		Scanner entrada = new Scanner(System.in);
		int ack;
		System.out.println("Introduzca la frase");
		String frase = entrada.nextLine();
		//Creo el Socket
		Socket socketCliente = new Socket("localhost", 6789);
		//Creo los objetos que manejan la I/O de la aplicacion
		DataOutputStream salidaAServidor = new DataOutputStream(
			socketCliente.getOutputStream());
		BufferedReader entradaDesdeServidor = 
				new BufferedReader(new InputStreamReader(
					socketCliente.getInputStream()));
		
		for(int i=0; i<frase.length(); i++){
			salidaAServidor.writeBytes("(" + frase.charAt(i) + "," + i + ")" + '\n');
			ack = entradaDesdeServidor.read();
			if (i == ack){
				System.out.println("ACK: " + ack);
			}
		}		
		salidaAServidor.writeBytes("FINACK" + '\n');
		System.out.println("Frase obtenida: ");
		String entradaFinal = entradaDesdeServidor.readLine();
		System.out.println(entradaFinal);
	}
}