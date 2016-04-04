import java.io.*;
import java.net.*;

class TCPCliente {
	//Es el metodo principal para ejecutarse. "Exception" permite manejar los errores internamente.
	public static void main(String argv[]) throws Exception {
		System.out.println("[SocketCliente] Iniciando...");
		// Declaro las variables que voy a utilizar.
		// Como el programa va a trabajar con frases, los declaro String.
		// Es la frase que introduce el usuario y la que devuelve el server.
		String frase;
		String fraseModificada;
		// No me queda muy claro, pero al parecer se crea el objeto Buffered
		// Reader.
		// Este objeto lo que hace es crear el objeto necesario para leer la
		// entrada del usuario.
		//Puedo poner directamente el nextLine().
		BufferedReader entradaDesdeUsuario = new BufferedReader(
				new InputStreamReader(System.in));
		// Se crea el socket y se establece la conexion con el server.
		// "nombrehost" se reemplaza por el nombre del server.
		// 6789 es el puerto asignado al socket. (Puede ser cualquiera siempre
		// que coincida con el server).
		Socket socketCliente = new Socket("localhost", 6789); //Puedo poner "192.168.X.X" entre comillas.

		System.out.println("[SocketCliente] creado en puerto 6789");
		// Stream Data y esos hacen y mantiene la conexion entre los sockets.
		DataOutputStream salidaAServidor = new DataOutputStream(
				socketCliente.getOutputStream());
		BufferedReader entradaDesdeServidor = new BufferedReader(
				new InputStreamReader(socketCliente.getInputStream()));
		// Se guarda en la variable "frase" la entrada generada por el Cliente.
		System.err.println("Ingrese una Frase");
		frase = entradaDesdeUsuario.readLine();
		System.out.println("[SocketCliente] leyo: " + frase);
		// Concatena un salto de linea.
		salidaAServidor.writeBytes(frase + '\n');
		System.out.println("[SocketCliente] enviada la solicitud al socketServidor");
		// La variable "fraseModificada" recibe los datos desde el server.
		// Â¿Como funca el objeto entradaDesdeServidor?
		fraseModificada = entradaDesdeServidor.readLine();
		// Se muestra en pantalla la frase obtenida
		System.out.println("[SocketCliente] Del Servidor: " + fraseModificada);
		// Cierra la conexion TCP.
		socketCliente.close();
	}

}