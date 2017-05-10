/**
 * Created by Alireza on 2/28/17.
 */
import java.util.Scanner;
public class main {
    static int [][] c ;
    private static int combination(int n,int k){
        if ( c[n][k] == 0)
            c[n][k] = (combination(n-1,k) + combination(n-1,k-1))%1000000;
        return c[n][k];
    }
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        c = new int[n+1][k+1];
        for (int i=0;i<=n;i++)
            c[i][0]=1;
        for (int j=0;j<=k;j++)
            c[j][j]=1;
        System.out.println(combination(n,k));
    }
}