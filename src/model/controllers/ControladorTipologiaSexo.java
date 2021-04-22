package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Tipologiasexo;

public class ControladorTipologiaSexo {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
	//Declaración de la instacia como null para crear un Singleton
	private static ControladorTipologiaSexo instance = null;
	
	/**
	 * Creación del patrón Singleton para poder acceder a todos los métodos mediante su instacia
	 */
	public static ControladorTipologiaSexo getInstance() {
		//Si es la primera vez que se ejecuta, se inicializa la instacia
		if (instance == null) {
			instance = new ControladorTipologiaSexo();
		}
		return instance;
	}	
	
	
	public ControladorTipologiaSexo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Método utilizado para buscar todos los fabricantes
	 * @return
	 */
	public List<Tipologiasexo> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM tipologiasexo", Tipologiasexo.class);
		
		List<Tipologiasexo> list = (List<Tipologiasexo>) q.getResultList();
		em.close();
		return list;
	}
}
