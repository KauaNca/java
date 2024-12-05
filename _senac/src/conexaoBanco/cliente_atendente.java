/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package conexaoBanco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaua33500476
 */
public class cliente_atendente extends javax.swing.JFrame {

    String situacao = "Ativo";
    String tipo;
    String saldo;
    PreparedStatement ps2;
    PreparedStatement ps3;
    ResultSet rs;
    Connection conexaoAtiva;

    /**
     * Creates new form cliente
     */
    public cliente_atendente() {
        initComponents();
        rbCliente.setActionCommand("cliente");
        rbFuncionario.setActionCommand("funcionario");
        cpf.setVisible(false);
        telefone.setVisible(false);
        email.setVisible(false);
        matricula.setVisible(false);
        salario.setVisible(false);
        lbcpf.setVisible(false);
        lbtelefone.setVisible(false);
        lbemail.setVisible(false);
        lbmatricula.setVisible(false);
        lbsalario.setVisible(false);
        
       
        

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
        tabelaCliente = new javax.swing.JTable();
        tipoPessoa = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rbCliente = new javax.swing.JRadioButton();
        rbFuncionario = new javax.swing.JRadioButton();
        nome = new javax.swing.JTextField();
        idade = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        lbcpf = new javax.swing.JLabel();
        cpf = new javax.swing.JTextField();
        lbtelefone = new javax.swing.JLabel();
        telefone = new javax.swing.JTextField();
        lbemail = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        lbmatricula = new javax.swing.JLabel();
        matricula = new javax.swing.JTextField();
        lbsalario = new javax.swing.JLabel();
        salario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPessoa = new javax.swing.JTable();
        pesquisa = new javax.swing.JTextField();
        Pesquisar = new javax.swing.JButton();

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_cliente", "telefone", "saldo", "email", "situacao", "id_pessoa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaCliente);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Idade");

