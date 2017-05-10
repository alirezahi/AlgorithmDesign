import java.util.Scanner;
public class Main {
    public static int coin_change(int amount,int[] v) {
        int[][] table = new int[v.length + 1][amount + 1];

        for (int i = 1; i <= amount; i++)
            table[0][i] = 0;

        for (int i = 0; i <= v.length; i++)
            table[i][0] = 1;

        for (int i = 1; i <= v.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (v[i - 1] <= j) table[i][j] = (table[i - 1][j] + table[i][j - v[i - 1]])%1000000;
                else table[i][j] = table[i - 1][j];
            }
        }
        return table[v.length][amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int n = sc.nextInt();
        int [] a = new int[v];
        for (int i=0;i<v;i++)
            a[i] = sc.nextInt();
        System.out.println(coin_change(n,a));
    }

}