import java.io.*
import java.net.*
class UDPServidor{
	public static void main(String args[]) throws Exception{
		//Se crea el socket con el puerto de escucha.
		DatagramSocket socketServidor = new DatagramSocket(9876);
		byte[] recibirDatos = new byte[1024];
		byte[] enviarDatos = new byte[1024];
		while(true){
			DatagramPacket recibirPaquete =
				new DatagramPacket(recibirDatos, recibirDatos.length);
			//Recibe el paquete del cliente y lo almacena en recibirPaquete.
			socketServidor.receive(recibirPaquete);
			//Las 3 lineas siguiente, extraen desde el paquete:
			//La frase, la direccion IP y el puerto del cliente.
			String frase = new String(recibirPaquete.getData());
			InetAddress DireccionIP = recibirPaquete.getAddress();
			int puerto = recibirPaquete.getPort();
			String fraseMayuscula = frase.toUpperCase();
			enviarDatos = fraseMayuscula.getBytes();
			DatagramPacket enviarPaquete = 
				new DatagramPacket(enviarDatos,enviarDatos.length, DireccionIP, puerto);
			socketServidor.send(enviarPaquete);
		}
	}
}