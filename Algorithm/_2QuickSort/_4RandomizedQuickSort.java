package Algorithm._2QuickSort;

import java.util.Random;

// QuickSort'tan farkı: Normal QuickSort'ta pivot element belirli bir yerden seçilirdi(genellikle ilk element), ama RandomQuickSort'ta durum biraz daha farklı ve pivot'u random olarak seçiyor.
// Peki pivot'u random olarak seçmesi ne fayda sağlıyor: NormalQuickS'un en kötü durum karmaşıklığını (O(n²)) olabildiğince nadir hale getirir çünkü pivotun rastgele seçilmesi, sıralı veya neredeyse sıralı veri kümelerindeki dengesiz bölmeleri önler
// Bu sayede ortalama durumda sık görülen zaman kamaşıklığı şöyle olur: //! O(nlogn)

//* Ana mantık şöyledir: 
// Rastgele bir pivot seçilir.
// Diziyi pivotun etrafında iki alt diziye böler:
// Pivotdan küçük elemanlar bir alt diziye.
// Pivotdan büyük elemanlar diğer alt diziye.
// Alt diziler üzerinde aynı işlem rekürsif olarak uygulanır.
// Alt diziler birleşerek sıralı dizi oluşturulur.


public class _4RandomizedQuickSort {

    public static void main(String[] args) {
        
    }



    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pivotIndex = randomizedPartition(arr, low, high);

            randomizedQuickSort(arr, low, pivotIndex - 1);
            randomizedQuickSort(arr, pivotIndex + 1, high);
        }
    }



    private static int randomizedPartition(int[] arr, int low, int high) {
        Random random = new Random();
        int randomPivotIndex = low + random.nextInt(high - low + 1);

        swap(arr, randomPivotIndex, high);

        return partition(arr, low, high);
    }


    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = low - 1;       

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;  // Pivot'un yeni pozisyonu
    }



    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    
}
