# TaskManager Console

Projeto em Java (console) para gerenciamento de tarefas.

## Funcionalidades

- Criar nova tarefa (normal ou prioritaria)
- Listar tarefas
- Marcar tarefa como concluida
- Remover tarefa

## Conceitos aplicados

- POO: encapsulamento, heranca, polimorfismo, classe abstrata e interface
- Estruturas de controle: if, else, switch, while
- Colecoes: ArrayList
- Tratamento de excecoes customizadas
- Organizacao em pacotes

## Estrutura

src/main/java/br/com/taskmanager/
- app
- controller
- model
- exceptions
- utils

## Como executar

Pre-requisito: Java 17+.

Opcao 1 (Java puro):

```bash
javac -d out src/main/java/br/com/taskmanager/model/*.java src/main/java/br/com/taskmanager/exceptions/*.java src/main/java/br/com/taskmanager/controller/*.java src/main/java/br/com/taskmanager/utils/*.java src/main/java/br/com/taskmanager/app/*.java
java -cp out br.com.taskmanager.app.Main
```

Opcao 2 (Maven, se instalado):

```bash
mvn clean test
mvn exec:java
```

## Fluxo de Git local (quando iniciar o repositorio)

```bash
git init
git add .
git commit -m "feat: primeira entrega taskmanager console"
```

Depois, conectar ao GitHub:

```bash
git remote add origin <URL_DO_SEU_REPOSITORIO>
git branch -M main
git push -u origin main
```
