/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author kauan
 */
public class Poo {
    private String nome;
    private int idade;
    
    //CONSTRUTOR PADRÃO, APENAS PARA INICIALIZAR
    public Poo(){
        nome = "";
        idade = 0;
    }
    
    //CONSTRUTOR QUE AO INSTANCIAR, RECEBE DADOS
    public Poo(String nome,int idade){ //<- PARÂMETROS
        this.nome = nome;
        this.idade = idade;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    
    
    
}
