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
	
	public abstract int dameFranjaHorariaDisponible();
	
	public abstract boolean tieneCuposDisponibles(Integer horario);
	
	public abstract void descontarUnCupoDeFranja(Integer horario);
	
	public abstract int dameCodigoDeMesa();
}
