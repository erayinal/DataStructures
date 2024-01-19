package _24StackAndQueue._1Stack;

// FİLO mantığı ile çalışır
// Tenis top kutusuna konulmuş tenis topları gibi düşünebiliriz. Son giren ilk çıkar, yeni gelen üste konur
// Örnek vermek için ArrayList burada Array'lerden daha çok iş görür çünkü kaç tane eleman ekleyeceğimizi bilmiyoruz

// Stack class'ı için önce bir Node class'ı açmamız gerkekiyor. Hadi önce bir Node class'ı açalım

// sondan eleman remove etme O(n)
// Sona eleman ekleme O(1)

// Baştan eleman ekleme de çıkarma da O(1)
// Bu başa eleman eklemde LinkedList'te removeFirst ve prepend diyorduk buna ise Pop(çıkarma) ve Push(ekleme) diyoruz 
// Head kısmnına Top, tail kısmına Bottom diyoruz

//! Bottom tarafından hiçbir şey ekleyemiyoruz ve çıkartamıyoruz. Her şeyi Top kısmından yapıyoruz.
//Bu yukarıda yazdığım sebepten dolayı aslında bizim Bottom pointera da ihtiyacımız yok

//   11 <- TOP
//   ↓
//   3
//   ↓
//   23
//   ↓
//   7



public class _1Stack {
    
    public static void main(String[] args) {

        Stack s = new Stack(5);
        s.Push(4);
        s.Push(7);
        s.pop();
        s.printStack();
        
    }

    
    
}


class Stack{

    private Node top;   // Bütün işlemler Top üzerinden döndüğü için Bottom'a ihtiyacımız yok
    private int height; // Eleman sayısını gösterir

    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }


    public void Push(int value){        // Üste ekleme
        Node newNode = new Node(value);
        
        if(height == 0){
            top = newNode;
        }
        else{
            newNode.next = top;
            top = newNode;
        }   
        height++;
    }


    public void pop(){      // Üstten çıkarma

        if(height == 1){
            top = null;
        }
        else if(height > 1){
            Node temp = top.next;
            top = top.next;
            temp.next = null;
        }
        height--;
    }



    

    public void printStack(){
        Node temp = top;    // İşlemleri temp üzerinden yürütmemizin sebebi alt satırlarda 'temp = temp.next' yazacak olmamız, yani Top etkilenmesin diye, topu korumak için
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public Node getTop() {
        return top;
    }
    public int getHeight() {
        return height;
    }


}



class Node {

    int value;
    Node next;


    public Node(int value) {
        this.value = value;
    }  

    // Şimdi de gidip Stack sınıfını yazabiliriz 
}
