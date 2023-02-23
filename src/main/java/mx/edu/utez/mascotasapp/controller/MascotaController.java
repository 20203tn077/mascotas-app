package mx.edu.utez.mascotasapp.controller;

import mx.edu.utez.mascotasapp.model.Mascota;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {
    private List<Mascota> mascotas;
    @GetMapping(value = {"/list/{disponibles}", "/list/{tipo}/{disponibles}"})
    public String list(Model modelo, @PathVariable Optional<String> tipo, @PathVariable boolean disponibles) {
        System.out.println(disponibles ? "DISPONIBLES" : "NO DISPONIBLES");
        initMascotas();
        List<Mascota> mascotas = new LinkedList<>();
        for (Mascota mascota : this.mascotas) if ((tipo.isEmpty() || mascota.getTipoMascota().equals(tipo.get())) && (!disponibles || mascota.getDisponibleAdopcion())) mascotas.add(mascota);
        modelo.addAttribute("mascotas", mascotas);
        modelo.addAttribute("disponibles", disponibles);
        return "listMascotas";
    }

    private void initMascotas() {
        if (mascotas == null) {
            mascotas = new LinkedList<>();
            mascotas.add(new Mascota(
                    "Pancho",
                    5,
                    "Perro llamado Pancho",
                    "Perro",
                    "perro1.jpg",
                    false
            ));
            mascotas.add(new Mascota(
                    "Lince",
                    3,
                    "Gato llamado Lince",
                    "Gato",
                    "gato3.jpg",
                    true
            ));
            mascotas.add(new Mascota(
                    "Galleta",
                    3,
                    "Perro llamado Galleta",
                    "Perro",
                    "perro4.jpg",
                    true
            ));
            mascotas.add(new Mascota(
                    "Manchas",
                    6,
                    "Gato llamado Manchas",
                    "Gato",
                    "gato1.jpeg",
                    false
            ));
            mascotas.add(new Mascota(
                    "Sergio",
                    7,
                    "El Serch",
                    "Perro",
                    "perro3.jpeg",
                    true
            ));
            mascotas.add(new Mascota(
                    "Pelusa",
                    8,
                    "Gato llamado Pelusa",
                    "Gato",
                    "gato2.png",
                    true
            ));
            mascotas.add(new Mascota(
                    "Manchas 2",
                    6,
                    "Segundo gato llamado Manchas",
                    "Gato",
                    "gato4.png",
                    false
            ));
            mascotas.add(new Mascota(
                    "Max",
                    6,
                    "Perro llamado Max",
                    "Perro",
                    "perro2.jpg",
                    true
            ));
        }
    }
}
