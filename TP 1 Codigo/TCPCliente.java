import java.io.*;
import java.net.*;
class TCPCliente {
	//¿Que hace esta primer linea?
	public static void main(String argv[]) throws Exception
	{
		//Declaro las variables que voy a utilizar.
		//Como el programa va a trabajar con frases, los declaro String.
		//Son la frase que introduce el usuario y la que devuelve el server.
		String frase;
		String fraseModificada;
		//No me queda muy claro, pero al parecer se crea el objeto Buffered Reader.
		//Este objeto lo que hace es crear el objeto necesario para leer la entrada del usuario.
		BufferedReader entradaDesdeUsuario = new BufferedReader(
			new InputStreamReader(System.in));
		//Se crea el socket y se establece la conexion con el server.
		//"nombrehost" se reemplaza por el nombre del server.
		//6789 es el puerto asignado al socket. (Puede ser cualquiera siempre que coincida con el server).
		Socket socketCliente = new Socket("nombrehost", 6789);
		//Idem a antes. No me queda muy claro.
		//Creo que se crea los objetos de flujo que sacan y meten la info del socket cliente.
		DataOutputStream salidaAServidor = new DataOutputStream(
			socketCliente.getOutputStream());
		BufferedReader entradaDesdeServidor = 
			new BufferedReader(new InputStreamReader(
				socketCliente.getInputStream()));
		//Se guarda en la variable "frase" la entrada generada por el Cliente.
		//¿Tiene que ser si o si un objeto BufferedReader? ¿No puede ser una entrada normal?
		frase = entradaDesdeUsuario.readLine();
		//¿? ¿Que hace esto?
		salidaAServidor.writeBytes(frase + '\n');
		//La variable "fraseModificada" recibe los datos desde el server.
		//¿Como funca el objeto entradaDesdeServidor?
		fraseModificada = entradaDesdeServidor.readLine();
		//Se muestra en pantalla la frase obtenida
		System.out.println("Del Servidor: " + fraseModificada);
		//Cierra la conexion TCP.
		socketCliente.close();
	}
	
}