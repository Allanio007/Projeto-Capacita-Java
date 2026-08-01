# Projeto 1 - Entrega da Atividade (Java)

Este documento descreve a entrega do Projeto 1 da disciplina.

## Descricao

O projeto implementa um sistema de gerenciamento de tarefas em Java (aplicacao de console), com foco em boas praticas de Programacao Orientada a Objetos e organizacao em camadas/pacotes.

## Objetivo da atividade

- Aplicar conceitos de POO (encapsulamento, heranca, polimorfismo, abstracao e interfaces).
- Praticar validacoes e tratamento de excecoes em um fluxo real.
- Estruturar um projeto Java com Maven, testes e execucao em linha de comando.

## Conteudo entregue

- Codigo-fonte completo do projeto Java.
- Arquivo de configuracao Maven (`pom.xml`).
- Estrutura de pacotes organizada por responsabilidade.
- Documentacao de uso no README do projeto.

## Estrutura da entrega

No repositorio, os arquivos principais estao organizados assim:

- `taskmanager-console/`: projeto Java principal.
- `taskmanager-console/src/`: codigo-fonte.
- `taskmanager-console/pom.xml`: build e dependencias.
- `taskmanager-console/README.md`: instrucoes de execucao.
- `arquitetura-roteador.md`: este documento da atividade.

## Requisitos para executar

- Java 17 ou superior.
- Maven (opcional, recomendado para build e testes).

## Como executar (resumo)

Dentro da pasta `taskmanager-console`:

1. Rodar testes:

```bash
mvn clean test
```

2. Executar aplicacao:

```bash
mvn exec:java
```

## Publicacao no GitHub

Para publicar este Projeto 1:

```bash
git init
git add .
git commit -m "Entrega Projeto 1"
git branch -M main
git remote add origin <URL_DO_REPOSITORIO>
git push -u origin main
```

## Observacao

Esta entrega foi preparada para avaliacao academica, com foco em legibilidade, organizacao de codigo e reproducao simples do ambiente.
