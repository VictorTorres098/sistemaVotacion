package votacionPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//implementar try and catch ya que como ahora esta implementado el programa finalizaria si ingresas un dato invalido


public class SistemaVotacion {
	private HashMap <Integer, Mesa> mesas;
	private HashMap<Integer, Persona> votantes;
	private int contMesa;
	/* Constructor del sistema de asignación de turnos.
	* Si el parámetro nombre fuera null, debe generar una excepción.
	*/
	public SistemaVotacion(String nombreSistema){
		if(nombreSistema.equals(null)) {
			throw new RuntimeException("El sistema debe tener un nombre"); //usar try and catch
		}
		votantes = new HashMap<Integer, Persona>();
		mesas = new HashMap<Integer, Mesa>();
		contMesa = 0;
	}
	/* Registrar a los votantes. Antes de asignar un turno el votante debe estar registrado
	* en el sistema.
	* Si no lo está, se genera una excepción.
	* Si la edad es menor a 16, se genera una excepción
	*/
	public void registrarVotante(Integer dni, String nombre, int edad, boolean enfPrevia, boolean trabaja){
		if(!estaEnPadron(dni) && edad >= 16) { //O(1)
			votantes.put(dni, new Persona(nombre,dni,edad,enfPrevia,trabaja));
		}else{
			throw new RuntimeException("El votante ya existe o tiene una edad invalida"); //try and catch
		}
	}
	
