package main;
import java.util.Scanner;
import controller.ProfessorController;

public class Main {
	public static void main(String[] args) {
		String nome, especialidade, dataDeAdmissao;
		Integer idProfessor;
		
		ProfessorController professorController = new ProfessorController();
		Scanner scanner = new Scanner(System.in);
		
		int opcao = -1;
		
		while (opcao != 0) {

			// Menu da nossa aplicacao
			System.out.println("_____Menu_____");
			System.out.println("1. Adicionar professor");
			System.out.println("2. Listar professores");
			System.out.println("3. Buscar professor");
			System.out.println("4. Remover professor da lista");
			System.out.println("5. Atualizar dados do professor");
			System.out.println("0. Sair");
			System.out.print("Escolha uma opcao: ");
			
			try {

				opcao = scanner.nextInt();
	
				switch (opcao) {
	
				case 1:
					System.out.print("Digite o nome do professor: ");
					scanner.nextLine();
					nome = scanner.nextLine();
	
					System.out.print("Digite a especialidade do professor: ");
					especialidade = scanner.nextLine();
					
					System.out.print("Digite a data de admissao: ");
					dataDeAdmissao = scanner.nextLine();
	
					professorController.adicionarProfessor(nome, especialidade, dataDeAdmissao);
					System.out.print("Adicionado com Sucesso! ");
					break;
					
				case 2:
					professorController.listarProfessores();
					break;
					
				case 3:
					System.out.print("Digite o nome do pais que deseja buscar: ");
					scanner.nextLine();
					String nomeBusca = scanner.nextLine();
					
					professorController.buscaProfessorPorNome(nomeBusca);
					break;
	
				case 4:
					System.out.println("Digite o ID do país a ser removido: ");

					idProfessor = scanner.nextInt();
					professorController.removerProfessor(idProfessor);
					break;
					
				case 5:
					System.out.println("Digite o ID do professor que deseja atualizar: ");
					idProfessor = scanner.nextInt();
					
					System.out.print("Digite o nome do professor: ");
					scanner.nextLine();
					nome = scanner.nextLine();
	
					System.out.print("Digite a especialidade do professor: ");
					especialidade = scanner.nextLine();
					
					System.out.print("Digite a data de admissao do professor: ");
					dataDeAdmissao = scanner.nextLine();
	
					professorController.atualizarProfessor(idProfessor, nome, especialidade, dataDeAdmissao);
					break;
	
				case 0:
					System.out.println("Saindo...");
					professorController.fecharProfessorDAO();	
					break;
	
				default:
					System.out.println("Opção invalida.");
					break;
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Opcao invalida. Por favor, digite um numero inteiro valido.");
                scanner.nextLine();
			}
		}
		
		scanner.close();
	}
}
