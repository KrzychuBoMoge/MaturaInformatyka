package tablice;

public class tablcaDwuwymiarowa {
    public static void main(String[] args) {
        int[][] tab = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tab[i][j] = i*4+j;
            }
        }
        for (int[] i1 : tab) {
            for (int i2 : i1) {
                System.out.print(i2 + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(tab[i][j] + tab[i][j+1]);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                System.out.println(tab[i][j] + tab[i][j-1]);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(tab[j][i] + tab[j+1][i]);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                System.out.println(tab[j][i] + tab[j-1][i]);
            }
        }
    }
}
