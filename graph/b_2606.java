package graph;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class b_2606 {
    static Stack<Integer> stack = new Stack<Integer>();
    static int count = 0;
    static int[] node = {};

    public static void main(String[] args){
        b_2606 bb = new b_2606();
        Scanner sc = new Scanner(System.in);
        //node 수
        int N = sc.nextInt();
        //edge 수
        int M = sc.nextInt();
        int[][] map = new int[N+1][N+1];
        //System.out.println(N+" "+M);
        for(int i = 0;i<N+1;i++){
            for(int j = 0;j<N+1;j++){
                map[i][j]=0;
            }
        }
        sc.nextLine();
        for(int i=0;i<M;i++){
            String[] tmp = sc.nextLine().split(" ");
            
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            map[a][b] = 1;
            map[b][a] = 1;
        }
        node = new int[N+1];
        for(int f=0;f<N+1;f++){
            node[f] = 1;
        }
        stack.add(1);
        bb.virus(map,1);
        System.out.println(count);
    }

    public void virus(int[][] map, int start){
        node[start] = 0;
        int[] tmp = map[start];
        for(int i=0;i<tmp.length;i++){
            if(tmp[i] == 1 && node[i] == 1){
                node[i] = 0;
                count++;
                stack.add(i);
                map[start][i] = 0;
                map[i][start] = 0;
                virus(map,i);
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                
            }
                
        }
    }
}
