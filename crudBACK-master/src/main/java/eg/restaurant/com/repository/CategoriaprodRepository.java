package eg.restaurant.com.repository;

 import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eg.restaurant.com.entity.Cliente;


@Repository
public interface CategoriaprodRepository extends JpaRepository<Cliente, Integer>{
	
	Optional<Cliente> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

}
