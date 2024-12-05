import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BuscarProdutoFrame extends JFrame {
    public BuscarProdutoFrame() {
        setTitle("Buscar Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextField nomeField = new JTextField();
        JEditorPane textArea = new JEditorPane();
        textArea.setEditable(false);
        textArea.setContentType("text/html");
        JScrollPane scrollPane = new JScrollPane(textArea);
        JButton buscarButton = new JButton("Buscar");

        buscarButton.addActionListener(e -> {
            String nome = nomeField.getText().toLowerCase();
            boolean encontrado = false;
            StringBuilder result = new StringBuilder("<html><body>");

            for (Produto produto : Main.estoque) {
                if (produto.getNome().toLowerCase().contains(nome)) {
                    result.append("<p>").append(produto.toString()).append("</p>\n");
                    encontrado = true;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.");
            }

            textArea.setContentType("text/html");
            textArea.setText(result.toString());
        });

        add(nomeField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buscarButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
