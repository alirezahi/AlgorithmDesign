/**
 * Created by Alireza on 3/26/17.
 */
import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] array = new int[100][100];
        int [][] tmp_array = new int[100][100];
        for (int i=0;i<100;i++){
            for(int j=0;j<100;j++)
                array[i][j] = 0;
        }
        for(int i=0;i<n;i++)
            array[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                tmp_array[i][j] = array[i][j];
                if(array[i][j]>50){
                    tmp_array
                }
            }
        }
    }
}
