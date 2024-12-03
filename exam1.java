public class exam1 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,10};
        System.out.println(findMissing(arr, 0, arr.length));

        
        

    }


    public static int quickSelect(int[] arr, int low, int high, int k){

        if(low >= high){
            return arr[low];
        }

        int pivotIndex = partition(arr, low, high);

        if(k == pivotIndex){
            return arr[k];
        }else if(k < pivotIndex){
            quickSelect(arr, low, pivotIndex-1, k);
        }else{
            quickSelect(arr, pivotIndex+1, high, k);
        }

        return 1;

    }


    public static int partition(int[] arr, int low , int high){

        int pivot = arr[high];
        int i = low;

        for(int j = low ; j<high ; j++){

            if(arr[j]<pivot){
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




    

    

    public static int findMissing(int[] arr, int low, int high) {
        if (low > high) {
            return low + 1;
        }

        int midIndex = low + (high - low) / 2; 

        if (arr[midIndex] == midIndex + 1) {
            return findMissing(arr, midIndex + 1, high);
        } else {
            return findMissing(arr, low, midIndex - 1);
        }
    }

    
}
