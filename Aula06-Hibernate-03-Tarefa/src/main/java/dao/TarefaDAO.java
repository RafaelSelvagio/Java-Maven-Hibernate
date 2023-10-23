package dao;

import model.Estado;
import model.Prioridade;
import model.Tarefa;
import util.LoggerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TarefaDAO {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tarefa");
    private EntityManager entityManager;

    public TarefaDAO() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        entityManager.getTransaction().begin();
        entityManager.persist(tarefa);
        entityManager.getTransaction().commit();
    }

    public boolean atualizarTarefa(Integer id, String titulo, String descricao, Date dataDeVencimento, Prioridade prioridade, Estado estado) {
        Tarefa tarefa = buscarTarefaPorId(id);

        entityManager.getTransaction().begin();
        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        tarefa.setDataVencimento(dataDeVencimento);
        tarefa.setPrioridade(prioridade);
        tarefa.setEstado(estado);
        entityManager.getTransaction().commit();

        return true;
    }



    public Tarefa buscarTarefaPorId(Integer id) {
        return entityManager.find(Tarefa.class, id);
    }

    public Tarefa buscarTarefaPorTitulo(String tituloTarefa) {
        try {
            return entityManager.createQuery("SELECT t FROM Tarefa t WHERE t.titulo = :tituloTarefa", Tarefa.class)
                    .setParameter("tituloTarefa", tituloTarefa)
                    .getSingleResult();
        } catch (NoResultException e) {
            LoggerUtil.logError("Erro ao buscar tarefa: ", e);
            throw new EntityNotFoundException("Tarefa não encontrada com o título: " + tituloTarefa);
        }
    }

    public List<Tarefa> listarTarefas() {
        try {
            return entityManager.createQuery("SELECT t FROM Tarefa t ORDER BY t.titulo", Tarefa.class)
                    .getResultList();
        } catch (NoResultException e) {
            throw new EntityNotFoundException("Nenhuma tarefa encontrada.");
        } catch (Exception e) {
            LoggerUtil.logError("Erro ao listar tarefas: ", e);
            return new ArrayList<>();
        }
    }

    public boolean removerTarefa(Tarefa tarefa) {
        try {
            entityManager.getTransaction().begin();
            tarefa = entityManager.merge(tarefa);
            entityManager.remove(tarefa);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            LoggerUtil.logError("Erro ao remover tarefa: ", e);
            return false;
        }
    }

    public void fechar() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
