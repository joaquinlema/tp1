package tp1_sye;

public class Jugador {

	private int posicion;
	private String nombre;

public Jugador(){
	posicion = 0;
}

public Jugador(String nombre){
	this.nombre=nombre;
	posicion = 0;
}

public int getPosicion() {
	return posicion;
}

public void setPosicion(int posicion) {
	this.posicion = posicion;
}

public String getNombre(){
	return nombre;
}
public void setNombre(String nombre){
	 this.nombre=nombre;
}

}