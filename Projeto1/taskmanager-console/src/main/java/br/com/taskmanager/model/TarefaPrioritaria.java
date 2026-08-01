package br.com.taskmanager.model;

public class TarefaPrioritaria extends Tarefa {
    private int prioridade;

    public TarefaPrioritaria(String titulo, String descricao, int prioridade) {
        super(titulo, descricao);
        setPrioridade(prioridade);
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        if (prioridade < 1 || prioridade > 5) {
            throw new IllegalArgumentException("A prioridade deve estar entre 1 e 5.");
        }
        this.prioridade = prioridade;
    }

    @Override
    public String resumo() {
        return String.format("%s (Prioridade: %d)", super.resumo(), prioridade);
    }
}
