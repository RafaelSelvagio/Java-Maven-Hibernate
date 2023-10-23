package controller;

import dao.ProfessorDAO;
import model.Professor;
import view.ProfessorView;

public class ProfessorController {
	private ProfessorDAO professorDAO;
	private ProfessorView professorView;

	public ProfessorController() {
		professorDAO = new ProfessorDAO();
		professorView = new ProfessorView();
	}

	public void adicionarProfessor(String nome, String especialidade, String dataDeAdmissao) {
		Professor professor = new Professor(nome, especialidade, dataDeAdmissao);

		professorDAO.adicionarProfessor(professor);
	}
	
	public void atualizarProfessor(Integer id, String nome,  String especialidade, String dataDeAdmissao) {
		boolean professorAtualizado = professorDAO.atualizarProfessor(id, nome, especialidade, dataDeAdmissao);
		
		professorView.atualizarProfessor(professorAtualizado);
	}
	
	public void buscaProfessorPorNome(String nome) {
		professorView.exibirProfessor(professorDAO.buscarProfessorPorNome(nome));
	}
	
	public void listarProfessores() {
		professorView.exibirListaDeProfessores(professorDAO.listarProfessores());
	}

	public void removerProfessor(Integer id) {
		Professor professor = professorDAO.buscarProfessorPorId(id);

		boolean professorRemovido = professorDAO.removerProfessor(professor);
		professorView.removerProfessor(professorRemovido);
	}
	
	public void fecharProfessorDAO() {
    	professorDAO.fechar();
    }
}
