package mx.edu.utez.mascotasapp.service;

import mx.edu.utez.mascotasapp.model.Contacto;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ContactoServiceImpl implements IContactoService{
    @Override
    public boolean save(Contacto contacto) {
        return new Random().nextBoolean();
    }
}
