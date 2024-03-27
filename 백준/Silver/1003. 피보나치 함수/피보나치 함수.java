import java.util.Scanner;

public class Main{
    static int[][] dp = new int[46][2];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int n = sc.nextInt();
        sc.nextLine();
        
        for(int j = 0; j<n;j++){
            int m = sc.nextInt();
            pivo(m);
        }
        
    }

    public static void pivo(int n){

        if(n == 0){
            System.out.println(dp[0][0]+" "+dp[0][1]);
        }
        else if(n==1){
            System.out.println(dp[1][0]+" "+dp[1][1]);
        }
        else{
            for(int i = 2; i < n+1;i++){
                dp[i][0] = dp[i-1][0]+dp[i-2][0];
                dp[i][1] = dp[i-1][1]+dp[i-2][1];
            }
            
            System.out.println(dp[n][0]+" "+dp[n][1]);
        }
    }
}