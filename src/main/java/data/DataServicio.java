package data;

import java.sql.*;
import java.util.*;
import entities.*;

public class DataServicio {

	public ArrayList<Servicio> getAll() {			
			Statement stmt = null;
			ResultSet rs = null;
			ArrayList<Servicio> servicios = new ArrayList<Servicio>();
			
			try {
				stmt = DbConnector.getInstancia().getConn().createStatement();
				rs = stmt.executeQuery("select idservicios, nombre, descripcion, duracion, precio from servicios");
				if(rs!= null) {
					while(rs.next()) {
						Servicio srv = new Servicio();
						srv.setIdservicios(rs.getInt("idservicios"));
						srv.setNombre(rs.getString("nombre"));
						srv.setDescripcion(rs.getString("descripcion"));
						srv.setDuracion(rs.getInt("duracion"));
						srv.setPrecio(rs.getDouble("precio"));
						
						servicios.add(srv);
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
			return servicios;
		}

	public Servicio getByID(Servicio serv) {
			
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Servicio s = null;
			
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
				"select idservicios, nombre, descripcion, duracion, precio from servicios where idservicios=?");
			stmt.setInt(1, serv.getIdservicios());
			rs = stmt.executeQuery();
				
			if(rs!=null && rs.next()) {
				s=new Servicio();
				s.setIdservicios(rs.getInt("idservicios"));
				s.setNombre(rs.getString("nombre"));
				s.setDescripcion(rs.getString("descripcion"));
				s.setDuracion(rs.getInt("duracion"));
				s.setPrecio(rs.getDouble("precio"));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return s;
	}

}
