package logic;

import entities.*;
import data.*;

public class Login {
	private DataUser dp;	
	
	public Login(){
		dp = new DataUser();
	}
	
	public Usuario validar(Usuario u) {
		return dp.getByMail(u);
	}

}
