package _26Heaps;

import java.util.ArrayList;
import java.util.List;

// Heaps'ler aslında bir Binary Tree'dir


//                 99
//          72             61
//      58      55     27       18

// Heaps'lerde en büyük eleman Top'tadır
// En büyüğün başta olması dışında diğer Node'lar arasında herhangi bir sıralama yoktur. Yani 61 ile 72nin yeri değişse de bir şey farketmez
// Tree'den herhangi bir kesit aldığında Top'ta kalan büyük olacak
// Mesela yularıdaki Tree'yi 61,27,18 üçlüsünün kesitini aldığımızda: 
//        61
//    27      18  şeklinde olur ve gördüğünüz gibi yine Top(61) en büyük eleman

// Heaps'ler her zaman Complete modundadır.(Complate = _1Tree'de anlattık)

// Biz heaps'leri ArrayList ile implemet edeceğiz, Node class'ı oluşturmayacağız
// Yani aslında biz yularıdaki Tree'yi şu şekilde düşünebiliriz:

//  99
//  |       72  61      
//  |       |   |         58  55  27   18
//  ↓       ↓   ↓          ↓  ↓    ↓   ↓ 
//  ⬜      ⬜  ⬜         ⬜  ⬜   ⬜   ⬜    (7 elemanlı bir ArrayList)

// Child'ın indexini Parent'a bakarak nasıl bulacağız:
// leftChild = 2n+1
// rightChild = 2n+2    
// Peki Child'a bakarak Parent index'ini nasıl buluruz:
// Parent = (child-1)/2

public class _1Heaps {

    public static void main(String[] args) {
        
    }
    
}




class Heaps {

    List<Integer> heap;

    public Heaps(){
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap(){
        return new ArrayList<>(heap);   // Heap'in kopyasını return edecek
    }


    //! Helper Methods:
    public int leftChildIndex(int ParentIndex){
        return 2*ParentIndex+1;
    }
    public int rightChildIndex(int ParentIndex){
        return 2*ParentIndex+2;
    }
    public int parentIndex(int childIndex){
        return (childIndex-1)/2;
    }
    public void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }



    //! Insert Method:
    public void insert(int value){

        heap.add(value); // ekledik. Şimdi kontrol etme zamanı:
        int currentIndex = heap.size()-1;  // currentIndex'i en son eklediğimiz elemanın indexine eşitliyorum

        while( currentIndex > 0 && (heap.get(currentIndex)>parentIndex(currentIndex)) ){  // index 0'dan büyükse ve ekledeiğimiz eleman parent'tan büyükse while'a girecek
            // Eğer zaten bu koşullar tamamsa sorun kalmıyor, geriye sadece değiştirmek kalıyor
            swap(currentIndex, parentIndex(currentIndex));
            currentIndex = parentIndex(currentIndex);
        }
    }



    //! Remove Method:
    public void remove(int value){
        // Remove'da kaldırılan eleman yerine en sonraki eleman(heap.size-1'deki eleman) yerleştirilir

        if(heap.size() == 0){
            return;
        }
        if(heap.size() == 1){
            heap.remove(0);
        }

    }





}








