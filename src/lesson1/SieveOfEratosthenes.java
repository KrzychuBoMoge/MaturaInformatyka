package lesson1;


public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int max = 120;
        int[] tab = new int[max];
        for (int i = 2; i < max; i++) {
            if (tab[i] != -1){
                for (int j = 2*i; j < max; j+=i) {
                    tab[j] = -1;
                }
                System.out.print(i + " ");
            }
        }
    }
}
