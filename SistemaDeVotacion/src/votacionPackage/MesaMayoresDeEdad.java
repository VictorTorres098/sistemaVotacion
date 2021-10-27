package votacionPackage;

public class MesaMayoresDeEdad extends Mesa {
	private String tipoMesa;
	private Integer cod;
	private int presidenteMesa;
	//cupos 10 x franja
	
	public MesaMayoresDeEdad(String tipoMesa, Integer cod, int presidenteMesa) {
		this.tipoMesa = tipoMesa;
		this.cod = cod;
		this.presidenteMesa = presidenteMesa;
	}

	@Override
	public void designarPresidente(int dni) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int cuposRestante() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int consultarCuposTotales() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cantidadDeTurnosDesignados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String tipoDeMesa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int dameFranjaHorariaDisponible() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean tieneCuposDisponibles(Integer horario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void descontarUnCupoDeFranja(Integer horario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int dameCodigoDeMesa() {
		// TODO Auto-generated method stub
		return 0;
	}

}
