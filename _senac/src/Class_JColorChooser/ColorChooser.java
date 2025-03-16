package JColorChooser;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorChooser extends JFrame{
    JColorChooser caixaDeCores = new JColorChooser();
    JLabel titulo = new JLabel("KAUÃ NUNES");
    public ColorChooser(){
        titulo.setFont(new Font("Arial",Font.BOLD,35));
        add(caixaDeCores);
        add(BorderLayout.NORTH,titulo);
        caixaDeCores.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                titulo.setForeground(caixaDeCores.getColor());
            }
        });
        Frame();
    }
    public ColorChooser(JPanel nome){
        Frame();
        caixaDeCores.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
               nome.setBackground(caixaDeCores.getColor());
            }
        });
    }
    public void Frame() {
        setSize(600, 600); // Ajuste do tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(caixaDeCores);
        setVisible(true);
    }
    public static void main(String[] args){
        new ColorChooser();
    }
}
