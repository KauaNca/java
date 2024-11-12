package a_java_basico;

public class Vetores_Matrizes {
    public static void main(String[] args) {
        //VETORES E MATRIZES JUNTO COM LAÇOS DE REPETIÇÃO

        /*fazendo aparecer nome na vertical*/
        String nome = "Kauã Nunes Caetano";
        for(int i = 0;i<nome.length();i++){
            System.out.println(nome.charAt(i));
        }

        //Deixando na horizontal, mas colocando | nos espaços
       String palavra = ""; //vai servir para colocar as letras na horizontal
        char caracter; //vai fazer a averiguação e saber se é um espaço ou não
        for (int i = 0; i<nome.length();i++){
            caracter = nome.charAt(i);
            if(caracter == ' '){
                palavra += " | "; //substitui o espaço por " | "
            }
            else{

                palavra += caracter;
            }
        }
        System.out.println(palavra);

        //USANDO VETORES AGORA
        //colocar as letras em cada índice
        String[] letras = new String[nome.length()];
        for (int i = 0; i < nome.length(); i++) {
            char caracter1 = nome.charAt(i);
            if (caracter1 == ' ') {
                letras[i] = " | ";  //substitui o espaço por " | "
            } else {
                letras[i] = Character.toString(caracter1); // Converte o char para String

            }
        }
        System.out.println(letras[0]+letras[1]+letras[2]+letras[3]);
        /*
        Em Java, usamos Character.toString() para converter um char em String.
        No JavaScript, você pode simplesmente usar toString() para fazer essa conversão.

        Ou seja, existe as outras conversões:
        Integer.toString(int value): Converte um int para String.
        Float.toString(float value): Converte um float para String.
        Boolean.toString(boolean value): Converte um boolean para String. E mais.
        */
    }
    //DECLARAÇÃO DE MATRIZES

    //String[] nomes = new String[][];
}
