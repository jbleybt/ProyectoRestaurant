package eg.restaurant.com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eg.restaurant.com.security.entity.Rol;
import eg.restaurant.com.security.enums.RolNombre;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

	Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
