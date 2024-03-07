import java.util.Scanner;
import java.io.*;

public class b_2491 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    sc.nextLine();
    for(int i=0; i<N;i++){
      arr[i] = sc.nextInt();
    }
    int cnt = 1;
    int pls = 1;
    for(int j=0;j<N-1;j++){
      if(arr[j] < arr[j+1] && pls == 1){
        cnt++;
      }
      else if(arr[j] < arr[j+1] && pls == -1){
        cnt = 1;
        pls = -1;
      }
      else if(arr[j] > arr[j+1] && pls == -1){
        cnt++;
      }
      else{
        cnt = 1;
        pls = 1;
      }
    }
    System.out.println(cnt);
  }
}
