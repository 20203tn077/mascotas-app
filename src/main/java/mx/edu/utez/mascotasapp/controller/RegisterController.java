package mx.edu.utez.mascotasapp.controller;

import jakarta.validation.Valid;
import mx.edu.utez.mascotasapp.model.Contacto;
import mx.edu.utez.mascotasapp.service.IContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/registro")
public class RegisterController {
    @Autowired
    IContactoService contactoService;

    @GetMapping("")
    public String form(Contacto contacto) {
        return "registro";
    }

    @PostMapping("/save")
    public String save(@Valid Contacto contacto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) return "registro";
        contactoService.save(contacto);
        attributes.addFlashAttribute("message", "Bienvenid@, " + contacto.getNombre().split(" ")[0]);
        attributes.addFlashAttribute("success", true);
        return "redirect:/mascotas/list/false";
    }
}
