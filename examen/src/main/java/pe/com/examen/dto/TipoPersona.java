package pe.com.examen.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
@Entity(name="Tipo_Persona")
public class TipoPersona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator="seq_tipopersona")
	@SequenceGenerator(name="seq_tipopersona",sequenceName="incremento_id_tipopersona",allocationSize=1)
	@Column(name="id",updatable = false, nullable = false)
	private int id;
	@Column(name="descripcion")
	@NotBlank(message="Por favor ingrese la descripcion!!")
	private String descripcion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "TipoPersona [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
	

}
