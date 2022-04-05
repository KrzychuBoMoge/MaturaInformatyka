package lesson1;

//Algorytm wydaje reszty najmniejsza liczba nominalow

import java.util.ArrayList;
import java.util.Scanner;

public class AlgorytmWydawaniaReszty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kwota = scanner.nextInt();
        int[] nom = {50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        ArrayList<Double> answer = new ArrayList<>();
        while (kwota != 0)
            for (int j : nom)
                while (kwota / j > 0){
                    answer.add(Double.parseDouble(Integer.toString(j))/100);
                    kwota -= j;
                }
        System.out.println(answer);
    }
}
