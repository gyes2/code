import java.io.*;
import java.util.*;

public class Main {
  static public void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int digit = count(N);
    

    //각 자릿수가 다 채워졌을 때 가정.
    int[] cntDigit = {0,9,90,900,9000,90000,900000,9000000,90000000};
    int result = 0;
    if(digit > 1){
      for(int i = 1; i<digit; i++){
        result += cntDigit[i]*i;
      }
      int rest = N - (int)Math.pow(10,digit-1) + 1;
      
      result = result + rest*digit;
      System.out.println(result);
    }
    else{
      System.out.println(N);
    }
    
  }

  static private int count(int N){
    int cnt = 0;
    while(N > 0){
      N = N / 10;
      cnt++;
    }
    return cnt;
  }
}