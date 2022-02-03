package eg.restaurant.com.dto;


import javax.validation.constraints.NotBlank;

public class ClienteDto {

	 @NotBlank
	 private String nombre;
	 @NotBlank
	 private String apellido;
	 @NotBlank
	 private String tipodocumento;
	 @NotBlank
	 private String numerodocumento;
	 @NotBlank   
	 private String correo;


	    public ClienteDto() {
	    }

	    public ClienteDto(@NotBlank String nombre, @NotBlank String apellido,@NotBlank String tipodocumento,
	    		@NotBlank String numerodocumento,@NotBlank String correo) {
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.tipodocumento = tipodocumento;
	        this.numerodocumento = numerodocumento;
	        this.correo = correo;
	        
	    }

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getTipodocumento() {
			return tipodocumento;
		}

		public void setTipodocumento(String tipodocumento) {
			this.tipodocumento = tipodocumento;
		}

		public String getNumerodocumento() {
			return numerodocumento;
		}

		public void setNumerodocumento(String numerodocumento) {
			this.numerodocumento = numerodocumento;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

	    
}
