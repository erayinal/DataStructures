package Algorithm._3HeapSort;

// Heap sort sıralama için Max Heap yapısını kullanır(Max Heap: Parent > Child)

//! Mantığı: 
//* Build Max-Heap: sıralı olmayan bir array'den max heap oluşturur
// Diziyi bir Max-Heap'e dönüştürür. Bu işlem, dizinin en altındaki düğümlerden başlayarak yukarıya doğru hareket eder.
// Zaman karmaşıklığı: O(n).
//* Elemanları Sıralama:
// En büyük eleman (root) en sona taşınır.
// Son eleman "heap'ten çıkarılmış" gibi düşünülerek kalan kısmı tekrar Max-Heap'e dönüştürülür (Heapify).
// Bu işlem dizideki tüm elemanlar için tekrarlanır.
// Zaman karmaşıklığı: O(n log n).


// buildHeap(): sıralı olmayan bir array'den max heap oluşturur
// heapify(): buildHeap'e çok benzer, ancak dizinin bir kısmının zaten sıralanmış olduğunu varsayar.


public class _1HeapSort {

    public static void main(String[] args) {
        
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.print("Orijinal dizi: ");
        for (int i : arr) {
            System.out.print(i + ", ");
        }

        heapSort(arr);

        System.out.print("\nSıralı dizi:");
        for (int i : arr) {
            System.out.print(i + ", ");
        }

    }




    public static void heapSort(int[] arr){
        int n = arr.length;

        // 1. Aşama: Max-Heap oluştur
        buildHeap(arr, n);

        // 2. Aşama: Elemanları sıralama
        for (int i = n - 1; i > 0; i--) {
            // En büyük elemanı sona taşı
            swap(arr, 0, i);

            // Kalan kısmı tekrar Max-Heap'e dönüştür
            heapify(arr, i, 0);
        }

    }


    public static void buildHeap(int[] arr, int n){

        for(int i = n/2-1 ; i>=0 ; i--){
            heapify(arr, n, i);
        }
    }


    public static void heapify(int[] arr, int n, int i){

        int largest = i;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;


        // Sol çocuk root'tan büyükse
        if(leftChild < n && arr[leftChild] > arr[largest]){
            largest = leftChild;
        }


        // Sağ çocuk root'tan büyükse
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }


        // Eğer root en büyük değilse
        if(largest != i){
            swap(arr, i, largest);

            // Alt ağacı Max-Heap yap
            heapify(arr, n, largest);
        }


    }




    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
