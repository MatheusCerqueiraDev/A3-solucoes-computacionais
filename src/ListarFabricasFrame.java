import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
            textArea.setText("Não existem fábricas.");
        } else {
            textArea.append(String.format("%-30s %-30s %-25s\n",
                    "Nome", "Marca", "Produtos"));
            textArea.append("=".repeat(90) + "\n");
            for (Fabrica fabrica : Main.fabricas) {
                textArea.append(String.format("%-30s %-30s %-25s\n",
                        fabrica.getNome(),
                        fabrica.getMarca(),
                        fabrica.getProdutos()));
            }
        }

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}

