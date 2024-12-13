
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Emprestimo extends javax.swing.JInternalFrame {

    String comandoSQL;
    PreparedStatement stmt;
    ResultSet rs;
    DefaultTableModel tabela;
    String livro;
    String ano;
    String preco;
    String categoria;
    String id_livro;
    int Id = 0;
    String nomeUsuario = null;
    int idLivro = 0;

    public Emprestimo(int userId) {
        this.Id = userId;

        initComponents();
        nomeCliente.setText(puxarPessoa(Id));
        tabela = (DefaultTableModel) tabelaLivro.getModel();
        debito.setActionCommand("Débito");
        credito.setActionCommand("Crédito");
        pix.setActionCommand("PIX");
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
        btConfirmar1 = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

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

        btConfirmar1.setText("Adicionar ao carrinho");
        btConfirmar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConfirmar1MouseClicked(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txValor, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                    .addComponent(txLivro)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(debito)
                                        .addGap(18, 18, 18)
                                        .addComponent(credito)
                                        .addGap(18, 18, 18)
                                        .addComponent(pix))
                                    .addComponent(btConfirmar1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addComponent(btConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btConfirmar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
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
    }//GEN-LAST:event_tabelaLivroMouseClicked


    private void btConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmarMouseClicked
        try (Connection con = Conexao.conexao()) {
            String comandoSQL = "INSERT INTO compra(id_usuario, id_livro, valor, tipoPagamento) VALUES (?, ?, ?, ?);";
            try (PreparedStatement stmt = con.prepareStatement(comandoSQL)) {
                System.out.println("ID do Usuário: " + Id); // Depuração
                stmt.setInt(1, Id); // Certifique-se de que 'Id' é um valor inteiro válido

                idLivro = puxarIdLivro(txLivro.getText());
                System.out.println("ID do Livro: " + idLivro); // Depuração
                if (idLivro != -1) {
                    stmt.setInt(2, idLivro); // Use setInt para IDs inteiros
                    stmt.setBigDecimal(3, new BigDecimal(txValor.getText())); // Converta valor para BigDecimal se necessário

                    // Defina o tipo de pagamento antes de executar
                    stmt.setString(4, tipoPagamento.getSelection().getActionCommand());
                    System.out.println("Tipo de Pagamento: " + tipoPagamento.getSelection().getActionCommand()); // Depuração

                    // Execute a instrução após definir todos os parâmetros
                    stmt.execute();
                } else {
                    System.out.println("ID do livro não encontrado");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, "Não consegui realizar a compra", ex);
        }

    }//GEN-LAST:event_btConfirmarMouseClicked

    private void btConfirmar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btConfirmar1MouseClicked

    private void btCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseClicked
       txLivro.setText(null);
       txValor.setText(null);
       
    }//GEN-LAST:event_btCancelarMouseClicked

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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btConfirmar1;
    private javax.swing.JRadioButton credito;
    private javax.swing.JRadioButton debito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JRadioButton pix;
    private javax.swing.JTable tabelaLivro;
    private javax.swing.ButtonGroup tipoPagamento;
    private javax.swing.JTextField txLivro;
    private javax.swing.JTextField txValor;
    // End of variables declaration//GEN-END:variables
}
