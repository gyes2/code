package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class kote{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        ArrayList<int[]> results = new ArrayList<>();
        for(int i =1; i<= T; i++){
            int N = sc.nextInt();
            
            int[] power = new int[N+1];
            for(int j = 1; j < N+1;j++){
                power[j] = sc.nextInt();
            }
            System.out.println("#"+i+" "+sumMaxPower(power,N));
        }
        
    }

    public static int sumMaxPower(int[] power, int N){
        int[][] result = new int[N+1][N+1];
        for(int i = 1;i <=N;i++){
            for(int j = i;j<=N;j++){
                for(int k = i; k<=j;k++){
                    result = go(result,power,i,j,k);
                }
                
            }
        }
        System.out.println(Arrays.deepToString(result));
        
        int max = 0;
        for(int y=1;y<N;y++){
            int[] tmp = result[y];
            
            max += Math.max(Math.abs(tmp[y]), Math.abs(tmp[y+1]));
        }

        return max;
    }

    public static int[][] go(int[][] result,int[] power, int start, int end, int middle){
        for(int i = start; i <= end; i ++){
            int tmp = 0;
            if(suo(power,start,end,i) < su(power,start,end,i)){
                    tmp = su(power,start,end,i);
                }
            else{
                tmp = suo(power,start,end,i);
            }
            if(tmp > result[middle][i]){
                result[middle][i] = tmp;
            }
        }
        
        return result;
    }

    public static int su(int[] power, int start, int end, int middle){
        int max = 0;
        for(int i = start; i<=end; i++){
            
            if(i == middle){
                continue;
            }
            max += power[i];
        }
        
        return max;
    }

    public static int suo(int[] power, int start, int end, int middle){
        int max = 0;
        for(int i = start; i<=end; i++){

            max += power[i];
        }
        
        return max;
    }
}