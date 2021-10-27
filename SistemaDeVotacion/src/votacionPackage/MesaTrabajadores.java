package votacionPackage;

public class MesaTrabajadores extends Mesa {
	private String tipoMesa;
	private Integer cod;
	private int presidenteMesa;
	//unica franja horaria 8 hasta 12hs cupos limitados
	
	public MesaTrabajadores(String tipoMesa, Integer cod, int presidenteMesa) {
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
