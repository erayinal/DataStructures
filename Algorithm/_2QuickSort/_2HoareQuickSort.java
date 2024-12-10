package Algorithm._2QuickSort;

// Quick sort diyince aklımıza gelmesi gereken birkaç şey var:
// 1) Pivot

// 2) Partition: Partition'un işi seçilen pivot'un en baştaki arraydaki yerini belirlemek ve soluna küçükleri sağına büyükleri yerleştirmek
// tabi sol ve sağdaki elemanlar kendi aralarında sıralı olmak zorunda değil, onları yavaş yavaş sıraya sokucaz.
// Tabi bu partition için 2 tane algoritmamız var: Hoare ve 

//! Hoare:
// Array içerisindeki ilk eleman pivot olarak seçilir.
// i ve j olarak iki tane değişkenimiz olur. Amacı i dizinin başından j ise dizinin sonundan başlayarak pivotun yerini bulmaya çalışacak
// Daha başlamadan i = start-1, j = array.length+1 olarak seçilir yani 5 elemanlı bir arrayin tamamını attığını düşünürsek: i -1 olur j 5 olur
// i'nin olayı pivottan büyük veya eşit olanları bulana kadar array'i taramak 
// j'nin olayı ise pivottan küçük bir değer bulana kadar array'i taramak
// Diyelim i pivottan büyük veya eşit, j ise pivottan küçük bir eleman buldu: eğer i, j'yi geçmemişse bu iki eleman yer değiştirilir
// Devam ettiğimde yine i pivottan büyük veya eşit, j ise pivottan küçük bir eleman buldu ama i j'yi geçmiş oldu. //!Bu haldeyken i'nin gösterdiği yer aslında pivotun sıralı array'de olması gereken yerdir.
/// Bu işlem bittikten sonra Hoare algoritması diyor ki: ikiye böl ve yukarıdaki işlemi tekrar yap. Tabi yeni elemanda pivot artık değişecek ve ilk eleman olarak belirlenecek


public class _2HoareQuickSort {

    public static void main(String[] args) {

        int[] array = {6,10,13,5,8,3,2,11};
        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }



    public static void quickSort(int[] arr, int low, int high){

        if(low < high){
            int pivotIndex = hoarePartition(arr, low, high);

            quickSort(arr, low, pivotIndex);
            quickSort(arr, pivotIndex+1, high);
        }
    }



    public static int hoarePartition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low-1;
        int j = high+1;

        while(true){

            do{
                i++;
            }while(arr[i] < pivot);

            
            do{
                j--;
            }while(arr[j] > pivot);

            if(i>=j){
                return j;
            }
            
            swap(arr, i, j);
        }
        
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
