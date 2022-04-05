package informatyka2020kwiecien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Zadanie_4 {
    public static void main(String[] args) throws IOException {
        Path dane4Path = Paths.get("dane/dane4.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(dane4Path.toFile()));
        ArrayList<Integer> daneList = new ArrayList<>();
        ArrayList<Integer> luki = new ArrayList<>();
        while (bufferedReader.ready())
            daneList.add(Integer.parseInt(bufferedReader.readLine()));

        for (int i = 0; i < daneList.size()-1; i++)
            luki.add(Math.abs(daneList.get(i) - daneList.get(i+1)));
        System.out.println(Collections.max(luki) + " " + Collections.min(luki) + "\n");

        int liczbaWystapien = 1, liczbaWystapienFinal = 1, indexPoczatku = 0, indexKonca = 0;
        for (int i = 1; i < luki.size(); i++)
            if (luki.get(i-1).equals(luki.get(i))){
                liczbaWystapien++;
            }
            else {
                if (liczbaWystapienFinal < liczbaWystapien) {
                    indexPoczatku = indexKonca;
                    indexKonca = i-1;
                    liczbaWystapienFinal = ++liczbaWystapien;
                }
                liczbaWystapien = 1;
            }
        System.out.println(luki.get(indexPoczatku) + " " + luki.get(indexKonca) + " " + liczbaWystapienFinal);
    }
}
