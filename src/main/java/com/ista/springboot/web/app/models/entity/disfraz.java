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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.ista.springboot.web.app.models.validations.ValidNum;







@Table(name = "disfraz",uniqueConstraints = @UniqueConstraint(columnNames = "codigo_disfraz"))
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
	
	@Size(min=5,max=50)
	private String descripcion_disfraz;
	
	@Positive
	@ValidNum
	private Double precio_disfraz;
	
	@NotEmpty
	private String tipo_disfraz;
	private boolean estado;
	
	
	public disfraz(Long id_disfraz, String codigo_disfraz,
			@NotBlank(message = "La descripción del disfraz es obligatoria") String descripcion_disfraz,
			Double precio_disfraz, String tipo_disfraz, boolean estado) {
		super();
		this.id_disfraz = id_disfraz;
		this.codigo_disfraz = codigo_disfraz;
		this.descripcion_disfraz = descripcion_disfraz;
		this.precio_disfraz = precio_disfraz;
		this.tipo_disfraz = tipo_disfraz;
		this.estado = estado;
	}
	
	
	public disfraz() {
		
	}


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

	public Double getPrecio_disfraz() {
		return precio_disfraz;
	}
	public void setPrecio_disfraz(Double precio_disfraz) {
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
