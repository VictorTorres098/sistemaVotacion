package votacionPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main  {
	public static void main(String[] args) {
		SistemaVotacion sistema = new SistemaVotacion("Test ungs"); //creo el sistema 
		sistema.registrarVotante(1, "pepe", 23, false, false); //votante comun y permitido 
		sistema.registrarVotante(2, "yuya", 19, true, false); // votante con enfermedad 
		sistema.registrarVotante(3, "sapito", 20, false, true); //votante trabaja
		//sistema.registrarVotante(3, "sapito", 20, false, true); //votante ya existe
		
		//Mesas Presidentes
		sistema.registrarVotante(4, "presidenteComun", 23, false, false);
		sistema.registrarVotante(5, "presidenteEnf", 23, false, false);
		sistema.registrarVotante(6, "presidenteMayorEdad", 23, false, false);
		sistema.registrarVotante(7, "presidenteTrab", 23, false, false);
		
		//crear mesas 
		System.out.println(sistema.agregarMesa("General", 4)); //mesa general debe retornar 1
		System.out.println(sistema.agregarMesa("Enf_Preex", 5)); //mesa general debe retornar 2
		System.out.println(sistema.agregarMesa("Mayor65", 6)); //mesa general debe retornar 3
		System.out.println(sistema.agregarMesa("Trabajador", 7)); //mesa general debe retornar 4
		
		
		
		
		
		
	
	
	
	
	}	
}
