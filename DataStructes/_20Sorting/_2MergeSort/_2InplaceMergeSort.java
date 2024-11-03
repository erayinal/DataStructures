package _20Sorting._2MergeSort;

// In-place merge sort, klasik merge sort algoritmasının daha az bellek kullanarak çalışan bir versiyonudur:
// klasik merge sort'ta, birleştirme (merge) işlemi sırasında geçici bir dizi kullanılır, bu da ekstra bellek gerektirir. In-place merge sort ise bu geçici diziyi kullanmadan, diziyi doğrudan yerinde sıralar.

public class _2InplaceMergeSort {

    public static void main(String[] args) {
        
    }



    public static void mergeSort(int[] array, int start, int
        end) {
        if (start < end) {

            int mid = start + (end - start) / 2;
            
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            
            mergeInPlace(array, start, mid, end);
        }
    }

    
    private static void mergeInPlace(int[] array, int start, int middle, int end) {

        int start1 = start;
        int start2 = middle + 1;
        // Traverse both halves and shift elements to sort them in-place
        while (start1 <= middle && start2 <= end) {

            if (array[start1] <= array[start2]) {
                start1++;

            } else {
                int value = array[start2];
                int index = start2;

                // Shift all elements between start1 andstart2 to the right by one
                while (index > start1) {
                    array[index] = array[index - 1];
                    index--;
                }

                array[start1] = value;

                // Update all pointers
                start1++;
                middle++;
                start2++;
                
            } 
        }
    } 




}

    

