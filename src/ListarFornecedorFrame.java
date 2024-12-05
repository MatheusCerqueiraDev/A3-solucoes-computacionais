import java.awt.BorderLayout;
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
        JScrollPane scrollPane = new JScrollPane(textArea);

        if (Main.fornecedores.isEmpty()) {
            textArea.setText("Não existem fornecedores.");
        } else {
            for (Fornecedor fornecedor : Main.fornecedores) {
                textArea.append(fornecedor.getNome() + "\n");
            }
        }

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}