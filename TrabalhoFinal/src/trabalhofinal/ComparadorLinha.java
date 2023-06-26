/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author guton
 */
/*
CLASSE ComparadorLinha --> Usada para ordenar a variável tabela da classe Liga.
    
    - MÉTODO compare: Ordena a tabela pelo número de pontos, número de vitórias 
e número de capotes, repectivamente. 



*/






public class ComparadorLinha implements Comparator<ArrayList<Integer>>{
    public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2){
        if(a1.get(1) < a2.get(1)){
            return 1;
        } else if(a1.get(1) == a2.get(1)){
            if(a1.get(2) < a2.get(2)){
                return 1;
            } else if(a1.get(2) == a2.get(2)){
                if(a1.get(3) < a2.get(3)){
                    return 1;
                } else if(a1.get(3) == a2.get(3)){
                    return 0;
                } else{
                    return -1;
                }
            } else{
                return -1;
            }
        } else{
            return -1;
        }
    }
}
