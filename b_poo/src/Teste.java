/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author kauan
 */
public class Teste {

    public static void main(String[] args) {
        Poo p1 = new Poo(); //Usando construtor simples
        p1.setNome("Kaua");
        System.out.println(p1.getNome());
        
        Poo p2 = new Poo("Kaua",18); //construtor parametrizado
        System.out.println(p2.getNome() + " e " + p2.getIdade());
        
    }
    
}
