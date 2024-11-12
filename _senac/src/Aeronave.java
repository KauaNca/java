
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author kauan
 */
public class Aeronave extends javax.swing.JFrame {

    /**
     * Creates new form Aeronave
     */
    public Aeronave() {
        initComponents();
        //DESATIVANDO OS CAMPOS
        subir_text.setEditable(false);
        aut_descer_text.setEditable(false);
        descer_text.setEditable(false);
        desligar_text.setEditable(false);
        
        
        check_text.setText("Não");
        aut_voar_text.setText("Não");
        ligar_text.setText("Não");
        subir_text.setText("Não");
        aut_descer_text.setText("Não");
        descer_text.setText("Não");
        desligar_text.setText("Não");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAut_voar = new javax.swing.JButton();
        btCheckList = new javax.swing.JButton();
        btLigar = new javax.swing.JButton();
        btAut_descer = new javax.swing.JButton();
        btSubir = new javax.swing.JButton();
        btDescer = new javax.swing.JButton();
        btDesligar = new javax.swing.JButton();
        check_text = new javax.swing.JTextField();
        aut_voar_text = new javax.swing.JTextField();
        ligar_text = new javax.swing.JTextField();
        descer_text = new javax.swing.JTextField();
        subir_text = new javax.swing.JTextField();
        aut_descer_text = new javax.swing.JTextField();
        desligar_text = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        btReiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btAut_voar.setText("Autorização_voar");
        btAut_voar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAut_voarMouseClicked(evt);
            }
        });

        btCheckList.setText("CheckList");
        btCheckList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCheckListMouseClicked(evt);
            }
        });

        btLigar.setText("Ligar");
        btLigar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btLigarMouseClicked(evt);
            }
        });

        btAut_descer.setText("Autorização_descer");
        btAut_descer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAut_descerMouseClicked(evt);
            }
        });

        btSubir.setText("Subir");
        btSubir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSubirMouseClicked(evt);
            }
        });

        btDescer.setText("Descer");
        btDescer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDescerMouseClicked(evt);
            }
        });

        btDesligar.setText("Desligar");
        btDesligar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDesligarMouseClicked(evt);
            }
        });

        check_text.setEnabled(false);

        aut_voar_text.setEnabled(false);

        ligar_text.setEnabled(false);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        btReiniciar.setText("Reiniciar");
        btReiniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btReiniciarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btAut_descer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAut_voar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLigar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCheckList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSubir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDescer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDesligar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aut_voar_text, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descer_text, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aut_descer_text, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(desligar_text, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(check_text, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ligar_text, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(subir_text, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addComponent(btReiniciar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCheckList)
                            .addComponent(check_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btLigar)
                            .addComponent(ligar_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAut_voar)
                            .addComponent(aut_voar_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSubir)
                            .addComponent(subir_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btReiniciar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAut_descer)
                            .addComponent(aut_descer_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDescer)
                            .addComponent(descer_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDesligar)
                            .addComponent(desligar_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCheckListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCheckListMouseClicked
        textArea.setText("CheckList: completo");
        check_text.setText("Sim");
    }//GEN-LAST:event_btCheckListMouseClicked

    private void btLigarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLigarMouseClicked
        if (check_text.getText().equals("Sim")) {
            textArea.setText("CheckList: completo \nLigado");
            ligar_text.setText("Sim");
        } else {
            JOptionPane.showMessageDialog(null, "Fazer check_list primeiro");
        }
    }//GEN-LAST:event_btLigarMouseClicked

    private void btAut_voarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAut_voarMouseClicked
        if (ligar_text.getText().equals("Sim")) {
            textArea.setText("CheckList: completo \nLigado \nVoar: Sim");
            aut_voar_text.setText("Sim");
            
        } else {
            JOptionPane.showMessageDialog(null, "Ligar a aeronave primeiro");
        }

    }//GEN-LAST:event_btAut_voarMouseClicked

    private void btSubirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSubirMouseClicked
        if (aut_voar_text.getText().equals("Sim")) {
            subir_text.setText("Sim");
            Timer tempo = new Timer();
            TimerTask tarefa = new TimerTask() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, "Subindo...");
                    textArea.setText("CheckList: completo \nLigado \nVoar: Sim \nSubiu");
                }
            };
            tempo.schedule(tarefa, 1500);
               

        } else {
            JOptionPane.showMessageDialog(null, "Autorização para voar");
        }
    }//GEN-LAST:event_btSubirMouseClicked

    private void btAut_descerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAut_descerMouseClicked
        if (subir_text.getText().equals("Sim")) {
            textArea.setText("CheckList: completo \nLigado \nVoar: Sim \nSubiu \nAutorização para descer: SIM");
            aut_descer_text.setText("Sim");
        } else {
            JOptionPane.showMessageDialog(null, "O avião tem que estar voando");
        }
    }//GEN-LAST:event_btAut_descerMouseClicked

    private void btDescerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDescerMouseClicked
        if (aut_descer_text.getText().equals("Sim")) {
            textArea.setText("CheckList: completo \nLigado \nVoar: Sim \nSubiu \nAutorização para descer: SIM \nDescer: Sim");
            descer_text.setText("Sim");
            Timer tempo = new Timer();
            TimerTask tarefa = new TimerTask() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, "Descendo...");
                    textArea.setText("CheckList: completo \nLigado \nVoar: Sim \nSubiu \nAutorização para descer: SIM \nDesceu");
                }
            };
            tempo.schedule(tarefa, 1500);
               

        } else {
            JOptionPane.showMessageDialog(null, "Autorização para descer");
        }
    }//GEN-LAST:event_btDescerMouseClicked

    private void btDesligarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDesligarMouseClicked
        if (descer_text.getText().equals("Sim") && ligar_text.getText().equals("Sim")) {
            textArea.setText("CheckList: completo \nLigado \nVoar: Sim \nSubiu \nAutorização para descer: SIM \nDesceu \nDesligado");
            desligar_text.setText("Sim");
        } else if (ligar_text.getText().equals("Não")) {
            JOptionPane.showMessageDialog(null, "O avião não está ligado");
        } else {
            JOptionPane.showMessageDialog(null, "O avião está voando");
        }
    }//GEN-LAST:event_btDesligarMouseClicked

    private void btReiniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btReiniciarMouseClicked
        check_text.setText("Não");
        aut_voar_text.setText("Não");
        ligar_text.setText("Não");
        subir_text.setText("Não");
        aut_descer_text.setText("Não");
        descer_text.setText("Não");
        desligar_text.setText("Não");
        textArea.setText("");
    }//GEN-LAST:event_btReiniciarMouseClicked

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
            java.util.logging.Logger.getLogger(Aeronave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aeronave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aeronave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aeronave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aeronave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aut_descer_text;
    private javax.swing.JTextField aut_voar_text;
    private javax.swing.JButton btAut_descer;
    private javax.swing.JButton btAut_voar;
    private javax.swing.JButton btCheckList;
    private javax.swing.JButton btDescer;
    private javax.swing.JButton btDesligar;
    private javax.swing.JButton btLigar;
    private javax.swing.JButton btReiniciar;
    private javax.swing.JButton btSubir;
    private javax.swing.JTextField check_text;
    private javax.swing.JTextField descer_text;
    private javax.swing.JTextField desligar_text;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ligar_text;
    private javax.swing.JTextField subir_text;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
