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
public class ComparadorLinha implements Comparator<ArrayList<Integer>>{
    public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2){
        if(a1.get(1) > a2.get(1)){
            return 1;
        } else if(a1.get(1) == a2.get(1)){
            if(a1.get(2) > a2.get(2)){
                return 1;
            } else if(a1.get(2) == a2.get(2)){
                if(a1.get(3) > a2.get(3)){
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
