package _20Sorting._1BasicSort._3InsertionSort;

//  for i <- 2 to n do
//      temp <- arr[i]
//      j <- i-1
//      while j>-1 and temp<arr[j]
//      do
//          arr[j+1] <- arr[j]
//          j <- j-1
//      endwhile
//      arr[j] <- temp
//  endfor

//! Worst case BigO = O(n^2)

public class _1InsertionSort {

    // InsertionSort daima array'in 2. elemanıyla başlar
    // sonrasında; onun öncesindeki her elemanla karşılaştırılır ve eğer küçükse yer değiştirirler, küçük değilse:
    // 3. eleman ele alınır ve kıyaslama o ve ondan önceki elemanlarla yapılarak devam eder

    // Küçük sayıdaki elemanlar için en hızlı sorting algoritmasıdır ama büyük sayıdaki elemanlar için tabiki değil.

    public static void main(String[] args) {

        int[] arr = {4,2,6,5,1,3};

        insertionSort(arr);

        for (int elem : arr) {
            System.out.println(elem);
        }
        

    }



    public static void insertionSort(int[] arr){
        
        for (int i = 1; i < arr.length; i++) {  // i 0'dan başlamaz buna dikkat et
            int temp = arr[i];  // Karşılaştırmak için 2. elemanı havaya kaldırıyoruz
            int j = i-1;

            while(j>-1 && temp < arr[j]){    // Burada 'j>-1' 'temp < arr[j]'den önce yazılmazsa 'temp < arr[j]' hata verir
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }  
        }
    

    }
    
}

