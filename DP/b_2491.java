import java.util.*;
import java.io.*;

public class b_2491 {
  static int[] answer;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    answer = new int[N-1];
    sc.nextLine();
    for(int i=0; i<N;i++){
      arr[i] = sc.nextInt();
    }
    int cnt = 1;
    int pls = 1;
    int max = 0;
    for(int i=0;i<N-1;i++){
      if(arr[i] > arr[i+1]){
        answer[i] = -1;
      }
      else if(arr[i]<arr[i+1]){
        answer[i] = 1;
      }
      else{
        answer[i] = 0;
      }
    }
    int m = 0;
    for(int i=0;i<N-1;i++){

      int tmp = cntMethod(i);
      if(m < tmp){
        m = tmp;
      }
    }
    
    System.out.println(m+1);

  }
  private static int cntMethod(int start){
    int cnt = 1;
    int max = 0;
    for(int i = start;i<answer.length-1;i++){
      if(answer[i] == 0){
        if(answer[i+1] == answer[i-1] || (answer[i+1] != answer[i-1] && (answer[i+1] == 0 || answer[i-1]==0))){
          cnt++;
        }
      }
      else{
        if(answer[i] == answer[i+1] || answer[i+1] == 0){
          cnt++;
        }
        else{
          cnt = 1;
        }
      }
      if(max < cnt){
        max = cnt;
      }
    }
    
    return max;
  }
}
