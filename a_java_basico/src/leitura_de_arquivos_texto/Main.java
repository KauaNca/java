/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leitura_de_arquivos_texto;

/**
 *
 * @author kauan
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> texto = new ArrayList<>();

        try {
            FileInputStream is = new FileInputStream("C:\\Users\\kauan\\OneDrive\\Área de Trabalho\\programacao\\meus_estudos\\backend\\java\\a_java_basico\\src\\leitura_de_arquivos_texto/nome_idade.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String linha = br.readLine();

            while (linha != null) {
                texto.add(linha); // Adiciona a linha à lista
                System.out.println(linha);
                linha = br.readLine();
            }
            br.close();
            isr.close();
            is.close();

            OutputStream os = new FileOutputStream("lista.txt");
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            for (int x = 0; x < texto.size(); x++) { // Corrigido para x < texto.size()
                String cadastro = texto.get(x);
                bw.write(cadastro);
                bw.newLine(); // Adiciona uma nova linha após cada cadastro
            }

            bw.close(); // Fecha o BufferedWriter
            osw.close();
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
    O que Acontece Dentro do while
Leitura da Linha:

String linha = br.readLine();

Antes do while loop, uma linha é lida do arquivo e armazenada na variável linha.

readLine() retorna a próxima linha do arquivo ou null se o fim do arquivo for alcançado.

Condição do while:

while (linha != null)

O while loop continua a iterar enquanto linha não for null.

Divisão da Linha em Tokens:

texto = linha.split(",");

Dentro do loop, a linha lida é dividida em tokens separados por vírgulas e armazenados no array texto.

split(",") divide a string em um array de strings, usando a vírgula como delimitador.

Impressão da Linha:

System.out.println(linha);

A linha completa é impressa no console.

Leitura da Próxima Linha:

linha = br.readLine();

Lê a próxima linha do arquivo e atualiza a variável linha.

O loop repete até que readLine() retorne null, indicando o fim do arquivo.

Fechamento dos Streams:

br.close();, isr.close(); e is.close();

Após sair do loop, todos os streams de leitura são fechados para liberar recursos.
 */
