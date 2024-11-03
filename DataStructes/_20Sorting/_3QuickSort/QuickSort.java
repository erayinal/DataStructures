package _20Sorting._3QuickSort;

import java.util.Arrays;

public class QuickSort {

    // Pivot sınıfını yazdıktan sonra bu sınıfa geçebiliriz:


    public static void main(String[] args) {
        
        int[] arr = {4,6,1,7,3,2,5};
        quickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));


    }



    public static void quickSort(int[] arr, int left, int right){
        
        if(left < right){
            int pivotIndex = Pivot.pivot(arr,left,right);
            quickSort(arr, left, pivotIndex-1);
            quickSort(arr, pivotIndex+1, right);
        }
    }


    
}


// Quick Sort'ta array'i duplicate etmeden orijinal array üzerinden işlem yaptığımız için bu bize büyük bir Space Complexity sağlar = O(1)
// Time complexity ise = O(n logn)


// En kötü durumda time complexity = O(n^2) olabilir ama random bir array için QuickSort en hızlı yöntem olarak varsayılır
