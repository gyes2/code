package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class b_1158 {
    
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        //원으로 둘러 앉기
        int[] circle = new int[N+1];
        for(int i =1;i<=N;i++){
            circle[i] = i;
        }

        int count = 0;
        
        getCur(circle,K,N,1,count);

        System.out.print("<");
        for(int i =0;i<result.size();i++){
            System.out.print(result.get(i));
            if(i != result.size()-1){
                System.out.print(", ");
            }
            
        }
        System.out.print(">");
    }

    public static void getCur(int[] member, int K, int N, int cur, int count){
        
        if(member[cur] != 0){
            count += 1;
            if(count == K){
                
                member[cur] = 0;
                result.add(cur);
                count = 0;
                cur = (cur+1) % N;
                if(cur == 0){
                    cur = N;
                }
                getCur(member, K, N, cur,count);
            }
            else{
                cur = (cur+1) % N;
                if(cur == 0){
                    cur = N;
                }
                getCur(member, K, N, cur,count);
            }
        }
        else{
            if(empty(member)){
                return;
            }
            else{
                cur = (cur+1) % N;
                if(cur == 0){
                    cur = N;
                }
                getCur(member, K, N, cur,count);
            }
        }
    }

    public static boolean empty(int[] member){
        boolean re = true;
        for(int i =0; i<member.length;i++){
            if(member[i] != 0){
                re = false;
                break;
            }
        }
        return re;
    }
}
