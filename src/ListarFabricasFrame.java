import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;

public class ListarFabricasFrame extends JFrame {
    public ListarFabricasFrame() {
        setTitle("Listar Fabricas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);

        if (Main.fabricas.isEmpty()) {
            textArea.setText("O estoque está vazio.");
        } else {
            textArea.append(String.format("%-30s %-30s %-25s\n",
                    "Nome", "Marca", "Produtos"));
            textArea.append("=".repeat(90) + "\n"); // Linha separadora
            for (Fabrica fabrica : Main.fabricas) {
                textArea.append(String.format("%-15s %-20s %-15s %-15s %-10d R$ %-10.2f\n",
                        fabrica.getNome(),
                        fabrica.getMarca(),
                        fabrica.getProdutos()));
            }
        }

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}

