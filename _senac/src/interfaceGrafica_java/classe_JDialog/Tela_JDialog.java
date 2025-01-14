/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaceGrafica_java.classe_JDialog;

import javax.swing.*;
import java.awt.event.*;

public class Tela_JDialog {
    public static void main(String[] args) {
        // Criando a janela principal
        JFrame frame = new JFrame("Janela Principal");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Botão para abrir o JDialog
        JButton button = new JButton("Abrir Diálogo");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Criando o JDialog
                JDialog dialog = new JDialog(frame, "Diálogo", true);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(frame);

                // Adicionando um botão de OK ao JDialog
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
                });

                // Adicionando o botão ao painel do diálogo
                JPanel panel = new JPanel();
                panel.add(okButton);
                dialog.add(panel);

                // Exibindo o diálogo
                dialog.setVisible(true);
            }
        });

        // Adicionando o botão à janela principal
        frame.getContentPane().add(button);
        frame.setVisible(true);
    }
}

