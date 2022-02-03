package eg.restaurant.com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class Cliente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido;
	private String tipodocumento;
	private String numerodocumento;
	private String correo;
	
	
	public Cliente() {
	}


	public Cliente(String nombre, String apellido, String tipodocumento, String numerodocumento,
			String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipodocumento = tipodocumento;
		this.numerodocumento = numerodocumento;
		this.correo = correo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
