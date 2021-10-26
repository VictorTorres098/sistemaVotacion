package votacionPackage;

public class Persona {
	private String nombre;
	private Integer dni;   //como voy usar los dni como un dato importante necesito que sean Integer
	private int edad;
	private boolean enfPrevia;
	private boolean trabaja;
	private boolean esPresidente;
	private boolean turno;
	private boolean voto;
	
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
		this.turno = false;
		this.voto = false;
	}
	public boolean esPresidenteDeMesa() {
		return esPresidente; //en caso de ser presidente retorna true
	}
	public boolean tieneCondicionEspecial() {
		return (this.enfPrevia || this.trabaja || edad >= 65); // en caso de cumplir algunas de estas condiciones retorna true
	}
	public boolean tieneTurnoAsignado() {
		return this.turno;
	}
	public void confirmarTurno() {
		this.turno = true;
	}
	public boolean voto() {
		return this.voto;
	}
	public void confirmarVoto() {
		this.voto = true;
	}
	

}
