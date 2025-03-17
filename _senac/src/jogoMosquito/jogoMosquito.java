package jogoMosquito;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Utilização do Math.random();
public class jogoMosquito extends JFrame {
    ImageIcon mosquitoV = new ImageIcon(getClass().getResource("mosquito.gif"));
    ImageIcon mosquitoF = new ImageIcon(getClass().getResource("mosquitoMorto.png"));
    ImageIcon paredeFundo = new ImageIcon(getClass().getResource("parede.jpg"));
    JLabel mosquito = new JLabel(mosquitoV);
    JLabel parede = new JLabel(paredeFundo);
    int posicaoX = (int) (Math.random() * 950); 
    int posicaoY = (int) (Math.random() * 850);
    
   
    public jogoMosquito(){
        editarJanela();
        mosquito();
        
    }
    public void editarJanela(){       
        setSize(1000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add(mosquito);
        add(parede);
        
    }
    public void mosquito(){
        mosquito.setBounds(posicaoX,posicaoY,270,361);
        mosquito.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mosquito.setIcon(mosquitoF);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
    }
    public static void main(String[] args){
        new jogoMosquito();
    }
}
