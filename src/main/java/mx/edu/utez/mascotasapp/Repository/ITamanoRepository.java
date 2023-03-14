package mx.edu.utez.mascotasapp.Repository;

import mx.edu.utez.mascotasapp.model.Tamano;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITamanoRepository extends JpaRepository<Tamano, Long> {
    List<Tamano> findAll();
}