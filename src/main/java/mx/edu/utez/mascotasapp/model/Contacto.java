package mx.edu.utez.mascotasapp.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Contacto {
    @NotBlank(message = "Debes ingresar un nombre")
    @Size(max = 128, message = "Máximo 128 caracteres")
    @Pattern(regexp = "[A-zÁ-ù ]*", message = "Solo puede contener letras")
    private String nombre;
    @NotBlank(message = "Debes ingresar una dirección de correo electrónico")
    @Size(max = 128, message = "Máximo 128 caracteres")
    @Email(message = "Correo inválido")
    private String correo;
    @NotBlank(message = "Debes ingresar un número de teléfono")
    @Size(max = 10, min = 10, message = "El teléfono debe contener exactamente 10 dígitos")
    @Pattern(regexp = "[0-9]*", message = "Solo puede contener números")
    private String telefono;

    public Contacto() {
    }

    public Contacto(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
