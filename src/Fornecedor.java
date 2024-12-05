import java.util.UUID;

public class Fornecedor {
    private UUID ID;
    private String nome;
    private String numero;
    private String marca;
    private Fabrica fabrica;

    public Fornecedor(String nome, String numero, String marca, Fabrica fabrica) {
        this.nome = nome;
        this.numero = numero;
        this.marca = marca;
        this.fabrica = fabrica;
    }

    public Fornecedor(String nome, String numero, String marca) {
        this.nome = nome;
        this.numero = numero;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return nome;  
    }

    public String getNome() {
        return nome;
    }

    public Fabrica getFabrica() {
        return fabrica;
    }
    
    public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public static UUID gerarID() {
      return UUID.randomUUID();
    }
}
