
import java.util.Timer;
import java.util.TimerTask;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kauan
 */
public class Timer_timerTask {
    
    //FAZER COM ATRASO
    public void simulacao(){
        Timer tempo = new Timer();
        TimerTask tarefa = new TimerTask(){
            public void run(){
                System.out.println("Codigo funcionando");
        }
            
        };
        tempo.schedule(tarefa, 2000);
    }
    //COM TEMPO INFINITO, MAS CANCELANDO
    public void simulacao_dois(){
        Timer tempo = new Timer();
        TimerTask tarefa = new TimerTask(){
            public void run(){
                System.out.println("Codigo funcionando");
        }
            
        };
        tempo.scheduleAtFixedRate(tarefa, 2000, 2000);
        
        //CANCELANDO, SENÃO FICA INFINITO
        new Timer().schedule(new TimerTask(){//ISSO É FUNÇÃO ANÔNIMA, POIS COMO SÓ VOU USAR SOMENTE UMA VEZ, NÃO É NECESSÁRIO VARIÁVEL PARA ARMAZENAR
            public void run(){
                tempo.cancel();
            }
        }
    ,10000);
    }
    public static void main(String[]args){
        //TESTANDO
            Timer_timerTask novo = new Timer_timerTask();
            novo.simulacao();
            novo.simulacao_dois();
    }
}
