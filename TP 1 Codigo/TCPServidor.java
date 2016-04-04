import java.io.*
import java.net.*
class TCPServidor {
	public static void main(String argv[]) throws Exception{
		String fraseCliente;
		String fraseMayusculas;
		//Se crea el Socket de "escucha". El socket va a estar a la escucha
		//en el puerto 6789 a la espera de un contacto de algun cliente.
		ServerSocket socketAcogida = new ServerSocket (6789);
		while(true){
			//Se crea un nuevo socket, el cual sera quien se comunique con
			//el cliente una vez que se establezca la conexion.
			//(Para este ejemplo, solo escucha una conexion por vez)
			Socket socketConexion = socketAcogida.accept();
			BufferedReader entradaDesdeCliente =
				new BufferedReader(new InputStreamReader(
					socketConexion.getInputStream()));
			DataOutputStream salidaACliente = 
				new DataOutputStream(socketConexion.getOutputStream());
			//fraseCliente recibe lo enviado por el Cliente	
			fraseCliente = entradaDesdeCliente.readLine();
			//fraseMayusculas toma la fraseCliente y la pasa a mayusculas.
			fraseMayusculas = fraseCliente.toUpperCase() + '\n';
			salidaACliente.writeBytes(fraseMayusculas);
		}
	}
}