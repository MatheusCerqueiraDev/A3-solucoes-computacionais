import java.util.UUID;

public abstract class Produto {
    private UUID id;
    private String nome;
    private String descricao;
    private String marca;
    private String modelo;
    Fabrica fabrica;
    Fornecedor fornecedor;
    private int ano;
    private double preco;

    public Produto(
        String nome, 
        String descricao, 
        String marca, 
        String modelo, 
        Fabrica fabrica,
        Fornecedor fornecedor,
        int ano,
        double preco
    ) {
        this.id = gerarID();
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
        this.fabrica = fabrica;
        this.fornecedor = fornecedor;
    }

    public static UUID gerarID() {
        return UUID.randomUUID();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public Fabrica getFabrica() {
        return this.fabrica;
    }

    public void setFabrica(Fabrica fabrica){
        this.fabrica = fabrica;
    }

    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor){
        this.fornecedor = fornecedor;
    }
    
    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Descrição: " + descricao + ", Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano + ", Preço: R$ " + preco;
    }
}
