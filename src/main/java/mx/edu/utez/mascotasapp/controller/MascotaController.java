package mx.edu.utez.mascotasapp.controller;

import jakarta.validation.Valid;
import mx.edu.utez.mascotasapp.model.Mascota;
import mx.edu.utez.mascotasapp.service.ICaracterService;
import mx.edu.utez.mascotasapp.service.IColorService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private IMascotaService mascotaService;
    @Autowired
    private ICaracterService caracterService;
    @Autowired
    private IColorService colorService;

    @GetMapping({"/list/{disponibles}", "/list/{tipo}/{disponibles}"})
    public String list(Model modelo, @PathVariable(required = false) @ModelAttribute String tipo, @PathVariable @ModelAttribute boolean disponibles) {
        List<Mascota> mascotas = new LinkedList<>();
        for (Mascota mascota : mascotaService.findAll()) if ((tipo == null || mascota.getTipo().equals(tipo)) && (!disponibles || mascota.getDisponibleAdopcion())) mascotas.add(mascota);
        modelo.addAttribute("mascotas", mascotas);
        return "listMascotas";
    }

    @GetMapping({"/new", "/new/{tipo}"})
    public String newPet(@PathVariable(required = false) @ModelAttribute String tipo, Mascota mascota, Model modelo) {
        modelo.addAttribute("caracteres", caracterService.findAll());
        modelo.addAttribute("colores", colorService.findAll());
        return "formMascotas";
    }

    @PostMapping({"/save", "/save/{tipo}"})
    public String save(@PathVariable(required = false) @ModelAttribute String tipo, @Valid Mascota mascota, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) return "formMascotas";
        if (mascota.getTipo() == null) mascota.setTipo(tipo);
        if (mascotaService.save(mascota)) {
            attributes.addFlashAttribute("message", "Mascota registrada exitosamente");
            attributes.addFlashAttribute("success", true);
        } else {
            attributes.addFlashAttribute("message", "Ocurrió un error :(");
            attributes.addFlashAttribute("success", false);
        }
        return "redirect:/mascotas/list" + (tipo != null ? "/" + tipo : "") + "/false";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
