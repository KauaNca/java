package JList;


import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class List extends JFrame {
    String[] paises = {"Brasil","Holanda","Japão"};
    JList lista = new JList(paises);
    JLabel imagem = new JLabel();
    
    public List(){
        lista.addListSelectionListener(e-> {
            imagem.setIcon(new ImageIcon(Imagem()));
        });
        add(BorderLayout.CENTER,imagem);
        add(BorderLayout.WEST,lista);
        Frame();
    }
    public Image Imagem(){
        int index = lista.getSelectedIndex();
        String nomePais = paises[index];
        ImageIcon pais = new ImageIcon(getClass().getResource(nomePais + ".png"));
        Image redimensionar = pais.getImage();
        Image imagemRedimensionada = redimensionar.getScaledInstance(250, 300, Image.SCALE_SMOOTH);
        return imagemRedimensionada;
    }
    public void Frame() {
        setSize(300, 300); // Ajuste do tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);}
    public static void main(String[] args){
        new List();
    }
}
