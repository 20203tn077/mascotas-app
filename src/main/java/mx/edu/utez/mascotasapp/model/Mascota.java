package mx.edu.utez.mascotasapp.model;

import jakarta.validation.constraints.*;
import org.springframework.lang.NonNull;

import java.util.Date;

public class Mascota {
	@NotBlank(message = "Debes ingresar un nombre")
	@Size(max = 32, message = "Máximo 32 caracteres")
	@Pattern(regexp = "[A-z ]*", message = "Solo puede contener letras")
	private String nombre;
	@NotNull(message = "Debes ingresar una edad")
	@PositiveOrZero(message = "La edad no puede ser negativa")
	private Integer edad;
	@NotBlank(message = "Debes ingresar una descripción")
	@Size(max = 128, message = "Máximo 128 caracteres")
	private String descripcion;
	private String tipoMascota;
	@NotBlank(message = "Debes seleccionar una imagen")
	private String imagen;
	@NotNull(message = "Debes ingrsar una fecha de rescate")
	@PastOrPresent(message = "La fecha no puede estar en el futuro")
	private Date fechaRescate;
	@NotNull(message = "Debes indicar la disponibilidad")
	private Boolean disponibleAdopcion;

	public Mascota() {
	}

	public Mascota(String nombre, Integer edad, String descripcion, String tipoMascota, String imagen, Date fechaRescate, Boolean disponibleAdopcion) {
		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
		this.tipoMascota = tipoMascota;
		this.imagen = imagen;
		this.fechaRescate = fechaRescate;
		this.disponibleAdopcion = disponibleAdopcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoMascota() {
		return tipoMascota;
	}

	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Date getFechaRescate() {
		return fechaRescate;
	}

	public void setFechaRescate(Date fechaRescate) {
		this.fechaRescate = fechaRescate;
	}

	public Boolean getDisponibleAdopcion() {
		return disponibleAdopcion;
	}

	public void setDisponibleAdopcion(Boolean disponibleAdopcion) {
		this.disponibleAdopcion = disponibleAdopcion;
	}
}
