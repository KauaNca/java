
import javax.swing.JOptionPane;

public class Tarefa2 {
    int segundos;
    

    public Tarefa2() {
        Tempo tempo = new Tempo();
        tempo.start();
        perguntas();
        tempo.interrupt(); // Interrompe a thread de contagem
        String tempoFormatado = String.valueOf(segundos); 
        JOptionPane.showMessageDialog(null, "Tempo para responder: " + tempoFormatado + " segundos");
    }

    public void perguntas() {
        JOptionPane.showInputDialog(null, "Quantos anos tem?");
        JOptionPane.showInputDialog(null, "Em que ano nasceu?");
    }

    public class Tempo extends Thread { //fazendo uma classe dentro de outra para utilizar uma Thread. Dessa forma pode fazer várias tarefas
        public void run() {
            segundos = 0;
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(1000); // Dorme por 1 segundo. Por isso não precisa de conversão
                    segundos++;
                }
            } catch (InterruptedException e) {
                // Thread interrompida
            }
        }
    }

    public static void main(String[] args){
        new Tarefa2();
    }
}
