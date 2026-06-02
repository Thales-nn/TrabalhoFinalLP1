# Gerenciador Financeiro

## Sobre o Projeto

O Gerenciador Financeiro é uma aplicação desktop desenvolvida em Java utilizando JavaFX e SQLite. O sistema permite que usuários realizem cadastro, login e gerenciamento de movimentações financeiras, armazenando os dados em um banco de dados local.

---

## Tecnologias Utilizadas

* Java 25
* JavaFX 17.0.19
* SQLite
* SQLite JDBC Driver
* FXML
* CSS
* Visual Studio Code

---

## Pré-requisitos

Antes de executar o projeto, é necessário instalar os seguintes componentes:

### 1. Java

Verifique se o Java está instalado executando:

```bash
java -version
javac -version
```

O projeto foi desenvolvido utilizando Java 25.

---

### 2. JavaFX

Baixe o JavaFX SDK 17.0.19 no site oficial:

https://gluonhq.com/products/javafx/

Após o download:

1. Extraia o arquivo compactado.
2. Mova a pasta extraída para o diretório raiz do disco C:.

A estrutura deve ficar exatamente assim:

```text
C:\
└── javafx-sdk-17.0.19
    └── lib
        ├── javafx.base.jar
        ├── javafx.controls.jar
        ├── javafx.fxml.jar
        ├── javafx.graphics.jar
        └── ...
```

Importante: o projeto está configurado para procurar o JavaFX nesse caminho específico.

---

### 3. DB Browser for SQLite

Baixe e instale o DB Browser for SQLite:

https://sqlitebrowser.org/

O programa não é obrigatório para executar o sistema, mas é recomendado para visualizar e consultar os dados armazenados no banco de dados SQLite.

---

## Estrutura do Projeto

```text
TrabalhoFinalLP1
│
├── .vscode
│   ├── launch.json
│   └── settings.json
│
├── lib
│   └── sqlite-jdbc-3.53.1.0.jar
│
├── src
│   ├── application
│   │   └── Main.java
│   │
│   ├── controller
│   │   ├── CadastroController.java
│   │   ├── DashboardController.java
│   │   └── LoginController.java
│   │
│   ├── dao
│   │   ├── Banco.java
│   │   ├── ConnectionFactory.java
│   │   ├── MovimentacaoDAO.java
│   │   └── UsuarioDAO.java
│   │
│   ├── model
│   │   ├── Movimentacao.java
│   │   ├── Sessao.java
│   │   └── Usuario.java
│   │
│   └── view
│       ├── login.fxml
│       ├── cadastro.fxml
│       ├── dashboard.fxml
│       └── style.css
│
└── banco.db
```

---

## Como Executar

Após instalar o JavaFX e o DB Browser:

1. Abra o projeto no Visual Studio Code.
2. Aguarde o carregamento das extensões Java.
3. Certifique-se de que o JavaFX está localizado em:

```text
C:\javafx-sdk-17.0.19
```

4. Pressione:

```text
F5
```

ou clique em:

```text
Run → Start Debugging
```

O sistema será iniciado automaticamente.

---

## Banco de Dados

O banco de dados utilizado é o SQLite.

Na primeira execução:

* O arquivo `banco.db` será criado automaticamente.
* As tabelas necessárias serão criadas automaticamente pela classe `Banco.java`.

Não é necessário criar tabelas manualmente.

---

## Funcionalidades

### Cadastro de Usuários

Permite registrar novos usuários no sistema.

### Login

Permite autenticar usuários cadastrados.

### Gerenciamento de Movimentações

Cada usuário possui suas próprias movimentações financeiras.

É possível:

* Registrar movimentações.
* Consultar movimentações cadastradas.
* Armazenar os dados permanentemente no banco SQLite.

---

## Observações

* Cada usuário visualiza apenas suas próprias movimentações.
* Os dados permanecem salvos mesmo após fechar o sistema.
* O arquivo `banco.db` pode ser aberto utilizando o DB Browser for SQLite para inspeção dos dados.

---

## Autor

Projeto desenvolvido para a disciplina de Linguagem de Programação.
