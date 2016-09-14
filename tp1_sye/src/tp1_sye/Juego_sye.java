package tp1_sye;

public class Juego_sye {
private Jugador p1,p2;
private Tablero tabla;
private SyE serpiente,escalera;
private boolean ganar;

public Juego_sye(int tamañoTablero){
	ganar = false;
	
	tabla = new Tablero(tamañoTablero);
	
	serpiente = new SyE(12,2);
	escalera = new SyE(1,10);
	tabla.cargarTablero(serpiente,escalera);
	
	tabla.imprimir();
	
	p1 = new Jugador();
	p2 = new Jugador();
	
}

public void mostrarPosJugador(int p1pos,int p2pos){
	System.out.println("------------------------------------------------");
	System.out.println("Jugador 1 se encuentra en la posicion: "+p1pos);
	System.out.println("Jugador 2 se encuentra en la posicion: "+p2pos);
}

public int tirarDados(){
	int dados =(int)(1 + (Math.random()) *5);
	System.out.println("obtuvo: "+dados);
	return dados;
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

public boolean esEscalera(Jugador j){
	if (tabla.damePos(j.getPosicion()) == 2) {
		return true;
	}
	return false;
}

public boolean esSerpiente(Jugador j){
	if (tabla.damePos(j.getPosicion()) == 1) {
		return true;
	}
	return false;
}

public int verificarSyE(Jugador j1){
	if (esEscalera(j1)) {
		return 1;
	}else if (esSerpiente(j1)) {
		return 2;
	}
	return 0;
}

public int actualizarPos(Jugador p,int destino){
	int posicionNueva = p.getPosicion() + destino;
	return posicionNueva;
}

public void dondeCayo(Jugador j){
	if (verificarSyE(j) == 1) {
		System.out.println("el jugador: "+j.getNombre()+ " ha caido en una escalera");
		j.setPosicion(actualizarPos(j, escalera.getDestino()));
	}else if(verificarSyE(j) == 2){
		System.out.println("el jugador: "+j.getNombre()+ " ha caido en una serpiente");
		j.setPosicion(actualizarPos(j, serpiente.getDestino()));
	}
}

public void jugar(){
	while(ganar == false){
		
		mostrarPosJugador(p1.getPosicion(),p2.getPosicion());
		
		System.out.println("------------------------------------------------");	
		System.out.println("jugador 1: "+p1.getNombre()+" tira dados:");
		p1.setPosicion(actualizarPos(p1,tirarDados()));
		
		System.out.println("jugador 2: "+p2.getNombre()+" tira dados:");
		p2.setPosicion(actualizarPos(p2,tirarDados()));
		System.out.println("------------------------------------------------");
		
		dondeCayo(p1);
		dondeCayo(p2);
		
		verificaGanador();
	}
}

}
