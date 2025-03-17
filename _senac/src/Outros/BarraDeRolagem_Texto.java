package barraDeRolagem;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

/*
O JScrollPane deve ser inicializado antes de chamar setVisible(true) no JFrame. 
Isso garante que todos os componentes sejam configurados e adicionados ao frame antes que ele seja exibido na tela.
Por isso não dá para colocar o da Imagem aqui também, pois ele apareceria na frente do textArea no Frame
*/
public class BarraDeRolagem_Texto extends JFrame {
    JTextArea quadrado;
    JScrollPane barraTexto;
    
    public BarraDeRolagem_Texto(){
        textArea(); // Inicializa o JTextArea e JScrollPane
        Frame(); // Configura o JFrame e o torna visível
    }
    
    // Scroll com TextArea
    public void textArea(){
        quadrado = new JTextArea(20, 50); // Instanciando JTextArea
        barraTexto = new JScrollPane(quadrado); //Colocando o ScrollPane no TextArea;
    }

    public void Frame(){
        setSize(900,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout()); // Usando BorderLayout para adicionar múltiplos componentes
        add(barraTexto, BorderLayout.CENTER); // Adicionando JScrollPane do JTextArea ao centro do JFrame
        setVisible(true); // Torna o JFrame visível
    }

    public static void main(String[] args){
        new BarraDeRolagem_Texto(); // Cria o frame e inicializa tudo no construtor
    }
}
