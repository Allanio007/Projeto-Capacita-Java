public class Task {

    private static int contador = 1;

    private int id;
    private String descricao;
    private boolean concluida;

    public Task(String descricao) {
        this.id = contador++;
        this.descricao = descricao;
        this.concluida = false;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        String status = concluida ? "[X]" : "[ ]";
        return status + " [ID: " + id + "] " + descricao;
    }
}
