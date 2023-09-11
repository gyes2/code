package sorting;

import java.io.InputStream;
import java.util.Scanner;

public class b_2750 {
    public static void main(String[] args){
        //N 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for(int n = 0;n<N;n++){
            array[n] = sc.nextInt();
        }
        //정렬 - 버블정렬 이용
        for(int i=N-1; i>-1; i--){
            for(int j=0;j<i;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        //출력
        for(int i : array){
            System.out.println(i);
        }
       
    }
}
