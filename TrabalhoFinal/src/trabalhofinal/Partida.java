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
/*
CLASSE Participante --> Classe responsável por representar uma partida de sinuca
                        entre dois participantes. Obs.: um capote é quando um 
                        jogador vence a partida sem que seu adversário derrube
                        nenhuma bola;
    

    ATRIBUTO id: Variável privada do tipo int a qual armazena o id da partida;
    
    ATRIBUTO resultado: Variável privada do tipo ArrayList<Integer> a qual
armazena o resultado da partida;
    
    ATRIBUTO capote: Variável privada do tipo boolean a qual armazena se ocorreu
capote na partida;
    
    ATRIBUTO p1: Variável privada do tipo Participante a qual armazena o 
participante 1;

    ATRIBUTO p2: Variável privada do tipo Participante a qual armazena o 
participante 2;
    
    ATRIBUTO vencedor: Variável privada do tipo Participante a qual armazena
o vencedor da partida;
    
    ATRIBUTO perdedor: Variável privada do tipo Participante a qual armazena
o perdedor da partida;
    

    MÉTODO Partida(): Construtor Padrão;
    
    MÉTODO Partida(int id, ..., Participante p2): Construtor que incializa os
atributos da classe pai e os participantes;
    

    MÉTODO getId:  Retorna o valor de id;
    
    MÉTODO getResultado: Retorna o resultado da partida;

    MÉTODO getP1: Retorna o participante 1; 
    
    MÉTODO getP2:  Retorna o participante 2;

    MÉTODO setId: Atribui um novo valor a id; 

    MÉTODO setResultado: Atribui um novo valor ao resultado; 
    
    MÉTODO setCapote: Atribui um novo valor a capote;
    
    MÉTODO setP1: Atribui um novo valor a p1; 
    
    MÉTODO setP2:  Atribui um novo valor a p2;
    
    MÉTODO getVencedor:  Retorna o vencedor da partida;
    
    MÉTODO getPerdedor:  Retorna o perdedor da partida;
 
*/

public class Partida {
    private int id;
    private ArrayList<Integer> resultado = new ArrayList();
    private boolean capote;
    private Participante p1, p2;
    private Participante vencedor = new Participante(-1);
    private Participante perdedor = new Participante(-1);
    
    public Partida(){
        this.resultado = new ArrayList<>();
        this.capote = false;
    }
    
    Partida(int id, Participante p1,  Participante p2){
        this.id = id;
        this.p1 = p1;
        this.p2 = p2;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getResultado() {
        return resultado;
    }

    public boolean getCapote() {
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
        if(this.resultado.get(1) != this.resultado.get(0)){
            if(this.resultado.get(0) > this.resultado.get(1)){
                this.vencedor = this.p1;
                this.perdedor = this.p2;
            } else if(this.resultado.get(0) < this.resultado.get(1)){
                this.vencedor = this.p2;
                this.perdedor = this.p1;
            }
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
        if(this.vencedor.getId() == -1 && this.resultado.get(1) != this.resultado.get(0)){
            if(this.resultado.get(0) > this.resultado.get(1)){
                this.vencedor = this.p1;
                this.perdedor = this.p2;
            } else{
                this.vencedor = this.p2;
                this.perdedor = this.p1;
            }
        }
        return this.vencedor;
    }
    
    public Participante getPerdedor(){
        if(this.perdedor.getId() == -1 && this.resultado.get(1) != this.resultado.get(0)){
            if(this.resultado.get(0) > this.resultado.get(1)){
                this.vencedor = this.p1;
                this.perdedor = this.p2;
            } else{
                this.vencedor = this.p2;
                this.perdedor = this.p1;
            }
        }
        
        return this.perdedor;
    }
    
    
}
