/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anime_naruto;

/**
 *
 * @author kauan
 */
public class Main {
    public static void main(String[] args){
        //TESTANDO
        Ninja Naruto = new Ninja("Naruto",17,"Uzumaki","Aldeia da Folha","Multi-Clones da Sombra"); //instanciando
        System.out.println("Nome: "+Naruto.getNome()); 
//mesmo usando o construtor de Ninja, é possível puxar o nome por meio do método de Pessoa já que se Ninja herda dela, o objeto dele também pode
        System.out.println("Tecnica Principal: " + Naruto.getTecnica()); //método de Ninja
        Naruto.tecnicas("Rasengan"); //adicionando mais técnicas dentro do Array
        Naruto.tecnicas("Rasenshuriken");
        System.out.println("Tecnicas: " + Naruto.getTecnicas()); //puxando todas dentro do Array
        
        //TIME SETE
        Ninja Sasuke = new Ninja("Sasuke",17,"Uchiha","Aldeia da Folha","Chidori");
        Ninja Sakura = new Ninja("Sakura",17,"Haruno","Aldeia da Folha","Força bruta");
        Time time_sete = new Time(7,Naruto,Sasuke,Sakura); //passei os objetos no construtor de Time
        System.out.println("Time: "+time_sete.getNumero()); //método de Time
        System.out.println("\nMembros: ");
        for (Ninja ninja : time_sete.getTime()) { System.out.print(ninja.getNome() + " ");}
        System.out.println("\nTécnicas: ");
        for(Ninja ninja: time_sete.getTime()){System.out.print(ninja.getTecnicas() + " ");}
        
        
        //TIME AREIA
        Ninja Gaara = new Ninja("Gaara",15,"Deserto","Aldeira da Areia","Areia");
        Ninja Temari = new Ninja("Temari", 18, "Deserto", "Aldeia da Areia", "Vento"); 
        Ninja Kankuro = new Ninja("Kankuro", 19, "Deserto", "Aldeia da Areia", "Marionetes");
        
        Time time_areia = new Time(1,Gaara,Temari,Kankuro);
        System.out.print("\nTime: "+time_areia.getNumero() + " Nomes: ");
        for(Ninja ninja : time_areia.getTime()){
            System.out.print(ninja.getNome() + " ");
        }
        
}
}
