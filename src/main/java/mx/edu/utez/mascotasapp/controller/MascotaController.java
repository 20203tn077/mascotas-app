package mx.edu.utez.mascotasapp.controller;

import mx.edu.utez.mascotasapp.model.Mascota;
import mx.edu.utez.mascotasapp.service.IMascotaService;
import mx.edu.utez.mascotasapp.service.MascotaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.*;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {
    private Map<String, Object> context = new LinkedHashMap<>();

    @Autowired
    private IMascotaService mascotaService;
    @GetMapping({"/list/{disponibles}", "/list/{tipo}/{disponibles}"})
    public String list(Model modelo, @PathVariable(required = false) String tipo, @PathVariable boolean disponibles) {
        List<Mascota> mascotas = new LinkedList<>();
        for (Mascota mascota : mascotaService.findAll()) if (
                (tipo == null || mascota.getTipoMascota().equals(tipo)) &&
                (!disponibles || mascota.getDisponibleAdopcion())
        ) mascotas.add(mascota);
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
        mascotaService.save(new Mascota(
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

    private void includeContext(Model model) {
        model.addAllAttributes(context);
        context.clear();
    }
}
