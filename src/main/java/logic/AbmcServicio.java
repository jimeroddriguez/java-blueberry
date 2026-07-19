package logic;

import java.util.*;
import entities.*;
import data.*;

public class AbmcServicio {
	private DataServicio ds;
	
	public AbmcServicio(){
		ds = new DataServicio();
	}
	
	public ArrayList<Servicio> listar(){
		return ds.listServicio();
	}

	public Servicio buscarPorID(Servicio serv) {
		return ds.getServicioByID(serv);
	}
}
