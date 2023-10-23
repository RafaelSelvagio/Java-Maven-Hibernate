package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pessoa;

public class Main {

	public static void main(String[] args) {
		
		//Pessoa p1 = new Pessoa(null, "Carlos", "carlos@gmail.com");
		//Pessoa p2 = new Pessoa(null, "Rafael", "rafael@gmail.com");
		//Pessoa p3 = new Pessoa(null, "Javas", "javas@gmail.com");
		
		
		/*
		 * insert
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(p3);
		
		entityManager.getTransaction().commit();
		
		System.out.println("Pronto");
		*/
		
		
		/*
		 * buscar
		 */
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Pessoa pessoa = entityManager.find(Pessoa.class, 2);
		
		System.out.println(pessoa);
		//*/
		
		
		/*
		 * update simples
		 *
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Pessoa pessoa = entityManager.find(Pessoa.class, 3);
		
		entityManager.getTransaction().begin();
		pessoa.setNome("Java");
		entityManager.getTransaction().commit();
		
		
		
		entityManager.close();
		entityManagerFactory.close();
		*/
		
		
		/*
		 * update merge
		 *
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Pessoa pessoa = entityManager.find(Pessoa.class, 3);
		
		entityManager.getTransaction().begin();
		pessoa.setNome("Java Teste");
		entityManager.merge(pessoa);
		entityManager.getTransaction().commit();
		
		
		
		entityManager.close();
		entityManagerFactory.close();
		*/

		
		/*
		 * remover
		 *
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Pessoa pessoa = entityManager.find(Pessoa.class, 2);
		
		entityManager.getTransaction().begin();
		entityManager.remove(pessoa);
		entityManager.getTransaction().commit();
		
		System.out.println(pessoa);
		
		
		entityManager.close();
		entityManagerFactory.close();
		 */
	}

}
