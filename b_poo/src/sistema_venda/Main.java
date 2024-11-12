/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_venda;

/**
 *
 * @author kauan
 */
public class Main {
    public static void main(String[] args){
        Produto cafe = new Produto("Café", "Café moído especial", 25.50f); 
        Produto chocolate = new Produto("Chocolate", "Chocolate amargo 70%", 15.90f); 
        Produto livro = new Produto("Livro", "Romance de ficção científica", 39.99f);
        
        Carrinho kaua = new Carrinho();
        kaua.adicionarProduto(cafe);
        kaua.adicionarProduto(chocolate);
        kaua.adicionarProduto(livro);
        
        System.out.println(kaua.getProdutos());//dessa forma só vai aparecer os objetos em si
        kaua.mostrarDetalhes();
    }
}
