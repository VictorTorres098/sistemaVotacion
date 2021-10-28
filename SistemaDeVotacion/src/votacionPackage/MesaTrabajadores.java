package votacionPackage;

import java.util.HashMap;

public class MesaTrabajadores extends Mesa {
	private String tipoMesa;
	private Integer cod;
	private int presidenteMesa;
	private HashMap<Integer, Integer> franjasHorariasDisponibles;
	private Integer cupos;
	//unica franja horaria 8 hasta 12hs cupos ilimitados
	
	public MesaTrabajadores(String tipoMesa, Integer cod, int presidenteMesa) {
		this.tipoMesa = tipoMesa;
		this.cod = cod;
		this.presidenteMesa = presidenteMesa;
		this.franjasHorariasDisponibles = new HashMap<Integer, Integer>();
		this.cupos = 0;
		franjasHorariasDisponibles.put(8, cupos);
		franjasHorariasDisponibles.put(9, cupos);
		franjasHorariasDisponibles.put(10, cupos);
		franjasHorariasDisponibles.put(11, cupos);
		franjasHorariasDisponibles.put(12, cupos);
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
		return tipoMesa;
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
		//se agrega no se descuenta!!
		
	}

	@Override
	public int dameCodigoDeMesa() {
		// TODO Auto-generated method stub
		return 0;
	}

}
