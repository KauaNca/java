
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author kauan
 */
public class Array {
    
//CRIAR UM MÉTODO PARA PECORRER ARRAYLIST
    public void pecorrer(ArrayList<String> nome){ 
        /*
            o pega é o parâmetro
        Quando instanciar, a variável será do tipo ArrayList<String>, então,
        a variável nome aqui tem que ser do mesmo tipo para que possa receber o dado de mesmo tipo.
        ArrayList<String> nome dever ser = ArrayList<String> n1
        
        */
    for (int i = 0; i < nome.size(); i++) {
            System.out.println(nome.get(i));
        };

}
    
    public static void main(String[] args) {
       ArrayList<String> n1 = new ArrayList<>();
        Array n2 = new Array(); //fazer outra variável para que se possa utilizar o método pecorrer() e colocar n1;
        
        n1.add("Kauã");
        n1.add("Andressa");
        n1.add("Bruno");
        n1.add("Camila");
        n1.add("Daniel");
        n1.add("Fernanda");
        n1.add("Gabriel");
        n1.add("Helena");
        n1.add("Isabela");
        n1.add("João");
        n1.add("Laura");
        n1.add("Mariana");
        n1.add("Nicolas");
        n1.add("Olivia");
        n1.add("Pedro");
        n1.add("Rafaela");
        n1.add("Sofia");
        n1.add("Thiago");
        n1.add("Vitória");
        n1.add("Yasmin");

        System.out.println(n1.get(10));//vai imprimir Laura
        n2.pecorrer(n1);

        
    }
    }
