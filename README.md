# Projeto Final A3 - Sistema de Controle de Estoque para Loja de Autopeças

Este projeto consiste em um sistema CRUD para gerenciar o estoque de produtos de uma loja de autopeças. Ele foi desenvolvido como parte da avaliação A3 da disciplina, aplicando os conceitos de Orientação a Objetos (OO) e boas práticas de desenvolvimento.

---

## Funcionalidades

O sistema permite realizar as seguintes operações:

- **Incluir novo produto**: Adicionar uma nova peça ao estoque.
- **Consultar produto**: Buscar uma peça específica pelo código.
- **Alterar dados de um produto**: Atualizar as informações de uma peça cadastrada.
- **Excluir produto**: Remover uma peça do estoque.
- **Listar produtos**: Exibir todos os produtos disponíveis no estoque.

---

## Estrutura do Projeto

Abaixo está a estrutura do projeto:

**projetoFinalA3**


├── src/

│   ├── AlterarProdutoFrame.java      
│   ├── BuscarProdutoFrame.java       
│   ├── CriarProdutoFrame.java         
│   ├── DeletarProdutoFrame.java       
│   ├── ListarEstoqueFrame.java        
│   ├── Peca.java                    
│   ├── Produto.java                   
│   ├── Fornecedor.java
│   ├── Fabrica.java
│   ├── Main.java                    
│   ├── SecondMain.java 


├── .gitignore                         


└── README.md                         

## Pré-requisitos
Para executar este projeto, você precisará de:

- **Java 8 ou superior**.
- **Um ambiente de desenvolvimento, como IntelliJ ou Visual Studio CodeE**.

## Como Executar:

1. Clone o repositório
   - **git clone <url_do_repositorio>**
   

2. Importe o projeto em seu ambiente de desenvolvimento.

       - Clique em File > Open.
       - Selecione a pasta do projeto e clique em Open as Project.

3. Compile o projeto:

       - Certifique-se de que as dependências estão configuradas corretamente.
       - Clique com o botão direito no arquivo Main.java e selecione Run.


4. Interaja com o sistema:

        - Escolha uma das opções no menu para realizar operações como inclusão, consulta, alteração, exclusão ou listagem de produtos