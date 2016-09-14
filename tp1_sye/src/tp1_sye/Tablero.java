package tp1_sye;

public class Tablero {
private int[] t;
private int[] serpientes;
private int[] escaleras;

public Tablero(int n){
	t = new int[n];
	for (int i = 0; i < t.length; i++) {
		t[i]=0;
	} 
}

public Tablero(int n,int ser,int esc){
	t = new int[n];
	for (int i = 0; i < t.length; i++) {
		t[i]=0;
	} 
	serpientes = new int[ser];
	escaleras = new int[esc];
}

public void agregarSerpiente(SyE[] serpiente){
	int i = 0;
	for (SyE syE : serpiente) {
		t[syE.getInicio()] = 1;
		serpientes[i] = syE.getInicio();
		i++;
	}
}

public void agregarEscalera(SyE[] escalera){
	int j=0;
	for (SyE syE : escalera) {
		t[syE.getInicio()]=2;
		escaleras[j] = syE.getInicio();
		j++;
	}
}

public void dondeCayo(Jugador j){
		if (t[j.getPosicion()] == 2) {
			System.out.println("el jugador: "+j.getNombre()+ " ha caido en una escalera");
			
		}else if(t[j.getPosicion()] == 1){
			System.out.println("el jugador: "+j.getNombre()+ " ha caido en una serpiente");
	}
	
	
	/*if (escalera.verificarSyE(j,tabla) == 2) {
		System.out.println("el jugador: "+j.getNombre()+ " ha caido en una escalera");
		j.setPosicion(escalera.getDestino());
	}else if(serpiente.verificarSyE(j,tabla) == 1){
		System.out.println("el jugador: "+j.getNombre()+ " ha caido en una serpiente");
		j.setPosicion(serpiente.getDestino());
	}
	*/
}

public int tamaño(){
	int tamaño = t.length;
	return tamaño;
}

public void imprimir(){
	for (int i = 0; i < t.length; i++) {
		System.out.print(" "+t[i]);
	}
}
}

