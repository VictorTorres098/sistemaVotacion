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
		
	
	
	
	
	}	
}
