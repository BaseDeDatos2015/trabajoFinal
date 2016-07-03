package com.basededatos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 * Esta clase representa las respuestas de las preguntas de las encuestas del sistema.
 * Esta clase implementa la interfaz Versionable a fin de poder controlar la
 * edicion concurrente por parte de dos roles.
 * 
 * @author Silvana Bonafina
 * 
 */
@Entity
public class RespuestaUsuario {

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

		
	@OneToOne
	private Pregunta pregunta;
	
	@OneToOne
	private Respuesta respuesta;
	
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
	 * @return the pregunta
	 */
	public Pregunta getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * @return the respuesta
	 */
	public Respuesta getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	

	
}
