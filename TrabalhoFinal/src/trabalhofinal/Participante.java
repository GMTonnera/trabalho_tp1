/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

/**
 *
 * @author guton
 */
public class Participante extends Usuario{
    private int numVitorias, numDerrotas, capotesRecebidos, capotesAplicados, numTorneiosJogados, numTorneiosVencidos;
    
    Participante(){
        super();
    }
    
    Participante(int id){
        super(id);
    }
    
    
    Participante(int id, String nome, String curso, String email, String senha){
        super(id, nome, curso, email, senha);
        this.numVitorias = 0;
        this.numDerrotas = 0;
        this.capotesRecebidos = 0;
        this.capotesAplicados = 0;
        this.numTorneiosJogados = 0;
        this.numTorneiosVencidos = 0;
    }
    
    Participante(int id, String nome, String curso, String email, String senha, int numVitorias, 
                 int numDerrotas, int capotesRecebidos, int capotesAplicados, int numTorneiosJogados, int numTorneiosVencidos){
        
        super(id, nome, curso, email, senha);
        this.numVitorias = numVitorias;
        this.numDerrotas = numDerrotas;
        this.capotesRecebidos = capotesRecebidos;
        this.capotesAplicados = capotesAplicados;
        this.numTorneiosJogados = numTorneiosJogados;
        this.numTorneiosVencidos = numTorneiosVencidos;
    }
    
    public int getNumVitorias(){
        return this.numVitorias;
    }
    
    public void setNumVitorias(int num){
        this.numVitorias = num;
    }
    
    public int getNumDerrotas(){
        return this.numDerrotas;
    }
    
    public void setNumDerrotas(int num){
        this.numDerrotas = num;
    }
    
    public int getCapotesRecebidos(){
        return this.capotesRecebidos;
    }
    
    public void setCapotesRecebidos(int num){
        this.capotesRecebidos = num;
    }
    
    public int getCapotesAplicados(){
        return this.capotesAplicados;
    }
    
    public void setCapotesAplicados(int num){
        this.capotesAplicados = num;
    }
    
    public int getNumTorneiosJogados(){
        return this.numTorneiosJogados;
    }
    
    public void setNumTorneiosJogados(int num){
        this.numTorneiosJogados = num;
    }
    
    public int getNumTorneiosVencidos(){
        return this.numTorneiosVencidos;
    }
    
    public void setNumTorneiosVencidos(int num){
        this.numTorneiosVencidos = num;
    }
    
    public void incricaoTorneio(Torneio t){}
    
    public void cancelarInscricao(Torneio t){}
    
    
}
