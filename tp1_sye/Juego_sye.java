package tp1_sye;

import java.util.Scanner;

public class Juego_sye {
private Jugador p1,p2;
private Tablero tabla;
private Dado dado;
private SyE serpiente,escalera;
private Scanner scan;
private boolean ganar;

public Juego_sye(){
	ganar = false;
	scan = new Scanner(System.in);
	System.out.println("bienvenido a Serpientes y Escaleras");
	System.out.println("Ingrese tamaño del tablero:");
	int tamaño = scan.nextInt();
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
}

public SyE[] generadorSye(int n,int j){
	SyE[] lista = new SyE[n];
	for (int i = 0; i < n; i++) {
		int ran = (int)(Math.random()*j);
		SyE aux = new SyE(ran,ran+5);
		lista[i]=aux;
	}
	return lista;
}

public String ganador(Jugador p){
	String ganador = p.getNombre();
	return ganador;
}

public boolean verificaGanador(){
	if(p1.getPosicion()>tabla.tamaño()){
		System.out.print("Jugador ganador: "+ganador(p1));
		ganar = true;
	}else if(p2.getPosicion()>tabla.tamaño()){
		System.out.print("Jugador ganador: "+ganador(p2));
		ganar = true;
	}
	return ganar;
}


public int actualizarPos(Jugador p,int destino){
	int posicionNueva = p.getPosicion() + destino;
	return posicionNueva;
}

public void dondeCayo(Jugador j){
	if (escalera.verificarSyE(j,tabla) == 1) {
		System.out.println("el jugador: "+j.getNombre()+ " ha caido en una escalera");
		j.setPosicion(escalera.getDestino());
	}else if(serpiente.verificarSyE(j,tabla) == 2){
		System.out.println("el jugador: "+j.getNombre()+ " ha caido en una serpiente");
		j.setPosicion(serpiente.getDestino());
	}
}

public void mostrarPosJugador(int p1pos,int p2pos){
	System.out.println("------------------------------------------------");
	System.out.println("Jugador 1 se encuentra en la posicion: "+p1pos);
	System.out.println("Jugador 2 se encuentra en la posicion: "+p2pos);
}
 public int tirarDado(){
	 return dado.getCara();
 }

public void jugar(){
	while(ganar == false){
		
		mostrarPosJugador(p1.getPosicion(),p2.getPosicion());
		
		System.out.println("------------------------------------------------");	
		System.out.println("jugador 1: "+p1.getNombre()+" tira dados:");
		p1.setPosicion(actualizarPos(p1,tirarDado()));
		
		System.out.println("jugador 2: "+p2.getNombre()+" tira dados:");
		p2.setPosicion(actualizarPos(p2,tirarDado()));
		System.out.println("------------------------------------------------");
		
		dondeCayo(p1);
		dondeCayo(p2);
		
		verificaGanador();
	}
}

}
