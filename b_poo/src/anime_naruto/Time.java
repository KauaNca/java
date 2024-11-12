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
public class Time {
    private int numero;
    private ArrayList<Ninja> time = new ArrayList<>();
    
    //Para formar um time, precisa de 3 membros
    public Time(int numero,Ninja primeiro_ninja,Ninja segundo_ninja, Ninja terceiro_ninja){
        this.numero = numero;
        this.time.add(primeiro_ninja);
        this.time.add(segundo_ninja);
        this.time.add(terceiro_ninja);
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Ninja> getTime() {
        return time;
    }

    public void setTime(ArrayList<Ninja> time) {
        this.time = time;
    }
}
