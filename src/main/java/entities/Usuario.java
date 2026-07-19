package entities;

import java.time.LocalDate;

public class Usuario {
	private int idusuario;
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	private LocalDate fecha_nacimiento;

	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDefClase() {
		return "Usuario";
	}
	
	public Usuario() {
		this(0 , "", "", "", "");
	}
	
	public Usuario(int idusuario, String email, String nombre, String apellido, String password) {
		this.setIdusuario(idusuario);
		setEmail(email);
		setNombre(nombre);
		setApellido(apellido);
		setPassword(password);
	}
	
	public String getDetalle() {
		return this.getDetalle(false);
	}
	
	public String getDetalle(boolean mostrarDatosSensibles) {
		String detalle = this.getDefClase()+ " - ";
		if (mostrarDatosSensibles) {
			detalle+=this.getIdusuario()+":";
		}
		detalle+=this.getApellido()+", "+this.getNombre();
		return detalle;
	}
	
	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", email=" + email + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fecha_nacimiento=" + fecha_nacimiento + "]";
	}
	
	
	
}
