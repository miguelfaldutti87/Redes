import java.util.*;
public class rip {
	
	public static void main(String[] args) {
		int num1,resto,cociente;
		Scanner entrada=new Scanner(System.in);
		System.out.println("Ingrese el numero: ");
		String sCadena, sCadenaInvertida;
		sCadena="";
		sCadenaInvertida="";
		num1=entrada.nextInt();
		cociente=num1/2;
		resto=num1%2;
		System.out.print("En binario: ");
		while (cociente!=0) {
			//System.out.print(resto);
			sCadena = sCadena + resto;
			resto=cociente%2;
			cociente=cociente/2;
			
		}
		//System.out.print(resto);
		sCadena = sCadena + resto;
		for (int x=sCadena.length()-1;x>=0;x--)
			sCadenaInvertida = sCadenaInvertida + sCadena.charAt(x);
		System.out.println(sCadenaInvertida);
	}

}