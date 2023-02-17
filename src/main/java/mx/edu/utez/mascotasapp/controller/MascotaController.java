package mx.edu.utez.mascotasapp.controller;

import mx.edu.utez.mascotasapp.model.Mascota;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {
    private List<Mascota> mascotas;
    @GetMapping("/list")
    public String list(Model modelo) {
        initPets();
        modelo.addAttribute("mascotas", this.mascotas);
        return "list";
    }
    @GetMapping("/filter/{tipo}")
    public String perros(Model modelo, @PathVariable String tipo) {
        initPets();
        List<Mascota> mascotas = new ArrayList<>();
        for (Mascota mascota : this.mascotas) if (mascota.getTipoMascota().equals(tipo)) mascotas.add(mascota);
        modelo.addAttribute("mascotas", mascotas);
        return "list";
    }

    private void initPets() {
        if (mascotas == null) {
            mascotas = new ArrayList<>();
            mascotas.add(new Mascota(
                    "Pancho",
                    5,
                    "",
                    "Perro",
                    "perro1.jpg",
                    true
            ));
            mascotas.add(new Mascota(
                    "Eulalio",
                    6,
                    "",
                    "Perro",
                    "perro2.jpg",
                    true
            ));
            mascotas.add(new Mascota(
                    "Tripa",
                    7,
                    "",
                    "Perro",
                    "perro3.jpeg",
                    true
            ));
            mascotas.add(new Mascota(
                    "Sergio",
                    3,
                    "",
                    "Perro",
                    "perro4.jpg",
                    true
            ));
            mascotas.add(new Mascota(
                    "Manchas",
                    6,
                    "",
                    "Gato",
                    "gato1.jpeg",
                    true
            ));
            mascotas.add(new Mascota(
                    "Pelusa",
                    8,
                    "",
                    "Gato",
                    "gato2.png",
                    true
            ));
            mascotas.add(new Mascota(
                    "Lince",
                    3,
                    "",
                    "Gato",
                    "gato3.jpg",
                    true
            ));
            mascotas.add(new Mascota(
                    "Manchas 2",
                    6,
                    "",
                    "Gato",
                    "gato4.png",
                    true
            ));
        }
    }
}
