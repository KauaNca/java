/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package anime_naruto;

import java.util.ArrayList;

/**
 *
 * @author kauan
 */
public class Ninja extends Pessoa implements Tecnica{
    private String nomeCla;
    private String nomeVila;
    private String tecnica_principal;
    private ArrayList<String> tecnicas = new ArrayList<>();
    
    public Ninja(String nome, int idade,String nomeCla,String nomeVila,String tecnica_principal) {
        super(nome, idade); //vem de pessoa
        this.nomeCla = nomeCla;
        this.nomeVila = nomeVila;
        this.tecnica_principal = tecnica_principal;
        this.tecnicas.add(tecnica_principal);
    }
    
    public String getNomeCla() {
        return nomeCla;
    }

    public void setNomeCla(String nomeCla) {
        this.nomeCla = nomeCla;
    }

    public String getNomeVila() {
        return nomeVila;
    }

    public void setNomeVila(String nomeVila) {
        this.nomeVila = nomeVila;
    }
     
    public String getTecnica() {
        return tecnica_principal;
    }

    public void setTecnica(String tecnica) {
        this.tecnica_principal = tecnica;
    }

     public ArrayList<String> getTecnicas() {
        return tecnicas;
    }

    public void setTecnicas(ArrayList<String> tecnicas) {
        this.tecnicas = tecnicas;
    }
    @Override
    public void tecnicas(String tecnicas) {
        this.tecnicas.add(tecnicas);
    }
}
