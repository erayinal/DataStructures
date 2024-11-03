import java.util.Arrays;

public class deneme {

    public static void main(String[] args) {

        /* Online Insertion:
        int[] arr2 = {1, 3, 7, 8, 2, 4, 5, 6};

        double start = System.nanoTime();
        mergeSort(arr2, 0, arr2.length - 1);  // mergeSort'a start ve end parametrelerini ekledim
        double end = System.nanoTime();
        System.out.println(end - start);

        System.out.println(Arrays.toString(arr2)); 
        */


        /* Gapped:
        int[] deadlines = {40, 10, 30, 50, 20};
        shellSort(deadlines);
        System.out.println("Sorted Deadlines: " + java.util.Arrays.toString(deadlines));
        */


        /* MergeInPlace:
        int[] books = {35, 20, 50, 10, 40, 30};
        System.out.println("Original Shelf: " + java.util.Arrays.toString(books));
        mergeSort(books, 0, books.length - 1);
        System.out.println("Sorted Shelf: " + java.util.Arrays.toString(books));
        */


        /* Sort By Height:
        int[] bookHeights = {45, 32, 60, 22, 41};
        System.out.println("Original heights: " + java.util.Arrays.toString(bookHeights));
        insertionSort(bookHeights);
        System.out.println("Sorted heights: " + java.util.Arrays.toString(bookHeights));
        */


        
        
    }





    public static void insertionSort(int[] heights) {

        for (int i = 1; i < heights.length; i++) {
            int key = heights[i];
            int j = i - 1;
            
            while (j >= 0 && heights[j] > key) {
                heights[j + 1] = heights[j];
                j--;
            }

            heights[j + 1] = key;
        }
    }












    public static void shellSort2(int[] arr, int start, int end){

        if(start<end){
            int mid = (start+end)/2;

            shellSort2(arr, start, mid);
            shellSort2(arr, mid+1, end);

            mergeInPlace(arr, start, mid, end);
        }

    }

    public static void mergeInPlace(int[] arr, int start, int mid, int end){

        int start1 = start;
        int start2 = mid+1;

        while(start1<=mid && start2<=end){

            if(arr[start1] <= arr[start2]){
                start1++;

            }else{
                int value = arr[start2];
                int index = start2;

                while(index>start1){
                    arr[index] = arr[index-1];
                    index--;
                }

                arr[start1] = value;

                start1++;
                mid++;
                start2++;


            }

        }

        
    }

























    public static void shellSort(int[] arr){

        for(int gap = arr.length/2 ; gap>0 ; gap/=2){
            gappedInsertionSort(arr, gap);
        }
    }

    public static void gappedInsertionSort(int[] arr, int gap){

        for(int i = gap; i<arr.length; i++){
            
            int temp = arr[i];
            int j = 0;
            for(j=i; j>=gap && arr[j-gap]>temp ; j-=gap){
                arr[j] = arr[j-gap];
            }
            arr[j] = temp;

        }

    }























    public static void mergeSort(int[] arr, int start, int end){

        if(start<end){
            int mid = (start+end)/2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);

            merge(arr, start, mid, end);

        }

    }

    public static void merge(int[] arr, int start, int mid, int end){

        int n1 = mid-start+1;
        int n2 = end-mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0 ; i<n1 ; i++){
            left[i] = arr[start+i];
        }
        for(int i = 0 ; i<n2 ; i++){
            right[i] = arr[mid+1+i];
        }

        int i = 0, j = 0;
        int k = start;
        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k] = right[j];
            j++;
            k++;
        }

    }

    


    


    
}
