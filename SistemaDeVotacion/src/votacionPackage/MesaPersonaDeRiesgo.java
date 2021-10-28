package votacionPackage;

import java.util.HashMap;

public class MesaPersonaDeRiesgo extends Mesa {
	private String tipoMesa;
	private Integer cod;
	private int presidenteMesa;
	private HashMap<Integer, Integer> franjasHorariasDisponibles;
	private Integer cupos;
	//cupos 20 x franjahoraria
	
	public MesaPersonaDeRiesgo(String tipoMesa, Integer cod, int presidenteMesa) {
		this.tipoMesa = tipoMesa;
		this.cod = cod;
		this.presidenteMesa = presidenteMesa;
		this.franjasHorariasDisponibles = new HashMap<Integer, Integer>();
		this.cupos = 20;
		//de 8 hasta 18 = 10 franjas, cupos = 20
		franjasHorariasDisponibles.put(8, cupos);
		franjasHorariasDisponibles.put(9, cupos);
		franjasHorariasDisponibles.put(10, cupos);
		franjasHorariasDisponibles.put(11, cupos);
		franjasHorariasDisponibles.put(12, cupos);
		franjasHorariasDisponibles.put(13, cupos);
		franjasHorariasDisponibles.put(14, cupos);
		franjasHorariasDisponibles.put(15, cupos);
		franjasHorariasDisponibles.put(16, cupos);
		franjasHorariasDisponibles.put(17, cupos);
		franjasHorariasDisponibles.put(18, cupos);
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public int dameCodigoDeMesa() {
		// TODO Auto-generated method stub
		return 0;
	}

}
