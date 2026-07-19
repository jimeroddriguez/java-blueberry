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
	
	
}
