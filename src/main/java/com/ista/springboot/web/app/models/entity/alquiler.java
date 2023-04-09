package com.ista.springboot.web.app.models.entity;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;





@Table(name = "Alquiler_Disfraz")
@Entity
public class alquiler implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_alquiler;
	

	
	@Column(name="fecha_prestamo")
	@Temporal(TemporalType.DATE)
	private Date prestamo;
	@Column(name="fecha_devolucion")
	@Temporal(TemporalType.DATE)
	private Date devolucion;
	
	private String comentarios_alquiler;
	private int cantidad_disfraces;
	private double total_alquiler;
	
	@ManyToOne
	@JoinColumn(name="id_cliente",referencedColumnName ="id_cliente" )
	private cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="id_disfraz",referencedColumnName ="id_disfraz" )
	private disfraz disfraz;
	
	
	
	
	public cliente getCliente() {
		return cliente;
	}
	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}
	public disfraz getDisfraz() {
		return disfraz;
	}
	public void setDisfraz(disfraz disfraz) {
		this.disfraz = disfraz;
	}
	public Long getId_alquiler() {
		return Id_alquiler;
	}
	public void setId_alquiler(Long id_alquiler) {
		Id_alquiler = id_alquiler;
	}
	public Date getPrestamo() {
		return prestamo;
	}
	public void setPrestamo(Date prestamo) {
		this.prestamo = prestamo;
	}
	public Date getDevolucion() {
		return devolucion;
	}
	public void setDevolucion(Date devolucion) {
		this.devolucion = devolucion;
	}
	public String getComentarios_alquiler() {
		return comentarios_alquiler;
	}
	public void setComentarios_alquiler(String comentarios_alquiler) {
		this.comentarios_alquiler = comentarios_alquiler;
	}
	public int getCantidad_disfraces() {
		return cantidad_disfraces;
	}
	public void setCantidad_disfraces(int cantidad_disfraces) {
		this.cantidad_disfraces = cantidad_disfraces;
	}
	public double getTotal_alquiler() {
		return total_alquiler;
	}
	public void setTotal_alquiler(double total_alquiler) {
		this.total_alquiler = total_alquiler;
	}
	
	
		
	
	
	
}
