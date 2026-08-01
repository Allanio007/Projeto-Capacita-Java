package br.com.taskmanager.controller;

import br.com.taskmanager.exceptions.EntradaInvalidaException;
import br.com.taskmanager.model.Tarefa;
import br.com.taskmanager.model.TarefaPrioritaria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskManager {
    // A lista principal usa a classe base Tarefa, aceitando subtipos como TarefaPrioritaria.
    private final ArrayList<Tarefa> tarefas;

    public TaskManager() {
        this.tarefas = new ArrayList<>();
    }

    public Tarefa adicionarTarefa(String titulo, String descricao) {
        validarTextoObrigatorio(titulo, "titulo");
        validarTextoObrigatorio(descricao, "descricao");

        Tarefa nova = new Tarefa(titulo.trim(), descricao.trim());
        tarefas.add(nova);
        return nova;
    }

    public Tarefa adicionarTarefaPrioritaria(String titulo, String descricao, int prioridade) {
        validarTextoObrigatorio(titulo, "titulo");
        validarTextoObrigatorio(descricao, "descricao");

        Tarefa nova = new TarefaPrioritaria(titulo.trim(), descricao.trim(), prioridade);
        tarefas.add(nova);
        return nova;
    }

    public List<Tarefa> listarTarefas() {
        return Collections.unmodifiableList(tarefas);
    }

    public boolean concluirTarefa(int indiceBaseUm) {
        Tarefa tarefa = obterPorIndiceBaseUm(indiceBaseUm);
        if (tarefa.isConcluida()) {
            return false;
        }
        tarefa.concluir();
        return true;
    }

    public Tarefa removerTarefa(int indiceBaseUm) {
        int indiceReal = indiceBaseUm - 1;
        if (indiceReal < 0 || indiceReal >= tarefas.size()) {
            throw new EntradaInvalidaException("Indice invalido para remocao.");
        }
        return tarefas.remove(indiceReal);
    }

    private Tarefa obterPorIndiceBaseUm(int indiceBaseUm) {
        int indiceReal = indiceBaseUm - 1;
        if (indiceReal < 0 || indiceReal >= tarefas.size()) {
            throw new EntradaInvalidaException("Indice invalido.");
        }
        return tarefas.get(indiceReal);
    }

    private void validarTextoObrigatorio(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new EntradaInvalidaException("O campo " + campo + " e obrigatorio.");
        }
    }
}