        tipoPessoa.add(rbCliente);
        rbCliente.setText("Cliente");
        rbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbClienteItemStateChanged(evt);
            }
        });

        tipoPessoa.add(rbFuncionario);
        rbFuncionario.setText("Funcionário");
        rbFuncionario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbFuncionarioItemStateChanged(evt);
            }
        });

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        lbcpf.setText("CPF");

        lbtelefone.setText("Telefone");

        lbemail.setText("Email");

        lbmatricula.setText("Matrícula");

        lbsalario.setText("Salário");

        tabelaPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nome", "tipo"
            }
        ));
        jScrollPane2.setViewportView(tabelaPessoa);

        pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pesquisaKeyPressed(evt);
            }
        });

        Pesquisar.setText("Pesquisar");
        Pesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PesquisarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbmatricula, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbemail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addComponent(lbsalario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(salario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbcpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbtelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(idade))
                                            .addComponent(rbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(104, 104, 104)
                                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Pesquisar))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(idade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbCliente)
                            .addComponent(rbFuncionario))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbtelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbemail)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbmatricula)
                            .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsalario))
                        .addGap(18, 18, 18)
                        .addComponent(btCadastrar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pesquisar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbClienteItemStateChanged
        cpf.setVisible(true);
        telefone.setVisible(true);
        email.setVisible(true);
        lbcpf.setVisible(true);
        lbtelefone.setVisible(true);
        lbemail.setVisible(true);
        matricula.setVisible(false);
        salario.setVisible(false);
        lbmatricula.setVisible(false);
        lbsalario.setVisible(false);

    }//GEN-LAST:event_rbClienteItemStateChanged

    private void rbFuncionarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbFuncionarioItemStateChanged
        cpf.setVisible(false);
        telefone.setVisible(false);
        email.setVisible(false);
        lbcpf.setVisible(false);
        lbtelefone.setVisible(false);
        lbemail.setVisible(false);
        matricula.setVisible(true);
        salario.setVisible(true);
        lbmatricula.setVisible(true);
        lbsalario.setVisible(true);
    }//GEN-LAST:event_rbFuncionarioItemStateChanged

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        try {
            Connection conexaoAtiva = Conexao.conexaoBanco();
            String SQL = "INSERT INTO pessoa(nome,idade,cpf_cnpj,tipo,situacao) VALUES(?,?,?,?,?);";
            PreparedStatement ps1 = conexaoAtiva.prepareStatement(SQL);
            ps1.setString(1, nome.getText());
            ps1.setString(2, idade.getText());
            if (tipoPessoa.getSelection().getActionCommand().equals("cliente")) {
                ps1.setString(4, tipo = "Cliente");
                ps1.setString(3, cpf.getText());
                ps1.setString(5, situacao);
            } else {
                ps1.setString(4, tipo = "Atendente");
                ps1.setString(3, cpf.getText());
                ps1.setString(5, situacao);
            }
            ps1.execute();
            ps1.close();
            System.out.println("INSERIDO EM PESSOA");

            if (tipoPessoa.getSelection().getActionCommand().equals("cliente")) {
                String SQL2 = "INSERT INTO cliente(telefone,saldo,email,situacao,id_pessoa) VALUES(?,?,?,?,?);";
                PreparedStatement ps2 = conexaoAtiva.prepareStatement(SQL2);
                ps2.setString(1, telefone.getText());
                ps2.setString(2, saldo = "0");
                ps2.setString(3, email.getText());
                ps2.setString(4, situacao);
                // Seleção do id_pessoa correspondente ao nome
                String SQL3 = "SELECT id_pessoa FROM pessoa WHERE nome = ? ORDER BY nome DESC LIMIT 1";
                PreparedStatement ps3 = conexaoAtiva.prepareStatement(SQL3);
                ps3.setString(1, nome.getText() + "%"); // Use % para corresponder ao nome

                ResultSet rs = ps3.executeQuery();
                rs = ps3.executeQuery();
                if (rs.next()) {
                    ps2.setString(5, rs.getString("id_pessoa"));
                }

                ps2.execute();
                System.out.println("INSERÇÃO COMPLETA DE CLIENTE");

                rs.close();
                ps3.close();
                ps2.close();
                conexaoAtiva.close();

            } else {
                String SQL2 = "INSERT INTO atendente(matricula,salario,situacao,id_pessoa) VALUES(?,?,?,?);";
                PreparedStatement ps2 = conexaoAtiva.prepareStatement(SQL2);
                ps2.setString(1, matricula.getText());
                ps2.setString(2, salario.getText());
                ps2.setString(3, situacao);
                // Seleção do id_pessoa correspondente ao nome
                String SQL3 = "SELECT id_pessoa FROM pessoa WHERE nome = ? ORDER BY nome DESC LIMIT 1";
                PreparedStatement ps3 = conexaoAtiva.prepareStatement(SQL3);
                ps3.setString(1, nome.getText()); // Use % para corresponder ao nome

                ResultSet rs = ps3.executeQuery();
                rs = ps3.executeQuery();
                if (rs.next()) {
                    ps2.setString(4, rs.getString("id_pessoa"));
                }
                ps2.execute();
                System.out.println("INSERÇÃO COMPLETA DE FUNCIONÁRIO");

                rs.close();
                ps3.close();
                ps2.close();
                conexaoAtiva.close();

            }

        } catch (SQLException ex) {
            Logger.getLogger(cliente_atendente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(cliente_atendente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btCadastrarActionPerformed

    private void PesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PesquisarMouseClicked
        
    }//GEN-LAST:event_PesquisarMouseClicked

    private void pesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisaKeyPressed
        try (Connection conexaoAtiva = Conexao.conexaoBanco();
     PreparedStatement ps = conexaoAtiva.prepareStatement("SELECT nome, tipo FROM pessoa WHERE nome LIKE ? ORDER BY id_pessoa;")) {
    
    DefaultTableModel modeloTabela = (DefaultTableModel) tabelaPessoa.getModel();
    modeloTabela.setNumRows(0);
    
    ps.setString(1, "%" + pesquisa.getText() + "%");
    try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            Object[] dados = {
                rs.getString("nome"),
                rs.getString("tipo")
            };
            modeloTabela.addRow(dados);
        }
    }
} catch (SQLException e) {
    System.out.println("ERRO NA CONEXAO DE PESQUISA: " + e.getMessage());
}        catch (ClassNotFoundException ex) {
            Logger.getLogger(cliente_atendente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pesquisaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cliente_atendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cliente_atendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cliente_atendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cliente_atendente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cliente_atendente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pesquisar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JTextField cpf;
    private javax.swing.JTextField email;
    private javax.swing.JTextField idade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbcpf;
    private javax.swing.JLabel lbemail;
    private javax.swing.JLabel lbmatricula;
    private javax.swing.JLabel lbsalario;
    private javax.swing.JLabel lbtelefone;
    private javax.swing.JTextField matricula;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField pesquisa;
    private javax.swing.JRadioButton rbCliente;
    private javax.swing.JRadioButton rbFuncionario;
    private javax.swing.JTextField salario;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTable tabelaPessoa;
    private javax.swing.JTextField telefone;
    private javax.swing.ButtonGroup tipoPessoa;
    // End of variables declaration//GEN-END:variables
}
