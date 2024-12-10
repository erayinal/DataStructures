package Algorithm._2QuickSort;

// k'nıncı en küçük veya en büyük elemanı bulma soruları veya median(sıralayınca ortadaki eleman) bulma soruları quickSort ile yapılır
// Burada mantık şöyledir: 

public class _1QuickSelect {

    public static void main(String[] args) {
        
    }

    public static int quickSelect(int[] arr, int low, int high, int k){
        
        if (low == high) {
            return arr[low];
        }

        int pivotIndex = partition(arr, low, high);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, low, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, high, k);
        }
    }


    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low; 
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        
        swap(arr, i, high);
        return i;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    
}
