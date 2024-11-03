package _25Tree;

import java.util.LinkedList;
import java.util.Queue;

// Öncekilerden farklı olarak Tree'ler Previous ve Next yerinde Left ve Right tutarlar
// İsimlerini de buradan alırlar: Tree
// Biz burada Binary Tree görücez. Binary Tree denmesinin sebebi iki tane Node tutmasıdır(Left ve Right)
// Tree'ler Binary Tree olmak zorunda değil birden fazla Node da tutabilirler. Mesela yandaki şekilde 3 tane tutuyor:  ↙ ↓ ↘

// ↙↘
// Tree'nin en tepesine Root Node denir ve onun altındakilere ise Child denir. Her Child yine bir Root olabilir eğer alt elemana sahipse
// Tree'nin en altında olan yani Child'ları olmayan Node'lara ise Leaf(yaprak) denir

//                  4  <-Root
//              ↙       ↘
//  Child->  3             23   <-Child
//        ↙    ↘         ↙     ↘
//     1        7     14        27



// Her iki Node'un da dolu olmasına Full ya da Full Tree denir.
// Full Tree'de her elemanın ya iki Nodu da boş olacak ya da ikisi de dolu olacak. Mesela alttaki bir Full node değildir çünkü 3'ün Left'i var ama Right'ı yok
// Ama 3'ün rightı da dolu olsaydı bu bir Full Node olurdu
//                  4
//              ↙       ↘
//           3             23
//        ↙                   
//     1  

// Her seviyedeki Node'ların tam dolu olmasına Perfect Node denir: Mesela alttaki gösterim bir Perfect Node'dur
// Çünkü 1. ve 2. seviyedeki tüm Node'lar dolu. Eğer 23 olmasaydı, Perfect Node olmazdı
//                  4
//              ↙       ↘
//           3             23

// Sırasıyla soldan başlayarak sağa doğru yerşeltirme durumuna ise Complete Tree denir
// Çünkü 3. satır soldan başlamış ve diğerleri boş ama mesela 23'ün Left'ine bir eleman gelirse bu Complete olmaz çünkü 3'ün right'ı boş kaldı
//                  4
//              ↙       ↘
//           3             23
//        ↙                   
//      1 



// Binary Search Tree ise bunlara ek olarak küçüğün solda büyüğün sağda olduğu bir Tree yapısıdır. Yani küçük Child sola geçer
// Soldakilerin hepsi Parent'tan küçüktür, sağdakilerin ise hepsi Parent'tan büyük

// Eğer her satırdaki Node'lar dolu ise Node sayısını 2^n-1 ile bulabiliriz 
// Yüksek satırlı Tree'ler yazdığımızda bu -1i görmezden gelerek direkt eleman sayısına 2^n diyebiliyoruz

// Bir satıra Node eklemek veya çıkarmak Satır sayısı ile aynıdır. Mesela 4. satıra eleman ekleme/çıkarma işlemi 4 adımda gerçekleşir
//! BigO = O(logn) 


//                 BST           LINKEDLİST
// Search       O(log n)✅         O(n)     
// Insert       O(log n)           O(1)✅
// Delete       O(log n)✅         O(n)



public class _1Tree {

    public static void main(String[] args) {

        Tree t = new Tree(25);
        // t.insert(9);
        // t.insert(15);
        // t.insert(5);
        // t.insert(11);
        // //t.insert(13);
        // t.rInsert(13);
        // t.insert(23);

        // System.out.println(t.getRoot().getRight().getLeft().getValue());

        // System.out.println(t.contains(23));
        // System.out.println(t.contains(15));

        

        

        // System.out.println(t.getRoot().getLeft().getValue());
        // System.out.println(t.getRoot().getRight().getValue());


        t.insert(12);
        t.insert(71);
        t.insert(9);
        t.insert(1);
        t.insert(20);
        t.insert(14);
        t.insert(53);
        t.insert(86);
        t.insert(39);
        t.insert(61);
        t.insert(79);
        t.insert(95);
        t.insert(33);
        t.insert(45);
        t.insert(10);

        t.preorder();
        

        
    }
    
}






class Tree {

    private Node root;


    public Tree(int value) {
        Node newNode = new Node(value);
        root = newNode;
    }

    



    public void insert(int value){

        Node newNode = new Node(value);

        if(root == null){
            root = newNode;
        }

        Node temp = root;
        while(true){
            if(value < temp.getValue()){    // Önce büyük mü küçük mü olduğunu kontrol edicez sonra boş mu dolu mu

                if(temp.getLeft() == null){     // sonra solu boş mu dolu mu tabi bunu sağı için de aşağıda yapıcaz
                    temp.setLeft(newNode);
                    break;
                }
                temp = temp.getLeft();
            }
            else{
                if(temp.getRight() == null){
                    temp.setRight(newNode);
                    break;
                }
                temp = temp.getRight();
            }
        }
    }



    private Node rInsert(Node currentNode, int value){  // Insert'te ana methodumuz void ama bu Node buna dikkat et
        
        if(currentNode == null){    // Önce tree boş mu dolu mu ona bakalım
            currentNode = new Node(value);
            return currentNode;  //Veya direkt 'return new Node(value)' şeklinde de yazabiliriz fakat anlayabilelim diye açık açık yazdım
        }
        else{

            if(value < currentNode.getValue()){
                currentNode.setLeft( rInsert(currentNode.getLeft(), value) );   // Burada en zor kısım bu satır gerisi kolay
            }
            else{
                currentNode.setRight( rInsert(currentNode.getRight(), value) );  // Burada en zor kısım bu satır gerisi kolay
            }

        }
        return currentNode;
    }

