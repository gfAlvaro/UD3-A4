package colegio.main;

import javax.persistence.Persistence;

public class Principal5Generar {
	public static void main ( String[] args ){
		Persistence.generateSchema( "colegio", null );
	}
}