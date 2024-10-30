package GUI;

import Controle.ClienteControle;
import Controle.VendaControle;
import Classes.Cliente;
import Classes.Venda;
import Enums.TipoPagamento;
import Enums.Unidade;
import Enums.Parcelas;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import java.time.LocalDate;
import java.util.List;

public class VendaApp extends JFrame {
    private final VendaControle vendaControle;
    private final ClienteControle clienteControle;
    private JTextField txtIdCliente, txtNome, txtCpf, txtTelefone, txtEmail;
    private JTextField txtMaterial, txtQuantidade, txtPreco;
    private JFormattedTextField txtDataVenda;
    private JComboBox<TipoPagamento> cbPagamento;
    private JComboBox<Parcelas> cbParcelas;
    private JComboBox<Unidade> cbUnidade;
    private JTable tabelaVendas;

    public VendaApp(ClienteControle clienteControle) {
        this.clienteControle = clienteControle;
        this.vendaControle = new VendaControle(clienteControle);
        
        setTitle("Cadastro de Vendas");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel painelCliente = criarPainelCliente(gbc, painelFormulario);

        JButton btnBuscarCliente = new JButton("Buscar Cliente");
        btnBuscarCliente.addActionListener(e -> buscarCliente());
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelFormulario.add(btnBuscarCliente, gbc);

        JPanel painelVenda = criarPainelVenda(gbc, painelFormulario);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> cadastrarVenda());
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;
        painelFormulario.add(btnCadastrar, gbc);

        tabelaVendas = new JTable();
        atualizarTabela();
        add(new JScrollPane(tabelaVendas), BorderLayout.CENTER);

        JPanel painelAcoes = new JPanel();
        JButton btnFiltrar = new JButton("Filtrar por Data");
        btnFiltrar.addActionListener(e -> filtrarVendasPorData());
        painelAcoes.add(btnFiltrar);

        JButton btnRemover = new JButton("Remover");
        btnRemover.addActionListener(e -> removerVenda());
        painelAcoes.add(btnRemover);

        JButton btnHome = new JButton("Home");
        btnHome.addActionListener(e -> {
            dispose();
            new Home().setVisible(true);
        });
        painelAcoes.add(btnHome);

