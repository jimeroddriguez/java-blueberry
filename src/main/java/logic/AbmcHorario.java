package logic;

import java.util.ArrayList;

import data.*;
import entities.Empleado;
import entities.Horario;

public class AbmcHorario {
	private DataHorario dh;
	
	public AbmcHorario() {
		dh = new DataHorario();
	}

	public ArrayList<Horario> getHorariosPorIdEmpleado(Empleado emp) {
		return dh.getHorariosPorIdEmpleado(emp);
	}
	
	
}
