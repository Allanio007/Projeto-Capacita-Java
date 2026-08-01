package br.com.taskmanager.model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseTarefa implements ITarefa {
    private final String id;
    private String titulo;
    private String descricao;
    private boolean concluida;
    private final LocalDateTime dataCriacao;

    protected BaseTarefa(String titulo, String descricao) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false;
        this.dataCriacao = LocalDateTime.now();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean isConcluida() {
        return concluida;
    }

    @Override
    public void concluir() {
        this.concluida = true;
    }

    @Override
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    protected String statusTexto() {
        return concluida ? "[x]" : "[ ]";
    }
}
