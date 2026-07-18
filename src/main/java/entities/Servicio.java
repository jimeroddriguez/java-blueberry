package entities;

public class Servicio {
	private int idservicios;
	private String nombre;
	private String descripcion;
	private int duracion;
	private double precio;
	
	public int getIdservicios() {
		return idservicios;
	}
	public void setIdservicios(int idservicios) {
		this.idservicios = idservicios;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "\nServicio [idservicios=" + idservicios + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", duracion=" + duracion + ", precio=" + precio + "]";
	}
	
	
}
