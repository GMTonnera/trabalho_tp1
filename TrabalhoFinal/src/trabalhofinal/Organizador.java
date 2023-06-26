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
CLASSE Organizador --> Classe filha da Classe Abstrata Usuario. Representa um
                       cadastro responsável por criar e administrar torneios de
                       sinuca.
    

    ATRIBUTO numTorneiosCriados: Variável privada do tipo  int a qual armazena
quantos torneios o Organizador já criou;


    MÉTODO Organizador(): Construtor Padrão;
    
    MÉTODO Organizador(int id, ..., String senha): Construtor que incializa os
atributos da classe pai e o atributo numTorneiosCriados como 0;
    
    MÉTODO Organizador(int id, ..., int numTorneiosCriados): Construtor que
incializa os atributos da classe pai e o numTorneiosCriados;

    MÉTODO getNumTorneiosCriados: Retorna o valor de numTorneiosCriados;    
    
    MÉTODO setNumTorneiosCriados: Atribui um novo valor a numTorneiosCriados;   
 
*/
public class Organizador extends Usuario{
    private int numTorneiosCriados;
    
    Organizador(){
        super();
    }
    
    Organizador(int id, String nome, String curso, String email, String senha){
        super(id, nome, curso, email, senha);
        this.numTorneiosCriados = 0;
    }
    
    Organizador(int id, String nome, String curso, String email, String senha, int torneiosCriados){
        super(id, nome, curso, email, senha);
        this.numTorneiosCriados = torneiosCriados;
    }
    
    public int getNumTorneiosCriados(){
        return this.numTorneiosCriados;
    }
    
    public void setNumTorneiosCriados(int num){
        this.numTorneiosCriados = num;
    }    
}
