package eg.restaurant.com.controller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import eg.restaurant.com.dto.EmpleadoDto;
import eg.restaurant.com.dto.Mensaje;
import eg.restaurant.com.entity.Empleado;
import eg.restaurant.com.service.EmpleadoService;


@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {
	
	   @Autowired
	    EmpleadoService empleadoService;

	    @GetMapping("/lista")
	    public ResponseEntity<List<Empleado>> list(){
	        List<Empleado> list = empleadoService.list();
	        return new ResponseEntity(list, HttpStatus.OK);
	    }

	    @GetMapping("/detail/{id}")
	    public ResponseEntity<Empleado> getById(@PathVariable("id") int id){
	        if(!empleadoService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        Empleado empleado = empleadoService.getOne(id).get();
	        return new ResponseEntity(empleado, HttpStatus.OK);
	    }

	    @GetMapping("/detailname/{nombre}")
	    public ResponseEntity<Empleado> getByNombre(@PathVariable("nombre") String nombre){
	        if(!empleadoService.existsByNombre(nombre))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        Empleado empleado = empleadoService.getByNombre(nombre).get();
	        return new ResponseEntity(empleado, HttpStatus.OK);
	    }
	    
	    @PreAuthorize("hasRole('ADMIN')")
	    @PostMapping("/create")
	    public ResponseEntity<?> create(@RequestBody EmpleadoDto empleadoDto){
	        //if(StringUtils.isBlank(clienteDto.getNombre()))
	          //  return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	        //if(clienteDto.getPrecio()==null || clienteDto.getPrecio()<0 )
	          //  return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
	       /* if(empleadoService.existsByCorreo(empleadoDto.getCorreo()))
	            return new ResponseEntity(new Mensaje("ese correo ya existe"), HttpStatus.BAD_REQUEST);*/
	        
	        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			//String encodedPassword = passwordEncoder.encode(empleadoDto.getPassword());
			//user.setPassword(encodedPassword);
	        
	        
	        Empleado empleado = new Empleado(empleadoDto.getNombre(), empleadoDto.getApellido(),
	        		empleadoDto.getTipodocumento(),empleadoDto.getNumerodocumento(),empleadoDto.getCorreo(),empleadoDto.getPassword());
	        
	        empleadoService.save(empleado);
	        return new ResponseEntity(new Mensaje("emplado creado"), HttpStatus.OK);
	    }
	    
	    @PreAuthorize("hasRole('ADMIN')")
	    @PutMapping("/updateCliente/{id}")
	    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody EmpleadoDto empleadoDto){
	        if(!empleadoService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	       // if(clienteService.existsByNombre(clienteDto.getNombre()) && clienteService.getByNombre(clienteDto.getNombre()).get().getId() != id)
	         //   return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(empleadoDto.getNombre()))
	            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(empleadoDto.getApellido()))
	            return new ResponseEntity(new Mensaje("el apellido es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(empleadoDto.getTipodocumento()))
	            return new ResponseEntity(new Mensaje("el tipoDocumento es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(empleadoDto.getNumerodocumento()))
	            return new ResponseEntity(new Mensaje("el numeroDocumento es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(empleadoDto.getCorreo()))
	            return new ResponseEntity(new Mensaje("el correo es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(empleadoDto.getPassword()))
	            return new ResponseEntity(new Mensaje("el password es obligatorio"), HttpStatus.BAD_REQUEST);
	        
	        Empleado empleado = empleadoService.getOne(id).get();
	        empleado.setNombre(empleadoDto.getNombre());
	        empleado.setApellido(empleadoDto.getApellido());
	        empleado.setTipodocumento(empleadoDto.getTipodocumento());
	        empleado.setNumerodocumento(empleadoDto.getNumerodocumento());
	        empleado.setCorreo(empleadoDto.getCorreo());
	        
	        empleadoService.save(empleado);
	        return new ResponseEntity(new Mensaje("empleado actualizado"), HttpStatus.OK);
	    }
	    
	    @PreAuthorize("hasRole('ADMIN')")
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> delete(@PathVariable("id")int id){
	        if(!empleadoService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        empleadoService.delete(id);
	        return new ResponseEntity(new Mensaje("empleado eliminado"), HttpStatus.OK);
	    }
	

}