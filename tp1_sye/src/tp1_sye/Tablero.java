package tp1_sye;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
private int[] t;
private List <SyE> serpientes;
private List <SyE> escaleras;

public Tablero(int n){
	t = new int[n];
	for (int i = 0; i < t.length; i++) {
		t[i]=0;
	} 
	serpientes = new ArrayList<SyE>();
	escaleras = new ArrayList<SyE>();
}

public int damePos(int pos){
	if(pos<t.length){
	return t[pos];
	}
	return -1;
}

public int tama�o(){
	int tama�o = t.length;
	return tama�o;
}

public String imprimir(){
	String ret="";
	for (int i = 0; i < t.length; i++) {
		ret+=" "+t[i];
	}
	return ret;
}

private void cargarSerpiente(SyE serpiente){
	t[serpiente.getInicio()-1]=1;
	serpientes.add(serpiente);
}

private void cargarEscalera(SyE escalera){
	t[escalera.getInicio()-1]=2;
	escaleras.add(escalera);
}
public void agregarSerpiente(int inicio,int destino) throws Exception{
	if(1 < destino && inicio > destino && inicio < tama�o() && inicio != destino){
		SyE serpiente = new SyE(inicio,destino);
		this.cargarSerpiente(serpiente);
	}else{ 
		throw new Exception("DATOS DE CREACI�N DE SERPIENTES SON INCORRECTOS");
	}
	
}

public void agregarEscalera(int inicio,int destino) throws Exception{
	if(1 < inicio && destino > inicio && destino < tama�o()&& inicio != destino){
		SyE escalera = new SyE(inicio,destino);
			this.cargarEscalera(escalera);
	}else{ 
		throw new Exception("DATOS DE CREACI�N DE ESCALERAS SON INCORRECTOS");
	}
}

public SyE getSerpiente(int i) {
	for (SyE syE : serpientes) {
		if(syE.getInicio()==i){
			return syE;
		}
	}
	return null;
}


public SyE getEscalera(int i) {
	for (SyE syE : escaleras) {
		if(syE.getInicio()==i){
			return syE;
		}
	}
	return null;
}


}
