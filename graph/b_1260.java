package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class b_1260{
    static Stack<Integer> stack = new Stack<>();
    static int[] node = {};
    static int[] answer = {};
    static int index = 0;

    static Queue<Integer> queue = new LinkedList<Integer>();
    static int[] nodeB = {};
    static int[] answerB = {};
    static int indexB = 0;

    public static void main(String[] args){
        b_1260 bb = new b_1260();
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        int[][] map = new int[N+1][N+1];
        int[][] map2 = new int[N+1][N+1];
        node = new int[N+1];
        nodeB = new int[N+1];
        //index=N-1;
        answer = new int[node.length-1];
        answerB = new int[node.length-1];
        //맵 초기화
        for(int i=0;i<N+1;i++){
            for(int j=0; j<N+1;j++){
                map[i][j] = 0;
                map2[i][j] = 0;
                node[i] = 1;
                nodeB[i] = 1;
            }
        }
        sc.nextLine();
        //간선 연결
        for(int i=0;i<M;i++){
            String[] tmp = sc.nextLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            map[a][b] = 1;
            map[b][a] = 1;
            map2[a][b] = 1;
            map2[b][a] = 1;                                  
        }

        //System.out.println(Arrays.deepToString(map));
        bb.dfs(map,V);
        bb.bfs(map2,V);

        //System.out.println("dfs: "+Arrays.toString(answer));
        //System.out.println("bfs: "+Arrays.toString(answerB));
        for(int i=0; i<index;i++){
            System.out.print(answer[i]);
            System.out.print(" ");
        }
        System.out.println();
        for(int i=0; i<indexB;i++){
            System.out.print(answerB[i]);
            System.out.print(" ");
        }
    }

    public void bfs(int[][] map, int start){
        
        queue.add(start);
        while(!queue.isEmpty()){
            int s = queue.poll();
            answerB[indexB] = s;
            int[] tmp = map[s];
            
            for(int i=0;i<tmp.length;i++){
                if(tmp[i] == 1&&nodeB[i]==1){
                    map[start][i] = 0;
                    map[i][start] = 0;
                    nodeB[i]=0;
                    queue.add(i);
                }
            }
            //System.out.println(queue);
            indexB++;
        }
        
        
    }

    public void dfs(int[][] map, int start){
        int[] tmp = map[start];
        
        node[start]=0;
        stack.push(start);
        for(int i=0;i<tmp.length;i++){
            if(tmp[i] == 1&&node[i]==1){
                map[start][i] = 0;
                map[i][start] = 0;
                dfs(map,i);
            }
            else{
                if(!stack.isEmpty()){
                    int t = stack.pop();
                    answer[index] = t;
                    index++;
                    
                }
            }
        }
        
    }
    
    
}