	public boolean estaEnPadron(int dni) {
		return votantes.containsKey(dni);
	}  
	public boolean tieneTurnoAsignado(int dni) {
		return votantes.get(dni).tieneTurnoAsignado();
	}
	/* Agregar una nueva mesa del tipo dado en el par�metro y asignar el presidente
	* de cada una, el cual deber� estar entre los votantes registrados y sin turno asignado.
	* - Devuelve el n�mero de mesa creada.
	* si el president es un votante que no est� registrado debe generar una excepci�n
	* si el tipo de mesa no es v�lido debe generar una excepci�n
	* Los tipos v�lidos son: �Enf_Preex�, �Mayor65�, �General� y �Trabajador�
	*/
	public int agregarMesa(String tipoMesa, int dni){
		//falta completar las variables de las mesas
		//validar dni y que este sin turno
		if(!estaEnPadron(dni) || !(votantes.get(dni).tieneTurnoAsignado()) || !(validarDato(tipoMesa)) ) {
			throw new RuntimeException("datos no validos"); //try and catch
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
	* - Si el DNI no pertenece a un votante registrado debe generar una excepci�n.
	* - Si el votante ya tiene turno asignado se devuelve el turno como: N�mero de
	* Mesa y Franja Horaria.
	* - Si a�n no tiene turno asignado se busca una franja horaria disponible en una
	* mesa del tipo correspondiente al votante y se devuelve el turno asignado, como
	* N�mero de Mesa y Franja Horaria.
	* - Si no hay mesas con horarios disponibles no modifica nada y devuelve null.
	* (Se supone que el turno permitir� conocer la mesa y la franja horaria asignada)
	*/
	public Tupla<Integer,Integer> asignarTurno(int dni){
		//definir mesa y agregar el turno en mesa
		//elif???????
		if( !(estaEnPadron(dni))) {
			throw new RuntimeException("datos no validos"); //try and catch
		}
		if(votantes.get(dni).tieneTurnoAsignado()) {
			return votantes.get(dni).devolverTurnoPersona();
		}
		if(votantes.get(dni).tieneEnfPrevia()) {
			int codMesaDisponible = dameMesaEspecialConCupos("Enf_Preex");				//busca la mesa especial y devuelve su cod ahora podemos trabajar sobre esa mesa!
			int horario = mesas.get(codMesaDisponible).dameFranjaHorariaDisponible();   //asigno a la variable algun horario disponible de la mesa
			votantes.get(dni).asignarMesaYFranja(codMesaDisponible, horario);			//al votante asigno el codMMesa, y su horario
			mesas.get(codMesaDisponible).descontarUnCupoDeFranja(horario);				//descuento de la mesa el cupon de la franja 	
			//a mesa pasarle el horario y el dni
		}
		if(votantes.get(dni).esMayorDeEdad()) {
			int codMesaDisponible = dameMesaEspecialConCupos("Mayor65");				//busca la mesa especial y devuelve su cod ahora podemos trabajar sobre esa mesa!
			int horario = mesas.get(codMesaDisponible).dameFranjaHorariaDisponible();   //asigno a la variable algun horario disponible de la mesa
			votantes.get(dni).asignarMesaYFranja(codMesaDisponible, horario);			//al votante asigno el codMMesa, y su horario
			mesas.get(codMesaDisponible).descontarUnCupoDeFranja(horario);				//descuento de la mesa el cupon de la franja	
		}
		if(votantes.get(dni).trabajaDiaVotacion()) {
			int codMesaDisponible = dameMesaEspecialConCupos("Trabajador");				//busca la mesa especial y devuelve su cod ahora podemos trabajar sobre esa mesa!
			int horario = mesas.get(codMesaDisponible).dameFranjaHorariaDisponible();   //asigno a la variable algun horario disponible de la mesa
			votantes.get(dni).asignarMesaYFranja(codMesaDisponible, horario);			//al votante asigno el codMMesa, y su horario
			mesas.get(codMesaDisponible).descontarUnCupoDeFranja(horario);				//descuento de la mesa el cupon de la franja
		}
		if(!votantes.get(dni).trabajaDiaVotacion() && !votantes.get(dni).esMayorDeEdad() && !votantes.get(dni).tieneEnfPrevia() ) {
			int codMesaDisponible = dameMesaEspecialConCupos("General");				//busca la mesa especial y devuelve su cod ahora podemos trabajar sobre esa mesa!
			int horario = mesas.get(codMesaDisponible).dameFranjaHorariaDisponible();   //asigno a la variable algun horario disponible de la mesa
			votantes.get(dni).asignarMesaYFranja(codMesaDisponible, horario);			//al votante asigno el codMMesa, y su horario
			mesas.get(codMesaDisponible).descontarUnCupoDeFranja(horario);
		}
		return votantes.get(dni).devolverTurnoPersona();
	}
	private int dameMesaEspecialConCupos(String condicionEspecialMesa) {
		int codMesa = 0;
		for(Integer claves : mesas.keySet()) { 
			if(mesas.get(claves).tipoDeMesa().equals(condicionEspecialMesa) && mesas.get(claves).dameFranjaHorariaDisponible() !=0) {
				codMesa = claves; 
			}
		}
		return codMesa;
	}
	/* Asigna turnos autom�ticamente a los votantes sin turno.
	* El sistema busca si hay alguna mesa y franja horaria factible en la que haya disponibilidad.
	* Devuelve la cantidad de turnos que pudo asignar.
	*/

	public int asignarTurno() {
		int cont = 0;
		for(Integer claves : votantes.keySet()) {
			if(!votantes.get(claves).tieneTurnoAsignado()) {
				asignarTurno(claves);
				cont++;
			}
		}
		return cont;
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
//	* - Si el DNI no pertenece a un votante genera una excepci�n.
//	* - Si el votante no tiene turno devuelve null.
	
	public Tupla<Integer, Integer> consultarTurno(int dni){
		if(votantes.get(dni).voto() && estaEnPadron(dni)) {
			return votantes.get(dni).devolverTurnoPersona();
		}else {
			return null;
		}
	}
	/* Dado un n�mero de mesa, devuelve una Map cuya clave es la franja horaria y
	* el valor es una lista con los DNI de los votantes asignados a esa franja.
	* Sin importar si se presentaron o no a votar.
	* - Si el n�mero de mesa no es v�lido genera una excepci�n.
	* - Si no hay asignados devuelve null.
	*/
	//recorrer a los votantes, ver su numero de mesa y agregarlos al map
	public Map<Integer,List<Integer>> asignadosAMesa(int numMesa){
		Map<Integer, List<Integer>> asigMesa = new HashMap<Integer,List<Integer>>();
		asigMesa.put(8, null);
		asigMesa.put(9, null);
		asigMesa.put(10, null);
		asigMesa.put(11, null);
		asigMesa.put(12, null);
		asigMesa.put(13, null);
		asigMesa.put(14, null);
		asigMesa.put(15, null);
		asigMesa.put(16, null);
		asigMesa.put(17, null);
		asigMesa.put(18, null);
		
		for(Integer horarios : asigMesa.keySet()) {
			asigMesa.put(horarios, dameListadeVotantesPorHorario(horarios,numMesa));
		}
		return asigMesa;
	}
	private List<Integer> dameListadeVotantesPorHorario(int horario , int mesa){
		List<Integer> listaDni = new ArrayList<Integer>();
		for(Integer claves: votantes.keySet()) {
			if(votantes.get(claves).dameMesa().equals(mesa) && votantes.get(claves).dameHorario().equals(horario)) {
				listaDni.add(votantes.get(claves).getDni());
			}
		}
		return listaDni;
	}
	/*
	* Consultar la cantidad de votantes sin turno asignados a cada tipo de mesa.
	* Devuelve una Lista de Tuplas donde se vincula el tipo de mesa con la cantidad
	* de votantes sin turno que esperan ser asignados a ese tipo de mesa.
	* La lista no puede tener 2 elementos para el mismo tipo de mesa.
	*/
	public List<Tupla<String, Integer>> sinTurnoSegunTipoMesa(){
		Integer contEnf = 0;
		Integer contMayor = 0;
		Integer contTrabj = 0;
		Integer contComun = 0;
		List<Tupla<String, Integer>> vinculo = new ArrayList<Tupla<String,Integer>>();
		for(Integer claves: votantes.keySet()) {
			if(votantes.get(claves).tieneEnfPrevia())
				contEnf++;
			if(votantes.get(claves).esMayorDeEdad())
				contEnf++;
			if(votantes.get(claves).trabajaDiaVotacion())
				contTrabj++;
			if(!votantes.get(claves).trabajaDiaVotacion() && !votantes.get(claves).esMayorDeEdad() && !votantes.get(claves).tieneEnfPrevia())
				contComun++;
		}
		vinculo.add(new Tupla<>("Enf_Preex",contEnf));
		vinculo.add(new Tupla<>("Mayor65", contMayor));
		vinculo.add(new Tupla<>("General", contComun));
		vinculo.add(new Tupla<>("Trabajador", contTrabj));
		
		return vinculo;
	}

}
