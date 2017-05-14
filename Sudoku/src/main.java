/**
 * Created by Alireza on 5/14/17.
 */
import java.util.Scanner;
public class main {
    public static void print_result(int[][] table){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[] find_zero(int [][] table){
        int[] a =new int[2];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(table[i][j] ==0){
                    a[0]=i;
                    a[1]=j;
                    return a;
                }
            }
        }
        a[0]=-1;
        a[1]=-1;
        return a;
    }
    public static boolean check_row(int[][] table,int row,int col,int test_num){
        for(int i=0;i<9;i++){
            if(i!=col && table[row][i]== test_num)
                return false;
        }
        return true;
    }
    public static boolean check_col(int[][] table,int row,int col,int test_num){
        for(int i=0;i<9;i++){
            if(i!=row && table[i][col]== test_num)
                return false;
        }
        return true;
    }
    public static boolean check_around(int[][] table,int row,int col,int test_num){
        for(int i=(int)(row/3)*3;i<(int)(row/3)*3+3;i++){
            for(int j=(int)(col/3)*3;j<(int)(col/3)*3+3;j++){
                if(!(i==row && j== col) && table[i][j] == test_num)
                    return false;
            }
        }
        return true;
    }
    public static boolean check_valid(int[][] table,int row,int col,int test_num){
        if(check_row(table,row,col,test_num) && check_col(table,row,col,test_num) && check_around(table,row,col,test_num))
            return true;
        return false;
    }
    public static boolean sudoku(int [][] table){
        int[] location;
        location = find_zero(table);
        if(location[0]+location[1]==-2){
            print_result(table);
            return true;
        }
        for(int i=1;i<10;i++){
            if(check_valid(table,location[0],location[1],i)){
                table[location[0]][location[1]] = i;
                if(!sudoku(table))
                    table[location[0]][location[1]] = 0;
                else
                    return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int [][] table = new int[9][9];
        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                table[i][j] = sc.nextInt();
            }
        }
        sudoku(table);
    }
}
