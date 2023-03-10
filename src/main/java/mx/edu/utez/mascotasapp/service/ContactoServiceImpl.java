package mx.edu.utez.mascotasapp.service;

import mx.edu.utez.mascotasapp.model.Contacto;
import org.springframework.stereotype.Service;

@Service
public class ContactoServiceImpl implements IContactoService{
    @Override
    public boolean save(Contacto contacto) {
        System.out.println("Se ha registrado a " + contacto.getNombre());
        return false;
    }
}
