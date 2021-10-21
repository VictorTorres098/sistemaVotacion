package votacionPackage;

public class Persona {
	private String nombre;
	private Integer dni;   //como voy usar los dni como un dato importante necesito que sean Integer
	private int edad;
	private boolean enfPrevia;
	private boolean trabaja;
	private boolean esPresidente;
	
	public Persona(String nombre, Integer dni, int edad, boolean enfPrevia, boolean trabaja) throws Exception{
		if(edad<16) {
			throw new Exception("El votante no tiene la edad permitida para el sistema de votacion");
		}
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.enfPrevia = enfPrevia;
		this.trabaja = trabaja;
		this.esPresidente = false;
	}
	public boolean esPresidenteDeMesa() {
		return esPresidente; //en caso de ser presidente retorna true
	}
	public boolean tieneCondicionEspecial() {
		return (this.enfPrevia || this.trabaja || edad >= 65); // en caso de cumplir algunas de estas condiciones retorna true
	}
	

}
