
import java.util.Scanner;

public class Excecoes {

    public void exemplo1() throws Exception {
        System.out.println("Testar o método");
    }

    public void exemplo2() {
        //exemplo1(); //está forcando que você use o THROW ou faça try,catch
    }

    public static void exemplo3() {

        boolean novoCalculo = false;
        Scanner leitor = new Scanner(System.in);
        do {
            try {
                System.out.println("Digite o primeiro número:");
                int n1 = leitor.nextInt();
                leitor.nextLine(); // Consumir a nova linha
                System.out.println("Digite o segundo número:");
                int n2 = leitor.nextInt();
                leitor.nextLine(); // Consumir a nova linha
                int divisao = n1 / n2;
                System.out.println("Resultado da divisão: " + divisao);

            } catch (Exception e) {//pegando a exceção dentro do loop para que não saia
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
            System.out.println("Novo Cálculo? (S/N): ");
            String resposta = leitor.nextLine().toUpperCase();
            novoCalculo = resposta.equals("S"); //comparação. Se resposta for igual S, o equals dará true a novo cálculo e assim continuar o Loop. equals é o mesmo que o operador ==.
        } while (novoCalculo);
        leitor.close();

    }

    public static void main(String args[]) {
        exemplo3();
    }
}
