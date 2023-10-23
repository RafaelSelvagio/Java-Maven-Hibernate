package aplicacao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Professor;

public class Main {
	public static void main(String[] args) {

		// Objetos professor
		Professor p1 = new Professor(null, "Eduardo", "Tecnologia da Informação", new Date());
		Professor p2 = new Professor(null, "Matheus", "Robótica", new Date());
		Professor p3 = new Professor(null, "Rafael", "Tecnologia da Informação", new Date());

		// Criando objetos de persistencia
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("aula_hibernate_01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Insert
		entityManager.getTransaction().begin();
		entityManager.persist(p1);
		entityManager.persist(p2);
		entityManager.persist(p3);
		entityManager.getTransaction().commit();
		System.out.println("3 Inserts");

		// Busca por ID
		Professor professor = entityManager.find(Professor.class, 2);
		System.out.println(professor);

		// Remover por ID
		Professor professor_remove = entityManager.find(Professor.class, 3);

		entityManager.getTransaction().begin();
		entityManager.remove(professor_remove);
		entityManager.getTransaction().commit();

		System.out.println(professor_remove);
		
		
		// Alterar Professor
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Professor professor_alterar = entityManager.find(Professor.class, 1);
		professor_alterar.setNome("Novo Nome");
		professor_alterar.setEspecialidade("Novo Especialidade");
	    professor_alterar.setDataAdmissao(null);
	    transaction.commit();
	    
	}
}
