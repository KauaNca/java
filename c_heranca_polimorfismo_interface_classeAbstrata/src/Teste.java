/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kauan
 */
public class Teste {
    public static void main(String[] args) {
        //TESTANDO A CLASSE PESSOA
        //APÓS TORNAR ABSTRATA, NÃO PODE MAIS
        /*Pessoa p1 = new Pessoa("Kaua",21);
        p1.apresentar();*/
        
        //TESTANDO A HERANÇA DE FUNCIONÁRIO
        Funcionario f1 = new Funcionario("Kaua",21,"0000","Programador");
        f1.apresentar();
        f1.apresentacao(); //método abstrato de pessoa e implementado em funcionário
        
        //TESTANDO O MÉTODO DA INTERFACE
        f1.pagamento();
        
    }
}
