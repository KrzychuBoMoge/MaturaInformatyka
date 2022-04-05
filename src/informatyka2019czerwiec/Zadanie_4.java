package informatyka2019czerwiec;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class Zadanie_4 extends FileNotFoundException {
    public static void main(String[] args) throws IOException {
        Path liczbyFile = Paths.get("dane/liczby.txt");
        Path pierwszeFile = Paths.get("dane/pierwsze.txt");
        ArrayList<Integer> liczbyList = new ArrayList<>();
        ArrayList<Integer> pierwszeList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(liczbyFile.toString()));
        while (bufferedReader.ready()) {
            liczbyList.add(Integer.valueOf(bufferedReader.readLine()));
        }
        bufferedReader = new BufferedReader(new FileReader(pierwszeFile.toString()));
        while (bufferedReader.ready()) {
            pierwszeList.add(Integer.valueOf(bufferedReader.readLine()));
        }

        ArrayList<Integer> zadanie1 = new ArrayList<>();
        for (int l : liczbyList) {
            boolean pierwsza = true;
            if (l > 100 && l < 5000) {
                for (int i = 2; i < l/2; i++)
                    if (l % i == 0) {
                        pierwsza = false;
                        break;
                    }
                if (pierwsza)
                    zadanie1.add(l);
            }
        }
        System.out.println(zadanie1+"\n");

        ArrayList<Integer> zadanie2 = new ArrayList<>();
        for (int l : pierwszeList) {
            int lReverse = Integer.parseInt(new StringBuilder(String.valueOf(l)).reverse().toString());
            boolean pierwsza = true;
            for (int i = 2; i < lReverse/2; i++)
                if (lReverse % i == 0) {
                    pierwsza = false;
                    break;
                }
            if (pierwsza)
                zadanie2.add(l);
        }
        System.out.println(zadanie2+"\n");

        int zadanie3 = 0;
        for (int l : pierwszeList) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(l));
            while (stringBuilder.length() != 1) {
                int waga = 0;
                for (int i = 0; i < stringBuilder.length(); i++) {
                    waga += Integer.parseInt(String.valueOf(stringBuilder.charAt(i)));
                }
                stringBuilder = new StringBuilder(String.valueOf(waga));
            }
            if (Integer.parseInt(stringBuilder.toString()) == 1) zadanie3++;
        }
        System.out.println(zadanie3 + "\n");

        File file1 = new File("wyniki4_1.txt");
        file1.createNewFile();
        File file2 = new File("wyniki4_2.txt");
        file2.createNewFile();
        File file3 = new File("wyniki4_3.txt");
        file3.createNewFile();

        FileWriter fileWriter1 = new FileWriter(file1);
        FileWriter fileWriter2 = new FileWriter(file2);
        FileWriter fileWriter3 = new FileWriter(file3);
        for (int i : zadanie1)
            fileWriter1.write(i+"\n");
        for (int i : zadanie2)
            fileWriter2.write(i+"\n");
        fileWriter3.write(zadanie3+" liczb");

        fileWriter1.close();
        fileWriter2.close();
        fileWriter3.close();
    }
}
