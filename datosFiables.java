import java.io.*;
import java.net.*;

public class srvDatosFiables {
	public static void main(String argv[]) throws Exception{
	int valorCliente;
	ServerSocket socketAcogida = new ServerSocket (6789);
	while(true){
		Socket socketConexion = socketAcogida.accept();
		BufferedReader entradaDesdeCliente =
			new BufferedReader(new InputStreamReader(
				socketConexion.getInputStream()));
		DataOutputStream salidaACliente = 
			new DataOutputStream(socketConexion.getOutputStream());
		valorCliente = entradaDesdeCliente.read();
		salidaACliente.writeByte(valorCliente);
		}
	}
}