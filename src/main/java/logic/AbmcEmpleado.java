package logic;

import entities.*;
import data.*;

public class AbmcEmpleado {
	private DataEmpleado de;
	
	public AbmcEmpleado(){
		de = new DataEmpleado();
	}

	public Empleado getEmpleadoPorID(Empleado emp) {
		return de.getById(emp);
	}

}
