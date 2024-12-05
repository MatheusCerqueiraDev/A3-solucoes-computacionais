import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;

public class BuscarFabricaFrame extends JFrame {
    public BuscarFabricaFrame() {
        setTitle("Buscar Fabrica");
        setSize(600, 400); // Ajuste para melhor visualização
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
            textArea.setText(""); // Limpar o conteúdo anterior

            if (Main.fabricas.isEmpty()) {
                textArea.setText("Nenhuma fábrica cadastrada.");
                return;
            }

            // Cabeçalho
            textArea.append(String.format("%-30s %-30s\n", "Nome", "Marca"));
            textArea.append("=".repeat(60) + "\n");

            // Busca e formatação dos resultados
            for (Fabrica fabrica : Main.fabricas) {
                if (fabrica.getNome().toLowerCase().contains(nome)) {
                    textArea.append(String.format("%-30s %-30s\n",
                            fabrica.getNome(),
                            fabrica.getMarca()));
                    encontrado = true;
                }
            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Fábrica não encontrada.");
                textArea.setText(""); // Limpar o cabeçalho se nada for encontrado
            }
        });

        add(nomeField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buscarButton, BorderLayout.SOUTH);

        setVisible(true);
    }
}
