package entities;

public class Promocion {
	private int idpromocion;
	private boolean dosXuno;
	private int porcentaje;
	private Servicio servicio;
	
	public int getIdpromocion() {
		return idpromocion;
	}
	public void setIdpromocion(int idpromocion) {
		this.idpromocion = idpromocion;
	}
	public boolean isDosXuno() {
		return dosXuno;
	}
	public void setDosXuno(boolean dosXuno) {
		this.dosXuno = dosXuno;
	}
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	@Override
	public String toString() {
		return "\nPromocion [idpromocion=" + idpromocion + ", dosXuno=" + dosXuno + ", porcentaje=" + porcentaje
				+ ", servicio=" + servicio + "]";
	}
	
	
}
