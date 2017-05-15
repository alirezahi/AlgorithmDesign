/**
 * Created by Alireza on 5/14/17.
 */
import java.util.ArrayList;
import java.util.Scanner;
public class main {
    static ArrayList<int[]> result = new ArrayList<>();
    static int size;
    static int [][] table;
    static int min_num = 99999999;
    static int[] res;
//public static ArrayList<ArrayList<Integer>> permute(int[] num) {
//    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//
//
//    result.add(new ArrayList<>());
//    for (int i = 0; i < num.length; i++) {
//        ArrayList<ArrayList<Integer>> current = new ArrayList<>();
//        for (ArrayList<Integer> l : result) {
//            for (int j = 0; j < l.size()+1; j++) {
//                l.add(j, num[i]);
//                ArrayList<Integer> temp = new ArrayList<>(l);
//                current.add(temp);
//                l.remove(j);
//            }
//        }
//
//        result = new ArrayList<>(current);
//    }
//
//    return result;
//}
    public static void permutation(int[] list,int start){
        if(start == size-1){
            int tmp_res = 0;
            for(int i=0;i<size;i++){
                tmp_res += table[i][list[i]];
                if(tmp_res>min_num)
                    break;
            }
            if(tmp_res<min_num){
                for(int i=0;i<size;i++)
                    res[i] = list[i];
                min_num = tmp_res;
            }
        }
        else {
            for (int i = start; i < size; i++) {
                int tmp;
                tmp = list[start];
                list[start] = list[i];
                list[i] = tmp;
                permutation(list, start + 1);
                tmp = list[start];
                list[start] = list[i];
                list[i] = tmp;
            }
        }

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        size = n;
        res = new int[n];
        table = new int[size][size];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                table[i][j] = sc.nextInt();
        }
        int[] data = new int[n];
        for(int i=0;i<n;i++)
            data[i]= i;
        permutation(data,0);
//        int min_num = 999999999;
//        int[] tmp_res = new int[n];
//        for(int i=0;i<result.size();i++){
//            int tmp_num = 0;
//            for(int j=0;j<n;j++){
//                tmp_num += table[j][result.get(i)[j]];
//                if (tmp_num>min_num)
//                    break;
//            }
//            if(tmp_num<min_num){
//                min_num = tmp_num;
//                tmp_res = result.get(i);
//            }
//        }
        for(int i=0;i<n;i++)
            System.out.println(res[i]);
    }
}
