package _22LinkedList;

// LinkedList'ler durmadan ArrayList'ler ile karşılaştırılır çünkü aynı Array'ler gibi dinamiktir

// ArrayList'lerle neredeyse tüm özellikleri aynı fakat yapı farkları var.
// ArrayList'ten farklarında bir tanesi: elemanların index numarası yoktur
// ArrayList'ler Memory(Ram)'de sıralı olarak yerleşmek zorunda ama LinkedList'ler Memory'e sıralı olarak yerleşmek zorunda değil, ArrayList sıralı yerleştiği için index numarasına sahip olabiliyoruz

// LinkedHashSet'lerde bahsettiğimiz gibi Linked'in olayı: kendinden önceki nesnenin hafızasını ve kendinden sonraki nesnenin hafızasını aklında tutar
// null-15-3600(*3200*)    3200-3-4000(*3600*)    3600-17-null(*4000*)    // Burada gördüğümüz gibi, 3 değeri hem kendinden önceki değerin hafızasını(3200) hen de kendinden sonraki değerin hafızasını(4000) tutuyor.
// Son değerden sonra değer olmadığı için kendinden sonraki değerin hafızası null.

// Peki bu LinkedList'ler ne zaman kullanılır, ne zaman ArrayList yerine LinkedList kullanmalıyız?:
// Çok fazla ekleme yapacaksak ve gerektiğinde ortalara ya da bir kısmına falan da ekleme yapacaksak LinkedList kullanmalıyız çünkü:
// Bir arrayList'tin tam ortasına ekleme yapacaksak diğer yarısında kalan bütün değerler bir sıra kaydırılır fakat bunu LinkedList'ten yaparsak:
// Sadece eklenen yer ve sağındaki ve solundaki değerlerde ufak değişiklik yapalır ve diğer elemanlara müdahale edilmeden devam edilir.Mesela üstte verdiğimiz değere bir ekleme yapalım:

// null-15-!4400(*3200*)  3200-100-3600(*4400*)  !4400-3-4000(*3600*)    3600-17-null(*4000*)    //*Sadece '!' yazdığım yerleri değiştirdim sadece 2 tane.

// Ama şöyle de bir gerçek var ki search yani arama konusunda ArrayList'ler daha iyi

// Yani listeye çok fazla ekleme çıkartma yapılacaksa, sonradan çok değiştirilecekse LinkedList kullanmak mantıklıdır,
// Eğer çok fazla arama yapılacaksa kontrol yapılacaksa da ArrayList kullanmak mantıklıdır.


//! Joseph: 
//If you need to support random access through an index without inserting or removing elements from any place other than the end, ArrayList offers the most efficient collection. 
//If, however, your application requires the insertion or deletion of elements from any place in the list, you should choose LinkedList. A list can grow or shrink dynamically. An array is fixed once it is created. If your application does not require insertion or deletion of elements, the most efficient data structure is the array.
    

//! BigO:
// ↓(Head)          ↓(Tail)
// 11 -> 3 -> 23 -> 7
// Bütün örnekleri bu yukarıdaki LinkedList örneğinden vereceğim...

// LinkedList'lerde sona eleman ekleme(APPEND) bakımından; LinkedList'te 1 eleman olsa da 10000 eleman olsa da farketmez, sona eleman eklenir ve bundan sadece solundaki değer etklienir: bu yüzden //!BigO = O(1).

// Sondan eleman çıkarma(REMOVE LAST) işlemi ekleme işlemi gibi kolay gibi gelse de değildir BigO = O(n). Çünkü en sondaki elemanı işaret eden Tail Pointer, o kalkınca bir önceki elemanı işaret etmek zorunda
// Ama şimdi ondan önceki elemanı işaret eden sadece bir Pointer(->) var. Sorun şu ki biz geri geri gelemiyoruz ve Head'ten başlayarak bütün Pointerları(->) kontrol ederek gitmemiz lazım ki:
// 'next'(3600-17-null(*4000*)) elamanı boş olan o son Pointerı(->) bulsun ve onu Tail Pointer olarak atasın. Yani ne kadar fazla eleman varsa Head Pointer'dan başlayarak o kadar çok Pointer(->) kontrol edilecek. //! BigO = O(n)

// Başa eleman ekleme(PREPEND) konusunda da sona eleman ekleme gibi. LinkedList'te 1 eleman da olsa 1000 eleman da olsa farketmez. //!BigO = O(1)dir 

// Baştan eleman çıkarma(REMOVE FİRST) konusunda: 3 -> 23 -> 7
// sondan eleman çıkarmaktan farklıdır. 
// Çünkü artık Head Pointer bir sonraki elemanı(3) işaret etmeye başlar ve sonrasında ilk eleman kaldırılır, böylece ikinci eleman birinci eleman konumuna geçer //!BigO = O(1)

// LinkedListin ortasına eleman ekleme(INSERT) konusnda : 11 -> 3 -> 23 -> 4 -> 7
// Head Pointer'dan başlayarak eklenecek olan yeri işaret eden Pointer'a(23 ->) kadar gidilir ve artık o Pointer yeni elemanı(4) işaret eder(-> 4). 
// Yeni eklenen eleman ise(4) artık yerine geçtiği elemanı(7) işaret eder(-> 7) 
// Bu yüzden LinkedList'teki eleman sayısı arttıkça eleman eklemek zorlaşır //!BigO = O(n)  

// LinkedListin ortasından eleman çıkarma(REMOVE) konusunda da aynı eleman ekleme gibi olur. //!BigO = O(n)

