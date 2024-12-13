
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Categorias extends javax.swing.JInternalFrame {

    String comandoSQL;
    PreparedStatement stmt;
    ResultSet rs;
    String id_categoria = null;
    String categoria = null;
    DefaultTableModel tabela;

    /**
     * Creates new form Categorias
     */
    public Categorias() {
        initComponents();
        
        tabela = (DefaultTableModel) tabelaCategoria.getModel();

        editar.setSelected(true);
        txCategoria1.setVisible(false);
        lbCategoria2.setVisible(false);
        txCategoria.setVisible(true);
        lbCategoria.setVisible(true);

        arrumarOrdemAlfabetica();
    }

    public void arrumarOrdemAlfabetica() {
        try (Connection con = Conexao.conexao()) {
            tabela.setNumRows(0);
            String comandoSQL = "SELECT * FROM categoria ORDER BY categoria ASC;";
            PreparedStatement stmt = con.prepareStatement(comandoSQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] dados = {
                    id_categoria = rs.getString("id_categoria"), categoria = rs.getString("categoria")
                };
                tabela.addRow(dados);
            }
        } catch (SQLException e) {
            System.out.println("ERRO - ORDEM ALFABÉTICA");
        }
    }

    public void arrumarPorId() {
        try (Connection con = Conexao.conexao()) {
            tabela.setNumRows(0);
            String comandoSQL = "SELECT * FROM categoria ORDER BY id_categoria ASC;";
            PreparedStatement stmt = con.prepareStatement(comandoSQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] dados = {
                    id_categoria = rs.getString("id_categoria"), categoria = rs.getString("categoria")
                };
                tabela.addRow(dados);
            }
        } catch (SQLException e) {
            System.out.println("ERRO - ORDEM ID");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipodeOrdem = new javax.swing.ButtonGroup();
        tipoTarefa = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCategoria = new javax.swing.JTable();
        ordemNumerica = new javax.swing.JRadioButton();
        ordemAlfabética = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        txCategoria = new javax.swing.JTextField();
        btConfirmar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        lbCategoria2 = new javax.swing.JLabel();
        txCategoria1 = new javax.swing.JTextField();
        editar = new javax.swing.JRadioButton();
        adicionar = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Categorias");

        tabelaCategoria.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        tabelaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCategoria);

        tipodeOrdem.add(ordemNumerica);
        ordemNumerica.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        ordemNumerica.setText("Númerica");
        ordemNumerica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordemNumericaActionPerformed(evt);
            }
        });

        tipodeOrdem.add(ordemAlfabética);
        ordemAlfabética.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        ordemAlfabética.setText("Alfabética");
        ordemAlfabética.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordemAlfabéticaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        jLabel1.setText("Ordem:");

        lbCategoria.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        lbCategoria.setText("Categoria");

        txCategoria.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N

        btConfirmar.setBackground(new java.awt.Color(0, 128, 0));
        btConfirmar.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        btConfirmar.setText("Confirmar");
        btConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConfirmarMouseClicked(evt);
            }
        });

        btCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btCancelar.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCancelarMouseClicked(evt);
            }
        });

        lbCategoria2.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        lbCategoria2.setText("Categoria");

        txCategoria1.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N

        tipoTarefa.add(editar);
        editar.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        editar.setText("Editar categoria");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        tipoTarefa.add(adicionar);
        adicionar.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        adicionar.setText("Adicionar categoria");
        adicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adicionarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(editar)
                                        .addGap(45, 45, 45)
                                        .addComponent(adicionar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbCategoria)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbCategoria2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(232, 232, 232)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(ordemNumerica)
                        .addGap(60, 60, 60)
                        .addComponent(ordemAlfabética)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editar)
                            .addComponent(adicionar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCategoria)
                            .addComponent(txCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCategoria2)
                            .addComponent(txCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btConfirmar)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ordemNumerica)
                    .addComponent(ordemAlfabética)
                    .addComponent(jLabel1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ordemNumericaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordemNumericaActionPerformed
        arrumarPorId();
    }//GEN-LAST:event_ordemNumericaActionPerformed

    private void ordemAlfabéticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordemAlfabéticaActionPerformed
        arrumarOrdemAlfabetica();
    }//GEN-LAST:event_ordemAlfabéticaActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        txCategoria1.setVisible(false);
        lbCategoria2.setVisible(false);
        txCategoria.setVisible(true);
        lbCategoria.setVisible(true);
    }//GEN-LAST:event_editarActionPerformed

    private void tabelaCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCategoriaMouseClicked
        categoria = tabela.getValueAt(tabelaCategoria.getSelectedRow(), 1).toString();
        txCategoria.setText(categoria);
    }//GEN-LAST:event_tabelaCategoriaMouseClicked

    private void adicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adicionarMouseClicked
        txCategoria1.setVisible(true);
        lbCategoria2.setVisible(true);
        txCategoria.setVisible(false);
        lbCategoria.setVisible(false);
    }//GEN-LAST:event_adicionarMouseClicked

    private void btConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmarMouseClicked
        //FALTA COLOCAR UMA MÁSCARA
        if (adicionar.isSelected()) {
            try (Connection con = Conexao.conexao()) {
                comandoSQL = "INSERT INTO categoria(categoria) VALUE(?);";
                stmt = con.prepareStatement(comandoSQL);
                stmt.setString(1, txCategoria1.getText());
                stmt.execute();
                stmt.close();
                JOptionPane.showMessageDialog(null, "CATEGORIA ADICIONADA");
                arrumarOrdemAlfabetica();
                txCategoria1.setText(null);
                con.close();
            } catch (SQLException ex) {
                System.out.println("ERRO AO ADICIONAR");
            }
        }else{
            try (Connection con = Conexao.conexao()) {
                id_categoria = tabela.getValueAt(tabelaCategoria.getSelectedRow(), 0).toString();
                comandoSQL = "UPDATE categoria SET categoria = ? WHERE id_categoria = ?;";
                stmt = con.prepareStatement(comandoSQL);
                stmt.setString(1, txCategoria.getText());
                stmt.setString(2, id_categoria);
                stmt.execute();
                stmt.close();
                JOptionPane.showMessageDialog(null, "CATEGORIA ATUALIZADA");
                arrumarOrdemAlfabetica();
                txCategoria.setText(null);
                con.close();
            } catch (SQLException ex) {
                System.out.println("ERRO AO ATUALIZAR");
            }
        }

    }//GEN-LAST:event_btConfirmarMouseClicked

    private void btCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseClicked
        txCategoria1.setText(null);
         txCategoria.setText(null);
         arrumarOrdemAlfabetica();
    }//GEN-LAST:event_btCancelarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton adicionar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JRadioButton editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbCategoria2;
    private javax.swing.JRadioButton ordemAlfabética;
    private javax.swing.JRadioButton ordemNumerica;
    private javax.swing.JTable tabelaCategoria;
    private javax.swing.ButtonGroup tipoTarefa;
    private javax.swing.ButtonGroup tipodeOrdem;
    private javax.swing.JTextField txCategoria;
    private javax.swing.JTextField txCategoria1;
    // End of variables declaration//GEN-END:variables
}
