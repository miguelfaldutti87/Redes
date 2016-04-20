import java.io.*;
import java.net.*;

public class srvDatosFiables {
	public static void main(String argv[]) throws Exception{
	String fraseCliente;
	String fraseMayusculas="";
	int valorCliente;
	ServerSocket socketAcogida = new ServerSocket (6789);	
	while(true){
		System.out.println("Esperando...");
		Socket socketConexion = socketAcogida.accept();
		System.out.println("Cliente en línea");
		BufferedReader entradaDesdeCliente =
				new BufferedReader(new InputStreamReader(
					socketConexion.getInputStream()));
		DataOutputStream salidaACliente = 
				new DataOutputStream(socketConexion.getOutputStream());
		//fraseCliente = entradaDesdeCliente.readLine();
		/* while(fraseCliente != "FIN-ACK"){
			System.out.println("Enviando " + fraseCliente);
        	valorCliente = Integer.parseInt(""+(fraseCliente.charAt(3)));
        	fraseMayusculas = fraseMayusculas + fraseCliente.charAt(2);
        	//System.out.println("Enviando ACK: " + valorCliente + " - " + fraseCliente);
        	salidaACliente.write(valorCliente);
        	fraseCliente = entradaDesdeCliente.readLine();
        } */
        do{
        	fraseCliente = entradaDesdeCliente.readLine();
        	if (fraseCliente.equals("FINACK")){
        		break;
        	}
        	System.out.println(fraseCliente + "!FIN-ACK");
        	valorCliente = Integer.parseInt("" + (fraseCliente.charAt(3)));
        	fraseMayusculas = fraseMayusculas + fraseCliente.charAt(1);
        	System.out.println("Enviando ACK: " + valorCliente);
        	salidaACliente.write(valorCliente);
        }while(true);
        System.out.println("Enviando frase..");
        salidaACliente.writeBytes(fraseMayusculas);
        socketConexion.close();
		}
	}
}