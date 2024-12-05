import java.util.ArrayList;
import java.util.UUID;

public class Fabrica {
    private UUID ID;
    private String nome;
    private String marca;
    private ArrayList<Peca> produtos;

   public Fabrica(String nome, String marca) {
      this.ID = gerarID();
      this.nome = nome;
      this.marca = marca;
      this.produtos =  new ArrayList<>();
   }

   public static UUID gerarID() {
      return UUID.randomUUID();
   }

   public String getNome() {
      return nome;
   }

   @Override
   public String toString() {
       return nome;
   }  

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getMarca() {
      return marca;
   }
   
   public void setMarca(String marca) {
      this.marca = marca;
   }

   public UUID getID() {
      return ID;
   }
   public  void adicionarProduto( Peca peca) {
      produtos.add(peca);
   }
   public ArrayList<Peca> getProdutos() {
      return produtos;
   }

   public void listarProdutos() {
      System.out.println("Produtos da Fabrica " + nome + ":");
    for (Produto peca : produtos) {
         System.out.println("Nome: " + peca.getNome());
         System.out.println("Nome: " + peca.getDescricao());
         System.out.println("Marca: " + peca.getMarca());
         System.out.println("Quantidade: " + peca.getModelo());
         System.out.println("Quantidade: " + peca.getAno());
         System.out.println("Preço: " + peca.getPreco());
         System.out.println("----------------------------------");
      }
   }
}
