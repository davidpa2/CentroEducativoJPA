package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Profesor;

public class ControladorProfesor {
	//Declaración de la instacia como null para crear un Singleton
		private static ControladorProfesor instance = null;
		
		private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
		
			
		/**
		 * Creación del patrón Singleton para poder acceder a todos los métodos mediante su instacia
		 */
		public static ControladorProfesor getInstance() {
			//Si es la primera vez que se ejecuta, se inicializa la instacia
			if (instance == null) {
				instance = new ControladorProfesor();
			}
			return instance;
		}	
		
		public ControladorProfesor() {
		}
		
		public Profesor find(int id) {
			Profesor f = null;
			EntityManager em = factory.createEntityManager();
			f = (Profesor) em.find(Profesor.class, id);
			em.close();
			return f;
		}
		
		/**
		 * Método utilizado para buscar el primer registro de la tabla profesor
		 * @return
		 */
		public Profesor findPrimero() {
			Profesor c = null;
			
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.profesor order by id limit 1",Profesor.class);
			c = (Profesor) q.getSingleResult();
			em.close();
			return c;
		}
		
		/**
		 * Método utilizado para encontrar el último registro de la tabla profesor
		 * @return
		 */
		public Profesor findUltimo() {
			//En principio inicializar un objeto de tipo Profesor a null
			Profesor c = null;
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.profesor order by id desc limit 1",Profesor.class);
			c = (Profesor) q.getSingleResult();
			em.close();
			return c;
		}
		
		/**
		 * Método utilizado para encontrar un siguiente profesor
		 * @param idActualidActual Es necesario pasarle cual es el registro en el que ya se está para poder
		 * 		determinar cuál es el anterior
		 * @return
		 */
		public Profesor findSiguiente(int idActual) {
			//En principio inicializar un objeto de tipo profesor a null
			Profesor c = null;
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.profesor where id > ? order by id limit 1",Profesor.class);
			q.setParameter(1, idActual);
			c = (Profesor) q.getSingleResult();
			em.close();
			
			return c;
		}
		
		/**
		 * Método utilizado para encontrar un anterior profesor
		 * @param idActual Es necesario pasarle cual es el registro en el que ya se está para poder
		 * 		determinar cuál es el anterior
		 * @return
		 */
		public Profesor findAnterior(int idActual) {
			//En principio inicializar un objeto de tipo Profesor a null
			Profesor c = null;
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.profesor where id < ? order by id desc limit 1",Profesor.class);
			q.setParameter(1, idActual);
			c = (Profesor) q.getSingleResult();
			em.close();
			
			return c;
		}
		
		/**
		 * Guardar un profesor, ya sea uno nuevo o modificarlo
		 * @param f
		 * @return
		 */
		public boolean guardar (Profesor c) {
			try {
				EntityManager em = factory.createEntityManager();
				em.getTransaction().begin();
				//Si la id del nuevo registro es 0, se crea uno nuevo
				if (c.getId() == 0) {
					em.persist(c);
				}
				//Si no, se modifica uno existente
				else {
					em.merge(c);
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
		 * Borrar un registro de la BBDD
		 * @param id
		 * @return
		 */
		public void borrar(Profesor c) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			c = em.merge(c);
			em.remove(c);
			em.getTransaction().commit();
			em.close();
		}
		
		/**
		 * Método utilizado para buscar todos los profesores
		 * @return
		 */
		public List<Profesor> findAll () {
			EntityManager em = factory.createEntityManager();
			
			Query q = em.createNativeQuery("SELECT * FROM profesor", Profesor.class);
			
			List<Profesor> list = (List<Profesor>) q.getResultList();
			em.close();
			return list;
		}
}
