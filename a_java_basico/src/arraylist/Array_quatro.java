/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraylist;

import java.util.ArrayList;

/**
 *
 * @author kauan
 */

/*
    No Array_tres, utilizei um construtur parametrizado com tipo objeto List<>, achei muito complicado.
Neste vou fazer a mesma coisa, mas só com ArrayList<>.

*/
public class Array_quatro {
    //Atributos do tipo lista. Estou indicando que estes atributos receberão dados e organizará em forma de lista. 
    //Um será do tipo tipo String, outro, Integer. 
    private ArrayList<String> nome = new ArrayList<>(); //só pode receber dado do tipo String; além disso, estou já inicializando a variável
    private ArrayList<Integer> idade = new ArrayList<>(); //só pode receber dado do tipo int

    public ArrayList<Integer> getIdade() {
        return idade;
    }

    public void setIdade(ArrayList<Integer> idade) {
        this.idade = idade;
    }
    
    public Array_quatro(String nome,int idade){
        this.nome.add(nome); //quando instanciar, vou adicionar os nomes e idades nos atributos nome e idade
        this.idade.add(idade);
    }
    public ArrayList<String> getNome(){
        return nome;
    }
    public void setNome(ArrayList<String> nome ){
        this.nome = nome;
    }
    
    //MESMA COISA DO CONSTRUTOR, MAS COMO MÉTODO
    public void adicionar(String nome, int idade){
        this.nome.add(nome);
        this.idade.add(idade);
    }
    
    //MÉTODO PARA PEGAR UM NOME ESPECÍFICO. O OUTRO PEGA TODOS
    public String pegarEspecifico(int indice){
       //está faltando um if aqui
        return nome.get(indice);
    }
    
    //ATUALIZANDO UM ARRAY
    public void atualizar(int indice,String novoNome){
        if(indice > 0 && indice<nome.size()){
            nome.set(indice, novoNome); //este é um método da Interface Collection, mas está dentro do ArrayList
        }
        else{
            System.out.println("Não foi possível fazer a mudança");
    }
    }
    //MÉTODO PARA SABER SE HÁ O NOME NO ARRAY
    public boolean consulta(String nome){
        return nome.contains(nome);
    }
    
    //MÉTODO PARA REMOVER UM NOME
    //Primeiro por meio de um índice
    public void removerIndice(int indice){
        nome.remove(indice);
    }
    
    public static void main(String[] args){
        Array_quatro novo = new Array_quatro("Kaua",18);
        System.out.println(novo.getNome());
        
        //adicionando
        novo.adicionar("Lum", 22);
        novo.adicionar("Isa", 24);
        
        System.out.println("MOSTRAR TODOS: " + novo.getNome());//Vai mostrar todos
        System.out.println("ESPECÍFICO: " + novo.getNome().get(1)); //pegar o nome no índice 1
        
        
        //atualizando
        System.out.println("ANTES DO SET: " + novo.getNome());//Vai mostrar todos
        
        novo.atualizar(2, "Barbara");
        
        System.out.println("DEPOIS DO SET: " + novo.getNome());
        
        //pegando especificamente
        System.out.println("ESPECIFICO UTILIZANDO FUNÇÃO: " + novo.pegarEspecifico(2));
        
        //consulta
        System.out.println("CONSULTA " + novo.consulta("Kaua"));
        
        //removendo por meio do índice
        System.out.println("Antes de remover: " + novo.getNome());
        novo.removerIndice(0);
        System.out.println("Depois de remover: " + novo.getNome());
        
        
        
        
    }
   
    
    
    
}
