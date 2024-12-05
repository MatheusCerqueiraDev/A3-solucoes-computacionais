import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CriarFornecedorFrame extends JFrame {
    public CriarFornecedorFrame() {
        setTitle("Criar Fornecedor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel marcaLabel = new JLabel("Marca:");
        JTextField marcaField = new JTextField();
        JLabel numeroLabel = new JLabel("Número celular:");
        JTextField numeroField = new JTextField();
        JButton criarButton = new JButton("Criar");
        
        criarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String marca = marcaField.getText();
                String numero = numeroField.getText();
                
                // if (!nome.isBlank() || !descricao.isBlank() || !marca.isBlank() || !modelo.isBlank()) {
                //     JOptionPane.showMessageDialog(CriarProdutoFrame.this, "Todos os campos devem ser preenchidos.");
                // } else {
                // String precoText = precoField.getText();
                // if (!precoText.matches("\\d+(\\.\\d{1,2})?") && !precoText.matches("\\d+(,\\d{1,2})?")) {
                //     JOptionPane.showMessageDialog(null, "Preço deve ser um número válido.");
                // }

                // if (!numeroField.getText().matches("\\d+") || Integer.parseInt(numeroField.getText()) <= 0) {
                //     JOptionPane.showMessageDialog(null, "Ano deve ser um número inteiro positivo.");
                // }
                Fornecedor fornecedor = new Fornecedor(nome, numero, marca);
                Main.fornecedores.add(fornecedor);
                JOptionPane.showMessageDialog(null, "Fornecedor criado com sucesso!");
                dispose();
                // }
            }
        });

        add(nomeLabel);
        add(nomeField);
        add(marcaLabel);
        add(marcaField);
        add(numeroLabel);
        add(numeroField);
        add(new JLabel());
        add(criarButton);

        setVisible(true);
    }
}
