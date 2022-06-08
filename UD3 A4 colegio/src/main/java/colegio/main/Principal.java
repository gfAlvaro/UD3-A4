package colegio.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import colegio.dominio.Alumno;

public class Principal {
	public static void main ( String[] args ) {
		
		// unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory( "colegio" );
		EntityManager em = emf.createEntityManager();		
		System.out.println( em.find( Alumno.class, 1 ) );
	}
}