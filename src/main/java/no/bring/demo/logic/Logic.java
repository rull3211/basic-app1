package no.bring.demo.logic;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Logic { // En Logic klasse som inneholder logikken til kalkulatoren

    // for utregning av en enkelsending
    public int singlePrice(int base, int packetp, int count , int weight,int weightp){
        int total = (weight*count * weightp) + (packetp*count) + base;

        return total;
    }
    // For utregning av matrise
    public int[][] multiplePrice(int base, int packetp, int count , int weight,int weightp){
        int[][] liste = new int[weight][count];
        for(int i = 0; i < weight; i++){
            for(int k = 0 ; k < count; k++){
                liste[i][k] = ((i+1)*(k+1) * weightp) + (packetp*(k+1)) + base;
            }
        }
        return liste;
    }

}
