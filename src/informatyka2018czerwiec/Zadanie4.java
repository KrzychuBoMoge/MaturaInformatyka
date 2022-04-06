package informatyka2018czerwiec;

import java.io.*;
import java.util.ArrayList;

public class Zadanie4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("NM_DANE_PR/przyklad1.txt"));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("NM_DANE_PR/przyklad2.txt"));
        ArrayList<int[]> list1 = new ArrayList<>();
        ArrayList<int[]> list2 = new ArrayList<>();
        while (bufferedReader1.ready()) {
            StringBuilder stringBuilder = new StringBuilder(bufferedReader1.readLine());
            int[] tab = new int[10];
            for (int i = 0; i < 9; i++) {
                tab[i] = Integer.parseInt(stringBuilder.substring(0,stringBuilder.indexOf(" ")));
                stringBuilder.delete(0,stringBuilder.indexOf(" ")+1);
            }
            tab[9] = Integer.parseInt(stringBuilder.substring(0,stringBuilder.length()));
            list1.add(tab);
        }
        while (bufferedReader2.ready()) {
            StringBuilder stringBuilder = new StringBuilder(bufferedReader2.readLine());
            int[] tab = new int[10];
            for (int i = 0; i < 9; i++) {
                tab[i] = Integer.parseInt(stringBuilder.substring(0,stringBuilder.indexOf(" ")));
                stringBuilder.delete(0,stringBuilder.indexOf(" ")+1);
            }
            tab[9] = Integer.parseInt(stringBuilder.substring(0,stringBuilder.length()));
            list2.add(tab);
        }

        for (int[] i1 : list1) {
            for (int i2 : i1) {
                System.out.print(i2 + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int[] i1 : list2) {
            for (int i2 : i1) {
                System.out.print(i2 + " ");
            }
            System.out.println();
        }
        System.out.println();

        int odpowiedz1 = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i)[9] == list2.get(i)[9]) odpowiedz1++;
        }
        System.out.println(odpowiedz1+"\n");

        int odpowiedz2 = 0;
        for (int i = 0; i < list2.size(); i++) {
            int p = 0;
            for (int i1 : list1.get(i)) {
                if (i1%2==0)
                    p++;
            }
            if (p==5) {
                p = 0;
                for (int i1 : list2.get(i)) {
                    if (i1 % 2 == 0)
                        p++;
                }
                if (p == 5)
                    odpowiedz2++;
            }
        }
        System.out.println(odpowiedz2+"\n");

        int odpowiedz3liczba = 0;
        ArrayList<Integer> odpowiedz3lista = new ArrayList<>();
        ArrayList<ArrayList<Integer>> zadanie3tab1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> zadanie3tab2 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            ArrayList<Integer> tab1 = new ArrayList<>();
            ArrayList<Integer> tab2 = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                if (!tab1.contains(list1.get(i)[j]))
                    tab1.add(list1.get(i)[j]);
                if (!tab2.contains(list2.get(i)[j]))
                    tab2.add(list2.get(i)[j]);
            }
            zadanie3tab1.add(tab1);
            zadanie3tab2.add(tab2);
        }
        for (int i = 0; i < zadanie3tab1.size(); i++) {
            for (ArrayList<Integer> integers : zadanie3tab2) {
                if (zadanie3tab1.get(i).equals(integers)) {
                    odpowiedz3liczba++;
                    odpowiedz3lista.add(i + 1);
                }
            }
        }
        System.out.println(odpowiedz3liczba + " pary ciągów\n" +
                "numery wierszy:\n" +
                odpowiedz3lista + "\n");

        ArrayList<int[]> odpowiedz4 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            int[] tab = new int[20];
            int l1 = 0, l2 = 0;
            for (int j = 0; j < 20; j++) {
                if (l1 < 10 && l2 < 10) {
                    System.out.println(list1.get(i)[l1] + " " + list2.get(i)[l2]);
                    if (list1.get(i)[l1] <= list2.get(i)[l2]) {
                        tab[j]=list1.get(i)[l1];
                        l1++;
                    }
                    else {
                        tab[j]=list2.get(i)[l2];
                        l2++;
                    }
                } else if (l1 < 10)
                    tab[j]=list1.get(i)[l1++];
                else
                    tab[j]=list2.get(i)[l2++];
            }
            odpowiedz4.add(tab);
        }

        for (int[] i1 : odpowiedz4) {
            for (int i2 : i1) {
                System.out.print(i2 + " ");
            }
            System.out.println();
        }

        File file1 = new File("wynik4_1.txt");
        if (file1.createNewFile()) System.out.println(file1.getName() + " created.");
        FileWriter fileWriter1 = new FileWriter(file1);
        fileWriter1.write(odpowiedz1);
        fileWriter1.close();

        File file2 = new File("wynik4_2.txt");
        if (file2.createNewFile()) System.out.println(file2.getName() + " created.");
        FileWriter fileWriter2 = new FileWriter(file2);
        fileWriter2.write(odpowiedz2);
        fileWriter2.close();

        File file3 = new File("wynik4_3.txt");
        if (file3.createNewFile()) System.out.println(file3.getName() + " created.");
        FileWriter fileWriter3 = new FileWriter(file3);
        fileWriter3.write(odpowiedz3liczba + " pary ciągów\n" +
                "numery wierszy:\n" +
                odpowiedz3lista);
        fileWriter3.close();

        File file4 = new File("wynik4_4.txt");
        if (file4.createNewFile()) System.out.println(file4.getName() + " created.");
        FileWriter fileWriter4 = new FileWriter(file4);
        for (int[] i1 : odpowiedz4) {
            for (int i2 : i1) {
                fileWriter4.write(i2 + " ");
            }
            fileWriter4.write("\n");
        }
        fileWriter4.close();
    }
}
