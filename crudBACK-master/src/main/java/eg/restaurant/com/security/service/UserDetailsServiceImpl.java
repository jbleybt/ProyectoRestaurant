package eg.restaurant.com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import eg.restaurant.com.security.entity.Usuario;
import eg.restaurant.com.security.entity.UsuarioPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String nombreUsaurio) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario=usuarioService.getByNombreUsuario(nombreUsaurio).get();
		return UsuarioPrincipal.build(usuario);
	}

}
