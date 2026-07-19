package ui;

import java.util.*;

import entities.*;
import logic.*;

public class Menu {
	Scanner lector = null;
	Login ctrlLogin = new Login();
	AbmcServicio abmcServicio = new AbmcServicio();
	AbmcTurno abmcTurno = new AbmcTurno();
	
	public void start() {
		lector = new Scanner(System.in);
		Usuario u = login();
		if(u!= null) {
			System.out.println("\nBienvenido "+u.getNombre()+" "+u.getApellido()+"!");
			System.out.println("TU ROL EN LA PÁGINA ES: " + u.getDefClase());
			String opc;
			do {
				if (u.getDefClase().equals("Empleado")){
					opc = mostrarOpcionesEmpleado();
				}else if(u.getDefClase().equals("Administrador")) {
					opc = mostrarOpcionesAdmin();
				}else {
					opc = mostrarOpcionesCliente();
				}
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
			System.out.println(reservarServicio());
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

	private Turno reservarServicio() {

		System.out.println("¿Qué tipo de servicio desea realizarse?");
		System.out.println(listadoServicios());
		
		System.out.println("Elija tipo de servicio por id: ");
		Servicio serv = new Servicio();
		serv.setIdservicios(Integer.parseInt(lector.nextLine()));
		serv = abmcServicio.buscarPorID(serv);
		System.out.println("El servicio que usted eligió es: "+serv.getNombre()+", " +serv.getDescripcion());
		
		System.out.println("Qué prefieres, elegir el servicio"
				+ "1 - por profesional"
				+ "2- por horario?");
		int tipoReserva = Integer.parseInt(lector.nextLine());
		
		Turno turno = null;
		
		if(tipoReserva == 1){
			ArrayList<Empleado> empleados = abmcTurno.mostrarEmpleadosPorServicio(serv);
			System.out.println(empleados);
			turno = abmcTurno.reservarServicioPorProfesional();
		}else if(tipoReserva == 2){
			turno = abmcTurno.reservarServicioPorHorario();
		}
		return turno;
	}


	private String mostrarOpcionesCliente() {
		System.out.println("________________________________________");
		System.out.println("|                                       |");
		System.out.println("|                MENU                   |");
		System.out.println("|      a. Reservar servicio				|");
		System.out.println("|      b. Listado de reservas			|");
		System.out.println("|      c. Consultar turno				|");
		System.out.println("|      d. Cancelar turno				|");
		System.out.println("|      e. Reprogramar turno				|");
		System.out.println("|      f. Mostrar Servicios				|");
		System.out.println("|      g. Salir				   			|");
		System.out.println("|                                       |");
		System.out.println("|_______________________________________|");
		System.out.println();
		return lector.nextLine();
	}	
	
	private String mostrarOpcionesAdmin() {
			System.out.println("________________________________________");
			System.out.println("|                                       |");
			System.out.println("|                MENU                   |");
			System.out.println("|      a. Reservar servicio		        |");
			System.out.println("|      b. Listado de reservas			|");
			System.out.println("|      c. Consultar turno				|");
			System.out.println("|      d. Cancelar turno				|");
			System.out.println("|      e. Reprogramar turno				|");
			System.out.println("|      f. Registrar asistencia			|");
			System.out.println("|      g. Salir       	                |");
			System.out.println("|                                       |");
			System.out.println("|_______________________________________|");
			System.out.println();
			return lector.nextLine();
	}

	private String mostrarOpcionesEmpleado() {
		System.out.println("________________________________________");
		System.out.println("|                                       |");
		System.out.println("|                MENU                   |");
		System.out.println("|      a. Reservar servicio		        |");
		System.out.println("|      b. Listado de reservas			|");
		System.out.println("|      c. Consultar turno				|");
		System.out.println("|      d. Cancelar turno				|");
		System.out.println("|      e. Reprogramar turno				|");
		System.out.println("|      f. Registrar asistencia			|");
		System.out.println("|      g. Salir				   			|");
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
	
	public ArrayList<Servicio> listadoServicios() {
		System.out.println("LISTA DE SERVICIOS: ");
		return abmcServicio.listar();
	}



}
