/*package eg.restaurant.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import eg.restaurant.com.enums.NombreRol;



@Entity
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	@Column(unique = true)
	private NombreRol nombreRol;
	
	public Roles() {
		
	}
		

	public Roles(NombreRol nombreRol) {
		this.nombreRol = nombreRol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NombreRol getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(NombreRol nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	
	
}
*/