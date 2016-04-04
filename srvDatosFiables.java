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
        while((fraseCliente = entradaDesdeCliente.readLine())!= null){
        	valorCliente = Integer.parseInt(""+(fraseCliente.charAt(3)));
        	//fraseMayusculas = fraseMayusculas + fraseCliente.charAt(2);
    		salidaACliente.write(valorCliente);
        	}
        salidaACliente.writeBytes(fraseMayusculas);
        socketConexion.close();
		//fraseCliente = entradaDesdeCliente.readLine();
		//fraseMayusculas = fraseCliente.toUpperCase() + '\n';
		//salidaACliente.writeBytes(fraseMayusculas);	
		}
	}
}