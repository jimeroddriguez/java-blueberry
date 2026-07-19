package logic;

import java.time.LocalDate;
import java.util.*;
import data.*;
import entities.*;

public class AbmcTurno {
	private DataTurno dt;
	private DataEmpleado de;
	
	public AbmcTurno(){
		dt = new DataTurno();
		de = new DataEmpleado();
	}
	
	public Turno reservarServicioPorProfesional(Empleado emp, Servicio serv, Horario h, LocalDate fecha) {
		return dt.reservarServicioPorProfesional(emp, serv, h, fecha);
	}
	
	public Turno reservarServicioPorHorario() {
		return dt.reservarServPorHor();
	}

	public ArrayList<Empleado> mostrarEmpleadosPorServicio(Servicio serv){
		return de.getEmpleadoPorServicio(serv);
	}
	
	
}
