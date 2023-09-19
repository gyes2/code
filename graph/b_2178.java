package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b_2178 {
    static Queue<int[]> queue = new LinkedList<int[]>();
    static int[][] map = {};
    static int[][] checkMap={};
    static int[][] countMap={};
    static int count = 1;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args){
        b_2178 bb = new b_2178();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        map = new int[N][M];
        checkMap = new int[N][M];
        countMap = new int[N][M];
        sc.nextLine();
        for(int i =0;i<N;i++){
            String[] tmp = sc.nextLine().split("");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(tmp[j]);
                checkMap[i][j] = 1;
                countMap[i][j] = 0;
            }
        }
        int[] start = new int[2];
        start[0] = 0;
        start[1] = 0;
        //start[2] = 1;
        countMap[0][0] = 1;
        queue.add(start);
        checkMap[0][0] = 0;
        bb.bfs(map,N,M);
        
    }

    public void bfs(int[][] map,int N, int M){
        
        while(!queue.isEmpty()){
            
            int[] tmp = queue.poll();
            int y = tmp[0];
            int x = tmp[1];
            //int cnt = tmp[2];
            System.out.println(Arrays.toString(tmp));
            for(int i = 0;i<4;i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if( newX > -1 && newX < M && newY>-1 && newY<N){
                    if(map[newY][newX]==1 && checkMap[newY][newX]==1){
                        
                        count++;
                        int[] newStart = new int[2];
                        newStart[0] = newY;
                        newStart[1] = newX;
                        countMap[newY][newX] = countMap[y][x] + 1;
                        queue.add(newStart);
                        checkMap[newY][newX]=0;
                    }
                }
            }

        }
        System.out.println(countMap[N-1][M-1]);
    }
}
