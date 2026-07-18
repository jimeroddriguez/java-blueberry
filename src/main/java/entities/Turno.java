package entities;

import java.time.*;

public class Turno {
	private int idturno;
	private Servicio servicio;
	private Cliente cliente;
	private Empleado empleado;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private double precioTotal;
	private boolean cancelado;
	
	public int getIdturno() {
		return idturno;
	}
	public void setIdturno(int idturno) {
		this.idturno = idturno;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public boolean isCancelado() {
		return cancelado;
	}
	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}
	
	@Override
	public String toString() {
		return "\nTurno [idturno=" + idturno + ", servicio=" + servicio + ", cliente=" + cliente + ", empleado="
				+ empleado + ", fecha=" + fecha + ", horaInicio=" + horaInicio + ", precioTotal=" + precioTotal
				+ ", cancelado=" + cancelado + "]";
	}
	
	
}
