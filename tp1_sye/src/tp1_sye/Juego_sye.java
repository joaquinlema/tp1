package tp1_sye;

public class Juego_sye {
private Jugador p1,p2;
private Tablero tabla;
private Dado dado;
private boolean ganar;

public Juego_sye(int tama�oTablero,int tama�oSer,int inicioser,int tama�oEsca,int inicioesca){
	ganar = false;
	tabla = new Tablero(tama�oTablero,tama�oSer,tama�oEsca);
	System.out.println("tablero creado");
	dado = new Dado();

	tabla.agregarSerpiente(generadorSerpiente(tama�oSer,inicioser));
	tabla.agregarEscalera(generadorEscalera(tama�oEsca,inicioesca));
	tabla.imprimir();

	System.out.print("jugador 1 ");
	p1 = new Jugador();
	System.out.print("jugador 2 ");
	p2 = new Jugador();
	System.out.println("Jugadores creados");
}

public static SyE[] generadorEscalera(int n,int j){//n tama�o arreglo, j??, podria ser j = inicio
	SyE[] lista = new SyE[n];
	for (int i = 0; i < n; i++) {
		int ran = (int)(Math.random()*j);
		SyE aux = new SyE(j,ran+5);
		lista[i]=aux;
	}
	return lista;
}

public static SyE[] generadorSerpiente(int n,int j){//n tama�o arreglo, j??, podria ser j = inicio
	SyE[] lista = new SyE[n];
	for (int i = 0; i < n; i++) {
		int ran = (int)(Math.random()*j);
		SyE aux = new SyE(j,ran+5);
		lista[i]=aux;
	}
	return lista;
}


public String ganador(Jugador p){
	String ganador = p.getNombre();
	return ganador;
}

public boolean verificaGanador(){
	if(p1.getPosicion()>tabla.tama�o()){
		System.out.print("Jugador ganador: "+ganador(p1));
		ganar = true;
	}else if(p2.getPosicion()>tabla.tama�o()){
		System.out.print("Jugador ganador: "+ganador(p2));
		ganar = true;
	}
	return ganar;
}


public int actualizarPos(Jugador p,int destino){
	int posicionNueva = p.getPosicion() + destino;
	return posicionNueva;
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
		
		tabla.dondeCayo(p1);
		
		tabla.dondeCayo(p2);
		
		verificaGanador();
	}
}

}
