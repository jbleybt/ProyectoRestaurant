package eg.restaurant.com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eg.restaurant.com.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
	
	Optional<Empleado> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

}
