package eg.restaurant.com.security.jwt;

import java.io.IOException;
import java.lang.annotation.Target;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import eg.restaurant.com.security.service.UserDetailsServiceImpl;

//La mas importante
//Se activa por cada peticion, comprobara que se activo el tocken
//Utilizara la clase JwtProvider,
public class JwtTokenFilter extends OncePerRequestFilter{
	
	private final static Logger logger=LoggerFactory.getLogger(JwtEntryPoint.class);
	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	//Comprueba que el token es valido
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token=getToken(req);
			//Valida si existe el token
			if(token!=null && jwtProvider.validateToken(token)) {
				String nombreUsuario=jwtProvider.getNombreUsuarioFromToken(token);
				UserDetails userDetails=userDetailsService.loadUserByUsername(nombreUsuario);
				UsernamePasswordAuthenticationToken auth=new 
						UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				//Los datos lo pasamos al contexto
				SecurityContextHolder.getContext().setAuthentication(auth);
			
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("fail en el metodo doFilterInternal "+e.getMessage());
		}
		
		filterChain.doFilter(req,res);
	}
	
	private String getToken(HttpServletRequest request) {
		String header=request.getHeader("Authorization");
		if(header!=null && header.startsWith("Bearer"))
			return header.replace("Bearer","");
		return null;
	}
	
	
}
