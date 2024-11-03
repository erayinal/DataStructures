package _23DoublyLinkedList;


// DoublyLinkedList'lerin LinkedList'lerden farkı 'Previous' Node'unu da tutmasıdır.
// LinkedList sadece kendisinden sonraki değeri tutuyordu DoublyLinkedList hem sonraki hem önceki değeri tutar




public class _1DoublyLinkedList {

    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList(5);
        dll.prepend(11);
        
    
        

    }
    
}



class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }



    public void append(int value){

        Node newNode = new Node(value);

        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }



    public Node removeLast(){
        // LinkedList'de removeLast istemi O(n) di çünkü orada geriye dönüş yoktu
        // Ama burada 'Prev' ile öncekini tuttuğumuz için O(1) ile hemencecik kaldırabiliyoruz. //!BigO = O(1)

        if(length == 0) return null;

        Node temp = tail;   // Sonradan return edebilmek için temp adında bir variable açıyoruz
        tail = temp.prev;
        tail.next = null;
        temp.prev = null;

        length--;
        // Eğer çıkarttıktan sonra eleman kalmıyorsa head ve tail 0 olmalı:
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }



    public void prepend(int value){

        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        
        length++;
    }



    public Node removeFirst(){
        if(length == 0) return null;

        Node temp = head;
        if(length == 1){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        return temp;
    }




    public Node get(int index){   // LinkedList'ten daha verimli bir kod yazıcaz çünkü geriye doğru da gidebiliyoruz
        if(index < 0 || index >= length) return null;

        Node temp = head;
        if(index < length/2){
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        else{
            temp = tail;    //! burada temp'i tail yapmayı unutma
            for (int i = length-1; i > index; i--) {    // İki for'da da <index veya > index var, eşitlik falan kafa karıştırıcı bir şey yok, kolay
                temp = temp.prev;
            }
        }
        return temp;
    }



    public boolean set(int index, int value){

        Node temp = get(index);

        if(temp != null){
            temp.value = value;
            return true;
        }
        
        return false;
    }



    public boolean insert(int index, int value){
        Node newNode = new Node(value);

        if(index < 0 || index > length) return false;   // index >= length değil index > length buna dikkat et, eşitlik yok
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){    // index == length olduğuna dikkat et
            append(value);
            return true;
        }

        Node temp = get(index);     // newNode'u koyacağımız yerde olan ve sonradan kaydırıp yerine newNode'u oturtacağımız elemanı ele alıyoruz
        newNode.next = temp;
        newNode.prev = temp.prev;   // Önce direkt tehlikeli olmayan ve kolay olan newNode'un prev ve nextini halleetik 
        temp.prev.next = newNode;
        temp.prev = newNode;

        length++;
        return true;
    }



    public Node remove(int index){

        if(index < 0 || index >= length) return null;

        if(index == 0){
            removeFirst();  
        }
        if(index == length-1){
            removeLast();   // Bunlar zaten kendi fonksiyonu içinde kaldırılan elemanı return ettikleri için return yazmaya gerek yok
        }

        Node temp = get(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;

        length--;
        return temp;
    }















    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

    public void getHead() {
        System.out.println("Head: " + head);
    }

    public void getTail() {
        System.out.println("Tail: " + tail);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }


    


}



class Node {

    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
    }

}



