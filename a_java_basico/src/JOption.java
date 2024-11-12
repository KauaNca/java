/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

import javax.swing.JOptionPane;

/**
 *
 * @author Kaua33500476
 */
public class JOption {

    public void aparecerMensagem() {
        JOptionPane.showMessageDialog(null, "Mensagem apareceu", "Teste", JOptionPane.INFORMATION_MESSAGE);
    }

    public int confirmacao() {
        return JOptionPane.showConfirmDialog(null, "Você confirma?", "Confirmação", JOptionPane.YES_NO_OPTION);
    }

    public String entradaDados() {
        return JOptionPane.showInputDialog("Digite seu nome?");
        //para armazenar, tem que ser uma variável do mesmo tipo do método
    }

    public String variasOpcoes() {
        Object[] options = {"Sim", "Não", "Cancelar"};
        int resposta = JOptionPane.showOptionDialog(null, "Você confirma?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        return String.valueOf(resposta);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        JOption n1 = new JOption();

        //TESTANDO O CONFIRM DIALOG
        //RESPOSTA = 0 = true
        //RESPOSTA = 1 = false
        /*int resposta = n1.confirmacao();
        System.out.println(resposta);*/

        /*String resposta_dois = n1.entradaDados();
        System.out.println(resposta_dois);*/

        String resposta_tres = n1.variasOpcoes();
        System.out.println(resposta_tres);

    }
}
