/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author guton
 */
public class MataMata extends Torneio implements gerenciarTorneio{
    private ArrayList<Participante> participantesAtuais = new ArrayList();
    
    MataMata(){
        super();
    }
    
    MataMata(String nome, String descricao, String local, LocalDate dataInicio, LocalDate dataInicioInscricao,int periodoTorneio, int periodoInscricao, 
            String regras, int id, Organizador organizador){
        
        super(nome, descricao, local, dataInicio, dataInicioInscricao, periodoTorneio, periodoInscricao, regras, id, 9, 16, 1, organizador);           
        this.numPartidas = 15;
    }
      
    public void setResultadoPartida(ArrayList<Integer> resultado, Boolean capote){
        Partida p = this.partidas.get(this.partidaAtual);
        p.setResultado(resultado);
        p.setCapote(capote);
        this.participantesAtuais.add(p.getVencedor());
        if(this.partidaAtual < this.numPartidas){
            this.partidaAtual++;
        } 
    };
    
    
    public Partida getProximaPartida(){
        return this.partidas.get(this.partidaAtual);
    };
    
    public Participante getCampeao(){
        return this.partidas.get(14).getVencedor();
    };
    
    public void generateOitavasFinal(){
        Collections.shuffle(this.participantes);
        if(this.participantes.size() < 16){
            for(int i = 0; i < 16 - this.participantes.size(); i++){
                this.participantes.add(new Participante(-1, "loser", "loser", "loser", "loser"));
            }
        }
        for(int i = 0; i < 16; i=i+2){
            Partida p = new Partida(TrabalhoFinal.currentPartidaId, this.participantes.get(i), this.participantes.get(i+1));
            this.partidas.add(p);
            TrabalhoFinal.currentPartidaId++;
        }
    }
    
    public void generateQuartasFinal(){
        for(int i = 0; i < 7; i=i+2){
            Partida p = new Partida(TrabalhoFinal.currentPartidaId, this.participantesAtuais.get(i), this.participantesAtuais.get(i+1));
            this.partidas.add(p);
            TrabalhoFinal.currentPartidaId++;
        }
        this.participantesAtuais.clear();
    }
    
    public void generateSemiFinal(){
        for(int i = 0; i < 3; i=i+2){
            Partida p = new Partida(TrabalhoFinal.currentPartidaId, this.participantesAtuais.get(i), this.participantesAtuais.get(i+1));
            this.partidas.add(p);
            TrabalhoFinal.currentPartidaId++;
        }
        this.participantesAtuais.clear();
    }
    
    public void generateFinal(){
        Partida p = new Partida(TrabalhoFinal.currentPartidaId, this.participantesAtuais.get(0), this.participantesAtuais.get(1));
        this.partidas.add(p);
        TrabalhoFinal.currentPartidaId++;
    }
    
    public void refazerParticipantesAtuais(){
        if(this.partidaAtual <= 8){
            for(Partida p : this.partidas){
                if(p.getVencedor().getId() != -1){
                    this.participantesAtuais.add(p.getVencedor());
                }
            }
        } else if(this.partidaAtual <= 12){
            for(Partida p : this.partidas.subList(8, 12)){
                if(p.getVencedor().getId() != -1){
                    this.participantesAtuais.add(p.getVencedor());
                }
            }
        } else if(this.partidaAtual <= 14){
            for(Partida p : this.partidas.subList(12, 14)){
                if(p.getVencedor().getId() != -1){
                    this.participantesAtuais.add(p.getVencedor());
                }
            }
        }
    }
}
