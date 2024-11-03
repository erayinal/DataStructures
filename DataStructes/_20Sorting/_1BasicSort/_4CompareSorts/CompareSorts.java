package _20Sorting._1BasicSort._4CompareSorts;

public class CompareSorts {


    public static void main(String[] args) {

        int[] arr = {4,2,6,5,1,3};

        double start = System.nanoTime();
        bubbleSort(arr);
        double end = System.nanoTime();

        double start2 = System.nanoTime();
        selectionSort(arr);
        double end2 = System.nanoTime();
        
        double start3 = System.nanoTime();
        insertionSort(arr);
        double end3 = System.nanoTime();
        



        System.out.println("Bubble Sort:      " + (end-start));
        System.out.println("Selection Sort:   " + (end2-start2));
        System.out.println("Insertion Sort:   " + (end3-start3));
                


    }





    // Bubble Sort:
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



    // Selection Sort:
    public static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            if(i != minIndex){  //! Yani i ve j yer değiştirmişse daha doğrusu karşılıştırdığımız elemandan daha küçük bir sayı bulunmuşsa bu kodun devamı gerçekleşiyor
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }

        }

    }





    // Insertion Sort:
    public static void insertionSort(int[] arr){
        
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];  // Karşılaştırmak için kaldırıyoruz
            int j = i-1;

            while(j>-1 && temp < arr[j]){    // Burada 'j>-1' 'temp < arr[j]'den önce yazılmazsa 'temp < arr[j]' hata verir
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }  
        }
    

    }



    
}
