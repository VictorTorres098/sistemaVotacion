package votacionPackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//implementar try and catch ya que como ahora esta implementado el programa finalizaria si ingresas un dato invalido


public class SistemaVotacion {
	private HashMap <Integer, Mesa> mesas;
	private HashMap<Integer, Persona> votantes;
	private int contMesa;
	
	public SistemaVotacion(String nombreSistema) throws Exception {
		if(nombreSistema.equals(null)) {
			throw new Exception("El votante no tiene la edad permitida para el sistema de votacion"); //usar try and catch
		}
		votantes = new HashMap<Integer, Persona>();
		contMesa = 0;
	}
	
	public void registrarVotante(Integer dni, String nombre, int edad, boolean enfPrevia, boolean trabaja) throws Exception {
		if(!estaEnPadron(dni)) {
			votantes.put(dni, new Persona(nombre,dni,edad,enfPrevia,trabaja));
		}else {
			throw new Exception("El votante ya existe"); //try and catch
		}
	}
	
	public boolean estaEnPadron(int dni) {
		return votantes.containsKey(dni); //generar la excepcion aca si esta el votante
	}  
	public boolean tieneTurnoAsignado(int dni) {
		return votantes.get(dni).tieneTurnoAsignado();
	}
	
	public int agregarMesa(String tipoMesa, int dni) {
		//falta completar las variables de las mesas
		//validar dni y que este sin turno
		if(tipoMesa.equals("Enf_Preex")) {
			mesas.put(contMesa, new MesaPersonaDeRiesgo("Enf_Preex",contMesa, dni));
			contMesa++;
		}
		if(tipoMesa.equals("Mayor65")) {
			mesas.put(contMesa, new MesaMayoresDeEdad());
			contMesa++;
		}
		if(tipoMesa.equals("General")) {
			mesas.put(contMesa, new MesaComun());
			contMesa++;
		}
		if(tipoMesa.equals("Trabajador")) {
			mesas.put(contMesa, new MesaTrabajadores());
			contMesa++;
		}
		return contMesa;
	}
	public boolean validarDato(String tipoMesa) {
		if(tipoMesa.equals("Enf_Preex") || tipoMesa.equals("Mayor65") || tipoMesa.equals("Trabajador")) {
			return true;
		}else {
			return false;
		}
	}
	public Tupla<Integer,Integer> asignarTurno(int dni){
		//definir mesa y agregar el turno en mesa
		if(estaEnPadron(dni) && !tieneTurnoAsignado(dni)) {
			return new Tupla(1,2);
		}
		return new Tupla(1,2);
	}
	
	public int asignarTurno() {
		//usar iteradores
		return -1;
	}
	
	public boolean votar(int dni) {
		//implementar los correspondientes IREP
		votantes.get(dni).confirmarVoto();
		return votantes.get(dni).voto();
	}
	
	public int votantesConTurno(String tipoMesa) {
		//implementar los correspondientes IREP
		int turnosDeMesa = 0;
		for(Integer clavesMesas : mesas.keySet()) {
			if(mesas.get(clavesMesas).tipoDeMesa().equals(tipoMesa)) {
				turnosDeMesa = mesas.get(clavesMesas).cantidadDeTurnosDesignados();
			}
		}
		return turnosDeMesa;
	}
	
	public Tupla<Integer, Integer> consultarTurno(int dni){
		//el cupon de su turno debe estar en mesa y persona
		return null;
	}
	
	public Map<Integer,List<Integer>> asignadosAMesa(int numMesa){
		return null;
	}
	
	public List<Tupla<String, Integer>> sinTurnoSegunTipoMesa(){
		return null;
	}

}
