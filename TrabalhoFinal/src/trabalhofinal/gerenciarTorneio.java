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
public interface gerenciarTorneio {
    
    public void atualizarPontuacao();
    
    public void setResultadoPartida(ArrayList<int[]> resultados, ArrayList<Boolean> capotes);
    
    public Partida getProximaPartida();
    
    public Participante getCampeao();
}
