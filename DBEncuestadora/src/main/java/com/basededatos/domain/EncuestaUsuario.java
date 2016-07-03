package com.basededatos.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 * Esta clase representa las encuestas que realizo el usuario.
 * 
 * @author Silvana Bonafina
 * 
 */
@Entity
public class EncuestaUsuario {

	/**
	 * Mantiene la version de este objeto.
	 */
	@Version
	private long version;

	/**
	 * Es el id que permite identificar a una instancia de esta clase.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/**
	 * Es la fecha en la que se realizo la encuesta.
	 */
	private Date fecha;
	
	/**
	 * Es el puntaje obtenido en la encuesta la encuesta.
	 */
	private Integer puntaje;

	@OneToOne 
	private Encuesta encuesta;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private List<RespuestaUsuario> respuestasUsuario;

	/**
	 * @return the version
	 */
	public long getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(long version) {
		this.version = version;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the encuesta
	 */
	public Encuesta getEncuesta() {
		return encuesta;
	}

	/**
	 * @param encuesta the encuesta to set
	 */
	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	/**
	 * @return the respuestasUsuario
	 */
	public List<RespuestaUsuario> getRespuestasUsuario() {
		return respuestasUsuario;
	}

	/**
	 * @param respuestasUsuario the respuestasUsuario to set
	 */
	public void setRespuestasUsuario(List<RespuestaUsuario> respuestasUsuario) {
		this.respuestasUsuario = respuestasUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the puntaje
	 */
	public Integer getPuntaje() {
		return puntaje;
	}

	/**
	 * @param puntaje the puntaje to set
	 */
	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	
	
	
	
}
