package tp1_sye;

public class Dado {
private int cara;
private int cont;



public int getCara(){
	cara=(int)(1 + (Math.random()) *5);
	setCont(getCont() + 1);
	return cara;
}

public int getCont() {
	return cont;
}

public void setCont(int cont) {
	this.cont = cont;
}

}
