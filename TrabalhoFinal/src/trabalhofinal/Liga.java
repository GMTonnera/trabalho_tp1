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
public class Liga extends Torneio implements gerenciarTorneio{
    private ArrayList<ArrayList<Integer>> tabela;
    
    Liga(){
        super();
    }
    
    Liga(String nome, String descricao, String local, LocalDate dataInicio, LocalDate dataInicioInscricao,int periodoTorneio, int periodoInscricao, 
            String regras, int id, Organizador organizador){
        
        super(nome, descricao, local, dataInicio, dataInicioInscricao, periodoTorneio, periodoInscricao, regras, id, 10, 20, 1, organizador);
        this.tabela = new ArrayList();
    }
    
    public ArrayList<ArrayList<Integer>> getTabela(){
        return this.tabela;
    }
    
    public void setTabela(ArrayList<ArrayList<Integer>> tabela){
        this.tabela = tabela;
    }
    
    public void setResultadoPartida(ArrayList<Integer> resultado, Boolean capote){
        Partida p = this.partidas.get(this.partidaAtual);
        p.setResultado(resultado);
        p.setCapote(capote);
        if(this.partidaAtual < this.numPartidas){
            this.partidaAtual++;
        }
        this.atualizarPontuacao(p.getVencedor(), capote);
    
    };
    
    private void atualizarPontuacao(Participante p, Boolean capote){
        for(ArrayList<Integer> linha: this.tabela){
            if(linha.get(0) == p.getId()){
                linha.set(1, linha.get(1)+3);
                linha.set(2, linha.get(2)+1);
                if(capote){
                    linha.set(3, linha.get(3)+1);
                }
            }
        }
        
         Collections.sort(this.tabela, new ComparadorLinha());
    }
   
    public Partida getProximaPartida(){
        return this.partidas.get(this.partidaAtual);
    };
    
    public Participante getCampeao(){
        int id = this.tabela.get(0).get(1);
        for(Participante p : this.participantes){
            if(p.getId() == id){
                return p;
            }
        }
        return new Participante(-1);
    };
    
    public void criarPartidas(){
        Collections.shuffle(this.participantes);        
        // Fazer uma lista com todas as paratidas
        for(int i = 0; i < this.participantes.size(); i++){
            for(int j = i+1; j < this.participantes.size(); j++){
                this.partidas.add(new Partida(TrabalhoFinal.currentPartidaId, this.participantes.get(i), this.participantes.get(j)));
                TrabalhoFinal.currentPartidaId++;
             }
        }
        
        Collections.shuffle(this.partidas);
        this.numPartidas = this.partidas.size();
    }
    
    public void inicializarTabela(){
        for(int i = 0; i < this.participantes.size(); i ++){
            ArrayList<Integer> linha = new ArrayList();
            Participante p = this.participantes.get(i);
            linha.add(p.getId());
            linha.add(0);
            linha.add(0);
            linha.add(0);
            
            tabela.add(linha);
        }
    }

}  

    
    

