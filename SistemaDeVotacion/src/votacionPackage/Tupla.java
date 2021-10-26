package votacionPackage;

public class Tupla<T1, T2> {
	T1 valor1;
	T2 valor2;
	
	Tupla(T1 valor1, T2 valor2){
		this.valor1 = valor1;
		this.valor2 = valor2;
	}
	
	public T1 getX() {
		return valor1;
	}
	public T2 getY() {
		return valor2;
	}
	public void setX(T1 valor1) {
		this.valor1 = valor1;
	}
	public void setY(T2 valor2) {
		this.valor2 = valor2;
	}
	public String toString() {
		return ""+valor1.toString()+""+valor2.toString();
	}
}
