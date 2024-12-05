import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CriarProdutoFrame extends JFrame {
    public CriarProdutoFrame() {
        setTitle("Criar Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(9, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel descricaoLabel = new JLabel("Descrição:");
        JTextField descricaoField = new JTextField();
        JLabel marcaLabel = new JLabel("Marca:");
        JTextField marcaField = new JTextField();
        JLabel modeloLabel = new JLabel("Modelo:");
        JLabel fabricaLabel = new JLabel("Fabrica:");
        JComboBox<Fabrica> fabricaComboBox = new JComboBox<>(Main.fabricas.toArray(new Fabrica[0]));
        JLabel fornecedorLabel = new JLabel("Fornecedor:");
        JComboBox<Fornecedor> fornecedorComboBox = new JComboBox<>(Main.fornecedores.toArray(new Fornecedor[0]));
        JTextField modeloField = new JTextField();
        JLabel anoLabel = new JLabel("Ano:");
        JTextField anoField = new JTextField();
        JLabel precoLabel = new JLabel("Preço:");
        JTextField precoField = new JTextField();
        JButton criarButton = new JButton("Criar");

        fornecedorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fornecedor fornecedor = (Fornecedor) fornecedorComboBox.getSelectedItem();
                if(fornecedor!=null && fornecedor.getFabrica()!=null){
                      fabricaComboBox.setSelectedItem(fornecedor.getFabrica());
                      fabricaComboBox.setEnabled(false);
                    }else{
                        fabricaComboBox.setEnabled(true);
                    }
                }
            }
        );
        
        criarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String descricao = descricaoField.getText();
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                Fornecedor fornecedor = (Fornecedor) fornecedorComboBox.getSelectedItem();
                Fabrica fabrica = (Fabrica) fabricaComboBox.getSelectedItem();
                int ano = Integer.parseInt(anoField.getText());
                double preco = Double.parseDouble(precoField.getText());
                
                // if (!nome.isBlank() || !descricao.isBlank() || !marca.isBlank() || !modelo.isBlank()) {
                //     JOptionPane.showMessageDialog(CriarProdutoFrame.this, "Todos os campos devem ser preenchidos.");
                // } else {
                // String precoText = precoField.getText();
                // if (!precoText.matches("\\d+(\\.\\d{1,2})?") && !precoText.matches("\\d+(,\\d{1,2})?")) {
                //     JOptionPane.showMessageDialog(null, "Preço deve ser um número válido.");
                // }

                // if (!anoField.getText().matches("\\d+") || Integer.parseInt(anoField.getText()) <= 0) {
                //     JOptionPane.showMessageDialog(null, "Ano deve ser um número inteiro positivo.");
                // }
                    Produto novoProduto = new Peca(nome, descricao, marca, modelo, fabrica, fornecedor, ano, preco);
                    Main.estoque.add(novoProduto);
                    JOptionPane.showMessageDialog(null, "Produto criado com sucesso!");
                    dispose();
                // }
            }
        });

        add(nomeLabel);
        add(nomeField);
        add(descricaoLabel);
        add(descricaoField);
        add(marcaLabel);
        add(marcaField);
        add(modeloLabel);
        add(modeloField);
        add(fabricaLabel);
        add(fabricaComboBox);
        add(fornecedorLabel);
        add(fornecedorComboBox);
        add(anoLabel);
        add(anoField);
        add(precoLabel);
        add(precoField);
        add(new JLabel());
        add(criarButton);

        setVisible(true);
    }
}
