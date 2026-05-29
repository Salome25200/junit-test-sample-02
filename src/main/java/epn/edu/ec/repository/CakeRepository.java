package epn.edu.ec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import epn.edu.ec.repository.model.Cake;

public interface CakeRepository extends JpaRepository<Cake, Long>{
    Optional<Cake> findByTitle(String title); // Agrega este método para buscar por título
}
