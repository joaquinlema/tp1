package tp1_sye;

import java.util.Scanner;
public class Jugador {

	private int posicion;
	private String nombre;
	private Scanner nom;
	
public Jugador(){
	nom = new Scanner(System.in);
	System.out.println("Dame tu nombre: ");
	nombre = nom.nextLine();
	posicion = 0;
}

public int getPosicion() {
	return posicion;
}

public void setPosicion(int posicion) {
	this.posicion = posicion;
}

public String getNombre(){
	return nombre;
}

}