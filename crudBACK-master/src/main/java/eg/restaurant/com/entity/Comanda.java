package eg.restaurant.com.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "comanda")
public class Comanda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idComanda")
	private Integer idComanda;
	
	@Basic(optional = false)
	@Column(name = "montototal")
	private Double montototal;
	
	//@JsonFormat(pattern = "yyyy-MM-dd")
	//@CreationTimestamp
	//@ColumnDefault("CURRENT_TIMESTAMP")
	//@Column(name = "fecharegistro", updatable = false)
	@Basic(optional = false)
	@Column(name = "fecharegistro")
	private String fecharegistro;
	
	@JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente idcliente;
	
	@JoinColumn(name = "empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado idempleado;

	
	public Comanda() {
		
	}

	public Comanda(Integer idComanda) {
		this.idComanda = idComanda;
	}

   
	
	public Comanda(Integer idComanda, Double montototal, String fecharegistro, Cliente idcliente, Empleado idempleado) {
		super();
		this.idComanda = idComanda;
		this.montototal = montototal;
		this.fecharegistro = fecharegistro;
		this.idcliente = idcliente;
		this.idempleado = idempleado;
	}
	
	
	
	

	public Integer getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}

	public Double getMontototal() {
		return montototal;
	}

	public void setMontototal(Double montototal) {
		this.montototal = montototal;
	}

	public String getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(String fecharegistro) {
		this.fecharegistro = fecharegistro;
	}


	public Cliente getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Cliente idcliente) {
		this.idcliente = idcliente;
	}

	public Empleado getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(Empleado idempleado) {
		this.idempleado = idempleado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comanda)) {
            return false;
        }
        Comanda other = (Comanda) object;
        if ((this.idComanda == null && other.idComanda != null) || (this.idComanda != null && !this.idComanda.equals(other.idComanda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyecto[ idComanda=" + idComanda + " ]";
    }
	
	
}
