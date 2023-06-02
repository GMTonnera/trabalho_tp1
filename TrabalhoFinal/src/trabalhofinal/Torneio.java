/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 *
 * @author guton
 */
public class Torneio {
    protected int id, maxParticipantes, statusTorneio, numJogosPartida;
    protected String nome, descricao, local, regras;
    protected LocalDateTime dataInicio, dataFinal, dataFimInscricoes; 
    protected ArrayList<Participante> participantes;
    protected Organizador organizador;
    protected ArrayList<Partida> partidas; 
            
    Torneio(){}
    
    Torneio(String nome, String descricao, String local, LocalDateTime dataInicio, LocalDateTime dataFinal,
            LocalDateTime dataFimInscricoes, String regras, int id, int maxParticipantes, int numJogosPartida, Organizador organizador){
        
        this.id = id;
        this.maxParticipantes = maxParticipantes;
        this.statusTorneio = 0;
        this.numJogosPartida = numJogosPartida;
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.regras = regras;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.dataFimInscricoes = dataFimInscricoes;
        this.participantes = new ArrayList();
        this.organizador = organizador;
        this.partidas = new ArrayList();
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getMaxParticipantes(){
        return this.maxParticipantes;
    }
    
    public void setMaxParticipantes(int maxParticipantes){
        this.maxParticipantes = maxParticipantes;
    }
    
    public int getStatusTorneio(){
        return this.statusTorneio;
    }
    
    public void setStatusTorneio(int statusTorneio){
        this.statusTorneio = statusTorneio;
    }
    
    public int getNumJogosPartida(){
        return this.numJogosPartida;
    }
    
    public void setNumJogosPartida(int numJogosPartida){
        this.numJogosPartida = numJogosPartida;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public String getLocal(){
        return this.local;
    }
    
    public void setLocal(String local){
        this.local = local;
    }
    
    public String getRegras(){
        return this.regras;
    }
    
    public void setRegras(String regras){
        this.regras = regras;
    }
    
    public LocalDateTime getDataInicio(){
        return this.dataInicio;
    }
    
    public void setDataInicio(LocalDateTime dataInicio){
        this.dataInicio = dataInicio;
    }
    
    public LocalDateTime getDataFinal(){
        return this.dataFinal;
    }
    
    public void setDataFinal(LocalDateTime dataFinal){
        this.dataFinal = dataFinal;
    }
        
    public LocalDateTime getDataFimInscricoes(){
        return this.dataFimInscricoes;
    }
    
    public void setDataFimInscricoes(LocalDateTime dataFimInscricoes){
        this.dataFimInscricoes = dataFimInscricoes;
    }
    
    public ArrayList<Partida> getPartidas(){
        return this.partidas;
    }
    
    public void setPartidas(ArrayList<Partida> partidas){
        this.partidas = partidas;
    }
    
    public ArrayList<Participante> getParticipantes(){
        return this.participantes;
    }
    
    public void setParticipantes(ArrayList<Participante> participantes){
        this.participantes = participantes; 
    }
    
    public Organizador getOrganizador(){
        return this.organizador;
    }
    
    public void setOrganizador(Organizador organizador){
        this.organizador = organizador;
    }
    
    public void addPartida(Partida partida){
        this.partidas.add(partida);
    }
    
    public void gerarPartidas(){}
    
    public void adicionarResultado(){}
    
    
}
