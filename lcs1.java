import java.util.*;
public class lcs1
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int l1 = s1.length();
        int l2 = s2.length();
        int dp[][] = new int[l1+1][l2+1];
        int i=0,j=0;
        for(i=0;i<=l1;i++)
            dp[i][0] = 0;
        for(i=0;i<=l2;i++)
            dp[0][i] = 0;
        for(i=1;i<=l1;i++)
        {
            for(j=1;j<=l2;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else    
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }

       /* for(i=0;i<=l1;i++)
        {
            for(j=0;j<=l2;j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }*/
        i=l1;
        String p="";
        for(j=l2;j>=0;j--)
        {
            if(dp[i][j]==0)
                break;
            if(dp[i][j]!=dp[i][j-1])
            {
                p = s2.charAt(j-1) + p;
                i--;
            }
        }
        System.out.println(p);
    }
}