import java.util.Scanner;
public class Inversion {
    private int number_of_inversions;
    private int[] array;
    private int[] tempMergArr;

    public Inversion(){
        this.number_of_inversions = 0;
    }
    public static void main(String a[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = sc.nextInt();
        Inversion inv_f = new Inversion();
        inv_f.sort(arr,n);
        System.out.println(inv_f.number_of_inversions);
    }

    public void sort(int inputArr[],int n) {
        this.array = inputArr;
        this.tempMergArr = new int[n];
        number_of_inversions = deMerge(0, n - 1);
    }

    private int deMerge(int lowerIndex, int higherIndex) {
        int z = 0;
        if (lowerIndex < higherIndex) {
            int a ,b;
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;

            a = (deMerge(lowerIndex, middle))%100000;
            b = (deMerge(middle + 1, higherIndex))%100000;

            z = (merge(lowerIndex, middle,middle+1, higherIndex)+a+b)%100000;
        }
        return z;
    }

    private int merge(int lowerIndex, int middle,int n_middle, int higherIndex) {
        int z = 0;
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = n_middle;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                z += middle - i + 1;
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
        return z;
    }
}