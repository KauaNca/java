
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;

public class Emprestimo extends javax.swing.JInternalFrame {

    String comandoSQL;
    PreparedStatement stmt;
    ResultSet rs;
    DefaultTableModel tabela;
    DefaultTableModel tabela2;
    ;
    String livro;
    String ano;
    String preco;
    String categoria;
    String id_livro;
    int Id = 0;
    String nomeUsuario = null;
    int idLivro = 0;
    Float acumulador = 0f;
    Float valorTotalTX = 0f;
    String situacao;
    String id_compra = null;
    String receberId = null;

    public Emprestimo(int userId) {
        this.Id = userId;

        initComponents();
        btProcurar.setVisible(false);
        btVoltar.setVisible(false);
        btCancelarItem.setVisible(false);
        try (Connection con = Conexao.conexao()) {
            String comandoSQL = "SELECT situacao FROM compra ORDER BY id_compra DESC LIMIT 1";
            try (PreparedStatement stmt = con.prepareStatement(comandoSQL); ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    situacao = rs.getString("situacao");
                }
            }

            if ("F".equals(situacao)) {
                receberId = iniciarVenda();
                txIdCompra.setText(receberId);
            } else if ("S".equals(situacao)) {
                int resposta = JOptionPane.showConfirmDialog(null, "Há uma venda salva. Deseja continuar?", null, JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    receberId = vendaSalva();
                    txIdCompra.setText(receberId);

                } else {
                    receberId = iniciarVenda(); // Certifique-se de atualizar a venda
                    txIdCompra.setText(receberId);
                }
            } else if ("P".equals(situacao)) {
                receberId = vendaPendente();
                txIdCompra.setText(receberId);
            } else if (situacao == null) { // Use comparação direta com null
                receberId = iniciarVenda();
                txIdCompra.setText(receberId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, "ERRO DE VENDA", ex);
        }

        nomeCliente.setText(puxarPessoa(Id));
        tabela = (DefaultTableModel) tabelaLivro.getModel();
        tabela2 = (DefaultTableModel) tabelaVenda.getModel();
        debito.setActionCommand("Débito");
        credito.setActionCommand("Crédito");
        pix.setActionCommand("PIX");
        debito.setSelected(true);
        try (Connection con = Conexao.conexao()) {
            String comandoSQL = "SELECT titulo, ano, valor, categoria FROM livro INNER JOIN categoria ON livro.id_categoria = categoria.id_categoria;";
            PreparedStatement stmt = con.prepareStatement(comandoSQL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Object[] dados = {
                    rs.getString("titulo"),
                    rs.getString("ano"),
                    rs.getString("categoria"),
                    rs.getString("valor")

                };
                tabela.addRow(dados);
                // Aqui você pode adicionar o código para processar os dados
            }
        } catch (SQLException ex) {
            Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoPagamento = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLivro = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btConfirmar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        debito = new javax.swing.JRadioButton();
        credito = new javax.swing.JRadioButton();
        pix = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        nomeCliente = new javax.swing.JTextField();
        txLivro = new javax.swing.JTextField();
        txValor = new javax.swing.JTextField();
        btAdicionar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVenda = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        valorTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txIdCompra = new javax.swing.JTextField();
        btSalvarVenda = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        btProcurar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btCancelarItem = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Empréstimo");

        tabelaLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Livro", "Ano", "Categoria", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaLivroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaLivro);

        jLabel1.setText("Livro:");

        jLabel2.setText("Valor:");

        btConfirmar.setText("Confirmar");
        btConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConfirmarMouseClicked(evt);
            }
        });

        jLabel3.setText("Forma de pagamento");

        tipoPagamento.add(debito);
        debito.setText("Débito");

        tipoPagamento.add(credito);
        credito.setText("Crédito");

        tipoPagamento.add(pix);
        pix.setText("PIX");

        jLabel4.setText("Usuário");

        nomeCliente.setEnabled(false);

        btAdicionar.setText("Adicionar livro");
        btAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAdicionarMouseClicked(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCancelarMouseClicked(evt);
            }
        });

        tabelaVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Livro", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaVenda);

        jLabel5.setText("Total");

        jLabel6.setText("Venda:");

        txIdCompra.setEnabled(false);

        btSalvarVenda.setText("Salvar venda");
        btSalvarVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSalvarVendaMouseClicked(evt);
            }
        });

        btPesquisar.setText("Pesquisar venda");
        btPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPesquisarMouseClicked(evt);
            }
        });

        btProcurar.setText("Procurar");
        btProcurar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btProcurarMouseClicked(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVoltarMouseClicked(evt);
            }
        });

        btCancelarItem.setText("Cancelar item");
        btCancelarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCancelarItemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txValor, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btSalvarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(debito)
                                            .addGap(18, 18, 18)
                                            .addComponent(credito)
                                            .addGap(18, 18, 18)
                                            .addComponent(pix)))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btCancelarItem))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btVoltar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar)
                    .addComponent(btProcurar)
                    .addComponent(btVoltar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(debito)
                            .addComponent(credito)
                            .addComponent(pix))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSalvarVenda)
                            .addComponent(btAdicionar))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCancelarItem))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btConfirmar)
                                    .addComponent(btCancelar))))
                        .addGap(26, 26, 26)))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLivroMouseClicked
        System.out.println("Evento de clique na tabela disparado");
        tabela = (DefaultTableModel) tabelaLivro.getModel();
        livro = tabela.getValueAt(tabelaLivro.getSelectedRow(), 0).toString();
        preco = tabela.getValueAt(tabelaLivro.getSelectedRow(), 3).toString();
        txLivro.setText(livro);
        txValor.setText(preco);

        if (evt.getClickCount() >= 2) {
            btCancelarItem.setVisible(true);
            if (tabelaVenda.getRowCount() == 0) {
                btCancelarItem.setVisible(false);
            }
            Object[] dados = {
                livro = tabela.getValueAt(tabelaLivro.getSelectedRow(), 0).toString(),
                preco = tabela.getValueAt(tabelaLivro.getSelectedRow(), 3).toString()
            };

            tabela2.addRow(dados);
            evitarRepeticao();
            acumulador = 0f;
            for (int x = 0; x < tabelaVenda.getRowCount(); x++) {

                preco = tabelaVenda.getValueAt(x, 1).toString();
                acumulador += Float.parseFloat(preco);
                valorTotal.setText(String.valueOf(acumulador));
            }

        }
    }//GEN-LAST:event_tabelaLivroMouseClicked
    public void evitarRepeticao() {
        DefaultTableModel tabela2 = (DefaultTableModel) tabelaVenda.getModel();
        Set<String> livrosSet = new HashSet<>();

        for (int x = 0; x < tabelaVenda.getRowCount(); x++) {
            String livro = tabelaVenda.getValueAt(x, 0).toString();
            if (livrosSet.contains(livro)) {
                tabela2.removeRow(x);
                x--; // Ajusta o índice devido à remoção de linha
            } else {
                livrosSet.add(livro);
            }
        }
    }

    private void btConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmarMouseClicked
        if (situacao.equals("S")) {
            confirmarVendaSalva(txIdCompra.getText());
            JOptionPane.showMessageDialog(null, "Compra concluída");
            txLivro.setText(null);
            txValor.setText(null);
            tabela2.setNumRows(0);
            txIdCompra.setText(null);
            this.dispose();
        } else {
            try (Connection con = Conexao.conexao()) {
                con.setAutoCommit(false); // Inicia a transação

                for (int x = 0; x < tabelaVenda.getRowCount(); x++) {
                    String comandoSQL = "INSERT INTO item_livro(id_livro, valor, situacao,id_compra) "
                            + "VALUES ((SELECT id_livro FROM livro WHERE titulo = ?), ?, "
                            + "'F',?);";

                    try (PreparedStatement stmt = con.prepareStatement(comandoSQL)) {
                        stmt.setString(1, tabelaVenda.getValueAt(x, 0).toString());
                        stmt.setBigDecimal(2, new BigDecimal(tabelaVenda.getValueAt(x, 1).toString())); // Certifique-se de usar BigDecimal para valores monetários
                        stmt.setString(3, id_compra);
                        stmt.execute();
                    } catch (SQLException ex) {
                        Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, "Não consegui realizar a compra", ex);
                    }
                }

                // Atualização na tabela compra após inserir todos os itens
                String comandoSQL2 = "UPDATE compra SET tipoPagamento = ?, valor = ?,situacao = 'F' "
                        + "WHERE id_compra = ?";
                try (PreparedStatement stmt2 = con.prepareStatement(comandoSQL2)) {
                    stmt2.setString(1, tipoPagamento.getSelection().getActionCommand());
                    stmt2.setBigDecimal(2, new BigDecimal(valorTotal.getText())); // Certifique-se de usar BigDecimal para valores monetários
                    stmt2.setString(3, id_compra);
                    stmt2.executeUpdate();
                    con.commit(); // Confirma a transação
                    System.out.println("Compra realizada com sucesso!");
                    txLivro.setText(null);
                    txValor.setText(null);
                    tabela2.setNumRows(0);
                    txIdCompra.setText(null);
                    valorTotal.setText(null);
                    receberId = iniciarVenda();
                    txIdCompra.setText(receberId);
                } catch (SQLException ex) {
                    con.rollback(); // Reverte a transação em caso de erro
                    Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, "Não consegui atualizar a compra", ex);
                }

            } catch (SQLException ex) {
                System.out.println("ERRO AO ADICIONAR NO item_livro: " + ex.getMessage());
            }

        }


    }//GEN-LAST:event_btConfirmarMouseClicked

    private void btAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAdicionarMouseClicked
        btCancelarItem.setVisible(true);
        if (tabelaVenda.getRowCount() == 0) {
            btCancelarItem.setVisible(false);
        }
        Object[] dados = {
            livro = tabela.getValueAt(tabelaLivro.getSelectedRow(), 0).toString(),
            preco = tabela.getValueAt(tabelaLivro.getSelectedRow(), 3).toString()
        };
        tabela2.addRow(dados);
        evitarRepeticao();
        acumulador = 0f;
        for (int x = 0; x < tabelaVenda.getRowCount(); x++) {

            preco = tabelaVenda.getValueAt(x, 1).toString();
            acumulador += Float.parseFloat(preco);
            valorTotal.setText(String.valueOf(acumulador));
        }
    }//GEN-LAST:event_btAdicionarMouseClicked

    private void btCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseClicked
        txLivro.setText(null);
        txValor.setText(null);
        tabela2.setNumRows(0);

    }//GEN-LAST:event_btCancelarMouseClicked

    private void btSalvarVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSalvarVendaMouseClicked
        try (Connection con = Conexao.conexao()) {
            con.setAutoCommit(false); // Inicia a transação

            for (int x = 0; x < tabelaVenda.getRowCount(); x++) {
                String comandoSQL = "INSERT INTO item_livro(id_livro, valor, situacao,id_compra) "
                        + "VALUES ((SELECT id_livro FROM livro WHERE titulo = ?), ?, "
                        + "'S',?);";

                try (PreparedStatement stmt = con.prepareStatement(comandoSQL)) {
                    stmt.setString(1, tabelaVenda.getValueAt(x, 0).toString());
                    stmt.setBigDecimal(2, new BigDecimal(tabelaVenda.getValueAt(x, 1).toString())); // Certifique-se de usar BigDecimal para valores monetários
                    stmt.setString(3, id_compra);
                    stmt.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, "Não consegui realizar a compra", ex);
                }
            }

            // Atualização na tabela compra após inserir todos os itens
            String comandoSQL2 = "UPDATE compra SET tipoPagamento = ?, valor = ?,situacao = 'S' "
                    + "WHERE id_compra = ?";
            try (PreparedStatement stmt2 = con.prepareStatement(comandoSQL2)) {
                stmt2.setString(1, tipoPagamento.getSelection().getActionCommand());
                stmt2.setBigDecimal(2, new BigDecimal(valorTotal.getText())); // Certifique-se de usar BigDecimal para valores monetários
                stmt2.setString(3, id_compra);
                stmt2.executeUpdate();
                con.commit(); // Confirma a transação
                System.out.println("Salvo");
                txLivro.setText(null);
                txValor.setText(null);
                tabela2.setNumRows(0);
                txIdCompra.setText(null);
                this.dispose();
            } catch (SQLException ex) {
                con.rollback(); // Reverte a transação em caso de erro
                Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, "Não consegui atualizar a compra", ex);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO AO ADICIONAR NO item_livro: " + ex.getMessage());
        }

    }//GEN-LAST:event_btSalvarVendaMouseClicked

    private void btPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPesquisarMouseClicked
        txIdCompra.setEnabled(true);
        txIdCompra.setEditable(true);
        txIdCompra.setText(null);
        btPesquisar.setVisible(false);
        btProcurar.setVisible(true);


    }//GEN-LAST:event_btPesquisarMouseClicked

    private void btProcurarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btProcurarMouseClicked
        txIdCompra.setEnabled(false);
        txIdCompra.setEditable(false);
        btVoltar.setVisible(true);
        try (Connection con = Conexao.conexao()) {
            comandoSQL = "SELECT situacao FROM compra WHERE id_compra = ?;";
            PreparedStatement stmt = con.prepareStatement(comandoSQL);
            stmt.setString(1, txIdCompra.getText());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                situacao = rs.getString("situacao");
            }
            rs.close();
            stmt.close();
            if (situacao.equals("S")) {
                situacao = "S";

                try (Connection con2 = Conexao.conexao()) {

                    tabela2 = (DefaultTableModel) tabelaVenda.getModel();
                    comandoSQL = "SELECT l.titulo, l.valor \n"
                            + "FROM item_livro \n"
                            + "INNER JOIN livro l ON l.id_livro = item_livro.id_livro \n"
                            + "WHERE item_livro.id_compra = ?;";
                    PreparedStatement stmt2 = con2.prepareStatement(comandoSQL);
                    stmt2.setString(1, txIdCompra.getText());
                    ResultSet rs2 = stmt2.executeQuery();
                    while (rs2.next()) {
                        Object[] dados = {
                            livro = rs2.getString("titulo"),
                            preco = rs2.getString("valor")
                        };
                        tabela2.addRow(dados);
                    }
                    rs2.close();
                    stmt2.close();
                    acumulador = 0f;
                    for (int x = 0; x < tabelaVenda.getRowCount(); x++) {

                        preco = tabelaVenda.getValueAt(x, 1).toString();
                        acumulador += Float.parseFloat(preco);
                        valorTotal.setText(String.valueOf(acumulador));
                    }

                } catch (SQLException ex) {
                    System.out.println("ERRO DE VENDA SALVA" + ex.getMessage());
                }
            } else if (situacao.equals("F")) {
                int resposta = JOptionPane.showConfirmDialog(null, "É uma venda concluída. Deseja vê-la?", "Venda Concluída", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    btAdicionar.setVisible(false);

                    btSalvarVenda.setVisible(false);
                    btConfirmar.setVisible(false);
                    btCancelar.setVisible(false);
                    try (Connection con2 = Conexao.conexao()) {

                        tabela2 = (DefaultTableModel) tabelaVenda.getModel();
                        comandoSQL = "SELECT l.titulo, l.valor \n"
                                + "FROM item_livro \n"
                                + "INNER JOIN livro l ON l.id_livro = item_livro.id_livro \n"
                                + "WHERE item_livro.id_compra = ?;";
                        PreparedStatement stmt2 = con2.prepareStatement(comandoSQL);
                        stmt2.setString(1, txIdCompra.getText());
                        ResultSet rs2 = stmt2.executeQuery();
                        while (rs2.next()) {
                            Object[] dados = {
                                livro = rs2.getString("titulo"),
                                preco = rs2.getString("valor")
                            };
                            tabela2.addRow(dados);
                        }
                        rs2.close();
                        stmt2.close();
                        acumulador = 0f;
                        for (int x = 0; x < tabelaVenda.getRowCount(); x++) {

                            preco = tabelaVenda.getValueAt(x, 1).toString();
                            acumulador += Float.parseFloat(preco);
                            valorTotal.setText(String.valueOf(acumulador));
                        }

                    } catch (SQLException ex) {
                        System.out.println("ERRO NA VENDA" + ex.getMessage());
                        this.dispose();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalido");
                txIdCompra.setEnabled(false);
                txIdCompra.setEditable(false);
                txIdCompra.setText(null);
                btPesquisar.setVisible(true);
                receberId = vendaPendente();
                txIdCompra.setText(receberId);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, "ERRO NA PROCURA", ex);
        }


    }//GEN-LAST:event_btProcurarMouseClicked

    private void btVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVoltarMouseClicked
        receberId = vendaPendente();
        txIdCompra.setText(receberId);
        btAdicionar.setVisible(true);
        btSalvarVenda.setVisible(true);
        btConfirmar.setVisible(true);
        btCancelar.setVisible(true);
        btPesquisar.setVisible(true);
        btProcurar.setVisible(false);
        btVoltar.setVisible(false);
        txLivro.setText(null);
        txValor.setText(null);
        tabela2.setNumRows(0);

    }//GEN-LAST:event_btVoltarMouseClicked

    private void btCancelarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarItemMouseClicked
        tabela2.removeRow(tabelaVenda.getSelectedRow());
        acumulador = 0f;
        for (int x = 0; x < tabelaVenda.getRowCount(); x++) {

            preco = tabelaVenda.getValueAt(x, 1).toString();
            acumulador += Float.parseFloat(preco);
            valorTotal.setText(String.valueOf(acumulador));
        }
    }//GEN-LAST:event_btCancelarItemMouseClicked

    public int puxarIdLivro(String nomeLivro) {
        idLivro = -1;
        comandoSQL = "SELECT id_livro FROM livro WHERE titulo = ?;";

        try (Connection con = Conexao.conexao(); PreparedStatement stmt = con.prepareStatement(comandoSQL)) {

            stmt.setString(1, nomeLivro);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idLivro = rs.getInt("id_livro");
                    System.out.println("ID do Livro encontrado: " + idLivro); // Mensagem de depuração
                } else {
                    System.out.println("Livro não encontrado: " + nomeLivro); // Mensagem de depuração
                }
            }

        } catch (SQLException ex) {
            System.out.println("Não consegui puxar o ID do livro: " + ex.getMessage());
        }
        return idLivro;
    }

    public String puxarPessoa(int id_usuario) {
        nomeUsuario = null;
        String comandoSQL = "SELECT nome FROM pessoa INNER JOIN usuario ON usuario.id_pessoa = pessoa.id_pessoa WHERE id_usuario = ?";

        try (Connection con = Conexao.conexao(); PreparedStatement stmt = con.prepareStatement(comandoSQL)) {

            stmt.setInt(1, id_usuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nomeUsuario = rs.getString("nome");
                }
            }

        } catch (SQLException ex) {
            System.out.println("Não consegui puxar o nome pelo id: " + ex.getMessage());
        }
        return nomeUsuario;
    }

    public String iniciarVenda() {
        btCancelarItem.setVisible(false);
        try (Connection con = Conexao.conexao()) {

            String comandoSQL = "INSERT INTO compra(id_usuario,tipoPagamento,valor,situacao)"
                    + "VALUE(?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(comandoSQL);
            stmt.setInt(1, Id);
            stmt.setString(2, "Indefinido");
            stmt.setString(3, "0");
            stmt.setString(4, "P");
            stmt.execute();
            stmt.close();

            comandoSQL = "SELECT id_compra FROM compra ORDER BY id_compra DESC LIMIT 1";
            PreparedStatement stmt2 = con.prepareStatement(comandoSQL);
            ResultSet rs = stmt2.executeQuery();
            if (rs.next()) {
                id_compra = rs.getString("id_compra");
            }
            rs.close();
            stmt2.close();

        } catch (SQLException ex) {
            System.out.println("ERRO AO INICIAR VENDA" + ex.getMessage());
        }
        return id_compra;
    }

    public String vendaPendente() {
        try (Connection con = Conexao.conexao()) {
            comandoSQL = "SELECT id_compra FROM compra ORDER BY id_compra DESC LIMIT 1";
            PreparedStatement stmt = con.prepareStatement(comandoSQL);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id_compra = rs.getString("id_compra");
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("ERRO AO INICIAR VENDA" + ex.getMessage());
        }
        return id_compra;
    }

    public String vendaSalva() {
        try (Connection con = Conexao.conexao()) {
            receberId = vendaPendente();
            tabela2 = (DefaultTableModel) tabelaVenda.getModel();
            comandoSQL = "SELECT l.titulo, l.valor \n"
                    + "FROM item_livro \n"
                    + "INNER JOIN livro l ON l.id_livro = item_livro.id_livro \n"
                    + "WHERE item_livro.id_compra = ?;";
            PreparedStatement stmt = con.prepareStatement(comandoSQL);
            stmt.setString(1, receberId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] dados = {
                    livro = rs.getString("titulo"),
                    preco = rs.getString("valor")
                };
                tabela2.addRow(dados);
            }
            acumulador = 0f;
            for (int x = 0; x < tabelaVenda.getRowCount(); x++) {

                preco = tabelaVenda.getValueAt(x, 1).toString();
                acumulador += Float.parseFloat(preco);
                valorTotal.setText(String.valueOf(acumulador));
            }

        } catch (SQLException ex) {
            System.out.println("ERRO DE VENDA SALVA" + ex.getMessage());
        }

        return receberId;
    }

    public void confirmarVendaSalva() {
        try (Connection con = Conexao.conexao()) {
            con.setAutoCommit(false); // Inicia a transação

            for (int x = 0; x < tabelaVenda.getRowCount(); x++) {
                String titulo = tabelaVenda.getValueAt(x, 0).toString();
                BigDecimal valor = new BigDecimal(tabelaVenda.getValueAt(x, 1).toString());

                String comandoSQL = "SELECT COUNT(*) FROM item_livro WHERE id_livro = (SELECT id_livro FROM livro WHERE titulo = ?) AND id_compra = ? AND situacao = 'S';";
                try (PreparedStatement stmt = con.prepareStatement(comandoSQL)) {
                    stmt.setString(1, titulo);
                    stmt.setString(2, txIdCompra.getText());
                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next() && rs.getInt(1) == 0) {
                            String insertItem = "INSERT INTO item_livro(id_livro, valor, situacao, id_compra) "
                                    + "VALUES ((SELECT id_livro FROM livro WHERE titulo = ?), ?, 'S', ?);";
                            try (PreparedStatement insertSQL = con.prepareStatement(insertItem)) {
                                insertSQL.setString(1, titulo);
                                insertSQL.setBigDecimal(2, valor);
                                insertSQL.setString(3, txIdCompra.getText());
                                insertSQL.execute();
                            }
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, "Não consegui realizar a compra", ex);
                }
            }

            // Atualização na tabela compra após inserir todos os itens
            String comandoSQL2 = "UPDATE compra SET tipoPagamento = ?, valor = ?, situacao = 'S' "
                    + "WHERE id_compra = ?";
            try (PreparedStatement stmt2 = con.prepareStatement(comandoSQL2)) {
                stmt2.setString(1, tipoPagamento.getSelection().getActionCommand());
                stmt2.setBigDecimal(2, new BigDecimal(valorTotal.getText())); // Certifique-se de usar BigDecimal para valores monetários
                stmt2.setString(3, txIdCompra.getText());
                stmt2.executeUpdate();
                con.commit(); // Confirma a transação
                System.out.println("Compra realizada com sucesso!");
            } catch (SQLException ex) {
                con.rollback(); // Reverte a transação em caso de erro
                Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, "Não consegui atualizar a compra", ex);
            }

        } catch (SQLException ex) {
            System.out.println("ERRO AO ADICIONAR NO item_livro: " + ex.getMessage());
        }

    }

    public void confirmarVendaSalva(String id) {
        try (Connection con = Conexao.conexao()) {
            id_compra = vendaPendente();
            comandoSQL = "UPDATE item_livro SET situacao = 'F' WHERE id_compra = ?;";
            PreparedStatement stmt = con.prepareStatement(comandoSQL);
            stmt.setString(1, id);
            stmt.execute();
            stmt.close();

            String comandoSQL2 = "UPDATE compra SET situacao = 'F' WHERE id_compra = ?;";
            PreparedStatement stmt2 = con.prepareStatement(comandoSQL2);
            stmt2.setString(1, id);
            stmt2.execute();
            stmt2.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("ERRO AO ADICIONAR NO item_livro: " + ex.getMessage());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelarItem;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btProcurar;
    private javax.swing.JButton btSalvarVenda;
    private javax.swing.JButton btVoltar;
    private javax.swing.JRadioButton credito;
    private javax.swing.JRadioButton debito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JRadioButton pix;
    private javax.swing.JTable tabelaLivro;
    private javax.swing.JTable tabelaVenda;
    private javax.swing.ButtonGroup tipoPagamento;
    private javax.swing.JTextField txIdCompra;
    private javax.swing.JTextField txLivro;
    private javax.swing.JTextField txValor;
    private javax.swing.JTextField valorTotal;
    // End of variables declaration//GEN-END:variables
}
