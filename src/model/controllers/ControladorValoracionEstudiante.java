package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;

public class ControladorValoracionEstudiante {
	
	//Declaración de la instacia como null para crear un Singleton
	private static ControladorValoracionEstudiante instance = null;
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
	
		
	/**
	 * Creación del patrón Singleton para poder acceder a todos los métodos mediante su instacia
	 */
	public static ControladorValoracionEstudiante getInstance() {
		//Si es la primera vez que se ejecuta, se inicializa la instacia
		if (instance == null) {
			instance = new ControladorValoracionEstudiante();
		}
		return instance;
	}

	public ControladorValoracionEstudiante() {
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (ValoracionMateria vm) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (vm.getId() == 0) {
				//Introducir uno nuevo
				em.persist(vm);
			}
			else {
				//Modificar
				em.merge(vm);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Método utilizado para elimiar alguna valoración de estudiante
	 * @param vm
	 * @return
	 */
	public boolean eliminar (ValoracionMateria vm) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			vm = em.merge(vm);
			em.remove(vm);
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Buscar todas los registros introducidos en la tabla valoracionmateria
	 * @return
	 */
	public List<ValoracionMateria> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM valoracionmateria;", ValoracionMateria.class);
		
		List<ValoracionMateria> cursos = (List<ValoracionMateria>) q.getResultList();
		
		em.close();
		
		return cursos;
	}
	
	/**
	 * Buscar los registros introducidos en valoracionmateria según el profesor, estudiante y materia
	 * que se pasen como parámetros
	 * @param profesor
	 * @param estudiante
	 * @param materia
	 * @return
	 */
	public ValoracionMateria findValoracionMateria (Profesor prof, Estudiante es, Materia mat) {
		ValoracionMateria vm = null;
		try {
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.valoracionmateria where idProfesor=? and idEstudiante=? and idMateria=?", ValoracionMateria.class);
			q.setParameter(1, prof.getId());
			q.setParameter(2, es.getId());
			q.setParameter(3, mat.getId());
			vm = (ValoracionMateria) q.getSingleResult();
			em.close();
			return vm;
		} catch (Exception e) {
			return vm;
		}
		
	}

}
