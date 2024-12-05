import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AlterarFornecedorFrame extends JFrame {
    public AlterarFornecedorFrame() {
        setTitle("Alterar Fornecedor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        if (Main.fornecedores.isEmpty()) {
            textArea.setText("Não existem fonecedores.");
        } else {
            textArea.setText("Escolha um item e delete escrevendo indice.\n");
            for (int i = 0; i < Main.fornecedores.size(); i++) {
                textArea.append("Índice: " + i + " - " + Main.fornecedores.get(i).toString() + "\n");
            }
        }

        JTextField indiceField = new JTextField();
        JButton alterarButton = new JButton("Alterar");

        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = Integer.parseInt(indiceField.getText());
                if (indice >= 0 && indice < Main.fornecedores.size()) {
                    Fornecedor fornecedor = Main.fornecedores.get(indice);

                    JTextField nomeField = new JTextField(fornecedor.getNome());
                    JTextField marcaField = new JTextField(fornecedor.getMarca());
                    JTextField numeroField = new JTextField(fornecedor.getNumero());

                    JPanel panel = new JPanel(new GridLayout(7, 2));
                    panel.add(new JLabel("Nome:"));
                    panel.add(nomeField);
                    panel.add(new JLabel("Marca:"));
                    panel.add(marcaField);
                    panel.add(new JLabel("Número celular:"));
                    panel.add(numeroField);

                    int result = JOptionPane.showConfirmDialog(null, panel, "Alterar Produto", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        fornecedor.setNome(nomeField.getText());
                        fornecedor.setMarca(marcaField.getText());
                        fornecedor.setNumero(numeroField.getText());
                        JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso!");
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Índice inválido.");
                }
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(indiceField, BorderLayout.NORTH);
        add(alterarButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}