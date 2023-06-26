/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

/**
 *
 * @author guton
 */
/*
CLASSE Participante --> Classe filha da Classe Abstrata Usuario. Representa um
                        jogador responsável participar e se inscrever nos 
                        torneios;
    

    ATRIBUTO numVitorias: Variável privada do tipo  int a qual armazena
o número de vitórias do jogador;
    
    ATRIBUTO numDerrotas: Variável privada do tipo  int a qual armazena
o número de derrotas do jogador;
    
    ATRIBUTO numCapotesRecebidos: Variável privada do tipo  int a qual armazena
o número de capotes recebidos pelo jogador;
    
    ATRIBUTO umCapotesAplicados: Variável privada do tipo  int a qual armazena
o número de  capotes aplicados pelo jogador;
    
    ATRIBUTO numTorneiosJogados: Variável privada do tipo  int a qual armazena
o número de torneios jogados pelo jogador;
    
    ATRIBUTO numTorneiosJogados: Variável privada do tipo  int a qual armazena
o número de torneios vencidos pelo jogador;
    

    MÉTODO Participante(): Construtor Padrão;

    MÉTODO Participante(ind id): Inicializa apenas o valor do atributo id;
    
    MÉTODO Participante(int id, ..., String senha): Construtor que incializa os
atributos da classe pai e os atributos como 0;
    
    MÉTODO Participante(int id, ..., int numTorneiosVencidos): Construtor que
incializa os atributos da classe pai e os demais atributos;

    MÉTODO getNumVitorias:  Retorna o valor de numVitorias;

    MÉTODO setNumVitorias: Atribui um novo valor a numVitorias; 
    
    MÉTODO getNumDerrotas:  Retorna o valor de numDerrotas;

    MÉTODO setNumDerrotas: Atribui um novo valor a numDerrotas; 
    
    MÉTODO getCapotesRecebidos:  Retorna o valor de capotesRecebidos;

    MÉTODO setCapotesRecebidos: Atribui um novo valor a capotesRecebidos; 
    
    MÉTODO getCapotesAplicados:  Retorna o valor de capotesAplicados;
    
    MÉTODO setCapotesAplicados: Atribui um novo valor a capotesAplicados; 
    
    MÉTODO getNumTorneiosJogados:  Retorna o valor de numTorneiosJogados;
    
    MÉTODO setNumTorneiosJogados: Atribui um novo valor a numTorneiosJogados; 
    
    MÉTODO getNumTorneiosVencidos:  Retorna o valor de numTorneiosVencidos;
    
    MÉTODO setNumTorneiosVencidos: Atribui um novo valor a numTorneiosVencidos; 
 
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
}
