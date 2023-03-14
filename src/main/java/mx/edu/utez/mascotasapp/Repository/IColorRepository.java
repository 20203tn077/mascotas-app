package mx.edu.utez.mascotasapp.Repository;

import mx.edu.utez.mascotasapp.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IColorRepository extends JpaRepository<Color, Long> {
    List<Color> findAll();
}
