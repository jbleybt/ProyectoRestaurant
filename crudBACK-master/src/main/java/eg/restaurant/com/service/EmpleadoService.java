package eg.restaurant.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eg.restaurant.com.entity.Empleado;
import eg.restaurant.com.repository.EmpleadoRepository;


@Service
@Transactional
public class EmpleadoService {
	
    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<Empleado> list(){
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> getOne(int id){
        return empleadoRepository.findById(id);
    }

    public Optional<Empleado> getByNombre(String nombre){
        return empleadoRepository.findByNombre(nombre);
    }

    public void save(Empleado empleado){
    	empleadoRepository.save(empleado);
    }

    public void delete(int id){
    	empleadoRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return empleadoRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return empleadoRepository.existsByNombre(nombre);
    }
    public boolean existsByCorreo(String correo){
        return empleadoRepository.existsByNombre(correo);
    }

}
