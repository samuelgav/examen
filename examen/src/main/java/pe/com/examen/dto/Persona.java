package pe.com.examen.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
public class Persona implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_persona")
	@SequenceGenerator(name="seq_persona",sequenceName="incremento_id_persona",allocationSize=1)
	private int idpersona;
	@Column(name="nombres")
	@NotBlank(message="Por favor ingrese su nombre!!")
	private String nombres;
	@Column(name="apellidos")
	@NotBlank(message="Por favor ingrese su apellido!!")
	private String apellidos;
	@Min(value = 1, message="Por favor ingrese una edad mayor a cero")
	@Column(name="edad")
	private int edad;
	@NotBlank(message="Por favor seleccione el tipo de sexo!!")
	@Column(name="sexo")
	private String sexo;
	@ManyToOne
	@JoinColumn(name="ID_TIPO_PERSONA")
	private TipoPersona tipoPersona;
	
	
	@Transient
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	
	public int getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
	
	
	
}
