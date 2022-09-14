package com.sena.proyecto.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ventas")
public class Venta {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@NotEmpty
    @Column(nullable=false)
	private String numero;

	@NotEmpty
    @Column(nullable=false)
	private Date fechaCreacion;

	@NotEmpty
    @Column(nullable=false)
	private Date fechaRecibida;

	private double total;
	
	
	@OneToMany(mappedBy = "venta")
	private List<Detalle> detalle;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Empleado empleado;
	
	public Venta() {
	
	}



	@Override
	public String toString() {
		return "Venta [id=" + id + ", numero=" + numero + ", fechaCreacion=" + fechaCreacion + ", fechaRecibida="
				+ fechaRecibida + ", total=" + total + "]";
	}



	public Venta(Integer id, @NotEmpty String numero, @NotEmpty Date fechaCreacion, @NotEmpty Date fechaRecibida,
			double total, List<Detalle> detalle, Cliente cliente, Empleado empleado) {
		this.id = id;
		this.numero = numero;
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibida = fechaRecibida;
		this.total = total;
		this.detalle = detalle;
		this.cliente = cliente;
		this.empleado = empleado;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public Date getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	public Date getFechaRecibida() {
		return fechaRecibida;
	}



	public void setFechaRecibida(Date fechaRecibida) {
		this.fechaRecibida = fechaRecibida;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public List<Detalle> getDetalle() {
		return detalle;
	}



	public void setDetalle(List<Detalle> detalle) {
		this.detalle = detalle;
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


}
