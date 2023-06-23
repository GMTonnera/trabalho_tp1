/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author guton
 */
public class teste {
    public static void main(String[] args) {
        long minDay = LocalDate.of(2023, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        
        for(int i = 0; i < 20; i++){
            long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
            LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
            System.out.println(randomDate);
        }
    }
}
