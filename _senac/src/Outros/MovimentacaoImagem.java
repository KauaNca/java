/* * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template */ package imagemMovimentacao;

import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MovimentacaoImagem extends JFrame {

    JLabel carro = new JLabel(imagem("carro.gif"));

    public MovimentacaoImagem() {
        editarFrame();
        new Movimentar().start();
    }

    public ImageIcon imagem(String imagem) {
        ImageIcon imagemOriginal = new ImageIcon(getClass().getResource("carro.gif"));
        if (imagemOriginal.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.out.println("Erro ao carregar a imagem");
        } else {
            System.out.println("Imagem carregada com sucesso");
        }
        Image pegarImagem = imagemOriginal.getImage();
        int largura = 100;
        int altura = 100;
        Image imagemRedimensionando = pegarImagem.getScaledInstance(largura, altura, Image.SCALE_DEFAULT);
        ImageIcon imagemRedimensionada = new ImageIcon(imagemRedimensionando);
        return imagemRedimensionada;
    }

    public void editarFrame() {
        setSize(1400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        carro.setBounds(0, 0, 100, 100);
        add(carro);
        setVisible(true);
    }
    public class Movimentar extends Thread{
        public void run(){
            while(true){
                try{
                    sleep(10);
                    if(carro.getX()<1300){
                       carro.setBounds(carro.getX()+10,0,100,100);
                    }
                }
                catch(Exception e){
                    
                }
            }
        }
    }

    public static void main(String[] args) {
        new MovimentacaoImagem();
    }
}
