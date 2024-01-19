package _21Recursive;

public class Recursive {

    // Recursive methodlarda ilk yapmak gereken şey durma noktası (Base Case) belirlemek
    

    public static void main(String[] args) {
        System.out.println(factorial(6));
    }



    public static char charToUp(char letter){
        letter = 'a';
        char letter2 = Character.toUpperCase(letter);

        return letter2;

    }




    public static int fibonacci(int n){
        if(n <= 1) return n;

        return fibonacci(n-1) + fibonacci(n-2);
    }




    public static int factorial(int n){
        if(n == 0) return 1;

        return n * factorial(n-1);
    }




    public static boolean isPalindrome(String word){

        if(word.length()<=1){
            return true;
        }

        if(word.charAt(word.length()-1) == word.charAt(0)){
            return isPalindrome( word.substring(1, word.length()-1) );
        }
        else{ 
            return false;
        }
        
    }





    public static int gcd(int m , int n ){

        if(n>m){             //Büyüğü m küçüğü n yaptık
            int tem = n;
            n = m;
            m = n;
        }

        if(m%n == 0)      //Tam bölünüyorsa mesele yok zaten
            return n;

        return gcd(n , m%n);     // n ve m'nin n ye bölümünden kalanı recursive

    }
    



    
    public static int fact(int n){

        if(n == 0)
            return 1;

        return n * fact(n-1);
    }




    public static boolean palindrome(String text){
        if(text.length() <= 1) return true;
        
        else if ( text.charAt(0) != text.charAt(text.length()-1) )
            return false;

        return palindrome(text.substring(1, text.length()-1));
    
    }



    public static int fibo(int n){

        if( n <= 1)
            return 1;
        
        return fibo(n-1) + fibo(n-2);

    }





    public static int grreatCD(int m , int n){

        if(n > m){
            int temp = n;
            n = m;
            m = temp;
        }

        if(m%n == 0)
            return n;
        

        return grreatCD(n, m%n) ;

    }




    

    public static String reverse(String text){

        if(text.length() == 1)
            return text;

        return reverse(text.substring(1)) + text.charAt(0);

    }
    
}
