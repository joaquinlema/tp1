package tp1_sye;

public class Tablero {
private int[] t;

public Tablero(int n){
	t = new int[n];
	for (int i = 0; i < t.length; i++) {
		t[i]=0;
	} 
}

public int damePos(int pos){
	if(pos<t.length){
	return t[pos];
	}
	return -1;
}

public void cargarTablero(SyE serpiente,SyE escalera){
	for (int i = 0; i < t.length; i++) {
		if(i == serpiente.getInicio()){
			t[i]=1;
		}else if(i == escalera.getInicio()){
			t[i]=2;
		}
	}
}

public int tama�o(){
	int tama�o = t.length;
	return tama�o;
}

public void imprimir(){
	for (int i = 0; i < t.length; i++) {
		System.out.print(" "+t[i]);
	}
	System.out.print(" ");
}
}
