package Algorithm._2QuickSort;

// Burada pivot olarak son eleman seçilir(Hoare'nin tam tersi)
// Burada da Hoare gibi 2 tane değişkene ihtiyacımız var ama burada ikisi de baştan başlıyor. Hatta i=-1'den j=0dan başlar
// i: En son swap yapılan yeri tutmak, yani bir nevi memory olarak kullanırız
// j: pivottan küçük veya eşit elemanı arar ve bulunca i'ninci ve j'ninci eleman yer değişir(tabi yer değiştirmeden önce i'yi 1 arttır)
// j değeri pivotun olduğu index'e gelince: pivotun olması gereken yer i+1 dir
// İşlem bittiğinde PİVOTU ALMADAN, sol taraftakileri ve sağ taraftakileri ayrı ayrı recursice şekilde tekrar atıyoruz


public class _3LomutoQuickSort {
    
    public static void main(String[] args) {
        
    }

    public static void quickSort(int[] arr, int low, int high){

        if (low < high) {
            
            int pivotIndex = lomutoPartition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);    // Pivot index gönderilmiyor bunu unutma
            quickSort(arr, pivotIndex + 1, high);
        }

    }

    public static int lomutoPartition(int[] arr, int low, int high){

        int pivot = arr[high];
        int i = low-1;

        for(int j=low ; j<high ; j++){
            if(arr[j] <= pivot ){

                i++;
                swap(arr, i, j);
            }
        }

        // Pivotu doğru pozisyona yerleştir:
        swap(arr, i+1, high);

        // Pivotun yeni pozisyonunu döndür:
        return i + 1;
    }




    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
