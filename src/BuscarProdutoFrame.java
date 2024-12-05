import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;

public class BuscarProdutoFrame extends JFrame {
    public BuscarProdutoFrame() {
        setTitle("Buscar Produto");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextField nomeField = new JTextField();
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);
        JButton buscarButton = new JButton("Buscar");

        buscarButton.addActionListener(e -> {
            String nome = nomeField.getText().toLowerCase();
            boolean encontrado = false;
            textArea.setText("");

            if (Main.estoque.isEmpty()) {
                textArea.setText("O estoque está vazio.");
                return;
            }


            textArea.append(String.format("%-15s %-20s %-20s %-15s %-10s %-10s\n",
                    "Nome", "Descrição", "Marca", "Modelo", "Ano", "Preço"));
            textArea.append("=".repeat(90) + "\n");

            for (Produto produto : Main.estoque) {
                if (produto.getNome().toLowerCase().contains(nome)) {
                    textArea.append(String.format("%-15s %-20s %-20s %-15s %-10d R$ %-10.2f\n",
                            produto.getNome(),
                            produto.getDescricao(),
                            produto.getMarca(),
                            produto.getModelo(),
                            produto.getAno(),
                            produto.getPreco()));
                    encontrado = true;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                textArea.setText("");
            }
        });

        add(nomeField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buscarButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
