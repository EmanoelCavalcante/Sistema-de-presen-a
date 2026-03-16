# Sistema-de-chamadas
Aplicação Java para registro e controle de presença de alunos, utilizando DAO, SQLite para persistência de dados e arquitetura em camadas.
# Sistema de Controle de Presença

Este projeto é uma aplicação desenvolvida em **Java** para celulares **Anroid** com o objetivo de gerenciar a presença de alunos em sala de aula.

O sistema permite registrar, consultar e controlar a frequência dos alunos de forma organizada, utilizando boas práticas de programação e arquitetura em camadas.

## Funcionalidades

- Cadastro de alunos
- Registro de presença
- Consulta de frequência
- Gerenciamento de dados em banco de dados
- Retorno de uma tabela em PDF com a aula, presença e os conceitos usado no dia a dia

## Tecnologias utilizadas

- Java
- Android Studio
- SQLite
- Padrão DAO
- Git
- Android SDK

## Arquitetura do projeto

O projeto segue uma arquitetura organizada em camadas para separação de responsabilidades:
UI
↓
Repository
↓
DAO
↓
SQLite Database


## Arquitetura do projeto
com.challengeEnglishCourse.br │ 
├── model 
│     └── Aluno.java 
|     └── Aula.java
|     └── Presenca.java
│ 
├── database 
│       └── DataBaseHelper.java 
│ 
├── database/DAO 
│       └── AlunoDAO.java
|       └── AulaDAO.java
|       └── PresencaDAO.java
|
└── repository 
        └── AlunoRepository.java


## Como executar o projeto
1. Clone o repositório
   git clone https://github.com/EmanoelCavalcante/Sistema-de-chamadas.git
2. Abra o projeto no **Android Studio**
3. Execute em um emulador ou dispositivo físico


## Roadmap
- [x] Operações CRUD
- [x] Cadastro de alunos
- [x] Registro de presença
- [ ] Tratamento de erros
- [ ] Hisórico de chamadas
- [ ] Criar interface do aplicativo
- [ ] Relatório atualizado em PDF

        
## Status do projeto
- Em desenvolvimento

## Objetivo do projeto

Este projeto foi desenvolvido com fins educacionais para praticar:

- Programação orientada a objetos
- Integração com banco de dados
- Arquitetura de software
- Boas práticas em Java

## Autor
Emanoel Cavalcante

Estudante de desenvolvimento de software
