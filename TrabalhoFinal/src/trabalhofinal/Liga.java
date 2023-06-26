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
CLASSE LIGA --> Classe filha da classe Torneio a qual implmenta a interface
                gerenciarTorneio. Responsável por simiular um tornio do tipo
                liga, no qual cada participante uma vez contra os outros
                participantes, o número mínimo de participantes é 10, o máximo
                é 20. Ganha a Liga o participante que obtiver o maior número de
                pontos. Os pontos são adquiridos por vitórias em partidas. Cada
                partida garante 3 pontos ao vencedor. Em caso de empate, os
                critérios de desempate são número de vitórias e número de 
                capotes aplicados, nessa ordem.


    ATRIBUTO tabela: Variável privada do tipo ArrayList<ArrayList<Integer>> 
responsável por armazenar a pontuação do torneio e a posiçãod e cada
participante.


    MÉTODO Liga(): Construtor Padrão;
    
    MÉTODO Liga(String nome, String descricao, ...): Construtor que incializa as
variáveis da classe pai e a variável tabela;
    
    MÉTODO setTabela: Atribui um novo valor a variável tabela;
    
    MÉTODO setResultadoPartida: Atribui um resultado a partida atual do torneio;

    MÉTODO atualizarPontuacao: Atualiza a variável tabela com o resultado de uma
partida;
    
    MÉTODO getProximaPartida: Retorna a próxima partida do torneio;
    
    MÉTODO getCampeao: Retorna o campeão do Torneio;

    MÉTODO criarPartidas: Cria todas as partidas do Torneio e ordena
aleatoriamente as partidas;

    MÉTODO inicializarTabela: Incializa a varável tabela com linhas com valores
zerados;

    MÉTODO atualizarTabela: Atualiza a tabela com os resultado das partidas que
já aconteceream;

*/
public class Liga extends Torneio implements gerenciarTorneio{
    private ArrayList<ArrayList<Integer>> tabela = new ArrayList();
    
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
            TorneioService ts = new TorneioService();
            ts.updateTorneio(this);
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
    
    public void atualizarTabela(){
        for(Partida p : this.partidas){
            if(p.getVencedor().getId() != -1){
                this.atualizarPontuacao(p.getVencedor(), p.getCapote());
            }
        }
    }
}  

    
    

