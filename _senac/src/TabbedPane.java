
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPane extends JFrame {

    //Criação de abas no frame
    //É só um teste, por isso o JPanel estão vazios

    JTabbedPane abas = new JTabbedPane();
    JPanel painelVermelho = new JPanel();
    JPanel painelAzul = new JPanel();
    JPanel painelVerde = new JPanel();

    public TabbedPane() {
        painelVermelho.setBackground(Color.red);
        painelAzul.setBackground(Color.blue);
        painelVerde.setBackground(Color.green);
        add(abas);
        abas.add("Painel Vermelho", painelVermelho);
        abas.add("Painel Azul", painelAzul);
        abas.add("Painel Verde", painelVerde);
        
        //Dá para brincar com métodos do TabbedPane
        
        abas.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int numero_aba = abas.getSelectedIndex();
                String titulo_aba = abas.getTitleAt(numero_aba); // utilizando a variável anterior pois essa só consegue por meio de um inteiro
                
                System.out.println("INDEX DA ABA: " + numero_aba + "| TITULO: " + titulo_aba);
            }
        });
        Frame();
    }

    public void Frame() {
        setSize(500, 500); // Ajuste do tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TabbedPane();
    }
}
