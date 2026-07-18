package entities;

import java.time.*;

public class Horario {
	private int idHorario;
	private Empleado empleado;
	private int day;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalTime getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}
	
	public String nombredeldia(int day){
		String nom;
		switch(day) {
		case 1:
			nom = "Lunes";
			break;
		case 2:
			nom = "Martes";
			break;
		case 3:
			nom = "Miercoles";
			break;
		case 4:
			nom = "Jueves";
			break;
		case 5:
			nom = "Viernes";
			break;
		default:
			nom = "";
		}
		return nom;
	}
	@Override
	public String toString() {
		return "\nHorario [idHorario=" + idHorario + ", empleado=" + empleado + ", dia=" + nombredeldia(day) + ", horaInicio="
				+ horaInicio + ", horaFin=" + horaFin + "]";
	}
	
	
	
}
