package mx.edu.utez.mascotasapp.controller;

import jakarta.validation.Valid;
import mx.edu.utez.mascotasapp.model.Mascota;
import mx.edu.utez.mascotasapp.service.IMascotaService;
import mx.edu.utez.mascotasapp.service.MascotaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.text.SimpleDateFormat;
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
        for (Mascota mascota : mascotaService.findAll()) if ((tipo == null || mascota.getTipoMascota().equals(tipo)) && (!disponibles || mascota.getDisponibleAdopcion())) mascotas.add(mascota);
        modelo.addAttribute("mascotas", mascotas);
        modelo.addAttribute("disponibles", disponibles);
        modelo.addAttribute("tipo", tipo);
        includeContext(modelo);
        return "listMascotas";
    }

    @GetMapping({"/new", "/new/{tipo}"})
    public String newPet(Model modelo, @PathVariable(required = false) String tipo) {
        modelo.addAttribute("tipo", tipo);
        modelo.addAttribute("mascota", new Mascota());
        includeContext(modelo);
        return "formMascotas";
    }

    @PostMapping({"/save", "/save/{tipo}"})
    public ModelAndView save(@PathVariable(required = false) String tipo, Mascota mascota, BindingResult result, @Valid @ModelAttribute ModelMap modelo) {
        if (result.hasErrors()) {
            modelo.addAttribute("tipo", tipo);
            return new ModelAndView("formMascotas", modelo);
        }
        if (mascota.getTipoMascota() == null) mascota.setTipoMascota(tipo);
        mascotaService.save(mascota);
        context.put("message", "Mascota registrada exitosamente");
        context.put("success", true);
        return new ModelAndView("redirect:/mascotas/list" + (tipo != null ? "/" + tipo : "") + "/false");
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    private void includeContext(Model model) {
        model.addAllAttributes(context);
        context.clear();
    }
}
