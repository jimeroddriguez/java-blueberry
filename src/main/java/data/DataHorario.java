package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

import entities.Empleado;
import entities.Horario;

public class DataHorario {

	public ArrayList<Horario> getHorariosPorIdEmpleado(Empleado emp) {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Horario> horarios = new ArrayList<>();
		Horario h;
			
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
				"select idhorarios, idempleado, day, horaInicio, horaFin from horarios where idempleado = ?");
			stmt.setInt(1, emp.getIdusuario());
			rs = stmt.executeQuery();
				
			if(rs!=null) {
				while(rs.next()) {
					h = new Horario();
					h.setIdHorario(rs.getInt("idhorarios"));
					h.setEmpleado(emp);
					h.setDay(rs.getInt("day"));
					h.setHoraInicio(rs.getObject("horaInicio", LocalTime.class));
					h.setHoraFin(rs.getObject("horaFin", LocalTime.class));
					
					horarios.add(h);
				}
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
		return horarios;

	}

}
