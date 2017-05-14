/**
 * Created by Alireza on 5/11/17.
 */
import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[2][n];
        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++)
                a[i][j] = sc.nextInt();
        }
        int end_time = 0;
        int[] b = new int[n];
        int num = 0;
        for(int i=0;i<n;i++){
            if (end_time<=a[0][i]){
                b[num] = i;
                end_time = a[1][i];
                num++;
            }
        }
        for(int i=0;i<num;i++)
            System.out.print(b[i]+" ");
    }
}
