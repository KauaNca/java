/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author kauan
 */
public class Funcionario extends Pessoa implements Pagamento{ //<- acesso aos atributos e métodos de pessoa quando instaciar
    String codigo;
    String cargo;
    
    // Construtor da classe derivada
    // Aqui é um exemplo de POLIMORFISMO DO TIPO SOBRESCRITA
    public Funcionario(String nome, int idade, String codigo, String cargo) {
        super(nome, idade); // Chama o construtor da classe base (Pessoa)
        this.codigo = codigo;
        this.cargo = cargo;
    }
    
    // Aqui um exemplo de sobrescrita de um método
    @Override
    public void apresentar(){
        super.apresentar(); // chama o método apresentar de pessoa
        System.out.println(codigo);
        System.out.println(cargo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    //APÓS COLOCAR PESSOA COMO CLASSE ABSTRATA E TENDO UM MÉTODO ABSTRATO, TEM QUE IMPLEMENTAR AQUI
    public void apresentacao() {
        System.out.println("CARGO: "+cargo + " CÓDIGO: "+codigo );
    }
    
    //MÉTODO DA INTERFACE PAGAMENTO
    @Override
    public void pagamento() {
        System.out.println("Pagamento à vista");
    }
}
