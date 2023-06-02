/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.ArrayList;
/**
 *
 * @author guton
 */
public class Liga extends Torneio{
    private ArrayList<Map<String, String>> tabela;
    
    Liga(){
        super();
    }
    
    Liga(String nome, String descricao, String local, LocalDateTime dataInicio, LocalDateTime dataFinal,
            LocalDateTime dataFimInscricoes, String regras, int id, int maxParticipantes, int numJogosPartida, Organizador organizador){
        
        super(nome, descricao, local, dataInicio, dataFinal, dataFimInscricoes, regras, id, maxParticipantes, numJogosPartida, organizador);
        this.tabela = new ArrayList();
    }
    
    public ArrayList<Map<String, String>> getTabela(){
        return this.tabela;
    }
    
    public void setTabela(ArrayList<Map<String, String>> tabela){
        this.tabela = tabela;
    }
    
}
