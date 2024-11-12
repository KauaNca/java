/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_venda;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kauan
 */
public class Carrinho {
    private ArrayList<Produto> produtos;
    
    public Carrinho(){
        produtos = new ArrayList<>();
    }
    public void adicionarProduto(Produto p){
        produtos.add(p);
    }
    public void removerProduto(Produto p){
        for(Produto procurar : produtos){
            if(procurar.equals(p)){
                produtos.remove(p);
            }
            else{
                JOptionPane.showMessageDialog(null, "Produto não encontrado");
            }
        }
    }
   
      public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public void mostrarDetalhes(){
        for(Produto p : produtos){
            System.out.println("PRODUTO: " + p.getNome() + " | VALOR: " + p.getValor()); 
/*como a classe Produto é pública, está na mesma pasta, 
a variável que vai entrar no loop é do objeto produto, 
é possível usar os métodos de Produto.
Se fosse em outra pasta, teria que importa.
Se Carrinho quiser usar, terá que herdar.
*/
        }
    }
}
