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
	/* Agregar una nueva mesa del tipo dado en el parámetro y asignar el presidente
	* de cada una, el cual deberá estar entre los votantes registrados y sin turno asignado.
	* - Devuelve el número de mesa creada.
	* si el president es un votante que no está registrado debe generar una excepción
	* si el tipo de mesa no es válido debe generar una excepción
	* Los tipos válidos son: “Enf_Preex”, “Mayor65”, “General” y “Trabajador”
	*/
	public int agregarMesa(String tipoMesa, int dni) throws Exception {
		//falta completar las variables de las mesas
		//validar dni y que este sin turno
		if(estaEnPadron(dni) || !(votantes.get(dni).tieneTurnoAsignado()) || !(validarDato(tipoMesa)) ) {
			throw new Exception("datos no validos"); //try and catch
		}
		if(tipoMesa.equals("Enf_Preex") ) {
			mesas.put(contMesa, new MesaPersonaDeRiesgo("Enf_Preex",contMesa, dni));
			contMesa++;
		}
		if(tipoMesa.equals("Mayor65") ) {
			mesas.put(contMesa, new MesaMayoresDeEdad("Mayor65", contMesa, dni));
			contMesa++;
		}
		if(tipoMesa.equals("General")) {
			mesas.put(contMesa, new MesaComun("General", contMesa, dni));
			contMesa++;
		}
		if(tipoMesa.equals("Trabajador") ) {
			mesas.put(contMesa, new MesaTrabajadores("Trabajador", contMesa, dni));
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
	/* Asigna un turno a un votante determinado.
	* - Si el DNI no pertenece a un votante registrado debe generar una excepción.
	* - Si el votante ya tiene turno asignado se devuelve el turno como: Número de
	* Mesa y Franja Horaria.
	* - Si aún no tiene turno asignado se busca una franja horaria disponible en una
	* mesa del tipo correspondiente al votante y se devuelve el turno asignado, como
	* Número de Mesa y Franja Horaria.
	* - Si no hay mesas con horarios disponibles no modifica nada y devuelve null.
	* (Se supone que el turno permitirá conocer la mesa y la franja horaria asignada)
	*/
	public Tupla<Integer,Integer> asignarTurno(int dni) throws Exception{
		//definir mesa y agregar el turno en mesa
		//elif???????
		if( !(estaEnPadron(dni))) {
			throw new Exception("datos no validos"); //try and catch
		}
		if(votantes.get(dni).tieneTurnoAsignado()) {
			return votantes.get(dni).devolverTurnoPersona();
		}
		if(votantes.get(dni).tieneEnfPrevia()) {
			for(Integer claves : mesas.keySet()) {
				if(mesas.get(claves).tipoDeMesa().equals("Enf_Preex") && mesas.get(claves).dameFranjaHorariaDisponible() != 0) {
					mesas.get(claves).descontarUnCupoDeFranja(mesas.get(claves).dameFranjaHorariaDisponible()); //cuento que cada vez que llamo a la funcion me devuelva el mismo horario
					votantes.get(dni).asignarMesaYFranja(mesas.get(claves).dameCodigoDeMesa(),mesas.get(claves).dameFranjaHorariaDisponible());
				}
			}
		}
		
		
		return votantes.get(dni).devolverTurnoPersona();
		
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
//	 Consulta el turno de un votante dado su DNI. Devuelve Mesa y franja horaria.
//	* - Si el DNI no pertenece a un votante genera una excepción.
//	* - Si el votante no tiene turno devuelve null.
	
	public Tupla<Integer, Integer> consultarTurno(int dni){
		if(votantes.get(dni).voto() && estaEnPadron(dni)) {
			return votantes.get(dni).devolverTurnoPersona();
		}else {
			return null;
		}
	}
	/* Dado un número de mesa, devuelve una Map cuya clave es la franja horaria y
	* el valor es una lista con los DNI de los votantes asignados a esa franja.
	* Sin importar si se presentaron o no a votar.
	* - Si el número de mesa no es válido genera una excepción.
	* - Si no hay asignados devuelve null.
	*/
	
	public Map<Integer,List<Integer>> asignadosAMesa(int numMesa){
		
		
		
		
		return null;
	}
	
	public List<Tupla<String, Integer>> sinTurnoSegunTipoMesa(){
		return null;
	}

}
