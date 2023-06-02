/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

/**
 *
 * @author guton
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
    
    public void criarTorneio(){}
    
    public void encerrarTorneio(){}
    
}
