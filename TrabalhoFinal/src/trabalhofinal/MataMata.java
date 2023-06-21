/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author guton
 */
public class MataMata extends Torneio implements gerenciarTorneio{
    private TornamentTree chavesTorneio;
    
    MataMata(){
        super();
    }
    
    MataMata(String nome, String descricao, String local, LocalDate dataInicio, LocalDate dataInicioInscricao,int periodoTorneio, int periodoInscricao, 
            String regras, int id, int minParticipantes, int maxParticipantes, int numJogosPartida, Organizador organizador){
        
        super(nome, descricao, local, dataInicio, dataInicioInscricao, periodoTorneio, periodoInscricao, regras, id, minParticipantes, maxParticipantes, numJogosPartida, organizador);
        this.chavesTorneio = new TornamentTree();            
    }
    
    public TornamentTree getChavesTorneio(){
        return this.chavesTorneio;
    }
    
    public void setChavesTorneio(TornamentTree chaves){
        this.chavesTorneio = chaves;
    }
    
    public void atualizarPontuacao(){};
    
    public void setResultadoPartida(ArrayList<int[]> resultados, ArrayList<Boolean> capotes){};
    
    
    public Partida getProximaPartida(){
        return new Partida();
    };
    
    public Participante getCampeao(){
        return new Participante();
    };
    
}
