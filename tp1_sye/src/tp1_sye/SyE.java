package tp1_sye;

public class SyE {
private int inicio,destino;

public SyE(int inicio, int destino){
	this.inicio = inicio;
	this.destino = destino;
}

public int getInicio() {
	return inicio;
}

public void setInicio(int inicio) {
	this.inicio = inicio;
}

public int getDestino() {
	return destino;
}

public void setDestino(int destino) {
	this.destino = destino;
}

public boolean esEscalera(Jugador j,Tablero tabla){
	if (tabla.damePos(j.getPosicion()) == 2) {
		return true;
	}
	return false;
}

public boolean esSerpiente(Jugador j,Tablero tabla){
	if (tabla.damePos(j.getPosicion()) == 1) {
		return true;
	}
	return false;
}

public int verificarSyE(Jugador j1,Tablero tabla){
	if (esEscalera(j1,tabla)) {
		return 1;
	}else if (esSerpiente(j1,tabla)) {
		return 2;
	}
	return 0;
}

}
