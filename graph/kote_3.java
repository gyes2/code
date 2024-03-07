package graph;

import java.util.Scanner;
import java.util.*;

public class kote_3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    for(int i = 0; i<T; i++){
      int N = sc.nextInt();
      int K = sc.nextInt();
      sc.nextLine();
      List<List<Integer>> cross = new ArrayList<>();
      for(int j = 0; j<N+1;j++){
        
        List<Integer> tmp1 = new ArrayList<>();
        cross.add(tmp1);
      }
      System.out.println(cross.toString());

      for(int j = 0; j<N-1;j++){
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        List<Integer> tmp1 = cross.get(a);
        tmp1.add(b);
        List<Integer> tmp2 = cross.get(b);
        tmp2.add(a);
        sc.nextLine();
      }
      System.out.println(cross.toString());
      
      int[] crime = new int[N+1];
      int[] check = new int[N+1];
      for(int m = 1; m<=N;m++){
        int t = sc.nextInt();
        crime[m] = t;
        check[m] = 0;
      }


      int total = 0;
      for(int l=0;l<N;l++){
        check = initCheck(check);
        total += dfs(N,K,cross,check,crime,l+1,0,0);
      }
      System.out.println("#"+i+" "+total);
      System.out.println("한번끝");
    }

  }

  public static int dfs(int N,int K, List<List<Integer>> cross, int[] check, int[] crime ,int start, int count, int maxCount){
    if(maxCount <= K && check[start] == 0){
      check[start] = 1;
      if(crime[start] == 1){
        count++;
      }
      List<Integer> tmp = cross.get(start);
      for(int i =0;i<tmp.size();i++){
        if(check[tmp.get(i)] == 0){
          int tt = dfs(N,K,cross,check,crime,tmp.get(i),count,maxCount+1);
          if(tt>count){
            count =  tt;
            
          }
        }
      }
    }
    return count;
  }
  
  public static int[] initCheck(int[] check){
    for(int m = 1; m<check.length;m++){ 
        check[m] = 0;
      }
      return check;
  }
}