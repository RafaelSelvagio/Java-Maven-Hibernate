package main;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import controller.TarefaController;
import model.Prioridade;
import model.Estado;

public class Main {
    public static void main(String[] args) {
        String titulo, descricao;
        Date dataCriacao, dataVencimento;
        Prioridade prioridade;
        Estado estado;
        Integer idTarefa;

        TarefaController tarefaController = new TarefaController();
        Scanner scanner = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 0) {

            // Menu da nossa aplicacao
            System.out.println("_____Menu_____");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Buscar tarefa");
            System.out.println("4. Remover tarefa da lista");
            System.out.println("5. Atualizar dados da tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = scanner.nextInt();

                switch (opcao) {
                case 1:
                    System.out.print("Digite o título da tarefa: ");
                    scanner.nextLine();
                    titulo = scanner.nextLine();

                    System.out.print("Digite a descrição da tarefa: ");
                    descricao = scanner.nextLine();

                    dataCriacao = new Date(); 

                    System.out.println("Data de criação: " + dataCriacao);

                    System.out.print("Digite a data de vencimento (yyyy-MM-dd): ");
                    dataVencimento = java.sql.Date.valueOf(scanner.nextLine());

                    System.out.print("Digite a prioridade (ALTA, MEDIA, BAIXA): ");
                    prioridade = Prioridade.valueOf(scanner.nextLine());

                    System.out.print("Digite o estado (ABERTA, EM_PROGRESSO, CONCLUIDA): ");
                    estado = Estado.valueOf(scanner.nextLine());

                    tarefaController.adicionarTarefa(titulo, descricao, dataCriacao, dataVencimento, prioridade, estado);
                    System.out.print("Tarefa adicionada com sucesso! ");
                    break;


                    case 2:
                        tarefaController.listarTarefas();
                        break;

                    case 3:
                        System.out.print("Digite o título da tarefa que deseja buscar: ");
                        scanner.nextLine();
                        String tituloBusca = scanner.nextLine();

                        tarefaController.buscaTarefaPorTitulo(tituloBusca);
                        break;

                    case 4:
                        System.out.println("Digite o ID da tarefa a ser removida: ");
                        idTarefa = scanner.nextInt();
                        tarefaController.removerTarefa(idTarefa);
                        break;

                    case 5:
                        System.out.println("Digite o ID da tarefa que deseja atualizar: ");
                        idTarefa = scanner.nextInt();

                        System.out.print("Digite o novo título da tarefa: ");
                        scanner.nextLine();
                        titulo = scanner.nextLine();

                        System.out.print("Digite a nova descrição da tarefa: ");
                        descricao = scanner.nextLine();

                        System.out.print("Digite a nova data de vencimento (yyyy-MM-dd): ");
                        dataVencimento = java.sql.Date.valueOf(scanner.nextLine());

                        System.out.print("Digite a nova prioridade (ALTA, MEDIA, BAIXA): ");
                        prioridade = Prioridade.valueOf(scanner.nextLine());

                        System.out.print("Digite o novo estado (ABERTA, EM_PROGRESSO, CONCLUIDA): ");
                        estado = Estado.valueOf(scanner.nextLine());

                        tarefaController.atualizarTarefa(idTarefa, titulo, descricao, dataVencimento, prioridade, estado);
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        tarefaController.fecharTarefaDAO();
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Opção inválida. Por favor, digite um número inteiro válido.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
