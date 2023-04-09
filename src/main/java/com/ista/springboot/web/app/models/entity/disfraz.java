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







@Table(name = "Disfraz",uniqueConstraints = @UniqueConstraint(columnNames = "codigo_disfraz"))
@Entity
public class disfraz implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_disfraz;
	

	private String codigo_disfraz;
	private String descripcion_disfraz;
	
	private double precio_disfraz;
	private String tipo_disfraz;
	private boolean estado;
	
	
	public Long getId_disfraz() {
		return id_disfraz;
	}
	public void setId_disfraz(Long id_disfraz) {
		this.id_disfraz = id_disfraz;
	}
	public String getCodigo_disfraz() {
		return codigo_disfraz;
	}
	public void setCodigo_disfraz(String codigo_disfraz) {
		this.codigo_disfraz = codigo_disfraz;
	}
	public String getDescripcion_disfraz() {
		return descripcion_disfraz;
	}
	public void setDescripcion_disfraz(String descripcion_disfraz) {
		this.descripcion_disfraz = descripcion_disfraz;
	}

	public double getPrecio_disfraz() {
		return precio_disfraz;
	}
	public void setPrecio_disfraz(double precio_disfraz) {
		this.precio_disfraz = precio_disfraz;
	}
	public String getTipo_disfraz() {
		return tipo_disfraz;
	}
	public void setTipo_disfraz(String tipo_disfraz) {
		this.tipo_disfraz = tipo_disfraz;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
}
