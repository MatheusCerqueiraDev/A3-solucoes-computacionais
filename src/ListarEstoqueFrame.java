import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;

public class ListarEstoqueFrame extends JFrame {
    public ListarEstoqueFrame() {
        setTitle("Listar Estoque");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);

        if (Main.estoque.isEmpty()) {
            textArea.setText("O estoque está vazio.");
        } else {
            textArea.append(String.format("%-15s %-20s %-15s %-15s %-10s %-10s\n",
                    "Nome", "Descrição", "Marca", "Modelo", "Ano", "Preço"));
            textArea.append("=".repeat(90) + "\n"); // Linha separadora
            for (Produto produto : Main.estoque) {
                textArea.append(String.format("%-15s %-20s %-15s %-15s %-10d R$ %-10.2f\n",
                        produto.getNome(),
                        produto.getDescricao(),
                        produto.getMarca(),
                        produto.getModelo(),
                        produto.getAno(),
                        produto.getPreco()));
            }
        }

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}

