package informatyka2020lipiec;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Zadanie_6{
    public static void main(String[] args) throws IOException {
        int tab1_size1 = 280, tab1_size2 = 7, tab2_size1 = 1120, tab2_size2 = 3, tab3_size1 = 573, tab3_size2 = 2;
        Path filePath1 = Paths.get("src/informatyka2020lipiec/DANE/dane_ankiet.txt");
        Path filePath2 = Paths.get("src/informatyka2020lipiec/DANE/lok.txt");
        Path filePath3 = Paths.get("src/informatyka2020lipiec/DANE/zain.txt");
        String[][] tab1 = new String[tab1_size1][tab1_size2];
        String[][] tab2 = new String[tab2_size1][tab2_size2];
        String[][] tab3 = new String[tab3_size1][tab3_size2];
        int tabIndexI = 0;

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(filePath1.toFile()));
        bufferedReader1.readLine();
        while (bufferedReader1.ready()) {
            StringBuilder stringBuilder = new StringBuilder(bufferedReader1.readLine());
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.substring(0, stringBuilder.indexOf("\t") + 1).isEmpty()) {
                    tab1[tabIndexI][i] = stringBuilder.toString();
                    break;
                }
                tab1[tabIndexI][i] = stringBuilder.substring(0, stringBuilder.indexOf("\t"));
                stringBuilder.delete(0,stringBuilder.indexOf("\t")+1);
            }
            tabIndexI++;
        }

        int kobiety = 0, mezczyzni = 0;
        for (String[] s1 : tab1) {
            StringBuilder stringBuilder = new StringBuilder(s1[2]);
            if (stringBuilder.charAt(stringBuilder.length()-1) == 'a') kobiety++;
            else mezczyzni++;
        }
        System.out.println("Kobiety: " + kobiety + "\nMężczyźni: " + mezczyzni);

        tabIndexI = 0;

        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(filePath2.toFile()));
        bufferedReader2.readLine();
        while (bufferedReader2.ready()) {
            StringBuilder stringBuilder = new StringBuilder(bufferedReader2.readLine());
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.substring(0, stringBuilder.indexOf("\t") + 1).isEmpty()) {
                    tab2[tabIndexI][i] = stringBuilder.toString();
                    break;
                }
                tab2[tabIndexI][i] = stringBuilder.substring(0, stringBuilder.indexOf("\t"));
                stringBuilder.delete(0,stringBuilder.indexOf("\t")+1);
            }
            tabIndexI++;
        }

        HashMap<String, Integer> mapLok = new HashMap<>(5);
        for (int i = 0; i < tab1_size1; i++) {
            for (int j = i*4; j < i*4+4; j++) {
                if (tab1[i][6].equals("Mazowieckie") && tab2[j][2].equals("lato")) {
                    boolean inMap = false;
                    for (int k = 0; k < 5; k++)
                        if (mapLok.containsKey(tab2[j][1])){
                            inMap = true;
                            break;
                        }
                    if (!inMap) mapLok.put(tab2[j][1], 1);
                    else mapLok.replace(tab2[j][1],mapLok.get(tab2[j][1]),mapLok.get(tab2[j][1])+1);
                }
            }
        }
        System.out.println(mapLok);

        HashMap<String, Integer> mapWoj = new HashMap<>();
        for (int i = 0; i < tab1_size1; i++) {
            boolean wojExist = false;
            for (int j = 0; j < 20; j++)
                if (mapWoj.containsKey(tab1[i][6])) {
                    wojExist = true;
                    break;
                }
            if (!wojExist) mapWoj.put(tab1[i][6], 1);
            else mapWoj.replace(tab1[i][6],mapWoj.get(tab1[i][6]),mapWoj.get(tab1[i][6])+1);
        }

        for (String o :
                mapWoj.keySet())
            if (mapWoj.get(o)>20) {
                System.out.print(o + " = " + mapWoj.get(o) + " ");
        }
        System.out.println();

        tabIndexI = 0;

        BufferedReader bufferedReader3 = new BufferedReader(new FileReader(filePath3.toFile()));
        bufferedReader3.readLine();
        while (bufferedReader3.ready()) {
            StringBuilder stringBuilder = new StringBuilder(bufferedReader3.readLine());
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.substring(0, stringBuilder.indexOf("\t") + 1).isEmpty()) {
                    tab3[tabIndexI][i] = stringBuilder.toString();
                    break;
                }
                tab3[tabIndexI][i] = stringBuilder.substring(0, stringBuilder.indexOf("\t"));
                stringBuilder.delete(0,stringBuilder.indexOf("\t")+1);
            }
            tabIndexI++;
        }

        int[] tabBlackList = new int[281];
        for (String[] s1 : tab3)
            if (s1[1].equals("informatyka") || s1[1].equals("gry komputerowe"))
                tabBlackList[Integer.parseInt(s1[0])-1]++;

        ArrayList<String[]> listZain = new ArrayList<>();
        for (int i = 0; i < tab1_size1; i++)
            if (tabBlackList[i] == 0)
                if (Integer.parseInt(tab1[i][3]) > 50 && (tab1[i][4].equals("wyzsze") || tab1[i][4].equals("srednie")))
                    for (String[] s1 : tab3)
                        if (Integer.parseInt(s1[0]) == i){
                            boolean inList = false;
                            for (String[] strings : listZain)
                                if (Arrays.equals(strings, new String[]{tab1[i][1], tab1[i][2], tab1[i][6]})) {
                                    inList = true;
                                    break;
                                }
                            if (!inList) listZain.add(new String[]{tab1[i][1], tab1[i][2], tab1[i][6]});
                        }

        String[][] tabZain = new String[listZain.size()][3];
        tabIndexI = 0;
        for (String[] s1 : listZain)
            tabZain[tabIndexI++] = s1;

        for (int i = 1; i < tabZain.length; i++)
            if (tabZain[i-1][0].charAt(0) > tabZain[i][0].charAt(0)){
                String[] copy = tabZain[i-1];
                tabZain[i-1] = tabZain[i];
                tabZain[i] = copy;
            }

        for (String[] s1 : tabZain) {
            for (String s2 : s1) 
                System.out.print(s2 + " ");
            System.out.println();
        }

        double dochod = 0.00;
        int liczba = 0;
        for (int i = 0; i < tab1_size1; i++)
            if (tab1[i][6].equals("Zachodniopomorskie") && new StringBuilder(tab1[i][2]).charAt(new StringBuilder(tab1[i][2]).length()-1) == 'a')
                for (int j = i*4; j < i*4+4; j++)
                    if (tab2[j][1].equals("rower")){
                        liczba++;
                        dochod += Double.parseDouble(tab1[i][5]);
                        break;
                    }
        System.out.println(dochod/liczba);
    }
}