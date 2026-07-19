package data;

import java.sql.*;
import java.time.LocalDate;

import entities.*;


public class DataUser {

	public Usuario getByMail(Usuario u) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario user = null;
		
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select email, password, nombre, apellido, idusuario, fecha_nacimiento from usuario where email = ? and password = ?");
			stmt.setString(1, u.getEmail());
			stmt.setString(2, u.getPassword());
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				user = setUserType(rs.getInt("idusuario"));
				user.setIdusuario(rs.getInt("idusuario"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setNombre(rs.getString("nombre"));
				user.setApellido(rs.getString("apellido"));
				user.setFecha_nacimiento(rs.getObject("fecha_nacimiento", LocalDate.class));
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
		return user;
	}
	
	private Usuario setUserType(int idusuario) {
		if(exists("cliente", idusuario)) {
			Cliente c = new Cliente();
			return c;
		}else if(exists("administrador", idusuario)){
			Administrador a = new Administrador();
			return a;
		}else if(exists("empleado", idusuario)) {
			Empleado e = createNewEmpleado(idusuario);
			return e;
		}
		else {return new Usuario();}
	}

	private Empleado createNewEmpleado(int idusuario) {
		PreparedStatement stmtemp = null;
		ResultSet rsemp = null;
		Empleado emp = null;
		try {
			stmtemp = DbConnector.getInstancia().getConn().prepareStatement(
					"select legajo, puesto from empleado where idusuario = ?");
			stmtemp.setInt(1, idusuario);
			rsemp = stmtemp.executeQuery();
			
			if(rsemp!=null && rsemp.next()) {
				emp = new Empleado();
				emp.setLegajo(rsemp.getInt("legajo"));
				emp.setPuesto(rsemp.getString("puesto"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmtemp!=null) {stmtemp.close();}
				if(rsemp!=null) {rsemp.close();}
				DbConnector.getInstancia().releaseConn();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	private boolean exists(String rol, int idusuario) {
		PreparedStatement stmtexist = null;
		ResultSet rsexist = null;
		boolean existe = false;
		try {
			stmtexist = DbConnector.getInstancia().getConn().prepareStatement(
					"select * from "+rol+" where idusuario = ? ");
			stmtexist.setInt(1, idusuario);
			rsexist = stmtexist.executeQuery();
			if(rsexist!=null) {
			existe = rsexist.next();}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmtexist!=null) {stmtexist.close();}
				if(rsexist!=null) {rsexist.close();}
				DbConnector.getInstancia().releaseConn();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return existe;
	}
		
}