    public void rInsert(int value){
        rInsert(root, value);  
    }











    public boolean contains(int value){

        if(root == null) return false;
        
        Node temp = root;
        while(temp != null){    // temp durmadan karşılaştırdığımız eleman olacağı için o her ne zaman null olursa artık bakmamıza gerek kalmayacak
            
            if(value < temp.getValue()){    // Value ya küçük ya büyük ya da eşit olabilir
                temp = temp.getLeft();
            }
            else if(value > temp.getValue()){
                temp = temp.getRight();
            }
            else{
                return true;
            }
        }
        return false;
    }


    private boolean rContains(Node currentNode, int value){     //Recursive Contains (private)

        if(currentNode == null) return false;
        if(value == currentNode.getValue()) return true;

        if(value < currentNode.getValue()){
            return rContains(currentNode.getLeft(), value);    // küçük olduğu için artık karşılaştırmak için soldakini yolluyoruz
        }
        else{
            return rContains(currentNode.getRight(), value);
        }
    }

    public boolean rContains(int value){
        return rContains(root, value);
    }




    public void rDelete(int value){
        rDelete(root, value);
    }
    private Node rDelete(Node currentNode, int value){
        // Burada 3 tane durum var:
        // Case1) root'un çocuğu olmaması, sadece root olması (En kolay case, direkt sil)
        // Case2) Sadece 1 child'in olması i)Solda olması ii)Sağda olması
        // Case3) 2 çocuğunun da olması(2 Child)

         // check for node initially
        if (currentNode == null) {
            return null;
        } 
        else if (value < currentNode.getValue()) {
            // process the left sub tree
            currentNode.setLeft( rDelete(currentNode.getLeft(), value ));
        } 
        else if (value > currentNode.getValue()) {
            // process the right sub tree
            currentNode.setRight( rDelete(currentNode.getRight(), value) );
        } 
        else if(currentNode.getValue() == value){ // Asıl olay şimdi başlıyor

            //Case3 - 2 child
            if(currentNode.getLeft() == null && currentNode.getRight() == null){
                int myMax = findMaxValue(currentNode.getLeft());    // Burada eğer ikisi de doluysa solun en büyüğünü alıyoruz
                currentNode.setValue(myMax);
                currentNode.setLeft( rDelete(currentNode.getLeft(), myMax) );
                return currentNode;
            }

            //Case2 - 1 Child
            //i) has only left
            else if(currentNode.getLeft() != null){
                return currentNode.getLeft();
            }
            //ii) has only right
            else if(currentNode.getRight() != null){
                return currentNode.getRight();
            }

            //Case1 - No child
            else{
                return null;
            }
        }
        return currentNode;
    }

    public int findMaxValue(Node root) {    // Yardımcı method
        if (root.getRight() != null) {
            return findMaxValue(root.getRight());
        } else {
            return root.getValue();
        }
    }








    //! BreadthFirstSearch:
    public void BreadthFirstSearch(){   // Queue oluştur ve root'u ekle. Daha sonra while aç ve yeni Node oluştur ve soutla. En son left right var mı kontrol et

        Queue<Node> q = new LinkedList<>();
        q.add(root);    

        while( !q.isEmpty() ){
            Node temp = q.poll();      // İlk değeri alır ve aldıktan sonra Queue'dan siler
            System.out.print(temp.getValue() + " ");    // İşte biz burada print yaptık, eğer başka bir şekilde kullanacaksanız bu satırı değiştirerek modifiye edebilirsiniz 
            
            if(temp.getLeft() != null){
                q.add(temp.getLeft());
            }
            if (temp.getRight()!=null) {
                q.add(temp.getRight());
            }
        }
    }


    //! Depth First Search: 3 yolu vardır(pre, in, post)
    //                 5
    //          3             8
    //      1      4      7       9

    public void preorder() {
        preorder(root);
    }
    private void preorder(Node root) { // root - left - left <- (gidilecek yer kalmadıysa)öncekinin right'ı
        // 5-3-1-4-8-7-9 yukarıda verilen örnek Tree'yi bu şekilde yazdırır

        if (root == null) {
            return;
        }
        System.out.print(root.getValue() + " ");
        preorder(root.getLeft());
        preorder(root.getRight());
    }

    

    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node root) { // Left -root - right şeklinde
        // 1-3-4-5-7-8-9

        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());
        // Yukarıdakinden(preOrder'dan) tek farkı Sout'un bir alt satırda alması
    }

    //                 5
    //          3             8
    //      1      4      7       9
    public void postorder() {
        postorder(root);
    }
    private void postorder(Node root) { //
        // 1-4-3-7-9-8-5

        if (root == null) {
            return;
        }
        postorder(root.getLeft());
        postorder(root.getRight());
        System.out.print(root.getValue()+ " ");
    }








    public Node getRoot() {
        return root;
    }

}















class Node{

    private int value;
    private Node left;
    private Node right;
    
    
    public Node(int value) {
        this.value = value;
    }




    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


}
