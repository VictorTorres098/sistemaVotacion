package votacionPackage;

public abstract class Mesa {
	/**
     * Default constructor
     */
	public Mesa() {
		
	}
	public abstract void designarPresidente(int dni);
	
	public abstract int cuposRestante();
	
	public abstract int consultarCuposTotales();
	
	public abstract int cantidadDeTurnosDesignados();
	
	public abstract String tipoDeMesa();
}
