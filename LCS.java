import java.util.*;
public class LCS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int l1 = a.length();
		int l2 = b.length();
		int dp[][] = new int[l1 + 1][l2 + 1];
		int i, j;
		for (i = 0; i <= l1; i++)
			dp[i][0] = 0;
		for (i = 0; i <= l2; i++)
			dp[0][i] = 0;
		StringBuffer s = new StringBuffer();
		for (i = 0; i < l1; i++) {
			for (j = 0; j < l2; j++) {
				if (a.charAt(i) == b.charAt(j))
					dp[i + 1][j + 1] = 1 + dp[i][j];
				else
					dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
			}
		}
		i = l1;
		j = l2;
		while (i > 0 && j > 0) {
			if (dp[i][j] != dp[i][j - 1]) {
				s = s.append(Character.toString(b.charAt(j - 1)));
				i = i - 1;
				j = j - 1;
			} else {
				j--;
			}
		}
		//  System.out.println(dp[l1][l2]);  length of LCS
		System.out.print(s.reverse());
	}
}
