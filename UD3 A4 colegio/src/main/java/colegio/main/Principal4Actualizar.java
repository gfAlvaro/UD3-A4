package colegio.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import colegio.dominio.Alumno;

public class Principal4Actualizar {
	public static void main (String[] args) {
		
		// unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "colegio" );
		EntityManager em = emf.createEntityManager();
		
		Alumno alumno = em.find( Alumno.class, 1 );
		try {
			em.getTransaction().begin();
			alumno.setNotaMedia( 5 );
			alumno.setNombre( "Pedro" );
			em.merge( alumno );
			em.getTransaction().commit();
		} catch ( Exception e ) {
			if( em != null )
				em.close();
		}
	}
}