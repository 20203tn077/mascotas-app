package mx.edu.utez.mascotasapp.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.util.Date;

public class Mascota {
	@NotBlank
	@Max(32)
	private String nombre;
	@NotNull
	@Min(0)
	private Integer edad;
	@NotBlank
	@Max(128)
	private String descripcion;
	private String tipoMascota;
	@NotBlank
	private String imagen;
	@NotNull
	private Date fechaRescate;
	@NotNull
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
