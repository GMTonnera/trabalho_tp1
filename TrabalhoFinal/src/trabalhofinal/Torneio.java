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
    protected int id, minParticipantes, maxParticipantes, statusTorneio, numJogosPartida, periodoInscricao, periodoTorneio;
    protected String nome, descricao, local, regras;
    protected LocalDateTime dataInicio, dataInicioInscricao; 
    protected ArrayList<Participante> participantes;
    protected Organizador organizador;
    protected ArrayList<Partida> partidas; 
            
    Torneio(){}
    
    Torneio(String nome, String descricao, String local, LocalDateTime dataInicio, LocalDateTime dataInicioInscricao,int periodoTorneio, int periodoInscricao, 
            String regras, int id, int minParticipantes, int maxParticipantes, int numJogosPartida, Organizador organizador){
        
        this.id = id;
        this.maxParticipantes = maxParticipantes;
        this.statusTorneio = 0;
        this.numJogosPartida = numJogosPartida;
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.regras = regras;
        this.dataInicio = dataInicio;
        this.periodoTorneio = periodoTorneio;
        this.periodoInscricao = periodoInscricao;
        this.participantes = new ArrayList();
        this.organizador = organizador;
        this.partidas = new ArrayList();
        this.minParticipantes = minParticipantes;
        this.dataInicioInscricao = dataInicioInscricao;
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

    public int getMinParticipantes() {
        return minParticipantes;
    }

    public int getPeriodoInscricao() {
        return periodoInscricao;
    }

    public int getPeriodoTorneio() {
        return periodoTorneio;
    }

    public void setDataInicioInscricao(LocalDateTime dataInicioInscricao) {
        this.dataInicioInscricao = dataInicioInscricao;
    }


    public void setMinParticipantes(int minParticipantes) {
        this.minParticipantes = minParticipantes;
    }

    public void setPeriodoInscricao(int periodoInscricao) {
        this.periodoInscricao = periodoInscricao;
    }

    public void setPeriodoTorneio(int periodoTorneio) {
        this.periodoTorneio = periodoTorneio;
    }

    public LocalDateTime getDataInicioInscricao() {
        return dataInicioInscricao;
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
}
