package view;

import java.util.List;
import model.Professor;

public class ProfessorView {
	public void exibirListaDeProfessores(List<Professor> professores) {
		System.out.println("==== Lista de Professores ====");
		System.out.println("------------------------------");

		for (Professor professor : professores) {
			exibirProfessor(professor);
		}
		System.out.println("------------------------------");
	}

	public void removerProfessor(boolean professorRemovido) {
		
		if (professorRemovido) {
			System.out.println("Professor removido com sucesso!\n");
		} else {
			System.out.println("Professor nao encontrado na lista.\n");
		}
	}
	
	public void atualizarProfessor(boolean professorAtualizado) {
	
		if (professorAtualizado) {
			System.out.println("Professor foi atualizado com sucesso!\n");
		} else {
			System.out.println("Professor não foi atualizado.\n");
		}
	}

	public void limparListaDeProfessores() {
		System.out.println("Lista de professores foi limpa!\n");
	}

	public void exibirProfessor(Professor professor) {
		if (professor != null) {
			System.out.println(
					"ID: " + professor.getId() + " - Professor: " + professor.getNome() + " - Especialidade: " + professor.getEspecialidade() + " - Data de Admissao: " + professor.getDataDeAdmissao());
		} else {
			System.out.println("Objeto professor é nulo !");
		}
	}

	/*
	 * Exibe uma mensagem recebida atráves do parametro msg no console
	 */
	public void exibirMensagem(String msg) {
		System.out.println(msg);
	}
}