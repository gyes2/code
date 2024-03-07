package graph;

import java.util.Scanner;

public class b_1388 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        String[][] map = new String[N][M];
        int[][] check = new int[N][M];

        for(int i  =0; i <N;i++){
            String tmp = sc.nextLine();
            String[] tmp1 = tmp.split("");
            for(int j=0;j<M;j++){
                map[i][j] = tmp1[j];
                check[i][j] = 1;
            }
        }

        int count = 0;

        for(int i  =0; i <N;i++){
            for(int j=0;j<M;j++){
                count = dfs(map,map[i][j],i,j,count,check);
            }
        }

        System.out.println(count);

    }

    public static int dfs(String[][] map, String cur, int x, int y, int count, int[][] check){
        
        if(0<=y && y<map.length && 0<=x && x<map[0].length){
            if(check[y][x] == 0){
                return count;
            }
            
            if(cur.equals(map[y][x])){
                check[y][x] = 0;
                if(cur.equals("-")){
                    count += dfs(map,cur,x+1,y,count,check);
                }
                else{
                    count += dfs(map,cur,x,y+1,count,check);
                }  
            }
            else{
                count += 1;
                if(map[y][x].equals("-")){
                    count += dfs(map,cur,x+1,y,count,check);
                }
                else{
                    count += dfs(map,cur,x,y+1,count,check);
                }   
            }
        }
        return count+1;
 
    }
}
