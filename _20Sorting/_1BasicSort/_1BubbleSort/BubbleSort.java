package _20Sorting._1BasicSort._1BubbleSort;

public class BubbleSort {

    // Ana mantığı iki elemanı kıyaslayarak küçük olanla büyük olanı yer değiştirmesidir

    public static void main(String[] args) {

         int[] arr = {2,4,6,5,1,3,7};
        // bubbleSort(arr);
        
        // for (int elem : arr) {
        //     System.out.println(elem);
        // }


        double start = System.nanoTime();
        bubbleSort(arr);
        double end = System.nanoTime();
        System.out.println(end-start);


    }



    public static void bubbleSort(int[] array){

        for (int i = array.length-1 ; i > 0; i--) {   //! int i = bubbleArray.length-1 öncemli
            for (int j = 0; j < i ; j++) {          //! j<i önemli
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

    }
    


}
