package _20Sorting._3QuickSort;

import java.util.Arrays;

public class Pivot {
    
    // Quick sort'a geçmeden önce 'Pivot' diye bir konu işleyeceğiz:
    // Ana mantığı şöyle:
    // Array'in ilk elemanını diğer elemanlarla karşılaştırmak için alırsın:
    // İlk elemandan büyük olanları bir tarafa, küçük olanları bir tarafa yerleştirir ve bu ilk elemanı iki grubun ortasına koyarsın
    // Böylece ilk eleman sıralamadaki doğru yerine oturmuş olur 


    public static void main(String[] args) {

        int[] arr = {4,6,1,7,3,2,5};

        pivot(arr, 0, 6);

        System.out.println(Arrays.toString(arr));
        
    }



    public static int pivot(int[] arr, int pivotIndex, int endIndex){
        // Bu method array içerisindeki ortada duracak olan elemanı yerine yerleştirir. Nasıl:
        // Array = {4,6,1,7,3,2,5}; Bu arrayde 1,3,2-> 4'ten küçük; 6,7,5 ise-> 4'ten küçük
        // Bu yüzden 4 ortada olmalı ve 4ü ortaya alıyor 

        int swapIndex = pivotIndex;
        for (int i = pivotIndex+1; i <= endIndex; i++) {
            if(arr[i] < arr[pivotIndex]){
                swapIndex++;
                swap(arr, swapIndex, i);
            }    
        }
        swap(arr, pivotIndex, swapIndex);

        return swapIndex;
    }



    // Helper Function:
    public static void swap(int[] arr, int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }




    
}
