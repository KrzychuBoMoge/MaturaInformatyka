package informatyka2020czerwiec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Zadanie_4 {
    public static void main(String[] args) throws IOException {
        Path paryPath = Paths.get("dane/pary.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(paryPath.toFile()));
        ArrayList<String[]> paryList = new ArrayList<>();
        while (bufferedReader.ready()){
            StringBuilder stringBuilder = new StringBuilder(bufferedReader.readLine());
            String[] tab = new String[2];
            tab[0] = stringBuilder.substring(0,stringBuilder.indexOf(" "));
            tab[1] = stringBuilder.delete(0,stringBuilder.indexOf(" ")+1).toString();
            paryList.add(tab);
        }

        ArrayList<Integer> liczbyPierwsze = new ArrayList<>();
        for (int i = 3; i < 100; i++) {
            boolean pierwsza = true;
            for (int j = 2; j < i; j++)
                if (i % j == 0) {
                    pierwsza = false;
                    break;
                }
            if (pierwsza)
                liczbyPierwsze.add(i);
        }

        for (String[] s1 : paryList) {
            int liczba = Integer.parseInt(s1[0]);
            if (liczba%2==0)
                for (int pierwsza : liczbyPierwsze)
                    if (liczbyPierwsze.contains(liczba - pierwsza)){
                        System.out.println(liczba + " " + pierwsza + " " + (liczba-pierwsza));
                        break;
                    }
        }

        for (String[] s1 : paryList) {
            StringBuilder stringBuilder = new StringBuilder(s1[1]);
            int ciag = 1, ciagCopy = 0;
            char znak = stringBuilder.charAt(0);
            for (int i = 1; i < stringBuilder.length(); i++)
                if (stringBuilder.charAt(i-1) == stringBuilder.charAt(i))
                    ciag++;
                else
                    if (ciag > ciagCopy) {
                        znak = stringBuilder.charAt(i-1);
                        ciagCopy = ciag;
                        ciag = 1;
                    }
            for (int i = 0; i < ciagCopy; i++)
                System.out.print(znak);
            System.out.println(" " + ciagCopy);
        }
        System.out.println();

        int min = Integer.MAX_VALUE;
        int ciagFinal = Integer.MAX_VALUE;
        int liczbaFinal = 0;
        String slowoFinal = "";
        char symbol = 'z';
        for (String[] s1 : paryList) {
            int liczba = Integer.parseInt(s1[0]);
            String slowo = s1[1];
            if (liczba == slowo.length()) {
                char[] tab = slowo.toCharArray();
                Arrays.sort(tab);
                StringBuilder slowoSort = new StringBuilder();
                for (char c : tab)
                    slowoSort.append(c);
                if (min >= liczba){
                    min = liczba;
                    StringBuilder stringBuilder = new StringBuilder(slowoSort);
                    System.out.println(stringBuilder);
                    int ciag = 1;
                    for (int i = 1; i < stringBuilder.length(); i++)
                        if (stringBuilder.charAt(i-1) == stringBuilder.charAt(i))
                            ciag++;
                        else
                            ciag = 1;
                    if (ciagFinal > ciag)
                        if (stringBuilder.charAt(stringBuilder.length()-1) < symbol){
                            slowoFinal = slowo;
                            liczbaFinal = liczba;
                        }
                }
            }
        }
        System.out.println(liczbaFinal + " " + slowoFinal);
    }
}
