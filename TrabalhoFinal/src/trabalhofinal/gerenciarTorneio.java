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
    
    public void setResultadoPartida(ArrayList<Integer> resultados, Boolean capotes);
    
    public Partida getProximaPartida();
    
    public Participante getCampeao();
}
