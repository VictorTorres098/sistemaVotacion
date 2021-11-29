package votacionPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main  {
	public static void main(String[] args) {
		SistemaVotacion sistema = new SistemaVotacion("Test ungs"); //creo el sistema 
		sistema.registrarVotante(1, "pepe", 23, false, false); //votante comun y permitido 
		sistema.registrarVotante(10, "pepe2", 23, false, false); //votante comun y permitido 
		sistema.registrarVotante(2, "yuya", 19, true, false); // votante con enfermedad 
		sistema.registrarVotante(3, "sapito", 20, false, true); //votante trabaja
		//sistema.registrarVotante(3, "sapito", 20, false, true); //votante ya existe
		
		//Mesas Presidentes
		sistema.registrarVotante(4, "presidenteComun", 23, false, false);
		sistema.registrarVotante(5, "presidenteEnf", 23, false, false);
		sistema.registrarVotante(6, "presidenteMayorEdad", 23, false, false);
		sistema.registrarVotante(7, "presidenteTrab", 23, false, false);
		
		//crear mesas 
		System.out.println(sistema.agregarMesa("General", 4)); //mesa general debe retornar 0
		System.out.println(sistema.agregarMesa("Enf_Preex", 5)); //mesa general debe retornar 1
		System.out.println(sistema.agregarMesa("Mayor65", 6)); //mesa general debe retornar 2
		System.out.println(sistema.agregarMesa("Trabajador", 7)); //mesa general debe retornar 3
		
		System.out.println("la cantidad de mesas creadas son: ");
		System.out.println(sistema.cantidadDeMesasCreadas() );
		System.out.println("Los id de mesas son: ");
		sistema.idDeMesas();
		//Mal funcionamiento de la asignacion de cleves
		
		//asignarTurnos// 
		//sistema.asignarTurno(8); //Debe generar un error ya que no existe el votante //funciona!!!
		sistema.asignarTurno(1); //votante debe ser asignado a mesa general ya que no tiene ninguna condicion especial
		//si uso de nuevo el metodo deberia devolverme el turno asignado
		//System.out.println(sistema.asignarTurno(1));
		sistema.asignarTurno(10);
		//System.out.println(sistema.asignarTurno(10));
		//Crear casos donde se supere el cupo para ver si cambia la franja horaria
		
		//consultarTurno
		System.out.println(sistema.consultarTurno(10));
		System.out.println(sistema.consultarTurno(1));
		//System.out.println(sistema.consultarTurno(2));  /pensar correctamente tieneTurnoAsignado de la clase Persosa no funciona 
		
		//asignadosAMesa
		System.out.println(sistema.asignadosAMesa(0));
		System.out.println(sistema.dameListadeVotantesPorHorario(15,0));
		
		//test de comparacion de Integer y int
		Integer test = 12;
		System.out.println(test.equals(12));
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	}	
}
