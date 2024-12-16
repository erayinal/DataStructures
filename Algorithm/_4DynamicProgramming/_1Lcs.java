package Algorithm._4DynamicProgramming;

public class _1Lcs {
    

    public static void main(String[] args) {

        String s1 = "abcdef";
        String s2 = "acbcf";

        //findLongestCommonSubstring(s1, s2);

        System.out.println(findLCSLength(s1, s2));
        

    }


    public static int findLCSLength(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {

                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }

        return dp[n][m];
    }



}
