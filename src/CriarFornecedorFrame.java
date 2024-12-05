import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
        JLabel fabricaLabel = new JLabel("Fabrica:");
        JComboBox<Fabrica> fabricaComboBox = new JComboBox<>(Main.fabricas.toArray(new Fabrica[0]));
        
        JTextField numeroField = new JTextField();
        JButton criarButton = new JButton("Criar");
        
        criarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String marca = marcaField.getText();
                String numero = numeroField.getText();
                Fabrica fabrica = (Fabrica) fabricaComboBox.getSelectedItem();
               
                Fornecedor fornecedor = new Fornecedor(nome, numero, marca, fabrica);
                Main.fornecedores.add(fornecedor);
                JOptionPane.showMessageDialog(null, "Fornecedor criado com sucesso!");
                dispose();
            }
        });

        add(fabricaLabel);
        add(numeroField);
        add(nomeLabel);
        add(nomeField);
        add(marcaLabel);
        add(marcaField);
        add(numeroLabel);
        add(numeroField);
        add(fabricaLabel);
        add(fabricaComboBox);
        add(new JLabel());
        add(criarButton);

        setVisible(true);
    }
}