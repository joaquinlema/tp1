package tp1_sye;

public class Dado {
private int cara;

public int getCara() {
	cara=(int)(1 + (Math.random()) *5);
	System.out.println("obtuvo: "+cara);
	return cara;
}

}
