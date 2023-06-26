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

/*
CLASSE Torneio --> Classe pai das Classes Liga e MataMata. Representa um torneio
                   de sinuca;
    
   
    ATRIBUTO id: Variável privada do tipo  int a qual armazena o id do torneio;
    
    ATRIBUTO minParticipantes: Variável privada do tipo int a qual armazena
o número mínimo de participantes para o torneio acontecer;
    
    ATRIBUTO maxParticipantes: Variável privada do tipo int a qual armazena
o número máximo de participantes para o torneio acontecer;
    
    ATRIBUTO statusTorneio: Variável privada do tipo int a qual armazena o 
estado do torneio;

    ATRIBUTO numJogosPartida: Variável privada do tipo int a qual armazena o 
número de jogos por partida;
    
    ATRIBUTO periodoInscricao: Variável privada do tipo int a qual armazena o 
número de dias que a fase de inscrição durará;
    
    ATRIBUTO periodoTorneio: Variável privada do tipo  int a qual armazena
o número de dias que o torneio durará;
    
    ATRIBUTO nome: Variável privada do String a qual armazena o nome do torneio;
    
    ATRIBUTO descricao: Variável privada do tipo String a qual armazena uma
descrição do torneio;
    
    ATRIBUTO local: Variável privada do tipo String a qual armazena o local em 
que o jogos acontecerão;
    
    ATRIBUTO regras: Variável privada do tipo String a qual armazena a regra que
será usada nos jogos (Sinuquiunha ou Bola 8);
    
    ATRIBUTO dataInicio: Variável privada do tipo Localdate a qual armazena a 
data de início das partidas;
    
    ATRIBUTO dataInicioInscricao: Variável privada do tipo LocalDate a qual
armazena a data de início das inscrições;

    ATRIBUTO participantes: Variável privada do tipo ArrayList<Participante> a
qual armazena os participantes inscritos no torneio;
    
    ATRIBUTO organizador: Variável privada do tipo Organizador a qual armazena o
organizaodr do torneio;
    
    ATRIBUTO partidas: Variável privada do tipo ArrayList<Partida> a qual
armazena as partidas do torneio;
    
    ATRIBUTO numPartidas: Variável privada do tipo int a qual armazena o número
de partidas que serão disputadas;
    
    ATRIBUTO partidaAtual: Variável privada do tipo int a qual armazena o index
da partida a ser disputada em relção a variável partidas;
    

    MÉTODO Torneio(): Construtor Padrão;
    
    MÉTODO Torneio(int id): Construtor que incializa apenas o id do Torneio;
    
    MÉTODO Participante(String nome, ..., Organizador organizador): Construtor 
que incializa os atributos da classe;
   
    MÉTODO getId: Retorna o valor do id;
    
    MÉTODO setId: Atribui um novo valor a id;
    
    MÉTODO getMaxParticipantes: Retorna o valor maxParticipantes;
    
    MÉTODO setMaxParticipantes: Atribui um novo valor a axParticipantes;
    
    MÉTODO getStatusTorneio: Retorna o valor de statusTorneio;
    
    MÉTODO setStatusTorneio: Atribui um novo valor a statusTorneio;
    
    MÉTODO getNumJogosPartida: Retorna o valor de numJogosPartida;
    
    MÉTODO setNumJogosPartida: Atribui um novo valor a numJogosPartida;
    
    MÉTODO getNome: Retorna o valor de nome;
    
    MÉTODO setNome: Atribui um novo valor a nome;
    
    MÉTODO getDescricao: Retorna o valor de descricao;
    
    MÉTODO setDescricao: Atribui um novo valor a descricao;
    
    MÉTODO getLocal: Retorna o valor de locals;
    
    MÉTODO setLocal: Atribui um novo valor a local;
    
    MÉTODO getRegras(: Retorna o valor de regras;
    
    MÉTODO setRegras: Atribui um novo valor a regras;
    
    MÉTODO getDataInicio: Retorna o valor de dataInicio;
    
    MÉTODO setDataInicio: Atribui um novo valor a dataInicio;

    MÉTODO getMinParticipantes: Retorna o valor de minParticipantes;

    MÉTODO getPeriodoInscricao: Retorna o valor de periodoInscricao;

    MÉTODO getPeriodoTorneio: Retorna o valor de periodoTorneio;

    MÉTODO setDataInicioInscricao: Atribui um novo valor a dataInicioInscricao;

    MÉTODO setMinParticipantes: Atribui um novo valor a minParticipantes;

    MÉTODO setPeriodoInscricao: Atribui um novo valor a periodoInscricao;

    MÉTODO setPeriodoTorneio: Atribui um novo valor a periodoTorneio;

    MÉTODO getDataInicioInscricao: Retorna o valor de dataInicioInscricao;
    
    MÉTODO getPartidas: Retorna o valor de partidas;
    
    MÉTODO setPartidas: Atribui um novo valor a partidass;
    
    MÉTODO getParticipantes: Retorna o valor de participantes;
    
    MÉTODO setParticipantes: Atribui um novo valor a participantes;
    
    MÉTODO getOrganizador: Retorna o valor de organizaodrs;
    
    MÉTODO setOrganizador: Atribui um novo valor a organizaodr;
    
    MÉTODO addPartida: Adiciona uma partida a partidas;
    
    MÉTODO addParticipante: Adiciona um participante a participantes;
    
    MÉTODO getFimInscricao: Retorna a data do fim das inscrições;
    
    MÉTODO getFimTorneio: Retorna a data do fim do torneio;
    
    MÉTODO removeParticipante> Remove um participante de participantes;
    
    MÉTODO atualizarEstado: Atualiza o estado do torneio de acordo com a data de
hoje e as datas de inscrição e de início dos jogos;

    MÉTODO getNumPartidas: Retorna o valor de numPartidas;

    MÉTODO getPartidaAtual: Retorna o valor de partidaAtual;

    MÉTODO setNumPartidas: Atribui um novo valor a numPartidas;

    MÉTODO setPartidaAtual: Atribui um novo valor a partidaAtual;
 
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
