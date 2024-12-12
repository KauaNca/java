package conexaoBanco;

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

    public Emprestimo() {
        initComponents();
        tabela = (DefaultTableModel) tabelaLivro.getModel();
        try (Connection con = Conexao.conexaoBanco()) {
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
        } catch (ClassNotFoundException ex) {
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
        txLivro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txValor = new javax.swing.JTextField();
        btConfirmar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btConfirmar1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        debito = new javax.swing.JRadioButton();
        credito = new javax.swing.JRadioButton();
        pix = new javax.swing.JRadioButton();

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

        txLivro.setEnabled(false);

        jLabel2.setText("Valor:");

        txValor.setEnabled(false);

        btConfirmar.setText("Confirmar");
        btConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConfirmarMouseClicked(evt);
            }
        });

        btCancelar.setText("Cancelar");

        btConfirmar1.setText("Adicionar ao carrinho");
        btConfirmar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConfirmar1MouseClicked(evt);
            }
        });

        jLabel3.setText("Forma de pagamento");

        debito.setText("Débito");

        credito.setText("Crédito");

        pix.setText("PIX");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txValor, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btConfirmar1)
                            .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(debito)
                        .addGap(18, 18, 18)
                        .addComponent(credito)
                        .addGap(18, 18, 18)
                        .addComponent(pix)))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
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
                        .addGap(30, 30, 30)
                        .addComponent(btConfirmar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLivroMouseClicked
        livro = tabela.getValueAt(tabelaLivro.getSelectedRow(), 0).toString();
        preco = tabela.getValueAt(tabelaLivro.getSelectedRow(), 3).toString();
        txLivro.setText(livro);
        txValor.setText(preco);
    }//GEN-LAST:event_tabelaLivroMouseClicked

    private void btConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmarMouseClicked
        try (Connection con = Conexao.conexaoBanco()) {
            comandoSQL = "INSERT INTO compra(id_usuario,id_livro,tipoPagamento,valor) VALUE (1,?,'Crédito',?);";
            stmt = con.prepareStatement(comandoSQL);
            stmt.setString(1, puxarIdLivro(txLivro.getText()));
            stmt.setString(2, txValor.getText());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btConfirmarMouseClicked

    public String puxarIdLivro(String titulo) {
        String idLivro = null;
        String comandoSQL = "SELECT id_livro FROM livro WHERE titulo = ?;";

        try (Connection con = Conexao.conexaoBanco(); PreparedStatement stmt = con.prepareStatement(comandoSQL)) {

            stmt.setString(1, titulo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idLivro = rs.getString("id_livro");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, "Erro ao buscar id_livro", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Emprestimo.class.getName()).log(Level.SEVERE, "Classe não encontrada", ex);
        }

        return idLivro;
    }
    
    private void btConfirmar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmar1MouseClicked

    }//GEN-LAST:event_btConfirmar1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btConfirmar1;
    private javax.swing.JRadioButton credito;
    private javax.swing.JRadioButton debito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton pix;
    private javax.swing.JTable tabelaLivro;
    private javax.swing.ButtonGroup tipoPagamento;
    private javax.swing.JTextField txLivro;
    private javax.swing.JTextField txValor;
    // End of variables declaration//GEN-END:variables
}
