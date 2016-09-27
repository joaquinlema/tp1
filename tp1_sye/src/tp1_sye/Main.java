package tp1_sye;

import java.util.Scanner;

public class Main {
	public static Scanner nom;
	public static void main(String args[]) throws Exception{
		
	nom = new Scanner(System.in);
	System.out.println("Dame tu nombre: ");
	String nombreJ1 = nom.nextLine();
	System.out.println("Dame tu nombre: ");
	String nombreJ2 = nom.nextLine();
	System.out.println("bienvenido a Serpientes y Escaleras");
	System.out.println("");
	System.out.println("las serpientes estan representadas con el numero 1");
	System.out.println("las escaleras estan representadas con el numero 2");
	System.out.println("");
	
	Juego_sye juego = new Juego_sye(80,nombreJ1,nombreJ2);
	System.out.println("tablero creado");
	System.out.println("Jugadores creados");

	juego.agregarEscalera(4,10);
	juego.agregarSerpiente(16,2);
	juego.agregarEscalera(12, 23);
	juego.agregarSerpiente(56, 3);
	
	while(juego.ganador()==""){
		juego.jugar();
		System.out.println(juego.ver());
	}
	System.out.println("El ganador es: "+juego.ganador);
	}
}
