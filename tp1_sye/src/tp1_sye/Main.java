package tp1_sye;

import java.util.Scanner;

public class Main {
	private static Scanner sca;
	
public static void main(String args[]){
	Juego_sye nuevo = new Juego_sye();
	sca = new Scanner(System.in);
	System.out.println("bienvenido a Serpientes y Escaleras");
	System.out.println("Ingrese tamaño del tablero:");
	int tamaño = sca.nextInt();
	tabla = new Tablero(tamaño);
	System.out.println("tablero creado");
	dado = new Dado();
	
	tabla.imprimir();
	System.out.println("");
	System.out.println("las serpientes estan representadas con el numero 1");
	System.out.println("las escaleras estan representadas con el numero 2");
	System.out.println("");
	System.out.print("jugador 1 ");
	p1 = new Jugador();
	System.out.print("jugador 2 ");
	p2 = new Jugador();
	System.out.println("Jugadores creados");

	nuevo.jugar();
}

}
