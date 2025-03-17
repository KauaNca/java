package a_java_basico;

public class Metodos {
    //TIPOS DE MÉTODOS
    //SEM RETORNO = VOID = sem a palavra return
    /*1 - MÉTODO SEM RETORNO E SEM PARÂMETRO (Usam a palavra VOID e
            executa uma ação específica)*/

    public void imprimirMensagem(){
        System.out.println("Olá, mundo!"); //apesar de ter uma saída, não representa um return
    }

    //2º MÉTODO SEM RETORNO, MAS COM PARÂMETRO (Executa uma ação específica usando valores fornecidos.)

    public void imprimirMensagem(String texto) {
        System.out.println(texto + ",olá");
    }

    //3º MÉTODO COM RETORNO, MAS SEM PARÂMETROS (Retorna um valor calculado ou armazenado.)

    public int numero(){
        return 42; //somente return, não aparece nada
    }

    //4º MÉTODO COM RETORNO E COM PARÂMETROS

    public int numero(int a,int b){
        return a + b;
    }

    // 5º MÉTODOS ESTÁTICOS
    //  Significa que o método ou variável pertence à classe, e não a instâncias individuais da classe.
    /*
        Acesso: Pode ser chamado sem criar uma instância da classe.
        Utilização: Ideal para utilitários ou funções que não dependem de variáveis de instância.
    */

    public static void main(String[] args) {
        Metodos metodo = new Metodos();
        metodo.imprimirMensagem();
        metodo.imprimirMensagem("Kauã");
        metodo.numero();
        metodo.numero(1,2);
    }
}
