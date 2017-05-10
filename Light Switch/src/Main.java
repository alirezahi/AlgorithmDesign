/**
 * Created by Alireza on 3/25/17.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static char change_num(char num){
        if(num == '1')
            return '0';
        return '1';
    }
    public static ArrayList<String> check_light(int n,int situation, ArrayList<Integer> lights_on, ArrayList<Integer> lights_off, ArrayList<String> result){
        char[] num_check = new char[n];
        for(int i=0;i<n;i++)
            num_check[i] = '1';
        if(situation%10 == 1){
            for(int i=0;i<n;i++)
                num_check[i] = change_num(num_check[i]);
        }
        if((situation/10)%10 == 1){
            for(int i=0;i<n;i=i+2)
                num_check[i] = change_num(num_check[i]);
        }
        if((situation/100)%10 == 1){
            for(int i=1;i<n;i=i+2)
                num_check[i] = change_num(num_check[i]);
        }
        if((situation/1000)%10 == 1){
            for(int i=0;i<n;i=i+3)
                num_check[i] = change_num(num_check[i]);
        }
        Boolean okay = true;
        for(int i:lights_on){
            if(num_check[i-1] != '1')
                okay = false;
        }
        for(int i:lights_off){
            if(num_check[i-1] != '0')
                okay = false;
        }
        if(okay)
            result.add(new String(num_check));
        return result;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        ArrayList<Integer> lights_on = new ArrayList<>();
        ArrayList<Integer> lights_off = new ArrayList<>();
        int a = sc.nextInt();
        while(a!=-1){
            lights_on.add(a);
            a = sc.nextInt();
        }
        a = sc.nextInt();
        while(a!=-1){
            lights_off.add(a);
            a = sc.nextInt();
        }
        ArrayList<String> result = new ArrayList<>();
        if(c==0)
            result = check_light(n,0,lights_on,lights_off,result);
        else if(c==1) {
            result = check_light(n, 1, lights_on, lights_off, result);
            result = check_light(n, 10, lights_on, lights_off, result);
            result = check_light(n, 100, lights_on, lights_off, result);
            result = check_light(n, 1000, lights_on, lights_off, result);
        }
        else if(c==2) {
            result = check_light(n, 0, lights_on, lights_off, result);
            result = check_light(n, 11, lights_on, lights_off, result);
            result = check_light(n, 101, lights_on, lights_off, result);
            result = check_light(n, 1001, lights_on, lights_off, result);
            result = check_light(n, 110, lights_on, lights_off, result);
            result = check_light(n, 1010, lights_on, lights_off, result);
            result = check_light(n, 1100, lights_on, lights_off, result);
        }
        else if(c%2==1) {
            result = check_light(n, 1, lights_on, lights_off, result);
            result = check_light(n, 10, lights_on, lights_off, result);
            result = check_light(n, 100, lights_on, lights_off, result);
            result = check_light(n, 1000, lights_on, lights_off, result);
            result = check_light(n, 111, lights_on, lights_off, result);
            result = check_light(n, 1011, lights_on, lights_off, result);
            result = check_light(n, 1101, lights_on, lights_off, result);
            result = check_light(n, 1110, lights_on, lights_off, result);
        }
        else if(c%2==0){
            result = check_light(n, 0, lights_on, lights_off, result);
            result = check_light(n, 11, lights_on, lights_off, result);
            result = check_light(n, 101, lights_on, lights_off, result);
            result = check_light(n, 1001, lights_on, lights_off, result);
            result = check_light(n, 110, lights_on, lights_off, result);
            result = check_light(n, 1010, lights_on, lights_off, result);
            result = check_light(n, 1100, lights_on, lights_off, result);
            result = check_light(n, 1111, lights_on, lights_off, result);
        }
        Collections.sort(result);
        if(result.size()>0){
            for(String i:result)
                System.out.println(i);
        }
        else
            System.out.println("IMPOSSIBLE");
    }
}
