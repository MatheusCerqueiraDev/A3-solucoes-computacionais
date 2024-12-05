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

public class AlterarFabricaFrame extends JFrame {
    public AlterarFabricaFrame() {
        setTitle("Alterar Fabrica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        if (Main.fabricas.isEmpty()) {
            textArea.setText("Não existem fabricas.");
        } else {
            textArea.setText("Escolha um item e delete escrevendo indice.\n");
            for (int i = 0; i < Main.fabricas.size(); i++) {
                textArea.append("Índice: " + i + " - " + Main.fabricas.get(i).toString() + "\n");
            }
        }

        JTextField indiceField = new JTextField();
        JButton alterarButton = new JButton("Alterar");

        alterarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = Integer.parseInt(indiceField.getText());
                if (indice >= 0 && indice < Main.fabricas.size()) {
                    Fabrica fabrica = Main.fabricas.get(indice);

                    JTextField nomeField = new JTextField(fabrica.getNome());
                    JTextField marcaField = new JTextField(fabrica.getMarca());

                    JPanel panel = new JPanel(new GridLayout(7, 2));
                    panel.add(new JLabel("Nome:"));
                    panel.add(nomeField);
                    panel.add(new JLabel("Marca:"));
                    panel.add(marcaField);

                    int result = JOptionPane.showConfirmDialog(null, panel, "Alterar Fabrica", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        fabrica.setNome(nomeField.getText());
                        fabrica.setMarca(marcaField.getText());
                        JOptionPane.showMessageDialog(null, "Fabrica alterada com sucesso!");
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