package eg.restaurant.com.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

//En esta clase se comprueba si el token es valido,
//Si no arrojara un mensaje 404 no autorizado

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{
	
	private final static Logger logger=LoggerFactory.getLogger(JwtEntryPoint.class);
	
	
	
	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException e) throws IOException, ServletException {
		logger.error("fail en el metodo commnece");
		res.sendError(HttpServletResponse.SC_UNAUTHORIZED,"no autorizado");
		
	}

}
