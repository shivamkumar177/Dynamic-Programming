import java.util.*;
public class optimal_strategy1
{
        static int arr[];
        static int dp[][];
        static int solve(int i ,int j)
        {
            if(i>j)
                return 0;
           // if(i==j-1)
             //   return Math.max(arr[i],arr[j-1]);
            if(dp[i][j]!=0)
                return dp[i][j];
            
            int a = arr[i] + Math.min(solve(i+2,j),solve(i+1,j-1));
            int b = arr[j] + Math.min(solve(i,j-2),solve(i+1,j-1));

            dp[i][j] = Math.max(a,b);
            return dp[i][j];
        }
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            arr = new int[n];
            dp = new int[n][n];
            int i;
            for(i=0;i<n;i++)
                arr[i] = sc.nextInt();
            
            int ans = solve(0,n-1);
            System.out.println(ans);
        }
}