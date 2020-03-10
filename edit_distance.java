import java.util.*;
import java.lang.*;
public class edit_distance
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int l1 = s1.length();
        int l2 = s2.length();
        int dp[][] = new int[l1+1][l2+1];
        int i,j;
        
        for(i=0;i<=l1;i++)
            dp[i][0] = i;
        for(i=0;i<=l2;i++)
            dp[0][i] = i;
        for(i=1;i<=l1;i++)
        {
            for(j=1;j<=l2;j++)
            {
                if(s1.charAt(i-1)!=s2.charAt(j-1))
                {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                }
                else
                    dp[i][j] = dp[i-1][j-1];
            }
        }
        System.out.println(dp[l1][l2]);
    }
}