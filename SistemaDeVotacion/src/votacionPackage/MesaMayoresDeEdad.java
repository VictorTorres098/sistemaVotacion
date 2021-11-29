package votacionPackage;

import java.util.HashMap;

public class MesaMayoresDeEdad extends Mesa {
	private String tipoMesa;
	private Integer cod;
	private int presidenteMesa;
	private HashMap<Integer, Integer> franjasHorariasDisponibles;
	private Integer cupos;
	//cupos 10 x franja
	
	public MesaMayoresDeEdad(String tipoMesa, Integer cod, int presidenteMesa) {
		this.tipoMesa = tipoMesa;
		this.cod = cod;
		this.presidenteMesa = presidenteMesa;
		this.franjasHorariasDisponibles = new HashMap<Integer, Integer>();
		this.cupos = 10;
		//de 8 hasta 18 = 10 franjas, cupos = 10
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
		Integer horarioDisponible = 0;
		for(Integer horario : franjasHorariasDisponibles.keySet()) {
			if(tieneCuposDisponibles(horario)) {
				horarioDisponible = horario;
			}else {
				horarioDisponible = 0;
			}
		}
		return horarioDisponible;
	}

	@Override
	public boolean tieneCuposDisponibles(Integer horario) {
		if( franjasHorariasDisponibles.get(horario) <= 30 ) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void descontarUnCupoDeFranja(Integer horario) {
		int nuevoValorDeCupo = franjasHorariasDisponibles.get(horario) - 1; //descuento uno al cupo
		franjasHorariasDisponibles.put(horario, nuevoValorDeCupo);
		
	}

	@Override
	public int dameCodigoDeMesa() {
		return cod;
	}


	@Override
	public void asignarIDMesa() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int dameIDMesa() {
		// TODO Auto-generated method stub
		return 0;
	}

}
