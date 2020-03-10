import java.util.*;
import java.lang.*;
public class matrix_chain
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int nu = sc.nextInt();
        int arr[] = new int[nu+1];
        System.out.println("Enter the final dimen. : ");
        int i;
        for(i=0;i<=nu;i++)
            arr[i] = sc.nextInt();
        
        int dp[][] = new int[nu][nu];
        int n = nu;
        for(i=1;i<n;i++)
        {
            int r=0,c=i;
            while(c<n)
            {
                int val = Integer.MAX_VALUE;
                int pivot;
                for(pivot = r;pivot < c;pivot++)
                    val = Math.min(val,dp[r][pivot]+dp[pivot+1][c] + arr[r]*arr[pivot+1]*arr[c+1]);
                
                dp[r][c] = val;
                r++;
                c++;
            }
        }
        System.out.println(dp[0][n-1]);
    }
}