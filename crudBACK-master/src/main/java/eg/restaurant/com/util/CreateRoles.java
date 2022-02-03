/*package eg.restaurant.com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eg.restaurant.com.security.entity.Rol;
import eg.restaurant.com.security.enums.RolNombre;
import eg.restaurant.com.security.service.RolService;

//6
//Inserta los roles en la BD
@Component
public class CreateRoles implements CommandLineRunner{
	
	@Autowired
	RolService rolService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Rol rolAdmin=new Rol(RolNombre.ROLE_ADMIN);
		Rol rolUser=new Rol(RolNombre.ROLE_USER);
		rolService.save(rolAdmin);
		rolService.save(rolUser);
		
		
	}

}
*/