package tp1_sye;

public class Main {
	
	public static void main(String args[]){
	System.out.println("bienvenido a Serpientes y Escaleras");
	System.out.println("");
	System.out.println("las serpientes estan representadas con el numero 1");
	System.out.println("las escaleras estan representadas con el numero 2");
	System.out.println("");
	
	Juego_sye juego = new Juego_sye(80);
	
	System.out.println("tablero creado");
	System.out.println("Jugadores creados");
	juego.jugar();
	}
}
