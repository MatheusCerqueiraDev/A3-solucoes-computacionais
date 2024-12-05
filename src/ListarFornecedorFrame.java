import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListarFornecedorFrame extends JFrame {
    public ListarFornecedorFrame() {
        setTitle("Listar Fornecedores");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);

        if (Main.fornecedores.isEmpty()) {
            textArea.setText("Não existem fornecedores.");
        } else {
            textArea.append(String.format("%-20s %-20s %-20s %-20s\n",
            "Nome", "Marca", "Número celular", "Fábricas"));
            textArea.append("=".repeat(90) + "\n");
            for (Fornecedor fornecedor : Main.fornecedores) {
                textArea.append(String.format("%-20s %-20s %-20s %-20s\n",
                    fornecedor.getNome(),
                    fornecedor.getMarca(),
                    fornecedor.getNumero(),
                    fornecedor.getFabrica()));
            }
        }

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}