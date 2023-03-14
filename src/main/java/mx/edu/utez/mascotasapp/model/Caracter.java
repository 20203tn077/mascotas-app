package mx.edu.utez.mascotasapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "caracter")
public class Caracter {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String nombre;

    public Caracter() {
    }

    public Caracter(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
