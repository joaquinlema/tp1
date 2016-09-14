package tp1_sye;

public class Juego_sye {
private Jugador p1,p2;
private Tablero tabla;
private SyE serpiente,escalera;
private boolean ganar;
private Dado dado;

public Juego_sye(int tamañoTablero){
	ganar = false;
	dado = new Dado();
	tabla = new Tablero(tamañoTablero);
	
	p1 = new Jugador();
	p2 = new Jugador();
	
}

public SyE[] generador(int n,int j){
	SyE[] lista = new SyE[n];
	for (int i = 0; i < n; i++) {
		int ran = (int)(Math.random()*tabla.tamaño());
		if (ran>j) {
			SyE aux = new SyE(j,ran);
			lista[i]=aux;
		}else{
		SyE aux = new SyE(j,j+5);
		lista[i]=aux;
		}
	}
	return lista;
}

public void agregarSerpiente(int inicio,int destino){
	serpiente = new SyE(inicio,destino);
	tabla.cargarSerpiente(serpiente);
}

public void agregarEscalera(int inicio,int destino){
		escalera = new SyE(inicio,destino);
		tabla.cargarEscalera(escalera);
	}

public void ver(){
	tabla.imprimir();
}

public void mostrarPosJugador(int p1pos,int p2pos){
	System.out.println("------------------------------------------------");
	System.out.println("Jugador 1 se encuentra en la posicion: "+p1pos);
	System.out.println("Jugador 2 se encuentra en la posicion: "+p2pos);
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
		return 2;
	}else if (esSerpiente(j1)) {
		return 1;
	}
	return 0;
}

	public int actualizarPos(Jugador p,int destino,int valor){
		int posicionNueva;
		if(valor == 2){//si es escalera
			posicionNueva = destino;
			return posicionNueva;
		}else if(valor == 1){//si es serpiente
			posicionNueva = destino;
			return posicionNueva;
		}else{//si no es nada
			posicionNueva = p.getPosicion() + destino;
		return posicionNueva;
		}
	}


public void dondeCayo(Jugador j){
	if (verificarSyE(j) == 2) {
		System.out.println("el jugador: "+j.getNombre()+ " ha caido en una escalera");
		j.setPosicion(actualizarPos(j, escalera.getDestino(),2));
	}else if(verificarSyE(j) == 1){
		System.out.println("el jugador: "+j.getNombre()+ " ha caido en una serpiente");
		j.setPosicion(actualizarPos(j, serpiente.getDestino(),1));
	}
}

public void jugar(){
	while(ganar == false){
		
		mostrarPosJugador(p1.getPosicion(),p2.getPosicion());
		
		System.out.println("------------------------------------------------");	
		System.out.println("jugador 1: "+p1.getNombre()+" tira dados:");
		p1.setPosicion(actualizarPos(p1,dado.getCara(),0));
		
		System.out.println("jugador 2: "+p2.getNombre()+" tira dados:");
		p2.setPosicion(actualizarPos(p2,dado.getCara(),0));
		System.out.println("------------------------------------------------");
		
		dondeCayo(p1);
		dondeCayo(p2);
		
		verificaGanador();
	}
}

}
