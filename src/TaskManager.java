import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tarefas;

    public TaskManager() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            System.out.println("Erro: a descrição da tarefa não pode ser vazia.");
            return;
        }
        Task novaTarefa = new Task(descricao.trim());
        tarefas.add(novaTarefa);
        System.out.println("Tarefa adicionada com sucesso: " + novaTarefa);
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        System.out.println("=== Lista de Tarefas ===");
        for (Task tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }

    public void marcarComoConcluida(int id) {
        Task tarefa = buscarPorId(id);
        if (tarefa == null) {
            System.out.println("Erro: tarefa com ID " + id + " não encontrada.");
            return;
        }
        if (tarefa.isConcluida()) {
            System.out.println("A tarefa já está marcada como concluída: " + tarefa);
            return;
        }
        tarefa.setConcluida(true);
        System.out.println("Tarefa marcada como concluída: " + tarefa);
    }

    public void removerTarefa(int id) {
        Task tarefa = buscarPorId(id);
        if (tarefa == null) {
            System.out.println("Erro: tarefa com ID " + id + " não encontrada.");
            return;
        }
        tarefas.remove(tarefa);
        System.out.println("Tarefa removida com sucesso: " + tarefa);
    }

    private Task buscarPorId(int id) {
        for (Task tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        return null;
    }
}
