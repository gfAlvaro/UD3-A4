package colegio.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import colegio.dominio.Alumno;

public class Principal2Insertar {
	public static void main ( String[] args ) {
		
		// unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "colegio" );
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();		
			Alumno alumno = new Alumno();
			alumno.setNombre( "Ana" );
			alumno.setDireccion( "C. Desengaño 21" );
			alumno.setNotaMedia( (float) 3.2 );
			alumno.setFechaNacimiento(  new java.sql.Date( new SimpleDateFormat( "d/M/yyyy" ).parse( "1/01/2020" ).getTime() )  );
			em.persist( alumno );
			em.flush();
			em.refresh( alumno );
			em.getTransaction().commit();
			System.out.println( "Inserción con éxito." );
		} catch (EntityExistsException e ) { System.out.println( "Ya existe el id en la base de datos." ); }
		  catch ( ParseException e ) { e.printStackTrace(); }
	}
}