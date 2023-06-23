/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;
import java.util.ArrayList;
/**
 *
 * @author guton
 */
public class Partida {
    private int id;
    private ArrayList<Integer> resultado;
    private boolean capote;
    private Participante p1, p2;
    private Participante vencedor;
    private Participante perdedor;
    
    Partida(){
        this.resultado = new ArrayList<>();
        this.capote = false;
    }
    
    Partida(int id, Participante p1,  Participante p2){
        this.id = id;
        this.resultado = new ArrayList<>();
        this.capote = false;
        this.p1 = p1;
        this.p2 = p2;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getResultado() {
        return resultado;
    }

    public boolean isCapote() {
        return capote;
    }

    public Participante getP1() {
        return p1;
    }

    public Participante getP2() {
        return p2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setResultado(ArrayList<Integer> resultado) {
        this.resultado = resultado;
        if(this.resultado.get(0) > this.resultado.get(1)){
            this.vencedor = this.p1;
            this.perdedor = this.p2;
        } else{
            this.vencedor = this.p2;
            this.perdedor = this.p1;
        }
    }

    public void setCapote(boolean capote) {
        this.capote = capote;
    }

    public void setP1(Participante p1) {
        this.p1 = p1;
    }

    public void setP2(Participante p2) {
        this.p2 = p2;
    }
    
    public Participante getVencedor(){
        return this.vencedor;
    }
    
    public Participante getPerdedor(){
        return this.perdedor;
    }
    
    
}
