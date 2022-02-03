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

import eg.restaurant.com.dto.ClienteDto;
import eg.restaurant.com.dto.Mensaje;
//import eg.restaurant.com.dto.ProductoDto;
import eg.restaurant.com.entity.Cliente;
import eg.restaurant.com.service.ClienteService;


@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
	
	   @Autowired
	    ClienteService clienteService;

	    @GetMapping("/lista")
	    public ResponseEntity<List<Cliente>> list(){
	        List<Cliente> list = clienteService.list();
	        return new ResponseEntity(list, HttpStatus.OK);
	    }

	    @GetMapping("/detail/{id}")
	    public ResponseEntity<Cliente> getById(@PathVariable("id") int id){
	        if(!clienteService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        Cliente cliente = clienteService.getOne(id).get();
	        return new ResponseEntity(cliente, HttpStatus.OK);
	    }

	    @GetMapping("/detailname/{nombre}")
	    public ResponseEntity<Cliente> getByNombre(@PathVariable("nombre") String nombre){
	        if(!clienteService.existsByNombre(nombre))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        Cliente cliente = clienteService.getByNombre(nombre).get();
	        return new ResponseEntity(cliente, HttpStatus.OK);
	    }
	    
	    @PreAuthorize("hasRole('ADMIN')")
	    @PostMapping("/create")
	    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto){
	        //if(StringUtils.isBlank(clienteDto.getNombre()))
	          //  return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	        //if(clienteDto.getPrecio()==null || clienteDto.getPrecio()<0 )
	          //  return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
	        //if(clienteService.existsByNombre(clienteDto.getNombre()))
	        //    return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
	        
	        Cliente producto = new Cliente(clienteDto.getNombre(), clienteDto.getApellido(),
	        		clienteDto.getTipodocumento(),clienteDto.getNumerodocumento(),clienteDto.getCorreo());
	        
	        clienteService.save(producto);
	        return new ResponseEntity(new Mensaje("producto creado"), HttpStatus.OK);
	    }
	    
	    @PreAuthorize("hasRole('ADMIN')")
	    @PutMapping("/updateCliente/{id}")
	    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ClienteDto clienteDto){
	        if(!clienteService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	       // if(clienteService.existsByNombre(clienteDto.getNombre()) && clienteService.getByNombre(clienteDto.getNombre()).get().getId() != id)
	         //   return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(clienteDto.getNombre()))
	            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(clienteDto.getApellido()))
	            return new ResponseEntity(new Mensaje("el apellido es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(clienteDto.getTipodocumento()))
	            return new ResponseEntity(new Mensaje("el tipoDocumento es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(clienteDto.getNumerodocumento()))
	            return new ResponseEntity(new Mensaje("el numeroDocumento es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(StringUtils.isBlank(clienteDto.getCorreo()))
	            return new ResponseEntity(new Mensaje("el correo es obligatorio"), HttpStatus.BAD_REQUEST);
	      
	        Cliente cliente = clienteService.getOne(id).get();
	        cliente.setNombre(clienteDto.getNombre());
	        cliente.setApellido(clienteDto.getApellido());
	        cliente.setTipodocumento(clienteDto.getTipodocumento());
	        cliente.setNumerodocumento(clienteDto.getNumerodocumento());
	        cliente.setCorreo(clienteDto.getCorreo());
	      
	        
	        
	        clienteService.save(cliente);
	        return new ResponseEntity(new Mensaje("cliente actualizado"), HttpStatus.OK);
	    }
	    
	    @PreAuthorize("hasRole('ADMIN')")
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> delete(@PathVariable("id")int id){
	        if(!clienteService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        clienteService.delete(id);
	        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
	    }
	

}