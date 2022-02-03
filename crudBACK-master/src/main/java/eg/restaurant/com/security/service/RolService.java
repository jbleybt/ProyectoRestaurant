package eg.restaurant.com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eg.restaurant.com.security.entity.Rol;
import eg.restaurant.com.security.enums.RolNombre;
import eg.restaurant.com.security.repository.RolRepository;

@Service
@Transactional
public class RolService {

	@Autowired
	RolRepository rolRepository;
	
	public Optional<Rol>getByRolNombre(RolNombre rolNombre){
		return rolRepository.findByRolNombre(rolNombre);
	}
	
	public void save (Rol rol) {
		rolRepository.save(rol);
	}
	
}
