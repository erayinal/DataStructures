package Algorithm._4DynamicProgramming.DP;

import java.util.Arrays;

// Bir kurbağa her bir zıplayışında ya 1 basamak ya da 2 basamak zıplayabilir
// Bize bir high array'i verilecek ve biz array içerisinde elemanları farkı kadar enerji harcamış olucaz:

// Çözüm: (Kurbağa her türlü 0. indexten başlıyor)
// 1)Problemi index türünden temsil et

//              f(3)
//            ↙       ↘
//        f(1)         f(2)
//                   ↙     ↘
//                 f(0)    f(1)       


// Önce normal yöntemle(memorization ve DP olmadan) çözelim: frogJump1()
// Şimdi memorization ile çözelim yani bir data structures yapısı kullanmamız lazım: frogJump2()
// Şimdi ise Tabulation ile çözelim yani herhnagi bir data st yapısı kullanmayacağız: frogJump3() 

public class _1FrogJumpQuestion {
    public static void main(String[] args) {

        int[] heights = {10,20,30,10};
        //System.out.println(frogJump1(3, heights));
        //System.out.println(frogJump2(3, heights));
        System.out.println(frogJump3(3, heights));
        
    }


    

    // Normal
    public static int frogJump1(int n, int[] heights){

        if(n==0) return 0;
        if(n==1) return Math.abs(heights[1] - heights[0]);

        int left = frogJump1(n-2, heights) + Math.abs(heights[n] - heights[n-2]);
        int right = frogJump1(n-1, heights) + Math.abs(heights[n] - heights[n-1]);
        return Math.min(left, right);
    }




    
    // Memorization: Time = O(n)  Space = O(n)
    public static int frogJump2(int n, int[] heights){
        if(n==0) return 0;
        if(n==1) return Math.abs(heights[1] - heights[0]);
        if(n<0) return Integer.MAX_VALUE;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        if(dp[n] != -1){
            return dp[n]; 
        }
        int left = frogJump2(n-2, heights) + Math.abs(heights[n] - heights[n-2]);
        int right = frogJump2(n-1, heights) + Math.abs(heights[n] - heights[n-1]);
        dp[n] = Math.min(left, right);

        return dp[n];
    }





    // Tabulation: 
    public static int frogJump3(int n, int[] heights){

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);

        for(int i = 2; i<n ; i++){  
            int left = dp[i-2] + Math.abs(heights[i] - heights[i-2]);   // yukarıdaki n yerine i
            int right = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            dp[i] = Math.min(left, right);
        }

        return dp[n-1];
    }




}
