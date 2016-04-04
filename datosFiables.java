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
		//char [] arrayFrase = new char [frase.length()];
		for(int i=0; i<frase.length(); i++){
			salidaAServidor.writeBytes("(" + frase.charAt(i) + "," + i + ")");
			//salidaAServidor.write(i);
			ack = entradaDesdeServidor.read();
			if (i == ack){
				System.out.println("ACK: " + ack);
			}
		}
		salidaAServidor.writeBytes(null);
		System.out.println(entradaDesdeServidor.readLine());
		socketCliente.close();
			/* int ack = entrada.nextInt();
			if ( i == ack ) {
				char letra = frase.charAt(i);
				arrayFrase[i] = letra;
			}
				else{
					i--;
			}
		}
		salidaAServidor.writeBytes(frase + '\n');
		fraseModificada = entradaDesdeServidor.readLine();
		System.out.println("Del Servidor: " + fraseModificada);
		socketCliente.close();			
		System.out.print("Frase obtenida: ");
		for(int j=0;j<frase.length(); j++){
			System.out.print(arrayFrase[j]);
		}
		System.out.println(""); */
	}
	
}