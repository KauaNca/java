/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panel;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Desenho extends JFrame {

    public Desenho() {
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paintComponents(g);
        g.drawLine(0, 0, 500, 500); //desenhar uma linha
        g.setColor(Color.red); //define a cor que vai afetar as próximas linhas de desenho
        g.drawRect(50, 100, 400, 400); //desenhar um retângulo
        
        //há outros métodos como desenhar um Oval, o de preencher(fill)
        /*
            x1: 10 - a coordenada X do ponto inicial da linha.

            y1: 100 - a coordenada Y do ponto inicial da linha.

            x2: 500 - a coordenada X do ponto final da linha.

            y2: 500 - a coordenada Y do ponto final da linha.
        
        Eu entendi x1 e y1 em qual parte da tela vai começar. Enquanto x2 e y2 é
        o horizont
        
        Aqui, o eixo X aumenta à medida que você se move para a direita e o 
        eixo Y aumenta à medida que você se move para baixo.

        Então, em gráficos de computador, 
        você está efetivamente trabalhando no que parece ser uma variação do 1º quadrante do sistema de coordenadas cartesiano padrão, 
        mas com o eixo Y invertido.
         */
    }

    public static void main(String[] args) {
        new Desenho();
    }
}
