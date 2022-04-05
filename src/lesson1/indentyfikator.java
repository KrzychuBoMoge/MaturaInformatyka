package lesson1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class indentyfikator {
    public static void main(String[] args) {
        ArrayList<String> file = new ArrayList<>();
        ArrayList<String> seria = new ArrayList<>();
        ArrayList<int[]> numer = new ArrayList<>();
        ArrayList<String> polindromy = new ArrayList<>();
        ArrayList<String> niepoprawneId = new ArrayList<>();
        BufferedReader br;
        int suma = 0 , indexSum = 0;
        int hasNext;
        try {
            br = new BufferedReader(new FileReader("/home/bartoszb/Java/projects/RozszerzonaInformatyka/src/lesson1/files/DANE/identyfikator.txt"));
             hasNext = br.read();
            while (hasNext != -1){
                file.add(Character.toString(hasNext) + br.readLine());
                hasNext = br.read();
            }
            for (String s : file) {
                int[] returnAnswer = new int[6];
                StringBuilder stringBuilder = new StringBuilder(s);
                seria.add(stringBuilder.substring(0,3));
                String sNumber = stringBuilder.substring(3,9);
                for (int i = 0; i < sNumber.length(); i++) {
                    returnAnswer[i] = Integer.parseInt(String.valueOf(sNumber.charAt(i)));
                }
                numer.add(returnAnswer);
            }
            for (int i = 0; i < seria.size(); i++) {
                int subSum = 0;
                for (int j : numer.get(i)) {
                    subSum += j;
                }
                if (suma < subSum) {
                    suma = subSum;
                    indexSum = i;
                }
            }
            System.out.print(seria.get(indexSum));
            for (int j : numer.get(indexSum)) {
                System.out.print(j);
            }

            for (int i = 0; i < seria.size(); i++) {
                String nString = seria.get(i);
                String rString = new StringBuilder(nString).reverse().toString();
                StringBuilder newInt = new StringBuilder();
                for (int j : numer.get(i)) {
                    newInt.append(j);
                }
                String nInt = newInt.toString();
                String rInt = new StringBuilder(nInt).reverse().toString();
                if (nString.equals(rString) || nInt.equals(rInt)) polindromy.add(nString+nInt);
            }
            System.out.println("\n"+polindromy);
            for (int i = 0; i < seria.size(); i++) {
                int[] wagi = {7,3,1,7,3,1,7,3};
                int indexWagi = 0;
                int sum = 0;
                StringBuilder newInt = new StringBuilder();
                for (int j : numer.get(i)) {
                    newInt.append(j);
                }
                String nInt = newInt.toString();
                String sSeria = seria.get(i);
                int[] sNumber = numer.get(i);
                for (int j = 0; j < sSeria.length(); j++)
                    sum += Character.getNumericValue(sSeria.charAt(j))*wagi[indexWagi++];
                for (int j = 1; j < sNumber.length; j++)
                    sum += sNumber[j]*wagi[indexWagi++];
                if (sum%10!=sNumber[0]) niepoprawneId.add(sSeria+nInt);
            }
            System.out.println(niepoprawneId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}