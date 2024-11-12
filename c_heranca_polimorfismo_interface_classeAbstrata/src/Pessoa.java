/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public abstract class Pessoa { //<- COLOCANCO ABSTRACT, NÃO SE CONSEGUE MAIS INSTANCIAR ESTA CLASSE
    //ATRIBUTOS
    private String nome;
    private int idade;
    
    //CONSTRUTOR
    
    /*VÊ-SE UM CASO DE DE POLIMORFISMO DO TIPO SOBRECARGA. HÁ UM CONSTRUTOR
    DE PESSOA INICIALIZANDO OS ATRIBUSO E OUTRO COM PARÂMETROS.
    APESAR DE TER O MESMO NOME, O JAVA ACEITA POIS ENTENDE QUE É DIFERENTE O MÉTODO
    */ 
    public Pessoa(String nome,int idade){
        this.nome = nome;
        this.idade = idade;
    }
    
    public Pessoa(){
        nome = "";
        idade = 0;
    }
    /*
    Exemplo de que poderia ter um método que só passasse o nome
    public Pessoa(String nome){
        this.nome nome;
    }
    */
//
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
    
    
    public void apresentar(){
        System.out.println(nome);
        System.out.println(idade);
    }
    
    //MÉTODO ABSTRATO: OBRIGA QUEM HERDA ESTA CLASSE A FAZER UM POLIMORFISMO DE SOBRESCRITA
    //Fazer um método que para quem herde, tenha um método que só mostre os atributos daquela classe
    public abstract void apresentacao();
    
}
