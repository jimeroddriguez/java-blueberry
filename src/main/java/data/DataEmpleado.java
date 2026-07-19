package data;

import java.sql.*;

import java.util.*;
import entities.*;

public class DataEmpleado {

	public ArrayList<Empleado> getEmpleadoPorServicio(Servicio serv) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Empleado> empleados = new ArrayList<>();
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"una buena query where idservicios = ?");
			
			stmt.setInt(1, serv.getIdservicios());
			
			rs = stmt.executeQuery();
			
			if(rs!=null) {
				while(rs.next()) {
					Empleado emp = new Empleado();
					emp.setIdusuario(rs.getInt("idservicios"));
					emp.setPuesto(rs.getString("puesto"));
					emp.setLegajo(rs.getInt("legajo"));
					emp.setNombre(rs.getString("nombre"));
					emp.setApellido(rs.getString("apellido"));
					
					empleados.add(emp);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) {stmt.close();}
				if(rs!=null) {rs.close();}
				DbConnector.getInstancia().releaseConn();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
	public Empleado getById(Empleado emp) {
		Empleado empleado = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select idusuario, puesto, legajo, nombre, apellido from empleado where idusuario =?");
			stmt.setInt(1, emp.getIdusuario());
			rs = stmt.executeQuery();
			
			if(rs.next() && rs!=null) {
				empleado = new Empleado();
				empleado.setIdusuario(rs.getInt("idservicios"));
				empleado.setPuesto(rs.getString("puesto"));
				empleado.setLegajo(rs.getInt("legajo"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setApellido(rs.getString("apellido"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	return empleado;
	}
		
}