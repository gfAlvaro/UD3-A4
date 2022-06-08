package colegio.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import colegio.dominio.Alumno;

public class Principal3Borrar {
	public static void main ( String[] args ) {
		
		// unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "colegio" );
		EntityManager em = emf.createEntityManager();

		try {
		em.getTransaction().begin();
		em.remove( em.find( Alumno.class, 2 ) );
		em.getTransaction().commit();
		} catch (IllegalArgumentException e) { e.printStackTrace(); }
	}
}