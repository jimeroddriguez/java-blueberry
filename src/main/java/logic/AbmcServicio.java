package logic;

import java.util.*;
import entities.*;
import data.*;

public class AbmcServicio {
	private DataServicio ds;
	
	public AbmcServicio(){
		ds = new DataServicio();
	}
	
	public ArrayList<Servicio> getAll(){
		return ds.getAll();
	}

	public Servicio getByID(Servicio serv) {
		return ds.getByID(serv);
	}
}
