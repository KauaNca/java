/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kaua
 *
 * } */
import java.util.ArrayList;

public class Array_dois {

    // Declaração da variável pessoa como uma lista de Pessoa
    private ArrayList<Pessoa> pessoa; //está dizendo que só vai aceitar dados da classe pessoa para adicionar na lista

    // Construtor
    public Array_dois() {
        pessoa = new ArrayList<>(); // Inicializa a lista
    }

    // Método para adicionar uma pessoa à lista
    public void adicionarPessoa(Pessoa p) {
        pessoa.add(p);
    }

    // Método para obter a lista de pessoas
    public ArrayList<Pessoa> getPessoas() {
        return pessoa;
    }

    // Classe interna para representar Pessoa
    public static class Pessoa {

        private String nome;
        private int idade;

        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }
    }

    public static void main(String[] args) {
        Array_dois exemplo = new Array_dois();
        Pessoa p1 = new Pessoa("Alice", 30);
        Pessoa p2 = new Pessoa("Bob", 25);

        exemplo.adicionarPessoa(p1);
        exemplo.adicionarPessoa(p2);

        for (Pessoa p : exemplo.getPessoas()) {//perceba que está utilizando um variável do tipo objeto pessoa para entrar no array
            System.out.println("Nome: " + p.getNome() + ", Idade: " + p.getIdade());
        }

        /*É O MAIS COMPLICADO DE ENTEDER ESSE FOR-EACH
Criação da variável p: Dentro do laço for, você cria uma variável p do tipo Pessoa. 
        Essa variável representa cada objeto da classe Pessoa que está contido na lista pessoa.

Acesso à lista pessoa: O objeto exemplo, que é uma instância de Array_dois, tem acesso ao método getPessoas(). 
        Este método retorna a lista pessoa, que contém os objetos do tipo Pessoa.

Percorrendo a lista pessoa: O laço for-each percorre automaticamente todos os elementos da lista pessoa. 
        Em cada iteração, ele atribui um objeto Pessoa à variável p. Assim, p representa cada elemento da lista de forma sequencial.

Acesso aos atributos de cada Pessoa: Com cada Pessoa atribuída à variável p, 
        você consegue acessar os métodos getNome() e getIdade(), que retornam o nome e a idade do objeto Pessoa atual.

Então, de maneira resumida: O for percorre a lista pessoa, e a cada iteração, 
        p representa um objeto da lista, permitindo o acesso aos atributos nome e idade de cada Pessoa.
        
        
        Acho que se for imaginar seria algo assim
        
        Pessoa p vai entrar em exemplo.
        p = p1.getNome() //p1 Armazena o nome e idade: Alice, 30
        p = p2.getNome() // e assim continua
        
         */
    }
}
