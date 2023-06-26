/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package trabalhofinal;

import java.util.ArrayList;
/**
 *
 * @author guton
 */
/*
CLASSE Usuario --> Interface usada para padronizar os métodos das classes Liga e
                   MataMata;
    
   
    MÉTODO setResultadoPartida:  Atribuir um resultado a uma partida;
    
    MÉTODO getProximaPartida: Retorna a próxima partida a ser jogada;
    
    MÉTODO getCampeao: Retorna o campeão do torneio;
*/

public interface gerenciarTorneio {
    
    public void setResultadoPartida(ArrayList<Integer> resultados, Boolean capotes);
    
    public Partida getProximaPartida();
    
    public Participante getCampeao();
}
