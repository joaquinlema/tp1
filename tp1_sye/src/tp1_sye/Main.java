package tp1_sye;

import java.util.Scanner;

public class Main {
	private static Scanner sca;
	
public static void main(String args[]){
	sca = new Scanner(System.in);
	System.out.println("bienvenido a Serpientes y Escaleras");
	System.out.println("Ingrese tama�o del tablero:");
	int tama�oTablero = sca.nextInt();
	System.out.println("Ingrese cantidad de serpientes:");
	int tama�oSer = sca.nextInt();
	System.out.println("Ingrese ubicacion de serpiente");
	int inicioser = sca.nextInt();
	System.out.println("Ingrese cantidad de escaleras:");
	int tama�oEsc = sca.nextInt();
	System.out.println("Ingrese ubicacion escalera");
	int inicioesc = sca.nextInt();
	
	Juego_sye nuevo = new Juego_sye(tama�oTablero,tama�oSer,inicioser,tama�oEsc,inicioesc);
	
	System.out.println("");
	System.out.println("las serpientes estan representadas con el numero 1");
	System.out.println("las escaleras estan representadas con el numero 2");
	System.out.println("");

	nuevo.jugar();
}

}
