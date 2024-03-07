import java.util.*;
import java.io.*;

public class b_2839{
  static int N = 0;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    int[] answer = new int[N+1];
    for(int i=1;i<N+1;i++){
      answer[i] = 0;
    }
    
    for(int j = 3; j <= N; j++){
      answer = countSuga(j,answer);
    }
    if(answer[N] == 0){
      System.out.println(-1);
      return;
    }
    System.out.println(answer[N]);
  }

  private static int[] countSuga(int tmp,int[] answer){
    
    int min = N;
    for(int i=1;i<=tmp;i++){
      if(answer[i] != 0 && answer[tmp-i] != 0){
        if(answer[i] + answer[tmp-i] < min ){
          answer[tmp] = answer[i] + answer[tmp-i];
          min = answer[i] + answer[tmp-i];
          
        }
      }
    }
    if(min == N && (tmp % 3 == 0 || tmp % 5 == 0)){
      if(tmp % 3 == 0){
        answer[tmp] = tmp/3;
      }
      else{
        answer[tmp] = tmp/5;
      }
    }
    return answer;
  }
}