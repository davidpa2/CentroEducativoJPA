package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Estudiante;

public class ControladorEstudiante {
		//Declaración de la instacia como null para crear un Singleton
		private static ControladorEstudiante instance = null;
		
		private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
		
			
		/**
		 * Creación del patrón Singleton para poder acceder a todos los métodos mediante su instacia
		 */
		public static ControladorEstudiante getInstance() {
			//Si es la primera vez que se ejecuta, se inicializa la instacia
			if (instance == null) {
				instance = new ControladorEstudiante();
			}
			return instance;
		}	
		
		/**
		 * Constructor por defecto
		 */
		public ControladorEstudiante() {
		}
		
		/**
		 * 
		 * @param id
		 * @return
		 */
		public Estudiante find(int id) {
			Estudiante f = null;
			EntityManager em = factory.createEntityManager();
			f = (Estudiante) em.find(Estudiante.class, id);
			em.close();
			return f;
		}
		
		/**
		 * Método utilizado para buscar el primer registro de la tabla Estudiante
		 * @return
		 */
		public Estudiante findPrimero() {
			Estudiante c = null;
			
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id limit 1",Estudiante.class);
			c = (Estudiante) q.getSingleResult();
			em.close();
			return c;
		}
		
		/**
		 * Método utilizado para encontrar el último registro de la tabla Estudiante
		 * @return
		 */
		public Estudiante findUltimo() {
			//En principio inicializar un objeto de tipo Estudiante a null
			Estudiante c = null;
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id desc limit 1",Estudiante.class);
			c = (Estudiante) q.getSingleResult();
			em.close();
			return c;
		}
		
		/**
		 * Método utilizado para encontrar un siguiente Estudiante
		 * @param idActualidActual Es necesario pasarle cual es el registro en el que ya se está para poder
		 * 		determinar cuál es el anterior
		 * @return
		 */
		public Estudiante findSiguiente(int idActual) {
			//En principio inicializar un objeto de tipo Estudiante a null
			Estudiante c = null;
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id > ? order by id limit 1",Estudiante.class);
			q.setParameter(1, idActual);
			c = (Estudiante) q.getSingleResult();
			em.close();
			
			return c;
		}
		
		/**
		 * Método utilizado para encontrar un anterior Estudiante
		 * @param idActual Es necesario pasarle cual es el registro en el que ya se está para poder
		 * 		determinar cuál es el anterior
		 * @return
		 */
		public Estudiante findAnterior(int idActual) {
			//En principio inicializar un objeto de tipo Estudiante a null
			Estudiante c = null;
			EntityManager em = factory.createEntityManager();
			Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id < ? order by id desc limit 1",Estudiante.class);
			q.setParameter(1, idActual);
			c = (Estudiante) q.getSingleResult();
			em.close();
			
			return c;
		}
		
		/**
		 * Método guardar, para introducir un registro en la tabla Estudiante
		 * @param f
		 * @return
		 */
		public boolean guardar (Estudiante c) {
			try {
				EntityManager em = factory.createEntityManager();
				em.getTransaction().begin();
				//Si la id el nuevo registro es 0, se crea uno nuevo
				if (c.getId() == 0) {
					em.persist(c);
				}
				//Sino, se modifica
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
		 * Borrar un registro de la tabla Estudiante
		 * @param id
		 * @return
		 */
		public void borrar(Estudiante c) {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			c = em.merge(c);
			em.remove(c);
			em.getTransaction().commit();
			em.close();
		}
		
		/**
		 * Método utilizado para buscar todos los campos de Estudiante
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
