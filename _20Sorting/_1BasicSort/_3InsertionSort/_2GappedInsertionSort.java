package _20Sorting._1BasicSort._3InsertionSort;

public class _2GappedInsertionSort {

    public static void main(String[] args) {

        int[] deadlines = {40, 10, 30, 50, 20};
        shellSort(deadlines);
        System.out.println("Sorted Deadlines: " + java.util.Arrays.toString(deadlines));
        
    }


    public static void shellSort(int[] arr){

        for(int gap = arr.length/2 ; gap>0 ; gap/=2){
            gappedInsert(arr, gap);
        }
    }
    
    public static void gappedInsert(int[] arr, int gap){
    
        for(int i = gap ; i<arr.length ; i++){
    
            int temp = arr[i];
            int j;
            for(j = i ; j>=gap && arr[j-gap]>temp ; j-=gap){
                arr[j] = arr[j - gap];
            }
            arr[j] = temp;
    
        }
    }
    
}


