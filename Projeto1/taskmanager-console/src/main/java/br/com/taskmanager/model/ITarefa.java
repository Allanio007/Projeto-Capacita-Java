package br.com.taskmanager.model;

import java.time.LocalDateTime;

public interface ITarefa {
    String getId();

    String getTitulo();

    String getDescricao();

    boolean isConcluida();

    void concluir();

    LocalDateTime getDataCriacao();

    String resumo();
}
