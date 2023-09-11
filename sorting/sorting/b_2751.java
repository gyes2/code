package sorting;


import java.util.Scanner;

public class b_2751 {
    public static void main(String[] args){
        //N 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int index = 0;
        int[] array = new int[N];
        for(int n = 0;n<N;n++){
            array[n] = sc.nextInt();
            for(int j=n;j>0;j--){
                if(array[j] > array[j-1]){
                    break;
                }
                else{
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }

        //출력
        for(int i : array){
            System.out.println(i);
        }
       
    }
}