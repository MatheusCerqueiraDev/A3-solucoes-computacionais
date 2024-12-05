public class Peca extends Produto implements Item{

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

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String getDescricao() {
        return super.getDescricao();
    }

    @Override
    public double getPreco() {
        return super.getPreco();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public void setDescricao(String descricao) {
        super.setDescricao(descricao);
    }

    @Override
    public void setPreco(double preco) {
        super.setPreco(preco);
    }
}
