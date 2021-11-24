# Doação de Livros
Projeto da Disciplica de Programação II da UFPB feito pelas alunas Alessandra Barros, Leticia e Laura.

### Sobre o projeto
A ideia do sistema é que os usuários possam colocar livros para doação e também pegar livros que estejam disponíveis, tudo isso de maneira concorrente.

### Ferramentas necessárias para execução do programa
#### Banco de dados
1. [Instalar](https://ajuda.hiper.com.br/hc/pt-br/articles/360055727811-Como-instalar-o-SSMS-SQL-Server-Management-Studio-) Microsoft Sql Server Management Studio
2. Apos instalar, siga esses passos para [habilitar o usuario do banco de dados](https://www.devmedia.com.br/ativar-usuario-sa-sql-server/20794), para que ele possa ser acessado pelo java.
3. Crie um banco com o nome "Doacao de Livros" no SQL, clicando em "Banco de Dados" -> "Novo banco de dados"
4. Depois rode os [scripts](./scripts_db) desta pasta para criar as tabelas do banco, clicando em "Nova Consulta" -> colar comando -> "Executar".
#### IDE
1. Para este projeto usamos o eclipse para [desenvolvimento](https://comoprogramarjava.com.br/instalacao/java-como-instalar-o-eclipse-no-windows-10/).
