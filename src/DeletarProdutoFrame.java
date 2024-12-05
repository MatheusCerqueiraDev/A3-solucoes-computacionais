import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DeletarProdutoFrame extends JFrame {
    public DeletarProdutoFrame() {
        setTitle("Deletar Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        if (Main.estoque.isEmpty()) {
            textArea.setText("O estoque está vazio.");
        } else {
            textArea.setText("Escolha um item e delete escrevendo indice.\n");
            for (int i = 0; i < Main.estoque.size(); i++) {
                textArea.append("Índice: " + i + " - " + Main.estoque.get(i).toString() + "\n");
            }
        }

        JTextField indiceField = new JTextField();
        JButton deletarButton = new JButton("Deletar");

        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = Integer.parseInt(indiceField.getText());
                if (indice >= 0 && indice < Main.estoque.size()) {
                    Main.estoque.remove(indice);
                    JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Índice inválido.");
                }
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(indiceField, BorderLayout.NORTH);
        add(deletarButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}