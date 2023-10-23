package dao;

import model.Professor;
import util.LoggerUtil;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class ProfessorDAO {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("professor-pu");
    private EntityManager entityManager;

    public ProfessorDAO() {
    	entityManager = entityManagerFactory.createEntityManager();
    }

    public void adicionarProfessor(Professor professor) {
    	entityManager.getTransaction().begin(); 
    	entityManager.persist(professor);
    	entityManager.getTransaction().commit();
    }

    public boolean atualizarProfessor(Integer id, String nome, String especialidade, String dataDeAdmissao) {
        Professor professor = buscarProfessorPorId(id);

        entityManager.getTransaction().begin();
        professor.setNome(nome);
        professor.setEspecialidade(especialidade);
        professor.setDataDeAdmissao(dataDeAdmissao);
        entityManager.getTransaction().commit();

        return true;
    }

    public Professor buscarProfessorPorId(Integer id) {
        return entityManager.find(Professor.class, id);
    }

    public Professor buscarProfessorPorNome(String nomeProfessor) {
        try {
            return entityManager.createQuery("SELECT p FROM Professor p WHERE p.nome = :nomeProfessor", Professor.class)
                    .setParameter("nomeProfessor", nomeProfessor).getSingleResult();
        } catch (NoResultException e) {
        	LoggerUtil.logError("Erro ao buscar professor: ", e);
        	throw new EntityNotFoundException("Professor nao encontrado com o nome: " + nomeProfessor);
        }
    }

    public List<Professor> listarProfessores() {
        try {
            return entityManager.createQuery("SELECT p FROM Professor p ORDER BY p.nome", Professor.class)
                    .getResultList();
        }catch (NoResultException e) {
            throw new EntityNotFoundException("Nenhum pais encontrado.");
        } catch (Exception e) {
            LoggerUtil.logError("Erro ao listar pais: ", e);
            return new ArrayList<>(); 
        } 
    }

    public boolean removerProfessor(Professor professor) {
        try {
        	entityManager.getTransaction().begin();
        	professor = entityManager.merge(professor);
            entityManager.remove(professor);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
        	LoggerUtil.logError("Erro ao remover pais: ", e);
            return false;
        }
    }
    
    public void fechar() {
    	entityManager.close();
    	entityManagerFactory.close();
    }
}