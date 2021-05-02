package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Materia;

public class ControladorMateria {
	
	//Declaración de la instacia como null para crear un Singleton
	private static ControladorMateria instance = null;
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
	
		
	/**
	 * Creación del patrón Singleton para poder acceder a todos los métodos mediante su instacia
	 */
	public static ControladorMateria getInstance() {
		//Si es la primera vez que se ejecuta, se inicializa la instacia
		if (instance == null) {
			instance = new ControladorMateria();
		}
		return instance;
	}

	/**
	 * Constructor por defecto
	 */
	public ControladorMateria() {
	}
	
	/**
	 * Método utilizado para buscar todos las materias
	 * @return
	 */
	public List<Materia> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM materia", Materia.class);
		
		List<Materia> list = (List<Materia>) q.getResultList();
		em.close();
		return list;
	}

}
