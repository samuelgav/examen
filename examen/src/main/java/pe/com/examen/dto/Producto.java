package pe.com.examen.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_producto")
	@SequenceGenerator(name="seq_producto",sequenceName="seq_id_producto",allocationSize=1)
	private long id;
	@Column(name="codigo")
	private String codigo;
	@NotBlank(message="Por favor ingrese el nombre!!")
	@Column(name="nombre")
	private String nombre;
	@NotBlank(message="Por favor ingrese la marca!!")
	@Column(name="marca")
	private String marca;
	@NotBlank(message="Por favor ingrese la descripcion!!")
	@Column(name="descripcion")
	private String descripcion;
	@Min(value = 1, message="Por favor ingrese precio mayor a cero!!")
	@Column(name="precio_unitario")
	private double precioUnitario;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="estado")
	private String estado="1";
	@Column(name="categoria_id")
	@JsonIgnore
	private long categoriaId;
	@Column(name="usuario_id")
	@JsonIgnore
	private long usuarioId;
	@Column(name="purchases")
	private int purchases;
	@Column(name="vistas")
	private int vistas;
	
	@Transient
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
		
	public Producto() {
		this.codigo = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getVistas() {
		return vistas;
	}

	public void setVistas(int vistas) {
		this.vistas = vistas;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", marca=" + marca
				+ ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + ", cantidad=" + cantidad
				+ ", estado=" + estado + ", categoriaId=" + categoriaId + ", usuarioId=" + usuarioId + ", purchases="
				+ purchases + ", vistas=" + vistas + "]";
	}
	
	
	
	
	
}
