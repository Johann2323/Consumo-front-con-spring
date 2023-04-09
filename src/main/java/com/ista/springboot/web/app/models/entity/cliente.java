package com.ista.springboot.web.app.models.entity;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




@Entity
@Table(name = "Cliente",uniqueConstraints = @UniqueConstraint(columnNames = "cedula_cliente"))
public class cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cliente;


	private String cedula_cliente;
	private String nombre_cliente;
	
	private String apellido_cliente;
	private String direccion_cliente;
	private boolean estado_cliente;
	
	
	
	
	
	public cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cliente(Long id_cliente, String cedula_cliente, String nombre_cliente, String apellido_cliente,
			String direccion_cliente, boolean estado_cliente) {
		super();
		this.id_cliente = id_cliente;
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.apellido_cliente = apellido_cliente;
		this.direccion_cliente = direccion_cliente;
		this.estado_cliente = estado_cliente;
	}
	public Long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(String cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public String getApellido_cliente() {
		return apellido_cliente;
	}
	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}
	public boolean isEstado_cliente() {
		return estado_cliente;
	}
	public void setEstado_cliente(boolean estado_cliente) {
		this.estado_cliente = estado_cliente;
	}
	

	
	

	
	
	
	
	
	
	
	
	
}