// LinkedList'te eleman get etme konusunda indexle de almaya çalışsak direkt değerle de almaya çalışsak BigO = O(n)dir çünkü:
// O elemanı bulmak için Head Pointer'dan başlayarak bütün Pointer'lar(->) kontrol edilir. //!BigO = O(n)dir
// Look By Index //!BigO = O(n)
// Look By Value //!BigO = O(n)


//                              LinkedList          ArrayList
// Append(Sona ekleme)             O(1)                O(1)
// Remove Last                  ❌ O(n)             ✅  O(1)
// Prepend(Başa Ekleme)         ✅ O(1)             ❌  O(n)
// Remove Fİrst                 ✅ O(1)             ❌  O(n)
// Insert(Ortaya Ekleme)           O(n)                O(n)
// Remove(Ortadan Çıkarma)         O(n)                O(n)
// Look By Index                ❌ O(n)             ✅  O(1)
// Look By Value                   O(n)                O(n)



//! Şimdi Node nedir ona bir bakıp anlayalım:

// Node sınıfını özelleştirebiliriz ve genellikle iki(Value, Next) veya üç(Before, Value, Next) içerik saklar
// Next dediğimiz şey aslında sabahtan beri antalattığımız Pointer ile aynı şey. (Next = ->) 
// {
//      Value = 11
//      Next = {
//                 Value = 3
//                 Next = {...}
//             }
// }
// Yani:
// class Node {
//     int value;
//     Node next;
// }



public class _1LinkedList {

    public static void main(String[] args) {
        
        LinkedList ll = new LinkedList(1);
        ll.append(3);
        ll.append(5);
        ll.prepend(9);


        ll.printLinkedList();
        ll.remove(3);
        ll.printLinkedList();


    }

}






class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }


    
    public void printLinkedList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }



    public static void removeList(Node head){
        
        if(head == null){
            return;
        }
        removeList(head);

    }



    public void append(int value){

        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }



    public Node removeLast(){
        if(length == 0) return null;

        Node temp = head;   
        Node pre = head;

        while(length != 0){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;   // Burada en son elemanı çıkarttık

        if(length == 0){
            head = null;
            tail = null;
        }

        length--;
        return temp;
    }



    public Node removeFirst(){
        
        Node temp = head;   // Method sonunda return edebilmek için bu temp'i oluşturuyoruz
        if(length != 0){
            //head = head.next;    // Normalde tek satırda çözülür ama kaldırdığımız elemanı Return etmek için biraz uzun sürüyor
            head = head.next;
            temp.next = null;
        }
        // Kaldırdıktan sonra eğer LinkedList'te eleman kalmazsa Tail'i de null yapmak lazım:
        if(length == 0){
            tail = null;
        }
        length--;
        return temp;

    }



    public void prepend(int value){

        Node newNode = new Node(value);

        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }



    public Node get(int index){
        if(index < 0 || index>=length){
            return null;
        }
        
        Node temp = head;   // method sonunda return edebilmek için temp'i oluşturdum
        for (int i = 0; i < index; i++) {   // Burada önemli olan for döngüsünü index'e kadar döndürmek
            temp = temp.next;
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

        if(index < 0 || index>length){
            return false;
        }
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length-1){
            append(value);
        }

        Node newNode = new Node(value);
        Node temp = get(index-1);   // Burada yerleştireceğimiz yerden bir önceki elemanı tutan temp variablesi oluşyuruyoruz 
        newNode.next = temp.next;
        temp.next = newNode;
        
        length++;
        return true;
    }



    public Node remove(int index){

        if(index < 0 || index>=length) return null;
        if(index == 0){
            return removeFirst();
        }
        if(index == length-1){
            return removeLast();
        }

        
        Node temp = get(index);
        Node pre = get(index-1);
        pre.next = temp.next;

        // Şimdi işlem bitti aslında ama hafızada yer kaplamasın diye 'temp' nodunu Null yapmalıyız:
        temp.next = null;
        
        length--;
        return temp;
    }



    public void reverse(){

        // 11 -> 3 -> 23 -> 7 mesela yandaki listi yan çevirelim: Asıl mantık Head'i Tail yapmak Tail'i Head ve Pointer(->) yönlerini ters çevirmek
        // Pointer'ları ters çevirebilmek için 'Before' ve 'After' adında iki tane Node'a ihtiyacımız var ki:
        // After ve Before'un yerini değiştire değiştire gidelim
        Node temp = head;
        head = tail;
        tail = head;

        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            //      ↓(before)       ↓(temp)        ↓(after)
            //      null     ->     11      ->      3       ->      23      ->      7
            temp.next = before; // Burada ok yönünü değiştirdik
            //      ↓(before)       ↓(temp)         ↓(after)
            //      null     <-     11      ->      3       ->      23      ->      7       //! null'dan sonraki okun yönüne dikkat et yön değiştirdi
            before = temp;
            temp = after;
            //                      ↓(before)      ↓↓(temp/after)                           //! Burada hem temp hem after 3'ü işaret ediyor. For tekrarlanınca after bir sonraki adıma geçecek
            //      null     <-     11      ->      3       ->      23      ->      7
        }

    }



    public void getHead(){
        System.out.println("Head: " + head.value);
    }

    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }

    public void getLength(){
        System.out.println("Length: " + length);
    }

}


class Node {

    int value;
    Node next;

    public Node(int value){
        this.value = value;
    }

}
