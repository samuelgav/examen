package pe.com.examen.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Direccion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_direccion")
	@SequenceGenerator(name="seq_direccion",sequenceName="seq_id_direccion",allocationSize=1)
	private int id;
	@NotBlank(message="Por favor ingrese la primera direccion!!")
	@Column(name="DIRECCION_LINEA_UNO")
	private String direccionLineaUno; 
	@NotBlank(message="Por favor ingrese la segunda direccion!!")
	@Column(name="DIRECCION_LINEA_DOS")
	private String direccionLineaDos;
	@NotBlank(message="Por favor ingrese la ciudad!!")
	@Column(name="ciudad")
	private String ciudad;
	@NotBlank(message="Por favor ingrese el estado!!")
	@Column(name="estado")
	private String estado;
	@NotBlank(message="Por favor ingrese el pais!!")
	@Column(name="pais")
	private String pais;
	@NotBlank(message="Por favor ingrese el codigo postal!!")
	@Column(name="CODIGO_POSTAL")
	private String codigoPostal;
	@Column(name="IS_BILLING")
	private String billing;
	@Column(name="IS_SHIPPING")
	private String shipping;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccionLineaUno() {
		return direccionLineaUno;
	}
	public void setDireccionLineaUno(String direccionLineaUno) {
		this.direccionLineaUno = direccionLineaUno;
	}
	public String getDireccionLineaDos() {
		return direccionLineaDos;
	}
	public void setDireccionLineaDos(String direccionLineaDos) {
		this.direccionLineaDos = direccionLineaDos;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getBilling() {
		return billing;
	}
	public void setBilling(String billing) {
		this.billing = billing;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", direccionLineaUno=" + direccionLineaUno + ", direccionLineaDos="
				+ direccionLineaDos + ", ciudad=" + ciudad + ", estado=" + estado + ", pais=" + pais + ", codigoPostal="
				+ codigoPostal + ", billing=" + billing + "]";
	}
	
	
	@Column(name="USUARIO_ID")
	private int usuarioId;


	public String getShipping() {
		return shipping;
	}
	public void setShipping(String shipping) {
		this.shipping = shipping;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
	
	
	
	
	
	
	
	
}
