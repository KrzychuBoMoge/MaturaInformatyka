package lesson1;

import java.util.ArrayList;
import java.util.Scanner;

public class Fiboniaci {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt()-2;
        list.add(0);
        list.add(1);
        for (int i = 0; i < n; i++)
            list.add(list.get(i) + list.get(i+1));
        System.out.println(list);
    }
}
