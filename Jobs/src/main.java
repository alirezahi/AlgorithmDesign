/**
 * Created by Alireza on 5/14/17.
 */
import java.util.ArrayList;
import java.util.Scanner;
public class main {
//    public static ArrayList permutation(int [] list){
//        if(list.length == 0 || list.length==1)
//            return list;
//        ArrayList result = new ArrayList();
//        for(int i=0;i<list.length;i++){
//            int tmp = list[i];
//            int[] tmp_list = new int[list.length-1];
//            int z = 0,r=0;
//            while(z<tmp_list.length){
//                if(z!=i){
//                    tmp_list[z] = list[r];
//                    z++;
//                }
//                r++;
//            }
//            for(int w=0;w<permutation(tmp_list).length;w++){
//                int[] tmp_result = new int[list.length];
//                tmp_result[0] = tmp;
//                for()
//                result.add();
//            }
//
//        }
//    }
public static ArrayList<ArrayList<Integer>> permute(int[] num) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();


    result.add(new ArrayList<>());
    for (int i = 0; i < num.length; i++) {
        ArrayList<ArrayList<Integer>> current = new ArrayList<>();
        for (ArrayList<Integer> l : result) {
            for (int j = 0; j < l.size()+1; j++) {
                l.add(j, num[i]);
                ArrayList<Integer> temp = new ArrayList<>(l);
                current.add(temp);
                l.remove(j);
            }
        }

        result = new ArrayList<ArrayList<Integer>>(current);
    }

    return result;
}
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] table = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                table[i][j] = sc.nextInt();
        }
        int[] data = new int[n];
        for(int i=0;i<n;i++)
            data[i]= i;
        ArrayList<ArrayList<Integer>> result = permute(data);
        int min_num = 999999999;
        ArrayList<Integer> tmp_res = new ArrayList<>();
        for(int i=0;i<result.size();i++){
            int tmp_num = 0;
            for(int j=0;j<result.get(i).size();j++)
                tmp_num += table[j][result.get(i).get(j)];
            if(tmp_num<min_num){
                min_num = tmp_num;
                tmp_res = result.get(i);
            }
        }
        for(int i=0;i<tmp_res.size();i++)
            System.out.println(tmp_res.get(i));
    }
}
