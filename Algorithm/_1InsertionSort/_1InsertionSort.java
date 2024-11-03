package Algorithm._1InsertionSort;

//! Worst case BigO = O(n^2)

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


public class _1InsertionSort{

    public static void main(String[] args) {
        
        int[] arr = {4,2,6,5,1,3};
        insertionSort(arr,0 , 5); // 0 5

        for (int elem : arr) {
            System.out.println(elem);
        }

    }




    public static void insertionSort(int[] arr, int start, int end){

        for(int i = start+1 ; i<end+1 ; i++){
            int temp = arr[i];
            int j = i-1;

            while(j>-1 && temp < arr[j]){
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }

        }

    }

}


