package votacionPackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//implementar try and catch ya que como ahora esta implementado el programa finalizaria si ingresas un dato invalido


public class SistemaVotacion {
	private HashMap mesas;
	private HashMap<Integer, Persona> votantes;
	
	public SistemaVotacion(String nombreSistema) throws Exception {
		if(nombreSistema.equals(null)) {
			throw new Exception("El votante no tiene la edad permitida para el sistema de votacion"); //usar try and catch
		}
		votantes = new HashMap<Integer, Persona>();
	}
	
	public void registrarVotante(Integer dni, String nombre, int edad, boolean enfPrevia, boolean trabaja) throws Exception {
		if(!estaEnPadron(dni)) {
			votantes.put(dni, new Persona(nombre,dni,edad,enfPrevia,trabaja));
		}else {
			throw new Exception("El votante ya existe"); //try and catch
		}
	}
	
	public boolean estaEnPadron(int dni) {
		return votantes.containsKey(dni);
	}  
	
	public int agregarMesa(String tipoMesa, int dni) {
		return -1;
	}
	
	public Tupla<Integer,Integer> asignarTurno(int dni){
		return null;
		//usar hashMap debido a mi implementacion pensada!
	}
	
	public int asignarTurno() {
		return -1;
	}
	
	public boolean votar(int dni) {
		return false;
	}
	
	public int votantesConTurno(String tipoMesa) {
		return -1;
	}
	
	public Tupla<Integer, Integer> consultarTurno(int dni){
		return null;
	}
	
	public Map<Integer,List<Integer>> asignadosAMesa(int numMesa){
		return null;
	}
	
	public List<Tupla<String, Integer>> sinTurnoSegunTipoMesa(){
		return null;
	}

}
