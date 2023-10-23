package controller;

import java.util.Date;

import dao.TarefaDAO;
import model.Estado;
import model.Prioridade;
import model.Tarefa;
import view.TarefaView;

public class TarefaController {
    private TarefaDAO tarefaDAO;
    private TarefaView tarefaView;

    public TarefaController() {
        tarefaDAO = new TarefaDAO();
        tarefaView = new TarefaView();
    }

    public void adicionarTarefa(String titulo, String descricao, Date dataDeCriacao, Date dataDeVencimento, Prioridade prioridade, Estado estado) {
        Tarefa tarefa = new Tarefa(titulo, descricao, dataDeCriacao, dataDeVencimento, prioridade, estado);

        tarefaDAO.adicionarTarefa(tarefa);
    }

    public void atualizarTarefa(Integer id, String titulo, String descricao, Date dataDeVencimento, Prioridade prioridade, Estado estado) {
        boolean tarefaAtualizada = tarefaDAO.atualizarTarefa(id, titulo, descricao, dataDeVencimento, prioridade, estado);

        tarefaView.atualizarTarefa(tarefaAtualizada);
    }

    public void buscaTarefaPorTitulo(String titulo) {
        tarefaView.exibirTarefa(tarefaDAO.buscarTarefaPorTitulo(titulo));
    }

    public void listarTarefas() {
        tarefaView.exibirListaDeTarefas(tarefaDAO.listarTarefas());
    }

    public void removerTarefa(Integer id) {
        Tarefa tarefa = tarefaDAO.buscarTarefaPorId(id);

        boolean tarefaRemovida = tarefaDAO.removerTarefa(tarefa);
        tarefaView.removerTarefa(tarefaRemovida);
    }

    public void fecharTarefaDAO() {
        tarefaDAO.fechar();
    }
}
