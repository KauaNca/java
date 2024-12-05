/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package conexaoBanco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaua33500476
 */
public class Venda extends javax.swing.JInternalFrame {

    DefaultTableModel tabela;
    DefaultTableModel tabela2;
    DefaultTableModel tabela3;
    String preco;
    float totalCompra;
    String situacao = null;
    String id_venda = null;
    String cliente = null;
    String atendente = null;
    Float valor = 0f;
    float descontoTotal;
    float acrescimoTotal;
    float acumuladorItem;
     String cancelado;
     String estoque;
    float acumulador;
    String produto;

    /**
     * Creates new form Venda
     */
    public Venda() {

        initComponents();
        try (Connection conexao = Conexao.conexaoBanco()) {
            //1º SABER SE A ÚLTIMA VENDA FICOU PENDENTE
            String SQL = "SELECT situacao FROM venda ORDER BY id_venda DESC LIMIT 1;";
            PreparedStatement stmt = conexao.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                situacao = rs.getString("situacao");
            }

            if (situacao.equals("S")) {//CASO NÃO ENCONTRE NADA, PASSA PARA PRÓXIMA VENDA
                //String comandoSQL = "INSERT INTO venda(situacao, id_cliente, id_atendente, numero_cupom) VALUES('P', 5, 4, 0)";
                String comandoSQL = "INSERT INTO venda(situacao, id_cliente, id_atendente, numero_cupom) VALUES('P', 8, 6, 0)";
                PreparedStatement ps = conexao.prepareStatement(comandoSQL);
                ps.execute();

                String getLastVendaIdSQL = "SELECT id_venda FROM venda ORDER BY id_venda DESC LIMIT 1";
                PreparedStatement getLastVendaIdStmt = conexao.prepareStatement(getLastVendaIdSQL);
                ResultSet rsVenda = getLastVendaIdStmt.executeQuery();
                int lastVendaId = 0;
                if (rsVenda.next()) {
                    lastVendaId = rsVenda.getInt("id_venda");
                }
                numeroIdVenda.setText(String.valueOf(lastVendaId));

            } else if (situacao.equals("P")) {//CASO ESTEJA PENDENTE
                int resposta = JOptionPane.showConfirmDialog(null, "A sua última venda não foi finalizada. Deseja continuar?", "Confirmação", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    String SQL2 = "SELECT id_venda FROM venda WHERE situacao = 'P' ORDER BY id_venda DESC LIMIT 1;";
                    PreparedStatement stmt2 = conexao.prepareStatement(SQL2);
                    ResultSet rs2 = stmt2.executeQuery();

                    if (rs2.next()) {
                        id_venda = rs2.getString("id_venda");
                        numeroIdVenda.setText(id_venda);
                    }

                    String SQL3 = "SELECT descricao, iv.preco, iv.cancelado, iv.quantidade, iv.valor_total FROM item_venda iv INNER JOIN produto pro ON iv.id_produto = pro.id_produto WHERE id_venda = ?";
                    PreparedStatement stmt3 = conexao.prepareStatement(SQL3);
                    stmt3.setString(1, id_venda);
                    ResultSet rs3 = stmt3.executeQuery();

                    DefaultTableModel tabela = (DefaultTableModel) tabelaVenda.getModel();
                    while (rs3.next()) {
                        Object[] dados = {
                            rs3.getString("descricao"),
                            rs3.getString("preco"),
                            rs3.getString("cancelado"),
                            rs3.getString("quantidade"),
                            rs3.getString("valor_total")
                        };
                        tabela.addRow(dados);

                        for (int x = 0; x < tabelaVenda.getRowCount(); x++) {
                            valor += Float.parseFloat(tabelaVenda.getValueAt(x, 4).toString());
                        }
                        totalBruto.setText(valor.toString());
                    }

                    String SQL4 = "SELECT pc.nome AS cliente_nome, pt.nome AS atendente_nome FROM venda v "
                            + "INNER JOIN cliente c ON c.id_cliente = v.id_cliente "
                            + "INNER JOIN pessoa pc ON pc.id_pessoa = c.id_pessoa "
                            + "INNER JOIN atendente ate ON ate.id_atendente = v.id_atendente "
                            + "INNER JOIN pessoa pt ON pt.id_pessoa = ate.id_pessoa "
                            + "WHERE id_venda = ?";
                    PreparedStatement stmt4 = conexao.prepareStatement(SQL4);
                    stmt4.setString(1, id_venda);
                    ResultSet rs4 = stmt4.executeQuery();

                    if (rs4.next()) {
                        cliente = rs4.getString("cliente_nome");
                        atendente = rs4.getString("atendente_nome");
                    }
                    nomeCliente.setText(cliente);
                    nomeAtendente.setText(atendente);

                } else if (resposta == JOptionPane.NO_OPTION) {
                    PreparedStatement stmt2 = null;
                    ResultSet rs2 = null;
                    PreparedStatement stmt3 = null;
                    PreparedStatement ps = null;

                    try {
                        String SQL2 = "SELECT id_venda FROM venda WHERE situacao = 'P' ORDER BY id_venda DESC LIMIT 1;";
                        stmt2 = conexao.prepareStatement(SQL2);
                        rs2 = stmt2.executeQuery();

                        if (rs2.next()) {
                            id_venda = rs2.getString("id_venda");
                            numeroIdVenda.setText(id_venda);
                        }

                        // Fechar recursos de stmt2 e rs2
                        if (rs2 != null) {
                            rs2.close();
                        }
                        if (stmt2 != null) {
                            stmt2.close();
                        }

                        // Atualizar situação da venda anterior
                        String atualizarVenda = "UPDATE venda SET situacao = 'C' WHERE id_venda = ?;";
                        stmt3 = conexao.prepareStatement(atualizarVenda);
                        stmt3.setString(1, id_venda);
                        stmt3.execute();

                        // Fechar recurso de stmt3
                        if (stmt3 != null) {
                            stmt3.close();
                        }

                        // Inserir nova venda
                        //String comandoSQL = "INSERT INTO venda(situacao, id_cliente, id_atendente, numero_cupom) VALUES('P', 5, 4, 0)";
                        String comandoSQL = "INSERT INTO venda(situacao, id_cliente, id_atendente, numero_cupom) VALUES('P', 8, 6, 0)";
                        ps = conexao.prepareStatement(comandoSQL);
                        ps.execute();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (rs2 != null) {
                                rs2.close();
                            }
                            if (stmt2 != null) {
                                stmt2.close();
                            }
                            if (stmt3 != null) {
                                stmt3.close();
                            }
                            if (ps != null) {
                                ps.close();
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                } else {
                    String SQL2 = "SELECT id_venda FROM venda ORDER BY id_venda DESC LIMIT 1;";
                    PreparedStatement stmt2 = conexao.prepareStatement(SQL2);
                    ResultSet rs2 = stmt2.executeQuery();

                    if (rs2.next()) {
                        id_venda = rs2.getString("id_venda");
                        numeroIdVenda.setText(id_venda);
                    }

                    String atualizarVenda = "UPDATE venda SET situacao = 'C' WHERE id_venda = ?;";
                    PreparedStatement stmt3 = conexao.prepareStatement(atualizarVenda);
                    stmt3.setString(1, id_venda);
                    stmt3.execute();

                    JOptionPane.showMessageDialog(null, "NOVA VENDA");
                    //String comandoSQL = "INSERT INTO venda(situacao, id_cliente, id_atendente, numero_cupom) VALUES('P', 5, 4, 0)";
                    String comandoSQL = "INSERT INTO venda(situacao, id_cliente, id_atendente, numero_cupom) VALUES('P', 8, 6, 0)";
                    PreparedStatement ps = conexao.prepareStatement(comandoSQL);
                    ps.execute();

                    String getLastVendaIdSQL = "SELECT id_venda FROM venda ORDER BY id_venda DESC LIMIT 1";
                    PreparedStatement getLastVendaIdStmt = conexao.prepareStatement(getLastVendaIdSQL);
                    ResultSet rsVenda = getLastVendaIdStmt.executeQuery();
                    int lastVendaId = 0;
                    if (rsVenda.next()) {
                        lastVendaId = rsVenda.getInt("id_venda");
                    }
                    numeroIdVenda.setText(String.valueOf(lastVendaId));

                }
            } else {
                //String comandoSQL = "INSERT INTO venda(situacao, id_cliente, id_atendente, numero_cupom) VALUES('P', 5, 4, 0)";
                String comandoSQL = "INSERT INTO venda(situacao, id_cliente, id_atendente, numero_cupom) VALUES('P', 8, 6, 0)";
                PreparedStatement ps = conexao.prepareStatement(comandoSQL);
                ps.execute();

                String getLastVendaIdSQL = "SELECT id_venda FROM venda ORDER BY id_venda DESC LIMIT 1";
                PreparedStatement getLastVendaIdStmt = conexao.prepareStatement(getLastVendaIdSQL);
                ResultSet rsVenda = getLastVendaIdStmt.executeQuery();
                int lastVendaId = 0;
                if (rsVenda.next()) {
                    lastVendaId = rsVenda.getInt("id_venda");
                }
                numeroIdVenda.setText(String.valueOf(lastVendaId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }

        try (Connection conexaoAtiva = Conexao.conexaoBanco()) {
            String comandoSQL = "SELECT * FROM produto";
            PreparedStatement ps = conexaoAtiva.prepareStatement(comandoSQL);
            tabela = (DefaultTableModel) tabelaProduto.getModel();
            tabela.setNumRows(0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object dados[] = {
                    rs.getString("codigo"),
                    rs.getString("descricao"),
                    rs.getString("preco"),
                    rs.getString("quantidade_estoque")

                };
                tabela.addRow(dados);
            }

        } catch (SQLException e) {
            System.out.println("ERRO BANCO DE DADOS - FRAME VENDA" + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO BANCO DE DADOS - FRAME VENDA" + e.getMessage());
        }

        try (Connection conexaoAtiva = Conexao.conexaoBanco()) {
            String comandoSQL = "SELECT nome,cpf_cnpj FROM pessoa WHERE tipo LIKE 'Cliente';";
            PreparedStatement ps = conexaoAtiva.prepareStatement(comandoSQL);
            tabela = (DefaultTableModel) tabelaCliente.getModel();
            tabela.setNumRows(0);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object dados[] = {
                    rs.getString("nome"),
                    rs.getString("cpf_cnpj"),};
                tabela.addRow(dados);
            }

        } catch (SQLException e) {
            System.out.println("ERRO BANCO DE DADOS - FRAME VENDA" + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO BANCO DE DADOS - FRAME VENDA" + e.getMessage());
        }
        acrescimoTotal = 0;
        descontoTotal = 0;
        acumuladorItem = 0f;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        campoPesquisar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVenda = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clientePesquisar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        desconto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totalBruto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        confirmarVenda = new javax.swing.JButton();
        cancelarVenda = new javax.swing.JButton();
        nomeVendedor = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        nomeCliente = new javax.swing.JTextField();
        nomeAtendente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        numeroIdVenda = new javax.swing.JTextField();
        cancelarItem = new javax.swing.JButton();
        acrescimo = new javax.swing.JTextField();
        btAtualizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Venda");

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Produto", "Preço", "Estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProduto);

        jLabel1.setText("Pesquisar");

        campoPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoPesquisarKeyPressed(evt);
            }
        });

        tabelaVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Preço", "Cancelado", "Quantidade", "Acréscimo", "Desconto", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVendaMouseClicked(evt);
            }
        });
        tabelaVenda.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabelaVendaPropertyChange(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaVenda);

        jLabel2.setText("Atendente");

        jLabel3.setText("Cliente");

        clientePesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clientePesquisarKeyPressed(evt);
            }
        });

        jLabel4.setText("Desconto");

        jLabel5.setText("Acréscimo");

        jLabel6.setText("Total bruto");

        jLabel7.setText("Total");

        confirmarVenda.setText("Confirmar venda");
        confirmarVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmarVendaMouseClicked(evt);
            }
        });

        cancelarVenda.setText("Cancelar");
        cancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarVendaActionPerformed(evt);
            }
        });

        nomeVendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "João Silva", "Ana Souza", "Laura Costa", "João", "Carlos" }));
        nomeVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeVendedorActionPerformed(evt);
            }
        });

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF/CNPJ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaCliente);

        nomeCliente.setEnabled(false);

        nomeAtendente.setEnabled(false);

        jLabel8.setText("Venda:");

        numeroIdVenda.setEnabled(false);
        numeroIdVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                numeroIdVendaKeyPressed(evt);
            }
        });

        cancelarItem.setText("Cancelar Item");
        cancelarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarItemMouseClicked(evt);
            }
        });

        btAtualizar.setText("Atualizar");
        btAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAtualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoPesquisar)
                            .addComponent(nomeVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numeroIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clientePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)))
                        .addGap(203, 203, 203)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(26, 26, 26)
                                    .addComponent(desconto, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(acrescimo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(totalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(confirmarVenda))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(numeroIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nomeVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(clientePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btAtualizar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cancelarItem))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(acrescimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(desconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(totalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(confirmarVenda))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cancelarVenda)))))
                        .addContainerGap(857, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisarKeyPressed
        try (Connection conexaoAtiva = Conexao.conexaoBanco()) {
            String comandoSQL = "SELECT codigo,descricao,preco,quantidade_estoque FROM produto WHERE descricao LIKE ? ORDER BY codigo DESC;";
            PreparedStatement stmt = conexaoAtiva.prepareStatement(comandoSQL);
            stmt.setString(1, "%" + campoPesquisar.getText() + "%");
            ResultSet rs = stmt.executeQuery();
            tabela = (DefaultTableModel) tabelaProduto.getModel();
            tabela.setNumRows(0);
            while (rs.next()) {
                Object dados[] = {
                    rs.getString("codigo"),
                    rs.getString("descricao"),
                    rs.getString("preco"),
                    rs.getString("quantidade_estoque")

                };
                tabela.addRow(dados);
            }
            recalcularTotalBruto();

        } catch (SQLException e) {
            System.out.println("Campo de pesquisa - erro");
        } catch (Exception e) {
            System.out.println("Campo de pesquisa - erro");
        }
    }//GEN-LAST:event_campoPesquisarKeyPressed

    private void tabelaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutoMouseClicked
        if (evt.getClickCount() >= 2) {
            tabela2 = (DefaultTableModel) tabelaVenda.getModel();
            String quantidade = JOptionPane.showInputDialog("Quantidade");
            preco = tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 2).toString();
            Float total = Float.parseFloat(preco) * Integer.parseInt(quantidade);
            Object[] dados = {
                produto = tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 1).toString(),
                preco,
                cancelado = "N",
                quantidade,
                acrescimoTotal,
                descontoTotal,
                String.valueOf(total)
            };
            tabela2.addRow(dados);
            recalcularTotalItem();
            recalcularTotalBruto();

        }


    }//GEN-LAST:event_tabelaProdutoMouseClicked

    private void cancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarVendaActionPerformed
        tabela2.setNumRows(0);
        totalBruto.setText(null);
    }//GEN-LAST:event_cancelarVendaActionPerformed

    private void confirmarVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarVendaMouseClicked
        try (Connection conexaoAtiva = Conexao.conexaoBanco()) {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja finalizar a venda?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                // Primeiro, obtenha o último id_venda
                String getLastVendaIdSQL = "SELECT id_venda FROM venda ORDER BY id_venda DESC LIMIT 1";
                try (PreparedStatement getLastVendaIdStmt = conexaoAtiva.prepareStatement(getLastVendaIdSQL); ResultSet rsVenda = getLastVendaIdStmt.executeQuery()) {
                    int lastVendaId = 0;
                    if (rsVenda.next()) {
                        lastVendaId = rsVenda.getInt("id_venda");
                    }

                    // Variáveis para acumular desconto e acréscimo da venda inteira
                    float descontoTotalVenda = 0;
                    float acrescimoTotalVenda = 0;

                    // Verifique se há desconto ou acréscimo na venda inteira
                    if (!desconto.getText().isEmpty()) {
                        descontoTotalVenda = Float.parseFloat(desconto.getText());
                    }
                    if (!acrescimo.getText().isEmpty()) {
                        acrescimoTotalVenda = Float.parseFloat(acrescimo.getText());
                    }

                    // Agora, para cada item na tabelaVenda, obtenha o id_produto e insira o item de venda
                    for (int x = 0; x < tabelaVenda.getRowCount(); x++) {
                        String descricaoProduto = tabelaVenda.getValueAt(x, 0).toString();
                        String getProdutoIdSQL = "SELECT id_produto FROM produto WHERE descricao = ?";
                        try (PreparedStatement getProdutoIdStmt = conexaoAtiva.prepareStatement(getProdutoIdSQL)) {
                            getProdutoIdStmt.setString(1, descricaoProduto);
                            try (ResultSet rsProduto = getProdutoIdStmt.executeQuery()) {
                                int produtoId = 0;
                                if (rsProduto.next()) {
                                    produtoId = rsProduto.getInt("id_produto");
                                }

                                float descontoItem = Float.parseFloat(tabelaVenda.getValueAt(x, 4).toString());
                                float acrescimoItem = Float.parseFloat(tabelaVenda.getValueAt(x, 5).toString());
                                float quantidade = Float.parseFloat(tabelaVenda.getValueAt(x, 3).toString());
                                float preco = Float.parseFloat(tabelaVenda.getValueAt(x, 1).toString());
                                float totalItem = (quantidade * preco) - descontoItem + acrescimoItem;

                                String comandoSQL = "INSERT INTO item_venda(quantidade, desconto, acrescimo, id_produto, id_venda) "
                                        + "VALUES (?, ?, ?, ?, ?)";
                                try (PreparedStatement stmt = conexaoAtiva.prepareStatement(comandoSQL)) {
                                    stmt.setFloat(1, quantidade);
                                    stmt.setFloat(2, descontoItem);
                                    stmt.setFloat(3, acrescimoItem);
                                    stmt.setInt(4, produtoId);
                                    stmt.setInt(5, lastVendaId);
                                    stmt.execute();
                                }
                            }
                        }
                    }

                    // Calcule o total da compra considerando desconto e acréscimo da venda inteira
                    float totalB = Float.parseFloat(totalBruto.getText());
                    totalCompra = totalB - descontoTotalVenda + acrescimoTotalVenda;

                    // Atualize a venda
                    String SQL = "UPDATE venda SET "
                            + "id_cliente = (SELECT id_cliente FROM cliente INNER JOIN pessoa ON pessoa.id_pessoa = cliente.id_pessoa WHERE nome = ?), "
                            + "id_atendente = (SELECT id_atendente FROM atendente INNER JOIN pessoa ON pessoa.id_pessoa = atendente.id_pessoa WHERE nome = ?), "
                            + "valor_total = ?, "
                            + "desconto = ?, "
                            + "acrescimo = ? "
                            + "WHERE id_venda = ?";
                    try (PreparedStatement ps = conexaoAtiva.prepareStatement(SQL)) {
                        ps.setString(1, nomeCliente.getText());
                        ps.setString(2, nomeAtendente.getText());
                        ps.setFloat(3, totalCompra);
                        ps.setFloat(4, descontoTotalVenda);
                        ps.setFloat(5, acrescimoTotalVenda);
                        ps.setInt(6, lastVendaId);
                        ps.execute();
                        System.out.println("FIM DA VENDA");
                        dispose();
                    }
                }
            } else if (resposta == JOptionPane.NO_OPTION) {
                int salvar = JOptionPane.showConfirmDialog(null, "Deseja salvar?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (salvar == JOptionPane.YES_OPTION) {
                    // Primeiro, obtenha o último id_venda
                    String getLastVendaIdSQL = "SELECT id_venda FROM venda ORDER BY id_venda DESC LIMIT 1";
                    try (PreparedStatement getLastVendaIdStmt = conexaoAtiva.prepareStatement(getLastVendaIdSQL); ResultSet rsVenda = getLastVendaIdStmt.executeQuery()) {
                        int lastVendaId = 0;
                        if (rsVenda.next()) {
                            lastVendaId = rsVenda.getInt("id_venda");
                        }

                        // Variáveis para acumular desconto e acréscimo da venda inteira
                        float descontoTotalVenda = 0;
                        float acrescimoTotalVenda = 0;

                        // Verifique se há desconto ou acréscimo na venda inteira
                        if (!desconto.getText().isEmpty()) {
                            descontoTotalVenda = Float.parseFloat(desconto.getText());
                        }
                        if (!acrescimo.getText().isEmpty()) {
                            acrescimoTotalVenda = Float.parseFloat(acrescimo.getText());
                        }

                        // Agora, para cada item na tabelaVenda, obtenha o id_produto e insira o item de venda
                        for (int x = 0; x < tabelaVenda.getRowCount(); x++) {
                            String descricaoProduto = tabelaVenda.getValueAt(x, 0).toString();
                            String getProdutoIdSQL = "SELECT id_produto FROM produto WHERE descricao = ?";
                            try (PreparedStatement getProdutoIdStmt = conexaoAtiva.prepareStatement(getProdutoIdSQL)) {
                                getProdutoIdStmt.setString(1, descricaoProduto);
                                try (ResultSet rsProduto = getProdutoIdStmt.executeQuery()) {
                                    int produtoId = 0;
                                    if (rsProduto.next()) {
                                        produtoId = rsProduto.getInt("id_produto");
                                    }

                                    float descontoItem = Float.parseFloat(tabelaVenda.getValueAt(x, 4).toString());
                                    float acrescimoItem = Float.parseFloat(tabelaVenda.getValueAt(x, 5).toString());
                                    float quantidade = Float.parseFloat(tabelaVenda.getValueAt(x, 3).toString());
                                    float preco = Float.parseFloat(tabelaVenda.getValueAt(x, 1).toString());
                                    float totalItem = (quantidade * preco) - descontoItem + acrescimoItem;

                                    String comandoSQL = "INSERT INTO item_venda(quantidade, desconto, acrescimo, cancelado, id_produto, id_venda) "
                                            + "VALUES (?, ?, ?,'N',?, ?)";
                                    try (PreparedStatement stmt = conexaoAtiva.prepareStatement(comandoSQL)) {
                                        stmt.setFloat(1, quantidade);
                                        stmt.setFloat(2, descontoItem);
                                        stmt.setFloat(3, acrescimoItem);
                                        stmt.setInt(4, produtoId);
                                        stmt.setInt(5, lastVendaId);
                                        stmt.execute();
                                    }
                                }
                            }
                        }

                        // Calcule o total da compra considerando desconto e acréscimo da venda inteira
                        float totalB = Float.parseFloat(totalBruto.getText());
                        totalCompra = totalB - descontoTotalVenda + acrescimoTotalVenda;

                        // Atualize a venda
                        String SQL = "UPDATE venda SET "
                                + "id_cliente = (SELECT id_cliente FROM cliente INNER JOIN pessoa ON pessoa.id_pessoa = cliente.id_pessoa WHERE nome = ?), "
                                + "id_atendente = (SELECT id_atendente FROM atendente INNER JOIN pessoa ON pessoa.id_pessoa = atendente.id_pessoa WHERE nome = ?), "
                                + "valor_total = ?, "
                                + "desconto = ?, "
                                + "acrescimo = ?, "
                                + "situacao = 'P' "
                                + "WHERE id_venda = ?";
                        try (PreparedStatement ps = conexaoAtiva.prepareStatement(SQL)) {
                            ps.setString(1, nomeCliente.getText());
                            ps.setString(2, nomeAtendente.getText());
                            ps.setFloat(3, totalCompra);
                            ps.setFloat(4, descontoTotalVenda);
                            ps.setFloat(5, acrescimoTotalVenda);
                            ps.setInt(6, lastVendaId);
                            ps.execute();
                            System.out.println("VENDA SALVA");
                            dispose();
                        }
                    }
                } else {
                    try (Connection conexao = Conexao.conexaoBanco()) {
                        String getLastVendaIdSQL = "SELECT id_venda FROM venda ORDER BY id_venda DESC LIMIT 1";
                        PreparedStatement getLastVendaIdStmt = conexao.prepareStatement(getLastVendaIdSQL);
                        ResultSet rsVenda = getLastVendaIdStmt.executeQuery();
                        int lastVendaId = 0;
                        if (rsVenda.next()) {
                            lastVendaId = rsVenda.getInt("id_venda");
                        }
                        // Atualize a venda
                        String SQL = "UPDATE venda SET "
                                + "id_cliente = 8, "
                                + "id_atendente = 6, "
                                + "valor_total = null, "
                                + "desconto = null, "
                                + "acrescimo = null, "
                                + "situacao = 'C' "
                                + "WHERE id_venda = ?";
                        try (PreparedStatement ps = conexaoAtiva.prepareStatement(SQL)) {
                            ps.setInt(1, lastVendaId);
                            ps.execute();
                            System.out.println("VENDA CANCELADA");
                            dispose();
                        }
                    }
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_confirmarVendaMouseClicked

    private void clientePesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clientePesquisarKeyPressed
        try (Connection conexaoAtiva = Conexao.conexaoBanco()) {
            String comandoSQL = "SELECT nome,cpf_cnpj FROM pessoa WHERE nome LIKE ? AND tipo = 'Cliente';";
            PreparedStatement stmt = conexaoAtiva.prepareStatement(comandoSQL);
            stmt.setString(1, "%" + clientePesquisar.getText() + "%");
            ResultSet rs = stmt.executeQuery();
            tabela3 = (DefaultTableModel) tabelaCliente.getModel();
            tabela3.setNumRows(0);
            while (rs.next()) {
                Object dados[] = {
                    rs.getString("nome"),
                    rs.getString("cpf_cnpj"),};
                tabela3.addRow(dados);
            }

        } catch (SQLException e) {
            System.out.println("Campo cliente - erro");
        } catch (Exception e) {
            System.out.println("Campo cliente - erro");
        }
    }//GEN-LAST:event_clientePesquisarKeyPressed

    private void tabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClienteMouseClicked
        String cliente = tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 0).toString();
        nomeCliente.setText(cliente);
    }//GEN-LAST:event_tabelaClienteMouseClicked

    private void nomeVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeVendedorActionPerformed
        String nome = nomeVendedor.getSelectedItem().toString();
        nomeAtendente.setText(nome);
    }//GEN-LAST:event_nomeVendedorActionPerformed
    private void recalcularTotalBruto() {
        float acumulador = 0f; // Inicializa o acumulador com 0
        for (int x = 0; x < tabelaVenda.getRowCount(); x++) { // Percorre as linhas da tabela
            Float precoLoop = 0f;
            Float quantidadeLoop = 0f;
            Float acrescimoLoop = 0f;
            Float descontoLoop = 0f;

            // Verifica se o valor é null antes de converter para Float
            if (tabelaVenda.getValueAt(x, 1) != null) {
                precoLoop = Float.parseFloat(tabelaVenda.getValueAt(x, 1).toString());
            }
            if (tabelaVenda.getValueAt(x, 3) != null) {
                quantidadeLoop = Float.parseFloat(tabelaVenda.getValueAt(x, 3).toString());
            }
            if (tabelaVenda.getValueAt(x, 4) != null) {
                acrescimoLoop = Float.parseFloat(tabelaVenda.getValueAt(x, 4).toString());
            }
            if (tabelaVenda.getValueAt(x, 5) != null) {
                descontoLoop = Float.parseFloat(tabelaVenda.getValueAt(x, 5).toString());
            }

            // Calcula o total para a linha atual
            Float total = (quantidadeLoop * precoLoop) - descontoLoop + acrescimoLoop;
            acumulador += total; // Adiciona ao acumulador
        }

        totalBruto.setText(String.valueOf(acumulador)); // Define o texto de totalBruto com o valor acumulado
    }

    private void tabelaVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendaMouseClicked

    }//GEN-LAST:event_tabelaVendaMouseClicked

    private void numeroIdVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numeroIdVendaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroIdVendaKeyPressed

    private void cancelarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarItemMouseClicked
        tabela = (DefaultTableModel) tabelaVenda.getModel();
        tabela.removeRow(tabelaVenda.getSelectedRow());
        recalcularTotalBruto();

    }//GEN-LAST:event_cancelarItemMouseClicked

    private void btAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAtualizarMouseClicked
        recalcularTotalItem();
        recalcularTotalBruto();
    }//GEN-LAST:event_btAtualizarMouseClicked

    private void tabelaVendaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabelaVendaPropertyChange
        recalcularTotalItem();
        recalcularTotalBruto();
    }//GEN-LAST:event_tabelaVendaPropertyChange
    private void recalcularTotalItem() {
        tabela2 = (DefaultTableModel) tabelaVenda.getModel();
        acumulador = 0f; // Inicializar acumulador

        for (int x = 0; x < tabelaVenda.getRowCount(); x++) {
            // Inicialização das variáveis
            Float precoLoop = 0f;
            Float quantidadeLoop = 0f;
            Float acrescimoLoop = 0f;
            Float descontoLoop = 0f;

            // Verifica se o valor da coluna 1 é null
            if (tabelaVenda.getValueAt(x, 1) == null) {
                tabelaVenda.setValueAt("0", x, 1);
            } else {
                precoLoop = Float.parseFloat(tabelaVenda.getValueAt(x, 1).toString());
            }

            // Verifica se o valor da coluna 3 é null
            if (tabelaVenda.getValueAt(x, 3) == null) {
                tabelaVenda.setValueAt("0", x, 3);
            } else {
                quantidadeLoop = Float.parseFloat(tabelaVenda.getValueAt(x, 3).toString());
            }

            // Verifica se o valor da coluna 4 é null
            if (tabelaVenda.getValueAt(x, 4) == null) {
                tabelaVenda.setValueAt("0", x, 4);
            } else {
                acrescimoLoop = Float.parseFloat(tabelaVenda.getValueAt(x, 4).toString());
            }

            // Verifica se o valor da coluna 5 é null
            if (tabelaVenda.getValueAt(x, 5) == null) {
                tabelaVenda.setValueAt("0", x, 5);
            } else {
                descontoLoop = Float.parseFloat(tabelaVenda.getValueAt(x, 5).toString());
            }

            // Calcula o total para a linha atual
            Float total = (quantidadeLoop * precoLoop) - descontoLoop + acrescimoLoop;
            acumulador += total; // Adiciona ao acumulador
            tabelaVenda.setValueAt(total, x, 6);
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acrescimo;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JButton cancelarItem;
    private javax.swing.JButton cancelarVenda;
    private javax.swing.JTextField clientePesquisar;
    private javax.swing.JButton confirmarVenda;
    private javax.swing.JTextField desconto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nomeAtendente;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JComboBox<String> nomeVendedor;
    private javax.swing.JTextField numeroIdVenda;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTable tabelaVenda;
    private javax.swing.JTextField total;
    private javax.swing.JTextField totalBruto;
    // End of variables declaration//GEN-END:variables
}