        add(painelFormulario, BorderLayout.NORTH);
        add(painelAcoes, BorderLayout.SOUTH);
    }

    private JPanel criarPainelCliente(GridBagConstraints gbc, JPanel painelFormulario) {
        JPanel painelCliente = new JPanel();
        painelCliente.setBorder(BorderFactory.createTitledBorder("Dados do Cliente"));
        painelCliente.setLayout(new GridLayout(5, 2, 5, 5));

        painelCliente.add(new JLabel("ID do Cliente:"));
        txtIdCliente = new JTextField();
        painelCliente.add(txtIdCliente);

        painelCliente.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        txtNome.setEditable(false);
        painelCliente.add(txtNome);

        painelCliente.add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        txtCpf.setEditable(false);
        painelCliente.add(txtCpf);

        painelCliente.add(new JLabel("Telefone:"));
        txtTelefone = new JTextField();
        txtTelefone.setEditable(false);
        painelCliente.add(txtTelefone);

        painelCliente.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        txtEmail.setEditable(false);
        painelCliente.add(txtEmail);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        painelFormulario.add(painelCliente, gbc);

        return painelCliente;
    }

    private JPanel criarPainelVenda(GridBagConstraints gbc, JPanel painelFormulario) {
        JPanel painelVenda = new JPanel();
        painelVenda.setBorder(BorderFactory.createTitledBorder("Dados da Venda"));
        painelVenda.setLayout(new GridLayout(7, 2, 5, 5));

        painelVenda.add(new JLabel("Data da Venda:"));
        txtDataVenda = criarCampoDataVenda();
        painelVenda.add(txtDataVenda);

        painelVenda.add(new JLabel("Material:"));
        txtMaterial = new JTextField();
        painelVenda.add(txtMaterial);

        painelVenda.add(new JLabel("Quantidade:"));
        txtQuantidade = new JTextField();
        painelVenda.add(txtQuantidade);

        painelVenda.add(new JLabel("Unidade:"));
        cbUnidade = new JComboBox<>(Unidade.values());
        painelVenda.add(cbUnidade);

        painelVenda.add(new JLabel("Preço:"));
        txtPreco = new JTextField();
        painelVenda.add(txtPreco);

        painelVenda.add(new JLabel("Pagamento:"));
        cbPagamento = new JComboBox<>(TipoPagamento.values());
        cbPagamento.addActionListener(e -> cbParcelas.setVisible(cbPagamento.getSelectedItem() == TipoPagamento.CARTAO));
        painelVenda.add(cbPagamento);

        painelVenda.add(new JLabel("Parcelas:"));
        cbParcelas = new JComboBox<>(Parcelas.values());
        cbParcelas.setVisible(false);
        painelVenda.add(cbParcelas);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        painelFormulario.add(painelVenda, gbc);

        return painelVenda;
    }

    private JFormattedTextField criarCampoDataVenda() {
        try {
            MaskFormatter formatoData = new MaskFormatter("##/##/####");
            formatoData.setPlaceholderCharacter('_');
            return new JFormattedTextField(formatoData);
        } catch (ParseException e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }

    private void buscarCliente() {
        try {
            int idCliente = Integer.parseInt(txtIdCliente.getText());
            Cliente cliente = clienteControle.buscarClientePorId(idCliente);
            if (cliente != null) {
                txtNome.setText(cliente.getNome());
                txtCpf.setText(cliente.getCpf());
                txtTelefone.setText(cliente.getTelefone());
                txtEmail.setText(cliente.getEmail());
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                limparCamposCliente();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID do Cliente inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            limparCamposCliente();
        }
    }

    private void limparCamposCliente() {
        txtNome.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
    }

    private void cadastrarVenda() {
        try {
            int idCliente = Integer.parseInt(txtIdCliente.getText());
            Cliente cliente = clienteControle.buscarClientePorId(idCliente);
            if (cliente != null) {
                String material = txtMaterial.getText();
                int quantidade = Integer.parseInt(txtQuantidade.getText());
                Unidade unidade = (Unidade) cbUnidade.getSelectedItem();
                double preco = Double.parseDouble(txtPreco.getText());
                TipoPagamento pagamento = (TipoPagamento) cbPagamento.getSelectedItem();
                Integer parcelas = null;

                if (pagamento == TipoPagamento.CARTAO) {
                    parcelas = ((Parcelas) cbParcelas.getSelectedItem()).getValor();
                }

                String dataStr = txtDataVenda.getText();
                LocalDate dataVenda = LocalDate.parse(dataStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                vendaControle.cadastrarVenda(idCliente, material, quantidade, unidade, preco, pagamento, parcelas, dataVenda);
                atualizarTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Erro: Unidade inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar a venda: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarTabela() {
        List<Venda> vendas = vendaControle.listarVendas();
        String[] colunas = {"ID", "ID Cliente", "Material", "Quantidade", "Unidade", "Preço", "Data", "Pagamento", "Parcelas"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (Venda venda : vendas) {
            Object[] linha = {
                venda.getId(),
                venda.getIdCliente(),
                venda.getMaterial(),
                venda.getQuantidade(),
                venda.getUnidade(),
                venda.getPreco(),
                venda.getDataVenda(),
                venda.getTipoPagamento(),
                venda.getParcelas()
            };
            modelo.addRow(linha);
        }

        tabelaVendas.setModel(modelo);
    }

    private void filtrarVendasPorData() {
        String dataStr = JOptionPane.showInputDialog(this, "Informe a data (dd/MM/yyyy) para filtrar:");
        if (dataStr != null) {
            try {
                LocalDate dataFiltro = LocalDate.parse(dataStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                List<Venda> vendasFiltradas = vendaControle.filtrarVendasPorData(dataFiltro);
                String[] colunas = {"ID", "ID Cliente", "Material", "Quantidade", "Unidade", "Preço", "Data", "Pagamento", "Parcelas"};
                DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

                for (Venda venda : vendasFiltradas) {
                    Object[] linha = {
                        venda.getId(),
                        venda.getIdCliente(),
                        venda.getMaterial(),
                        venda.getQuantidade(),
                        venda.getUnidade(),
                        venda.getPreco(),
                        venda.getDataVenda(),
                        venda.getTipoPagamento(),
                        venda.getParcelas()
                    };
                    modelo.addRow(linha);
                }

                tabelaVendas.setModel(modelo);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Data inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void removerVenda() {
        int linhaSelecionada = tabelaVendas.getSelectedRow();
        if (linhaSelecionada != -1) {
            int idVenda = (int) tabelaVendas.getValueAt(linhaSelecionada, 0);
            vendaControle.removerVenda(idVenda);
            atualizarTabela();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma venda para remover.", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClienteControle clienteControle = new ClienteControle();
            new VendaApp(clienteControle).setVisible(true);
        });
    }
}