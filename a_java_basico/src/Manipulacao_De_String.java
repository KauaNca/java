

public class Manipulacao_De_String{
    public static void main(String[] args) {
        //MANIPULAÇÃO DE STRINGS
        String nome = "Kauã Nunes"; //variável
        char primeira_letra = nome.charAt(1);
        String primeira_palavra = nome.substring(0, 4); /*0 -> começo, 4 -> fim da pesqusia*/
        String nome2 = "Caetano";
        int quantidade = nome.length();

        System.out.println(nome.concat(" Caetano")); //concatenar
        System.out.println(nome.contains("Kauã")); //se determinada variável possui tal palavra ou letra
        System.out.println(nome.equals("Kauã Nunes")); //saber se é igual
        System.out.println(primeira_letra);
        System.out.println(quantidade);
        System.out.println(primeira_palavra);
        System.out.println(nome.replace("Nunes", nome2)); //substituir
    }
}
