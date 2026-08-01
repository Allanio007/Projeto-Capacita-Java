package br.com.taskmanager.model;

public class Tarefa extends BaseTarefa {
    public Tarefa(String titulo, String descricao) {
        super(titulo, descricao);
    }

    @Override
    public String resumo() {
        return String.format("%s %s - %s", statusTexto(), getTitulo(), getDescricao());
    }

    @Override
    public String toString() {
        return resumo();
    }
}
