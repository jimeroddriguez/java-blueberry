package ui;

import java.util.*;

import entities.*;
import logic.*;

public class Menu {
	Scanner lector = null;
	Login ctrlLogin = new Login();
	
	public void start() {
		lector = new Scanner(System.in);
		Usuario u = login();
		if(u!= null) {
			System.out.println("\nBienvenido "+u.getNombre()+" "+u.getApellido()+"!");
			System.out.println("TU ROL EN LA PÁGINA ES: " + u.getDefClase());
			String opc;
			do {
				opc = mostrarOpciones();
				ejecutarOpcion(opc);
			}while (!opc.trim().equalsIgnoreCase("g"));
		}else {
			System.out.println("Error: Email o contraseña incorrectos. Reintente");
		}
	lector.close();
	}

	private void ejecutarOpcion(String opc) {
		switch(opc) {
		case "a":
			System.out.println("opcion a");
			break;
		case "b":
			System.out.println("opcion b");
			break;
		case "c":
			System.out.println("opcion c");
			break;
		case "d":
			System.out.println("opcion d");
			break;
		case "e":
			System.out.println("opcion e");
			break;
		case "f":
			System.out.println("opcion f");
			break;
		case "g":
			System.out.println("Vuelva pronto . . . . .");
			break;
		default:
			System.out.println("Ingreso incorrecto. Vuelva a Intentar");
		}
	}

	private String mostrarOpciones() {
		System.out.println("________________________________________");
		System.out.println("|                                       |");
		System.out.println("|                MENU                   |");
		System.out.println("|      a.   			                |");
		System.out.println("|      b.   					        |");
		System.out.println("|      c.   				            |");
		System.out.println("|      d.   				            |");
		System.out.println("|      e.   		                    |");
		System.out.println("|      f.   				            |");
		System.out.println("|      g.   Salir                       |");
		System.out.println("|                                       |");
		System.out.println("|_______________________________________|");
		System.out.println();
		return lector.nextLine();
	}

	public Usuario login() {
		Usuario u = new Usuario();
		System.out.println("---- INICIAR SESIÓN ----");
		System.out.println("Ingrese mail: ");
		u.setEmail(lector.nextLine());
		System.out.println("Ingrese contraseña: ");
		u.setPassword(lector.nextLine());
		return ctrlLogin.validar(u);
	}




}
