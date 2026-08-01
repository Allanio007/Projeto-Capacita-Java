package br.com.taskmanager.controller;

import br.com.taskmanager.exceptions.EntradaInvalidaException;
import br.com.taskmanager.model.Tarefa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskManagerTest {
    private TaskManager manager;

    @BeforeEach
    void setUp() {
        manager = new TaskManager();
    }

    @Test
    void deveAdicionarTarefaComum() {
        Tarefa tarefa = manager.adicionarTarefa("Estudar Java", "Revisar POO");

        Assertions.assertNotNull(tarefa.getId());
        Assertions.assertEquals(1, manager.listarTarefas().size());
    }

    @Test
    void deveConcluirTarefaPorIndice() {
        manager.adicionarTarefa("Atividade", "Fazer modulo 1");

        boolean concluiu = manager.concluirTarefa(1);

        Assertions.assertTrue(concluiu);
        Assertions.assertTrue(manager.listarTarefas().get(0).isConcluida());
    }

    @Test
    void deveLancarExcecaoParaIndiceInvalido() {
        manager.adicionarTarefa("A", "B");

        Assertions.assertThrows(EntradaInvalidaException.class,
                () -> manager.removerTarefa(99));
    }
}
