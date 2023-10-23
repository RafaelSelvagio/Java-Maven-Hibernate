package view;

import java.util.List;
import model.Tarefa;

public class TarefaView {
    public void exibirListaDeTarefas(List<Tarefa> tarefas) {
        System.out.println("==== Lista de Tarefas ====");
        System.out.println("------------------------------");

        for (Tarefa tarefa : tarefas) {
            exibirTarefa(tarefa);
        }
        System.out.println("------------------------------");
    }

    public void removerTarefa(boolean tarefaRemovida) {
        if (tarefaRemovida) {
            System.out.println("Tarefa removida com sucesso!\n");
        } else {
            System.out.println("Tarefa não encontrada na lista.\n");
        }
    }

    public void atualizarTarefa(boolean tarefaAtualizada) {
        if (tarefaAtualizada) {
            System.out.println("Tarefa foi atualizada com sucesso!\n");
        } else {
            System.out.println("Tarefa não foi atualizada.\n");
        }
    }

    public void limparListaDeTarefas() {
        System.out.println("Lista de tarefas foi limpa!\n");
    }

    public void exibirTarefa(Tarefa tarefa) {
        if (tarefa != null) {
            System.out.println(
                    "ID: " + tarefa.getId_tarefa() + " - Título: " + tarefa.getTitulo() + " - Descrição: " + tarefa.getDescricao()
                            + " - Data de Criação: " + tarefa.getDataCriacao() + " - Data de Vencimento: " + tarefa.getDataVencimento()
                            + " - Prioridade: " + tarefa.getPrioridade() + " - Estado: " + tarefa.getEstado());
        } else {
            System.out.println("Objeto tarefa é nulo !");
        }
    }

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }
}
