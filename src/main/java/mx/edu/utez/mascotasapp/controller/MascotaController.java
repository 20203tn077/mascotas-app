package mx.edu.utez.mascotasapp.controller;

import mx.edu.utez.mascotasapp.model.Mascota;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.*;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {
    private List<Mascota> mascotas = new LinkedList<>();
    private Map<String, Object> context = new LinkedHashMap<>();
    @GetMapping({"/list/{disponibles}", "/list/{tipo}/{disponibles}"})
    public String list(Model modelo, @PathVariable(required = false) String tipo, @PathVariable boolean disponibles) {
        initMascotas();
        List<Mascota> mascotas = new LinkedList<>();
        for (Mascota mascota : this.mascotas) if ((tipo == null || mascota.getTipoMascota().equals(tipo)) && (!disponibles || mascota.getDisponibleAdopcion())) mascotas.add(mascota);
        modelo.addAttribute("mascotas", mascotas);
        modelo.addAttribute("disponibles", disponibles);
        modelo.addAttribute("tipo", tipo);
        includeContext(modelo);
        return "listMascotas";
    }

    @GetMapping({"/new", "/new/{tipo}"})
    public String newPet(Model modelo, @PathVariable(required = false) String tipo) {
        modelo.addAttribute("tipo", tipo);
        includeContext(modelo);
        return "formMascotas";
    }

    @PostMapping({"/save", "/save/{tipo}"})
    public ModelAndView save(Model model, @PathVariable(required = false) String tipo,
        @RequestParam String nombre,
        @RequestParam Integer edad,
        @RequestParam String descripcion,
        @RequestParam(required = false) String tipoMascota,
        @RequestParam String imagen,
        @RequestParam Boolean disponibleAdopcion
    ) {
        mascotas.add(0, new Mascota(
                nombre,
                edad,
                descripcion,
                tipo != null ? tipo : tipoMascota,
                imagen,
                disponibleAdopcion
        ));
        context.put("message", "Mascota registrada exitosamente");
        context.put("success", true);
        return new ModelAndView("redirect:/mascotas/list" + (tipo != null ? "/" + tipo : "") + "/false");
    }

    private void initMascotas() {
        if (mascotas.isEmpty()) {
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
    private void includeContext(Model model) {
        model.addAllAttributes(context);
        context.clear();
    }
}
