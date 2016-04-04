import java.io.*;
import java.net.*;

class UDPCliente{
	public static void main(String args[]) throws Exception{
		//Idem a TCP
		BufferedReader entradaDesdeUsuario = 
			new BufferedReader(new InputStreamReader(System.in));
		//Se crea el socket del Cliente.
		//el tipo de socket es diferente al de TCP.
		//El objeto DatagramSocket no toma parametros por q no establece la conexion como en TCP.
		DatagramSocket socketCliente = new DatagramSocket();
		//Obtiene la direccion IP de "nombrehost" (gracias a los DNS) y lo almacena.
		InetAddress DireccionIP = InetAddress.getByName("nombrehost");
		//Estos objetos almacenan los datos que se van a enviar y recibir.
		//No entiendo cual es su fin.
		byte[] enviarDatos = new byte[1024];
		byte[] recibirDatos = new byte[1024];
		String frase = entradaDesdeUsuario.readLine();
		//Convierte un String en Bytes (creo)
		enviarDatos = frase.getBytes();
		//Se crea el paquete que se va a enviar.
		//El mismo se compone de los datos a enviar, ¿El largo de los datos? (para que?) y el puerto.
		DatagramPacket enviarPaquete = 
			new DatagramPacket(enviarDatos, enviarDatos.length, DireccionIP, 9876);
		//Se envia el paquete atraves del socket.	
		socketCliente.send(enviarPaquete);
		//Se crea el objeto que va a almacenar lo que envie el servidor.
		DatagramPacket recibirPaquete =
			new DatagramPacket(recibirDatos, recibirDatos.length);
		//El socket cliente recibe el nuevo paquete y lo almacena en recibirPaquete.
		socketCliente.receive(recibirPaquete);
		//Se convierte el paquete en un String y se almacena en la variable fraseModificada.
		String fraseModificada = new String(recibirPaquete.getData());
		System.out.println("Del Servidor: " + fraseModificada);
		//Se cierra el socket, pero este no avisa nada al servidor.
		socketCliente.close();
	}
}