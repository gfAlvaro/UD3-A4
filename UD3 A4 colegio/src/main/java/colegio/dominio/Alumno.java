package colegio.dominio;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Alumnos")
public class Alumno {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private int id;
	private String nombre;
	private String direccion;
	private float notaMedia;
	private Date fechaNacimiento;

	public int getId(){ return id; }
	public String getNombre(){ return nombre; }
	public String getDireccion(){ return direccion; }
	public float getNotaMedia(){ return notaMedia; }
	public Date getFechaNacimiento(){ return fechaNacimiento; }	
	
	private void setId( int id ){ this.id = id; }
	public void setNombre( String nombre ) {
		if( nombre.length() > 255 )	this.nombre = nombre.substring( 0, 256 );
		else					this.nombre = nombre;
	}
	public void setDireccion( String direccion ){
		if( direccion.length() > 255 )	this.direccion = direccion.substring( 0, 256 );
		else					this.direccion = direccion;
	}
	public void setNotaMedia( float notaMedia ) { this.notaMedia = notaMedia; }
	public void setFechaNacimiento( Date fechaNacimiento ) { this.fechaNacimiento = fechaNacimiento; }
	
	public Alumno() { super(); }
	public Alumno( int id ) {
		super();
		this.setId( id );
	}
	public Alumno( int id, String nombre, String direccion, float notaMedia, Date fecha ) {
		super();
		this.setId( id );
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaNacimiento = fecha;
		this.notaMedia = notaMedia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "[id=" + id + ",\n nombre=" + nombre + ",\n direccion=" + direccion + ",\n fecha de nacimiento=" + fechaNacimiento + ",\n Nota Media="
				+ notaMedia + "]";
	}	
}
