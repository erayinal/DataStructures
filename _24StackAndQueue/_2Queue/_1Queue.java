package _24StackAndQueue._2Queue;


// Bildiğimiz bir market sırası gibi düşünebiliriz -> FİFO
// İlk giren ilk çıkar

// Bu sınıfta get methodu yok, bütün elemanları for ile gezip varsa o şekilde return ederek almamız gerekiyor


//   ↓(Last)                               ↓(First)
//   7     <-      23    <-     3   <-     11
// Sıranın yönü sağdan başlıyor(first one is on the rigth)
// LinkedList'lerdeki Head burada First, Tail ise Last olarak adlandırılıyor
// En öndeki eleman arkadakinin değerini tutuyor

// Sıranın önünden eleman ekleme veya çıkarma O(1)'dir
// Ama sıranını sonundan eleman ekleme veya çıkarma O(n)'dir




public class _1Queue {

    public static void main(String[] args) {
        
    }
    
}




class Queue {

    private Node first;
    private Node last;
    private int length;

    public Queue(int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }



    public void enqueue(int value){     // Sıranın sonuna eleman ekleme

        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
            last = newNode;
        }
        else{
            last.next = newNode;
            last = newNode;
        }
        length++;
    }


    public void dequeue(){      // sıranın başından eleman çıkarma

        if(length == 1){
            first = null;
            last = null;
        }
        else if(length>1){
            Node temp = first.next;
            first.next = null;
            first = temp;
        }
        length--;
    }



    

}





class Node {    // Node sınıfı LinkedList ile birebir aynıdır 

    int value;
    Node next;


    public Node(int value) {
        this.value = value;
    }
}
