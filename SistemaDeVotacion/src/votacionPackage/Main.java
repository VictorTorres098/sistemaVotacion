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
		sistema.registrarVotante(8, "abu", 77, false, false); //votante Mayor de edad
		
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
		
		//asignarTurnos// 
		
		//1 comprobar si los gets de condicion especial de los votantes funciona correctamente
		// se consultara en primer lugar al votante con enfermedad, en segundo caso a votante trabaja  y por ultimo si es mayor de edad
		// por variable se pasaran a votantes que cumplan esta condicion y en todos los casos debera devolver TRUE
		System.out.println(sistema.elVotanteTieneEnfPrev(2));   //votante ENFPREEX
		System.out.println(sistema.elVotanteTrabaj(3));			//trabaja
		System.out.println(sistema.elVotanteEsMayorDeEdad(8));	//es mayor de edad
		
		//funciona correctamente los Gets de condicion especial!!!!!
		
		//ahora veremos si la funcion auxiliar dameMesaEspecialConCupos funciona correctamente 
		System.out.println(sistema.dameMesaEspecialConCupos("General"));
		System.out.println(sistema.dameMesaEspecialConCupos("Enf_Preex"));
		System.out.println(sistema.dameMesaEspecialConCupos("Mayor65"));
		System.out.println(sistema.dameMesaEspecialConCupos("Trabajador"));
		
		//funciona mal !
		
			
		
		//sistema.asignarTurno(8); //Debe generar un error ya que no existe el votante //funciona!!!
		sistema.asignarTurno(1); //votante debe ser asignado a mesa general ya que no tiene ninguna condicion especial
		//si uso de nuevo el metodo deberia devolverme el turno asignado
		//System.out.println(sistema.asignarTurno(1));
		sistema.asignarTurno(10);
		//ahora asignamos a un sujeto con una condicion especial y deberia devolver otro numero de mesa
		sistema.asignarTurno(2);
		//System.out.println(sistema.asignarTurno(10));
		//Crear casos donde se supere el cupo para ver si cambia la franja horaria
		
		//consultarTurno
		System.out.println(sistema.consultarTurno(10));
		System.out.println(sistema.consultarTurno(1));
		System.out.println(sistema.consultarTurno(2));
		//System.out.println(sistema.consultarTurno(2));  /pensar correctamente tieneTurnoAsignado de la clase Persona no funciona 
		
		//asignadosAMesa
		System.out.println(sistema.asignadosAMesa(0));
		System.out.println(sistema.dameListadeVotantesPorHorario(15,0));
		
		//test de comparacion de Integer y int
		Integer test = 12;
		System.out.println(test.equals(12));
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	}	
}
