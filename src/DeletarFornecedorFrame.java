import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DeletarFornecedorFrame extends JFrame {
    public DeletarFornecedorFrame() {
        setTitle("Deletar Fornecedor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        if (Main.fornecedores.isEmpty()) {
            textArea.setText("Não existem fornecedores.");
        } else {
            for (int i = 0; i < Main.fornecedores.size(); i++) {
                textArea.append("Índice: " + i + " - " + Main.fornecedores.get(i).toString() + "\n");
            }
        }

        JTextField indiceField = new JTextField();
        JButton deletarButton = new JButton("Deletar");

        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = Integer.parseInt(indiceField.getText());
                if (indice >= 0 && indice < Main.fornecedores.size()) {
                    Main.fornecedores.remove(indice);
                    JOptionPane.showMessageDialog(null, "Fornecedor deletado com sucesso!");
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