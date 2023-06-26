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

/*
CLASSE MataMata --> Classe filha da Classe Torneio a qual implmenta a Interface
                    gerenciarTorneio. Responsável por simular um torneio do tipo
                    mata-mata, no qual cada participante enfrenta outros 
                    participates em partidas eliminatórias, nas quais os
                    vencedores avançam para a próxima etapa do torneio e os 
                    perdedores são eliminados. O número mínimo de participantes 
                    é 9 e o máximo é 16. Caso o torneio na possua 16 
                    participantes até o final das inscrções, são adicionados
                    jogadores nulos, os quais devem perder para qualquer
                    participante do torneio por capote. O vencedor é aquele que
                    vencer a final.
    

    ATRIBUTO participantesAtuais: Variável privada do tipo 
ArrayList<Participante> a qual armazena os jogadores que não foram elinados do
torneio até o jogo atual;


    MÉTODO MataMata(): Construtor Padrão;
    
    MÉTODO MataMata(String nome, String descricao, ...): Construtor que
incializa os atributos da classe pai e a variável participantesAtuais;
    
    MÉTODO setResultadoPartida: Atribui um resultado a partida atual do torneio;    
    
    MÉTODO getProximaPartida: Retorna a próxima partida do torneio;
    
    MÉTODO getCampeao: Retorna o campeão do Torneio;

    MÉTODO generateOitavasFinal: Cria as partidas da fase de Oitavas de Final do
torneio;

    MÉTODO generateQuartasFinal: Cria as partidas da fase de Quartas de Final do
torneio;

    MÉTODO generateSemiFinal: Cria as partidas das Semifinais do torneio;
    
    MÉTODO generateFinal: Cria a partida da final do torneio;

    MÉTODO refazerParticipantesAtuais: Recria as lista de participantes que 
ainda estão no torneio quando o aplicativo é inciado;

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
            TorneioService ts = new TorneioService();
            ts.updateTorneio(this);
        } 
        
        if(this.getStatusTorneio() >= 2 && this.getPartidaAtual() == 8){
            //((MataMata) t).refazerParticipantesAtuais();
            this.generateQuartasFinal();
        } else if(this.getStatusTorneio() == 2 && this.getPartidaAtual() == 12){
            //((MataMata) t).refazerParticipantesAtuais();
                this.generateSemiFinal();
        } else if(this.getStatusTorneio() == 2 && this.getPartidaAtual() == 14){
            //((MataMata) t).refazerParticipantesAtuais();
            this.generateFinal();
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
        
        System.out.println(16 -this.participantes.size());
        if(this.participantes.size() < 16){
            int n = (16 - this.participantes.size());
            for(int i = 0; i < n; i++){
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