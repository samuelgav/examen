package pe.com.examen.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="usuario_detalle")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	/*@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_usuario")
	@SequenceGenerator(name="seq_usuario",sequenceName="seq_id_usuario",allocationSize=1)*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private int id;
	@NotBlank(message="Por favor ingrese su nombre!!")
	@Column(name="nombres")
	private String nombres;
	@NotBlank(message="Por favor ingrese sus apellidos!!")
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="rol")
	private String rol;
	@Column(name="estado")
	private String estado="1";
	@NotBlank(message="Por favor ingrese su password!!")
	@Column(name="password")
	private String password;
	@NotBlank(message="Por favor ingrese su direccion de correo!!")
	@Column(name="email")
	private String email;
	@NotBlank(message="Por favor ingrese su numero de contacto!!")
	@Column(name="numero_contacto")
	private String numeroContacto;
	@Transient
	private String confirmarPassword;
	public String getConfirmarPassword() {
		return confirmarPassword;
	}
	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumeroContacto() {
		return numeroContacto;
	}
	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", rol=" + rol + ", estado="
				+ estado + ", password=" + password + ", email=" + email + ", numeroContacto=" + numeroContacto + "]";
	}
	
	@OneToOne(mappedBy="usuario",cascade = CascadeType.ALL, fetch = FetchType.EAGER)	
	private Cart cart;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
	

}
