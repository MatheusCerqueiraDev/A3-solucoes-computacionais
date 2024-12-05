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

public class AlterarProdutoFrame extends JFrame {
    public AlterarProdutoFrame() {
        setTitle("Alterar Produto");
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
        JButton alterarButton = new JButton("Alterar");

        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = Integer.parseInt(indiceField.getText());
                if (indice >= 0 && indice < Main.estoque.size()) {
                    Produto produto = Main.estoque.get(indice);

                    JTextField nomeField = new JTextField(produto.getNome());
                    JTextField descricaoField = new JTextField(produto.getDescricao());
                    JTextField marcaField = new JTextField(produto.getMarca());
                    JTextField modeloField = new JTextField(produto.getModelo());
                    JTextField anoField = new JTextField(String.valueOf(produto.getAno()));
                    JTextField precoField = new JTextField(String.valueOf(produto.getPreco()));

                    JPanel panel = new JPanel(new GridLayout(7, 2));
                    panel.add(new JLabel("Nome:"));
                    panel.add(nomeField);
                    panel.add(new JLabel("Descrição:"));
                    panel.add(descricaoField);
                    panel.add(new JLabel("Marca:"));
                    panel.add(marcaField);
                    panel.add(new JLabel("Modelo:"));
                    panel.add(modeloField);
                    panel.add(new JLabel("Ano:"));
                    panel.add(anoField);
                    panel.add(new JLabel("Preço:"));
                    panel.add(precoField);

                    int result = JOptionPane.showConfirmDialog(null, panel, "Alterar Produto", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        produto.setNome(nomeField.getText());
                        produto.setDescricao(descricaoField.getText());
                        produto.setMarca(marcaField.getText());
                        produto.setModelo(modeloField.getText());
                        produto.setAno(Integer.parseInt(anoField.getText()));
                        produto.setPreco(Double.parseDouble(precoField.getText()));
                        JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
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