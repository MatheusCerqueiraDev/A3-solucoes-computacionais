import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CriarFabricaFrame extends JFrame {
    public CriarFabricaFrame() {
        setTitle("Criar Fabrica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel marcaLabel = new JLabel("Marca:");
        JTextField marcaField = new JTextField();
        JButton criarButton = new JButton("Criar");

        criarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText().trim();
                String marca = marcaField.getText().trim();

                if (nome.isEmpty() || marca.isEmpty()) {
                    JOptionPane.showMessageDialog(CriarFabricaFrame.this, "Todos os campos devem ser preenchidos.");
                    return;
                }

                Fabrica novaFabrica = new Fabrica(nome, marca);
                Main.fabricas.add(novaFabrica);
                JOptionPane.showMessageDialog(CriarFabricaFrame.this, "Fabrica criada com sucesso!");
                dispose();
            }
        });

        add(nomeLabel);
        add(nomeField);
        add(marcaLabel);
        add(marcaField);
        add(new JLabel());
        add(criarButton);

        setVisible(true);
    }
}
