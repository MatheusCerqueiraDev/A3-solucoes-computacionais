public class Peca extends Produto{

    public Peca(
        String nome,
        String descricao, 
        String marca, 
        String modelo,
        Fabrica fabrica,
        Fornecedor fornecedor,
        int ano,
        double preco
    ) {
        super(nome, descricao, marca, modelo, fabrica, fornecedor, ano, preco);
    }
}
