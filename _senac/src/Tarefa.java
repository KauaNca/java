/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kauan
 */
public class Tarefa implements Runnable {
    String nome;
    public Tarefa(String nome){
     this.nome = nome;   
    }
    @Override
    public void run() {
        int x = 0;
        while(x < 10){
            System.out.println(nome + " :" + x);
            x++;
        }
        
    }
    public static void  main(String[] args){
        Thread tarefa1 = new Thread(new Tarefa("TAREFA 1"));
        Thread tarefa2 = new Thread(new Tarefa("TAREFA 2"));
        
        tarefa1.start();
        tarefa2.start();
        
    }

    
}
