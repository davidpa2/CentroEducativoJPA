package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Estudiante;

public class ControladorFichaEstudiante {
	
	//Declaración de la instacia como null para crear un Singleton
	private static ControladorFichaEstudiante instance = null;
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
	
		
	/**
	 * Creación del patrón Singleton para poder acceder a todos los métodos mediante su instacia
	 */
	public static ControladorFichaEstudiante getInstance() {
		//Si es la primera vez que se ejecuta, se inicializa la instacia
		if (instance == null) {
			instance = new ControladorFichaEstudiante();
		}
		return instance;
	}	

	/**
	 * 
	 */
	public ControladorFichaEstudiante() {
	}
	
	
	
	/**
	 * Método utilizado para buscar todos los estudiantes
	 * @return
	 */
	public List<Estudiante> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);
		
		List<Estudiante> list = (List<Estudiante>) q.getResultList();
		em.close();
		return list;
	}

}
