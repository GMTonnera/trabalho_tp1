/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
/**
 *
 * @author guton
 */
public class Partida {
    private int id, numJogos;
    private ArrayList<SimpleEntry> resultados;
    private ArrayList<Boolean> capotes;
    
    Partida(){
        this.resultados = new ArrayList<>();
        this.capotes = new ArrayList<>();
    }
    
    Partida(int id, int numJogos){
        this.id = id;
        this.numJogos = numJogos;
        this.resultados = new ArrayList<>();
        this.capotes = new ArrayList<>();
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getNumJogos(){
        return this.numJogos;
    }
    
    public void setNumJogos(int numJogos){
        this.numJogos = numJogos;
    }
    
    public ArrayList<SimpleEntry> get_Resultados(){
        return this.resultados;
    }
    
    public void set_Resultados(ArrayList<SimpleEntry> resultados){
        this.resultados = resultados;
    }
    
    public ArrayList<Boolean> getCapotes(){
        return this.capotes;
    }
    
    public void setCapotes(ArrayList<Boolean> capotes){
        this.capotes = capotes;
    }
    
    public void updateResultados(SimpleEntry resultado, Boolean capote){
        this.resultados.add(resultado);
        this.capotes.add(capote);
    }
    
    
    
    
    
}
