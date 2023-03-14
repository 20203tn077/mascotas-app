package mx.edu.utez.mascotasapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "mascotas")
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Debes ingresar un nombre")
	@Size(max = 45, message = "Máximo 45 caracteres")
	@Pattern(regexp = "[A-z ]*", message = "Solo puede contener letras")
	@Column(nullable = false, length = 45)
	private String nombre;
	@NotBlank(message = "Debes ingresar el sexo")
	@Size(max = 45, message = "Máximo 1 caracter")
	@Column(nullable = false, length = 1)
	private String sexo;
	@NotNull(message = "Debes ingresar una edad")
	@PositiveOrZero(message = "La edad no puede ser negativa")
	@Column(nullable = false)
	private Integer edad;
	@Size(max = 5, message = "Máximo 45 caracteres")
	@Column(nullable = false, length = 5)
	private String tipo;
	@NotBlank(message = "Debes seleccionar una imagen")
	@Size(max = 45, message = "Máximo 45 caracteres")
	@Column(nullable = true, length = 45)
	private String imagen;
	@NotNull(message = "Debes indicar la disponibilidad")
	@Column(name = "disponible_adopcion", columnDefinition = "tinyint not null")
	private Boolean disponibleAdopcion;
	@Column(name = "fecha_registro", nullable = false)
	@CreationTimestamp
	private Date fechaRegistro;
	@Column(nullable = false, length = 10)
	private String validacion; // keywords: validado, rechazado, pendiente
	@Column(columnDefinition = "longtext null")
	private String detalles;
	@ManyToOne
	@JoinColumn(name = "tamano_id", nullable = false)
	private Tamano tamano;
	@NotNull(message = "Debes seleccionar un color")
	@ManyToOne
	@JoinColumn(name = "color_id", nullable = false)
	private Color color;
	@NotNull(message = "Debes seleccionar un carácter")
	@ManyToOne
	@JoinColumn(name = "caracter_id", nullable = false)
	private Caracter caracter;

	public Mascota() {
	}

	public Mascota(String nombre, String sexo, Integer edad, String tipo, String imagen, Boolean disponibleAdopcion, String validacion, String detalles, Tamano tamano, Color color, Caracter caracter) {
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.tipo = tipo;
		this.imagen = imagen;
		this.disponibleAdopcion = disponibleAdopcion;
		this.validacion = validacion;
		this.detalles = detalles;
		this.tamano = tamano;
		this.color = color;
		this.caracter = caracter;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Boolean getDisponibleAdopcion() {
		return disponibleAdopcion;
	}

	public void setDisponibleAdopcion(Boolean disponibleAdopcion) {
		this.disponibleAdopcion = disponibleAdopcion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getValidacion() {
		return validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public Tamano getTamano() {
		return tamano;
	}

	public void setTamano(Tamano tamano) {
		this.tamano = tamano;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Caracter getCaracter() {
		return caracter;
	}

	public void setCaracter(Caracter caracter) {
		this.caracter = caracter;
	}
}
