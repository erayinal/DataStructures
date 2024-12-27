package Algorithm._4DynamicProgramming.DP;

import java.util.Arrays;

// Her alt problemi yalnızca 1 kez çözer ve daha sonra bu çözümü kaydeder(Memorization)
//! Yani bakarsak aslında DP, alandan ödün vererek zamandan kazanılmasını sağlar.
// DP, optimizasyon problemlerini çözmekte yaygın olarak kullanılır.
// DP'de Fibonacci problemi sıkça karşımıza çıkar



// DP iki başlık altında incelenir: 1)Tabulation(Bottom-Up) , 2)Memorization(Top-Down)
//* 1)Tabulation:
// Bottom-Up denmesinin sebebi: Recursion yok iteration var. 
// Şimdi bir fibonacci problemini tabulation ile çözelim(iteration). TabuFibonnacci() methodu yazalım:




//* 2) Memorization:
// Top-Down denmesinin sebebi, alt problemleri çöze çöze küçülür ve sonrasında en başa gelerek ana problemi çözmüş olur. Yani Recursion var
// Şimdi ise aşağıda gidip DP olmayan normal bir recursive fibonacci() methodu yazalım
// Şimdi ise DP ile fibonacciMemo() methodu yazalım
// Bu ikisi arasında ciddi anlamda hız farkı vardır çünkü önceden hesaplardıklarını hafızada tutar ve zamanı gelince kullanır


// Hem Tabulation yönteminde hem de Memorization yönteminde fibonacci problemi için time complexity ve space complexity O(n)'dir. 
// Ama Memorization'da space complexity daha büyük. İkisi de O(n) ama Memorization daha büyük bir n katsayısına sahip
// Şimdi aşağıda bir method daha(bestFibo()) yazıcam ve space complexity'i O(1)'e düşürücem, bunun için array(ya da herhangi bir data structure) kullanmamam lazım: 

public class _0DP {
    public static void main(String[] args) {
        
        System.out.println(bestFibo(7));

    }



    public static int TabuFibonacci(int n){

        if(n==0 || n==1) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2 ; i<n+1 ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }




    public static int fibonacci(int n){
        if(n == 0 || n == 1 ){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int fibonacciMemo(int n){
        int[] dp = new int[n+1]; 
        Arrays.fill(dp, -1);

        if(n == 0 || n == 1) return n;
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = fibonacciMemo(n-1) + fibonacci(n-2);
        return dp[n];
    }






    public static int bestFibo(int n){
        if(n==0 || n==1) return n;

        int prev2 = 0;
        int prev = 1;
        for(int i = 2 ; i<n+1 ; i++){
            int curi = prev + prev2; // curi = Current i
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }




    
    
}



