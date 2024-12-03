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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaua33500476
 */
public class Venda extends javax.swing.JInternalFrame {

    DefaultTableModel tabela;
    DefaultTableModel tabela2;
    DefaultTableModel tabela3;
    String produto;
    String preco;
    String estoque;
    float acumulador;
    float totalCompra;
    String cancelado;
    int x;

    /**
     * Creates new form Venda
     */
    public Venda() {

        initComponents();
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
            String comandoSQL = "INSERT INTO venda(situacao,id_cliente,id_atendente,numero_cupom) VALUES('P',5,4,7)";
            PreparedStatement ps = conexaoAtiva.prepareStatement(comandoSQL);
            ps.execute();

        } catch (SQLException e) {
            System.out.println("ERRO BANCO DE DADOS - FRAME VENDA" + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO BANCO DE DADOS - FRAME VENDA" + e.getMessage());
        }

        // Adicionar TableModelListener para detectar alterações na tabela de vendas
        /*tabela2.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getColumn() == 3 && e.getType() == TableModelEvent.UPDATE) {
                    recalcularTotalBruto();
                }
            }
        });*/
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
        acrescimo = new javax.swing.JTextField();
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
                "Produto", "Preço", "Cancelado", "Quantidade", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                            .addComponent(nomeVendedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clientePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(desconto, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(acrescimo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addContainerGap(194, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(clientePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(acrescimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(desconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(901, Short.MAX_VALUE))
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
                String.valueOf(total)
            };
            tabela2.addRow(dados);
            recalcularTotalBruto();

            /*Float precoLoop = 0f;
            Float quantidadeLoop = 0f;
            Float multi = 0f;
            acumulador = 0f;  // Iniciar o acumulador em 0

            for (int x = 1; x < tabelaVenda.getRowCount(); x++) {
                precoLoop = Float.parseFloat(tabelaVenda.getValueAt(x, 1).toString());
                quantidadeLoop = Float.parseFloat(tabelaVenda.getValueAt(x, 3).toString());  // Corrigido índice de quantidade
                multi = precoLoop * quantidadeLoop;
                acumulador += multi;
            }
            totalBruto.setText(String.valueOf(acumulador));*/
        }


    }//GEN-LAST:event_tabelaProdutoMouseClicked

    private void cancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarVendaActionPerformed
        tabela2.setNumRows(0);
    }//GEN-LAST:event_cancelarVendaActionPerformed

    private void confirmarVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarVendaMouseClicked
        try (Connection conexaoAtiva = Conexao.conexaoBanco()) {
            // Primeiro, obtenha o último id_venda
            String getLastVendaIdSQL = "SELECT id_venda FROM venda ORDER BY id_venda DESC LIMIT 1";
            PreparedStatement getLastVendaIdStmt = conexaoAtiva.prepareStatement(getLastVendaIdSQL);
            ResultSet rsVenda = getLastVendaIdStmt.executeQuery();
            int lastVendaId = 0;
            if (rsVenda.next()) {
                lastVendaId = rsVenda.getInt("id_venda");
            }

            // Agora, para cada item na tabelaVenda, obtenha o id_produto e insira o item de venda
            for (int x = 0; x < tabelaVenda.getRowCount(); x++) {
                String descricaoProduto = tabelaVenda.getValueAt(x, 0).toString();
                String getProdutoIdSQL = "SELECT id_produto FROM produto WHERE descricao = ?";
                PreparedStatement getProdutoIdStmt = conexaoAtiva.prepareStatement(getProdutoIdSQL);
                getProdutoIdStmt.setString(1, descricaoProduto);
                ResultSet rsProduto = getProdutoIdStmt.executeQuery();
                int produtoId = 0;
                if (rsProduto.next()) {
                    produtoId = rsProduto.getInt("id_produto");
                }

                String comandoSQL = "INSERT INTO item_venda(quantidade, desconto, acrescimo, id_produto, id_venda) "
                        + "VALUES (?, 0, 0, ?, ?)";
                PreparedStatement stmt = conexaoAtiva.prepareStatement(comandoSQL);
                stmt.setString(1, tabelaVenda.getValueAt(x, 3).toString());
                stmt.setInt(2, produtoId);
                stmt.setInt(3, lastVendaId);
                stmt.execute();
            }

            // Atualize a venda
            String SQL = "UPDATE venda SET "
                    + "id_cliente = (SELECT id_cliente FROM cliente INNER JOIN pessoa ON pessoa.id_pessoa = cliente.id_pessoa WHERE nome = ?), "
                    + "id_atendente = (SELECT id_atendente FROM atendente INNER JOIN pessoa ON pessoa.id_pessoa = atendente.id_pessoa WHERE nome = ?) "
                    + "WHERE id_venda = ?";
            PreparedStatement ps = conexaoAtiva.prepareStatement(SQL);
            ps.setString(1, nomeCliente.getText());
            ps.setString(2, nomeAtendente.getText());
            ps.setInt(3, lastVendaId);
            ps.execute();
            System.out.println("");
            dispose();

        } catch (SQLException ex) {
            Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
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
        for (int x = 0; x < tabelaVenda.getRowCount(); x++) { // Percorre as linhas da tabela, começando da segunda linha
            Float precoLoop = Float.parseFloat(tabelaVenda.getValueAt(x, 1).toString()); // Obtém o preço da coluna 1 e converte para Float
            Float quantidadeLoop = Float.parseFloat(tabelaVenda.getValueAt(x, 3).toString()); // Obtém a quantidade da coluna 3 e converte para Float
            acumulador += precoLoop * quantidadeLoop; // Multiplica preço pela quantidade e adiciona ao acumulador
        }
        totalBruto.setText(String.valueOf(acumulador)); // Define o texto de totalBruto com o valor acumulado
    }

    private void tabelaVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendaMouseClicked
        /*Float precoLoop = null;
        Float quantidadeLoop = null;
        for (int x = 0; x < tabelaVenda.getRowCount(); x++) {
            precoLoop += Float.parseFloat(tabelaVenda.getValueAt(x, 1).toString());
            quantidadeLoop +=Float.parseFloat(tabelaVenda.getValueAt(x,1).toString());
            
        }*/
    }//GEN-LAST:event_tabelaVendaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acrescimo;
    private javax.swing.JTextField campoPesquisar;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nomeAtendente;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JComboBox<String> nomeVendedor;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTable tabelaVenda;
    private javax.swing.JTextField total;
    private javax.swing.JTextField totalBruto;
    // End of variables declaration//GEN-END:variables
}
