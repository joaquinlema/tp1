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

public int damePos(int pos){
	if(pos<t.length){
	return t[pos];
	}
	return -1;
}

public void cargarTablero(SyE[] serpiente, SyE[] escalera){
	for (SyE syE : escalera) {
			t[syE.getInicio()]=1;
			serpientes[i] = syE.getInicio;
		}
	for (SyE syE : serpiente) {
		t[syE.getInicio()]=2;
		escaleras[i] = syE.getInicio;
	}
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
