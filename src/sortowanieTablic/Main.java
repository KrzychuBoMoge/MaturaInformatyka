package sortowanieTablic;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[][] tab = {{"Agata","Warszawa"},{"Maja","Podlasie"},{"Tomek","Warszawa"},{"Bartek","Kraków"},{"Marcin","Gdańsk"},{"Ewelina", "Podkarpackie"},{"Emilia", "Warszawa"}};
            System.out.println();
        for (int i = 0; i < tab.length; i++) {
            for (int j = 1; j < tab.length; j++) {
                if (tab[j-1][1].charAt(0) > tab[j][1].charAt(0)) {
                    String[] copy = tab[j];
                    tab[j] = tab[j-1];
                    tab[j-1] = copy;
                }
            }
        }
        int wi = 1;
        for (int i = 1; i < tab.length; i++) {
            if (tab[i][1].equals(tab[i-1][1])) wi++;
            else {
                System.out.println(tab[i-1][1]+" "+(wi));
                wi = 1;
            }
        }
        System.out.println(tab[tab.length-1][1] + " " + wi);
    }
}
