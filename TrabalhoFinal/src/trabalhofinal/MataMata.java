/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

import java.time.LocalDateTime;

/**
 *
 * @author guton
 */
public class MataMata extends Torneio{
    private TornamentTree chavesTorneio;
    
    MataMata(){
        super();
    }
    
    MataMata(String nome, String descricao, String local, LocalDateTime dataInicio, LocalDateTime dataFinal,
            LocalDateTime dataFimInscricoes, String regras, int id, int maxParticipantes, int numJogosPartida, Organizador organizador){
        
        super(nome, descricao, local, dataInicio, dataFinal, dataFimInscricoes, regras, id, maxParticipantes, numJogosPartida, organizador);
        this.chavesTorneio = new TornamentTree();            
    }
    
    public TornamentTree getChavesTorneio(){
        return this.chavesTorneio;
    }
    
    public void setChavesTorneio(TornamentTree chaves){
        this.chavesTorneio = chaves;
    }
    
    public void updateCgavesTorneio(){}
    
}
