package tp1_sye;

public class Juego_sye {
private Jugador p1,p2;
private Tablero tabla;
public String ganador;
private Dado dado;

public Juego_sye(int tamañoTablero,String jugador1,String jugador2){
	dado = new Dado();
	tabla = new Tablero(tamañoTablero);
	p1 = new Jugador(jugador1);
	p2 = new Jugador(jugador2);
	ganador="";
}

public Juego_sye(int tamañoTablero){
	dado = new Dado();
	tabla = new Tablero(tamañoTablero);
	p1 = new Jugador();
	p2 = new Jugador();
	ganador="";
}


public String ver(){
	String ret="";
	ret+="Juega jugador : " +p1.getNombre()+"\n";
	ret+="Su posicion es : "+ p1.getPosicion()+"\n";
	ret+=tabla.imprimir()+"\n";
	ret+="Juega jugador : " +p2.getNombre()+"\n";
	ret+="Su posicion es : "+ p2.getPosicion()+"\n";
	ret+=tabla.imprimir()+"\n";
	return ret;
}

public void verificaGanador(){
	if(p1.getPosicion()>tabla.tamaño()){
		ganador=p1.getNombre();
	}else if(p2.getPosicion()>tabla.tamaño()){
		ganador=p2.getNombre();
	}else if (dado.getCont()==1000){
		ganador="Loser perdieron los dos";
	}
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
public void agregarEscalera(int inicio,int destino) throws Exception{
	tabla.agregarEscalera(inicio, destino);
}

public void agregarSerpiente(int inicio,int destino) throws Exception{
	tabla.agregarSerpiente(inicio, destino);
}

public int actualizarPos(Jugador p,int avanzar,int valor){
		int posicionNueva = p.getPosicion();
		if(valor == 2){//si es escalera
			SyE escalera = tabla.getEscalera(p.getPosicion()+avanzar);
			if(escalera!=null)
			posicionNueva= escalera.getDestino();
		}else if(valor == 1){//si es serpiente
			SyE serpiente = tabla.getSerpiente(p.getPosicion()+avanzar);
			if(serpiente!=null)
			posicionNueva= serpiente.getDestino();
		}else{//si no es nada
			posicionNueva += + avanzar;	
		}
		return posicionNueva;
	}


public void verificarCasilla(Jugador p,int avanzar){
	if (verificarSyE(p) == 2) {
		p.setPosicion(actualizarPos(p, avanzar,2));
	}else if(verificarSyE(p) == 1){
		p.setPosicion(actualizarPos(p,avanzar ,1));
	}else if (verificarSyE(p) == 0){	
		p.setPosicion(actualizarPos(p,avanzar ,0));	
	}
}

public void jugar(){

		verificarCasilla(p1,tirarDados());
		
		verificarCasilla(p2,tirarDados());
		
		verificaGanador();
	
}

private int tirarDados(){
	return dado.getCara();
}


public String ganador() {
	return ganador;
}


}
