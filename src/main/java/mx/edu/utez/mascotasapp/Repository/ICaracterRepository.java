package mx.edu.utez.mascotasapp.Repository;

import mx.edu.utez.mascotasapp.model.Caracter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICaracterRepository extends JpaRepository<Caracter, Long> {
    List<Caracter> findAll();
}
