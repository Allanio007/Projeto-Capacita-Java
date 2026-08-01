package br.com.taskmanager.app;

import br.com.taskmanager.controller.TaskManager;
import br.com.taskmanager.exceptions.EntradaInvalidaException;
import br.com.taskmanager.model.Tarefa;
import br.com.taskmanager.utils.InputHelper;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        try (Scanner scanner = new Scanner(System.in)) {
            InputHelper input = new InputHelper(scanner);
            executarMenu(manager, input);
        }
    }

    private static void executarMenu(TaskManager manager, InputHelper input) {
        int opcao;
        do {
            imprimirMenu();
            try {
                // O menu roda em loop ate o usuario escolher sair.
                opcao = input.lerInteiro("Escolha uma opcao: ");
                processarOpcao(opcao, manager, input);
            } catch (EntradaInvalidaException | IllegalArgumentException ex) {
                opcao = 0;
                System.out.println("Erro: " + ex.getMessage());
            }
        } while (opcao != 5);
    }

    private static void imprimirMenu() {
        System.out.println("\n===== GERENCIADOR DE TAREFAS =====");
        System.out.println("1. Criar nova tarefa");
        System.out.println("2. Listar tarefas");
        System.out.println("3. Marcar tarefa como concluida");
        System.out.println("4. Remover tarefa");
        System.out.println("5. Sair");
    }

    private static void processarOpcao(int opcao, TaskManager manager, InputHelper input) {
        switch (opcao) {
            case 1 -> criarNovaTarefa(manager, input);
            case 2 -> listarTarefas(manager.listarTarefas());
            case 3 -> concluirTarefa(manager, input);
            case 4 -> removerTarefa(manager, input);
            case 5 -> System.out.println("Encerrando o sistema...");
            default -> System.out.println("Opcao invalida. Tente novamente.");
        }
    }

    private static void criarNovaTarefa(TaskManager manager, InputHelper input) {
        String titulo = input.lerTextoObrigatorio("Titulo: ");
        String descricao = input.lerTextoObrigatorio("Descricao: ");

        // Exemplo de polimorfismo: a lista armazena Tarefa e TarefaPrioritaria.
        int tipo = input.lerInteiro("Tipo (1-Normal, 2-Prioritaria): ");
        if (tipo == 2) {
            int prioridade = input.lerInteiro("Prioridade (1-5): ");
            manager.adicionarTarefaPrioritaria(titulo, descricao, prioridade);
        } else {
            manager.adicionarTarefa(titulo, descricao);
        }

        System.out.println("Tarefa adicionada com sucesso.");
    }

    private static void listarTarefas(List<Tarefa> tarefas) {
        System.out.println("\n===== LISTA DE TAREFAS =====");
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        for (int i = 0; i < tarefas.size(); i++) {
            Tarefa tarefa = tarefas.get(i);
            System.out.printf("%d. %s%n", i + 1, tarefa.resumo());
        }
    }

    private static void concluirTarefa(TaskManager manager, InputHelper input) {
        int indice = input.lerInteiro("Numero da tarefa para concluir: ");
        boolean concluiu = manager.concluirTarefa(indice);
        if (concluiu) {
            System.out.println("Tarefa concluida com sucesso.");
        } else {
            System.out.println("A tarefa ja estava concluida.");
        }
    }

    private static void removerTarefa(TaskManager manager, InputHelper input) {
        int indice = input.lerInteiro("Numero da tarefa para remover: ");
        Tarefa removida = manager.removerTarefa(indice);
        System.out.println("Tarefa removida: " + removida.getTitulo());
    }
}
