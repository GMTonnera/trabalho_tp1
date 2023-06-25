/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


/**
 *
 * @author guton
 */
public class Torneio {
    protected int id, minParticipantes, maxParticipantes, statusTorneio, numJogosPartida, periodoInscricao, periodoTorneio;
    protected String nome, descricao, local, regras;
    protected LocalDate dataInicio, dataInicioInscricao; 
    protected ArrayList<Participante> participantes = new ArrayList();
    protected Organizador organizador;
    protected ArrayList<Partida> partidas = new ArrayList();
    protected int numPartidas;
    protected int partidaAtual;
            
    Torneio(){}
    
    public Torneio(int id){
        this.id = id;
    }
    
    Torneio(String nome, String descricao, String local, LocalDate dataInicio, LocalDate dataInicioInscricao,int periodoTorneio, int periodoInscricao, 
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
        this.partidaAtual = 0;

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
    
    public LocalDate getDataInicio(){
        return this.dataInicio;
    }
    
    public void setDataInicio(LocalDate dataInicio){
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

    public void setDataInicioInscricao(LocalDate dataInicioInscricao) {
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

    public LocalDate getDataInicioInscricao() {
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
    
    public void addParticipante(Participante p){
        this.participantes.add(p);
    }
    
    public LocalDate getFimInscricao(){
        return this.dataInicioInscricao.plus(Period.ofDays(this.periodoInscricao));
    }
    
    public LocalDate getFimTorneio(){
        return this.dataInicio.plus(Period.ofDays(this.periodoTorneio));
    }
    
    public void removeParticipante(int id){
        for(int i = 0; i < this.participantes.size(); i++){
            if(this.participantes.get(i).getId() == id){
                this.participantes.remove(i);
                break;
            }
        }
    }
    
    public void atualizarEstado(){
        LocalDate hoje = LocalDate.now();
        if(hoje.compareTo(this.dataInicioInscricao) < 0){
            this.statusTorneio = 0;
        } else if(hoje.compareTo(this.dataInicioInscricao) >= 0 && hoje.compareTo(this.getFimInscricao()) <= 0){
            this.statusTorneio = 1;
        } else if(hoje.compareTo(this.dataInicio) >= 0 && hoje.compareTo(this.getFimTorneio()) <= 0){
            this.statusTorneio = 2;            
        } else{
            this.statusTorneio = 3;
        }
    }

    public int getNumPartidas() {
        return numPartidas;
    }

    public int getPartidaAtual() {
        return partidaAtual;
    }

    public void setNumPartidas(int numPartidas) {
        this.numPartidas = numPartidas;
    }

    public void setPartidaAtual(int partidaAtual) {
        this.partidaAtual = partidaAtual;
    }
}
