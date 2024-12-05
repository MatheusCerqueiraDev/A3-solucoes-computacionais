import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JFrame {

    private JPanel contentPanel;
    private CardLayout cardLayout;

    static ArrayList<Produto> estoque = new ArrayList<>();
    static ArrayList<Fabrica> fabricas = new ArrayList<>();
    static ArrayList<Fornecedor> fornecedores = new ArrayList<>();

    public Main() {
        // Inicializa os objetos
        Fabrica fabrica1 = new Fabrica("Fábrica São Bernardo do Campo", "Mercedes-Benz");
        Fabrica fabrica2 = new Fabrica("Fábrica Araguari", "BMW");
        Fabrica fabrica3 = new Fabrica("Fábrica São José dos Pinhais", "Audi");
        Fabrica fabrica4 = new Fabrica("Fábrica Camaçari", "Ford");

        fabricas.add(fabrica1);
        fabricas.add(fabrica2);
        fabricas.add(fabrica3);
        fabricas.add(fabrica4);

        Fornecedor fornecedor1 = new Fornecedor("Rodrigo Marinho", "71 99192-6666","Mercedes-Benz");
        Fornecedor fornecedor2 = new Fornecedor("Eduardo Ribeiro", "71 99192-6666", "Ford", fabrica4);
        Fornecedor fornecedor3 = new Fornecedor("Matheus Cerqueira", "71 99192-6666", "Audi", fabrica3);
        Fornecedor fornecedor4 = new Fornecedor("Carlos Helano", "71 99192-6666", "Ford", fabrica2);

        fornecedores.add(fornecedor1);
        fornecedores.add(fornecedor2);
        fornecedores.add(fornecedor3);
        fornecedores.add(fornecedor4);

        // Frame principal
        setTitle("Menu Principal");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Criação do sidebar
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(Color.WHITE);

        // Botões de navegação (sidebar)
        JButton btnProducts = new JButton("Produtos");
        JButton btnFactories = new JButton("Fabricas");
        JButton btnSuppliers = new JButton("Fornecedores");
        JButton shutdownBttn = new JButton("Sair do Sistema");

        // Botões de navegação (produto)
        JButton criarProdutoButton = new JButton("Criar Produto");
        JButton listarProdutoButton = new JButton("Listar Produto");
        JButton deletarProdutoButton = new JButton("Deletar Produto");
        JButton alterarProdutoButton = new JButton("Alterar Produto");
        JButton buscarProdutoButton = new JButton("Buscar Produto");

        // Botões de navegação (fabrica)
        JButton criarFabricaButton = new JButton("Criar Fabrica");
        JButton listarFabricasButton = new JButton("Listar Fabricas");
        JButton deletarFabricasButton = new JButton("Deletar Fabricas");
        JButton alterarFabricasButton = new JButton("Alterar Fabricas");
        JButton buscarFabricasButton = new JButton("Buscar Fabricas");

        // Botões de navegação (fornecedores)
        JButton criarFornecedoresButton = new JButton("Criar Fornecedores");
        JButton listarFornecedoresButton = new JButton("Listar Fornecedores");
        JButton deletarFornecedoresButton = new JButton("Deletar Fornecedores");
        JButton alterarFornecedoresButton = new JButton("Alterar Fornecedores");
        JButton buscarFornecedoresButton = new JButton("Buscar Fornecedores");

        // Adicionando botões ao sidebar
        sidebar.add(btnProducts);
        sidebar.add(btnFactories);
        sidebar.add(btnSuppliers);
        sidebar.add(shutdownBttn);

        // Criação do content layout
        contentPanel = new JPanel();
        cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);


        // Painel de produtos
        ActionListener criarEstoqueCheckListener = e -> {
            JButton sourceButton = (JButton) e.getSource();
            JFrame targetFrame = null;
            if (sourceButton == criarProdutoButton) {
                targetFrame = new CriarProdutoFrame();
            } else if (estoque.isEmpty()) {
                JOptionPane.showMessageDialog(Main.this, "Por favor crie ao menos um produto.");
            } else {
                if (sourceButton == listarProdutoButton) {
                    targetFrame = new ListarEstoqueFrame();
                } else if (sourceButton == deletarProdutoButton) {
                    targetFrame = new DeletarProdutoFrame();
                } else if (sourceButton == alterarProdutoButton) {
                    targetFrame = new AlterarProdutoFrame();
                } else if (sourceButton == buscarProdutoButton) {
                    targetFrame = new BuscarProdutoFrame();
                }

                if (targetFrame != null) {
                    targetFrame.setVisible(true);
                }
            }
        };

        criarProdutoButton.addActionListener(criarEstoqueCheckListener);
        listarProdutoButton.addActionListener(criarEstoqueCheckListener);
        deletarProdutoButton.addActionListener(criarEstoqueCheckListener);
        alterarProdutoButton.addActionListener(criarEstoqueCheckListener);
        buscarProdutoButton.addActionListener(criarEstoqueCheckListener);

        JPanel productsPanel = new JPanel();
        productsPanel.add(new JLabel("Produtos"));
        productsPanel.add(criarProdutoButton);
        productsPanel.add(listarProdutoButton);
        productsPanel.add(deletarProdutoButton);
        productsPanel.add(alterarProdutoButton);
        productsPanel.add(buscarProdutoButton);

        // Painel de fabricas
        ActionListener fabricaCheckListener = e -> {
            JButton sourceButton = (JButton) e.getSource();
            JFrame targetFrame = null;

            if (sourceButton == criarFabricaButton) {
                targetFrame = new CriarFabricaFrame();
            }

            if (fabricas.isEmpty()) {
                JOptionPane.showMessageDialog(Main.this, "Por favor crie ao menos uma fabrica.");
            } else {
                if (sourceButton == listarFabricasButton) {
                    targetFrame = new ListarFabricasFrame();
                } else if (sourceButton == deletarFabricasButton) {
                    targetFrame = new DeletarFabricaFrame();
                } else if (sourceButton == alterarFabricasButton) {
                    targetFrame = new AlterarFabricaFrame();
                } else if (sourceButton == buscarFabricasButton) {
                    targetFrame = new BuscarFabricaFrame();
                }
    
                if (targetFrame != null) {
                    targetFrame.setVisible(true);
                }
            }
        };

        criarFabricaButton.addActionListener(fabricaCheckListener);
        listarFabricasButton.addActionListener(fabricaCheckListener);
        deletarFabricasButton.addActionListener(fabricaCheckListener);
        alterarFabricasButton.addActionListener(fabricaCheckListener);
        buscarFabricasButton.addActionListener(fabricaCheckListener);

        JPanel factoriesPanel = new JPanel();
        factoriesPanel.add(new JLabel("Fabricas"));
        factoriesPanel.add(criarFabricaButton);
        factoriesPanel.add(listarFabricasButton);
        factoriesPanel.add(deletarFabricasButton);
        factoriesPanel.add(alterarFabricasButton);
        factoriesPanel.add(buscarFabricasButton);

        System.out.println("fornecedores: " + fornecedores);
        // Painel de fornecedores
        ActionListener fornecedorCheckListener = e -> {
            JButton sourceButton = (JButton) e.getSource();
            JFrame targetFrame = null;

            if (sourceButton == criarFornecedoresButton) {
                targetFrame = new CriarFornecedorFrame();
            }

            if (fornecedores.isEmpty()) {
                JOptionPane.showMessageDialog(Main.this, "Não existem fornecedores! Por favor crie um.");
            } else {
                if (sourceButton == listarFornecedoresButton) {
                    targetFrame = new ListarFornecedorFrame();
                } else if (sourceButton == deletarFornecedoresButton) {
                    targetFrame = new DeletarFornecedorFrame();
                } else if (sourceButton == alterarFornecedoresButton) {
                    targetFrame = new AlterarFornecedorFrame();
                } else if (sourceButton == buscarFornecedoresButton) {
                    targetFrame = new BuscarFornecedorFrame();
                }
                if (targetFrame != null) {
                    targetFrame.setVisible(true);
                }
            }
        };

        criarFornecedoresButton.addActionListener(fornecedorCheckListener);
        listarFornecedoresButton.addActionListener(fornecedorCheckListener);
        deletarFornecedoresButton.addActionListener(fornecedorCheckListener);
        alterarFornecedoresButton.addActionListener(fornecedorCheckListener);
        buscarFornecedoresButton.addActionListener(fornecedorCheckListener);

        JPanel suppliersPanel = new JPanel();
        suppliersPanel.add(new JLabel("Fornecedores"));
        suppliersPanel.add(criarFornecedoresButton);
        suppliersPanel.add(listarFornecedoresButton);
        suppliersPanel.add(deletarFornecedoresButton);
        suppliersPanel.add(alterarFornecedoresButton);
        suppliersPanel.add(buscarFornecedoresButton);

        // Add panels to the content panel
        contentPanel.add(productsPanel, "Produtos");
        contentPanel.add(factoriesPanel, "Fabricas");
        contentPanel.add(suppliersPanel, "Fornecedores");

        // Add action listeners to buttons
        btnProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Produtos");
            }
        });

        btnFactories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Fabricas");
            }
        });

        btnSuppliers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Fornecedores");
            }
        });

        shutdownBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        // Add sidebar and content panel to the frame
        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        // Show the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}