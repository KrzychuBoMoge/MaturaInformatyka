package lesson1;

import java.util.ArrayList;
import java.util.Scanner;

public class LiczbyPierwsze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe wyswietlanych liczb pierwszych:");
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        int number = list.get(0);
        while (list.size() != n){
            number++;
            if (pierwsza(number, list))
                list.add(number);
        }
        System.out.println(list);
    }

    private static boolean pierwsza(int number, ArrayList<Integer> list) {
        for (int i : list) {
            if (number%i==0) return false;
        }
        return true;
    }
}
