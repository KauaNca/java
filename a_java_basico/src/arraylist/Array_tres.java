
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

/*
    EXEMPLO UTILIZANDO A INTERFACE LIST<> COM CONSTRUTOR DE PARÂMETROS DO TIPO LIST<>, GET E SETTER.
    OPINÃO: DIFÍCIL. É MAIS FÁCIL UTILIZAR O TIPO OBJETO ARRAYLIST<>, QUE É MENOS TRABALHOSO,
APESAR DE DIZEREM QUE USAR LIST<> É MELHOR POIS HÁ A OPORTUNIDADE DE MUDAR PARA ARRAYLIST, LINKEDLIST E MAIS.
O QUE COMPLICA MUITO É O CONSTRUTOR, SÓ PODE PASSAR VARIÁVEL INSTANCIADAS DO MESMO TIPO PARA ELE.
*/
public class Array_tres {
    private List<String> nome = new ArrayList<>();
    private List<Integer> idade = new ArrayList<>();

    public List<String> getNome() {
        return nome;
    }

    public void setNome(List<String> nome) {
        this.nome = nome;
    }

    public List<Integer> getIdade() {
        return idade;
    }

    public void setIdade(List<Integer> idade) {
        this.idade = idade;
    }
    
    /*Está é uma forma de contrutor utilizando List; é a mais complicada
        Com este construtor, não pode passar tipos primitivos como eu fazia
            Array_tres n1 = new Array_tres("Kauã",21);
        Precisa ser uma variável de mesmo tipo para este construtor funcionar;
    
        Por isso que no MAIN abaixo, criei dois objetos do tipo List<String>, e depois
        cria-se uma instância da classe Array_tres, pois os objetos criados irão ser jogados
        para o construtor já que são do mesmo tipo.
    */
    public Array_tres(List<String> nome,List<Integer> idade){
        this.nome = nome;
        this.idade = idade;
    }
    
    public static void main(String[] args){
        List<String> kaua = new ArrayList<>();
        kaua.add("Kauã");
        kaua.add("Isabela");
        kaua.add("Laika");
        
        List<Integer> kaua_idade = new ArrayList<>();
        kaua_idade.add(21);
       
        
        Array_tres animal = new Array_tres(kaua,kaua_idade);
        System.out.println("EX.1" + animal.getNome()); //dessa forma ele retornará todos os resultados dentro do atributo nome dentro de animal
        
        //PEGANDO ESPECIFICAMENTE
        for(int x = 0;x <kaua.size();x++){
            System.out.println("Nome: " + animal.getNome().get(0));
            System.out.println("Idade: " + animal.getIdade().get(0));
        };
        //precisa ser animal.getNome().get(0) -> o getNome() retornara o atributo nome, e como ele é um atributo List<String>, pode
        //utilizar get();
        
        //perceba que no primeiro System.out, ele só retornou o primeiro que estava dentro de nome;
        
        
        //Testando o set -> tenho que fazer outra instância pois ele só aceita deste jeito;
        List<String> an = new ArrayList<>();
        an.add("Lum");
        an.add("Luiz");
       
        animal.setNome(an);
        
        //depois do set substitui todos os nomes que estavam dentro
        System.out.println(animal.getNome().get(0));
        System.out.println(animal.getNome().get(1));
        
        //pegando todos
        System.out.println(animal.getNome());
    }
}

