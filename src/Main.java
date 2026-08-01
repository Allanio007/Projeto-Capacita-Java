import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager gerenciador = new TaskManager();
        int opcao;

        System.out.println("=== Bem-vindo ao TaskManager ===");

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, insira um número.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da nova tarefa: ");
                    String descricao = scanner.nextLine();
                    gerenciador.adicionarTarefa(descricao);
                    break;
                case 2:
                    gerenciador.listarTarefas();
                    break;
                case 3:
                    System.out.print("Digite o ID da tarefa a marcar como concluída: ");
                    try {
                        int idConcluir = Integer.parseInt(scanner.nextLine().trim());
                        gerenciador.marcarComoConcluida(idConcluir);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido. Por favor, insira um número inteiro.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID da tarefa a remover: ");
                    try {
                        int idRemover = Integer.parseInt(scanner.nextLine().trim());
                        gerenciador.removerTarefa(idRemover);
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido. Por favor, insira um número inteiro.");
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o TaskManager. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("--- Menu ---");
        System.out.println("1. Criar nova tarefa");
        System.out.println("2. Listar todas as tarefas");
        System.out.println("3. Marcar tarefa como concluída");
        System.out.println("4. Remover tarefa");
        System.out.println("0. Sair");
    }
}
