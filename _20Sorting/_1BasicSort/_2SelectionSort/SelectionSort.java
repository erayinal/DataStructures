package _20Sorting._1BasicSort._2SelectionSort;

public class SelectionSort {

    // Bubble Sort'tan farklı olarak burada indexlere de ihtiyacımız var

    // Ana mantığı: öncelikle ilk indexi(elemanı) en küçük eleman VARSAYIYORUZ ve sonrasında diğer elemanlarla varsaydığımız elemanı karşılaştırıyoruz
    //      eğer karşılaştırdığımız eleman varsaydığımız elemandan küçükse minIndex'i küçük olanın indexine eşitliyoruz, bitmiyor:
    //      karşılaştırmaya array elemanları bitene kadar devam ediyor ve en küçük sayının index numarasını buluyoruz
    //      ve karşılaştırdığımız sayı ile yer 
    

    //! Selection sort'un Time Complexity'si O(n^2) dir

    public static void main(String[] args) {

        int[] arr = {4,2,6,5,1,3};

        selectionSort(arr);

        for (int elem : arr) {
            System.out.println(elem);
        }
        
    }



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

    
}
