import java.util.*;
import java.lang.*;
public class valentine
{
    static int n,m;
    static int arr1[];
    static int arr2[];
    static int dp[][];

    static int solve(int i,int j)
    {
        if(i==n)
            return 0;
        if(j==m)    
            return Integer.MAX_VALUE;
        if(dp[i][j]!=0)
            return dp[i][j];
        int o1 = Math.abs(arr1[i]-arr2[j]) + solve(i+1,j+1);
        int o2 = solve(i,j+1);

        dp[i][j] = Math.min(o1,o2);
        return dp[i][j];
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //number of boys
        m = sc.nextInt(); //number of girls
        arr1 =  new int[n];
        arr2 =  new int[m];
        dp = new int[n][m];
        int i;
        for(i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        for(i=0;i<m;i++)
            arr2[i] = sc.nextInt();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(solve(0,0));
    }
}