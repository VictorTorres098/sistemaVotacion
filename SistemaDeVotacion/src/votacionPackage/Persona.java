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
	private Tupla<Integer, Integer> dondeVota;
//	private Integer mesa;
//	private Integer franja;
	
	public Persona(String nombre, Integer dni, int edad, boolean enfPrevia, boolean trabaja){
		if(edad<16) {
			throw new RuntimeException("El votante no tiene la edad permitida para el sistema de votacion");
		}
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.enfPrevia = enfPrevia;
		this.trabaja = trabaja;
		this.esPresidente = false;
		this.turno = false;
		this.voto = false;
		//dondeVota = null;
//		this.mesa = 0;
//		this.franja = 0;
	}
	public boolean esPresidenteDeMesa() {
		return esPresidente; //en caso de ser presidente retorna true
	}
	public boolean tieneCondicionEspecial() {
		return (this.enfPrevia || this.trabaja || edad >= 65); // en caso de cumplir algunas de estas condiciones retorna true
	}
	//comprobacion de condiciones especiales de persona
	public boolean tieneEnfPrevia() {
		return enfPrevia;
	}
	public boolean trabajaDiaVotacion() {
		return trabaja;
	}
	public boolean esMayorDeEdad() {
		if(this.edad>=65) {
			return true;
		}else {
			return false;
		}
	}
	public boolean tieneTurnoAsignado() {
		return turno;
	}
	public void confirmarTurno() {
		turno = true;
	}
	public boolean voto() {
		return this.voto;
	}
	public void confirmarVoto() {
		this.voto = true;
	}
	public void asignarMesaYFranja(Integer mesa, Integer franja) {
		this.dondeVota = new Tupla<Integer, Integer>(mesa, franja);
	}
	public Tupla<Integer, Integer> devolverTurnoPersona(){
		return dondeVota;
	}
	public Tupla<Integer, Integer> getDondeVota() {
		return dondeVota;
	}
	public Integer dameMesa() {
		return dondeVota.valor1; //valor1 mesa 
	}
	public Integer dameHorario() {
		return dondeVota.valor2; //valor2 Horario;
	}
	public Integer getDni() {
		return dni;
	}
}
