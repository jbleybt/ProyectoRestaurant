package eg.restaurant.com.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//Clase encargada de la seguridad
//Privilegios de cada usuario
public class UsuarioPrincipal implements UserDetails{

	private String nombre;
	private String nombreUsuario;
	private String email;
	private String password;
	//Cambiamos la clase Rol por authorities (Verificacion y Autorizacion)
	//authirities es una clase.
	private Collection<? extends GrantedAuthority> authorities;
	
	
	
	
	
	public UsuarioPrincipal(String nombre, String nombreUsuario, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	
	//Aqui Asociamos si es Administrador o Usuario
	//Convertimos la clase rol en clase authorities
	public static UsuarioPrincipal build (Usuario usuario) {
		List<GrantedAuthority> authorities =
				usuario.getRoles().stream().map(rol->new SimpleGrantedAuthority(rol.getRolNombre().name()))
				.collect(Collectors.toList());
		return new UsuarioPrincipal(usuario.getNombre(),usuario.getNombreUsuario(),usuario.getEmail(),usuario.getPassword(),authorities);
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nombreUsuario;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

	
	
	
}
