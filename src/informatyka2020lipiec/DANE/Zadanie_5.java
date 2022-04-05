package informatyka2020lipiec.DANE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Zadanie_5 {
    public static void main(String[] args) throws IOException {
        int time = 18*60;
        Path file = Paths.get("DANE/myjnia.txt");
        ArrayList<String[]> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file.toFile()));
        while (bufferedReader.ready()) {
            StringBuilder stringBuilder = new StringBuilder(bufferedReader.readLine());
            String[] line = new String[3];
            for (int i = 0; i < 2; i++) {
                line[i] = (stringBuilder.substring(0,stringBuilder.indexOf(";")));
                stringBuilder.delete(0,stringBuilder.indexOf(";")+1);
            }
            line[2] = stringBuilder.toString();
            list.add(line);
        }

        int[] programy = new int[15];
        for (String[] s1 : list) {
            programy[Integer.parseInt(s1[1])-1]++;
        }
        for (int i : programy) {
            System.out.print(i + " ");
        }

        HashMap<String, Integer> mapaRejestracji = new HashMap<>();
        for (String[] s1 : list) {
            StringBuilder stringBuilder = new StringBuilder(s1[2]);
            if (mapaRejestracji.containsKey(stringBuilder.substring(0, 2)))
                mapaRejestracji.replace(stringBuilder.substring(0, 2), mapaRejestracji.get(stringBuilder.substring(0, 2))+1);
            else
                mapaRejestracji.put(stringBuilder.substring(0, 2),1);
        }

        for (int i : mapaRejestracji.values()) {
            if (i == 1 || i == 2)
                System.out.println(true);
        }
    }
}
