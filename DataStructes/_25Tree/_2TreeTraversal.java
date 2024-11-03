package _25Tree;

import java.util.LinkedList;
import java.util.Queue;

// Tree Traversal, 
// Biz önce bütün Node'lara gideceğiz sonrasında o Node'lardaki value'ları ArrayList'lere koyacağız ve sonrasında o ArrayList'i return edeceğiz

// Burada sadece nasıl Tree içerisinde gezinilir onu göreceğiz, eğer print etmek lazımsa o sırayla sout yazarsın, eğer contains kontrol etmek gerekiyorsa if == kullanarak kontrol edersin


//                 47
//          21             76
//      18      27     52       82

// ArrayList'te Node'ları gezinmek için tek bir yön var o yüzden kolay ama Tree'lerde gidilcekizlenecek çok yol var bu yüzden birden fazla Traversal yöntemi var
// 1)BFS - Breadth First Search -> Satır satır soldan sağa yazdırır     47-21-76-18-27-52-82 
// 2)DFS - Depth First Search(Ayrıca bunu yapmak için de 3 yöntem vardır)     18-21-27-47-52-76-82



// 1)BFS - Breadth First Search:
// Queue açar ve root'u içerisine atarız
// Queue.isEmpty! olacak şekilde bir while loop açarız ve bir tane temp Node'u oluşturup poll() methodu ile Queue'nin ilk elemanına eşitleriz
// Direkt sout ile temp'in value'sunu yazdırırız   ->   sout(temp.value)
// Sonra iki tane if ile temp'in Left'i ve Right'ı varsa onları Queue'ya ekleriz



public class _2TreeTraversal {

    public static void main(String[] args) {

        TreeTraversal t = new TreeTraversal(25);
        t.BreadthFirstSearch();

        
        
        
        
    }

    
    
}






class TreeTraversal {

    private Node root;

    public TreeTraversal(int value){
        Node newNode = new Node(value);
        root = newNode;
    }

    



    public void BreadthFirstSearch(){   // Queue oluştur ve root'u ekle. Daha sonra while aç ve yeni Node oluştur ve soutla. En son left right var mı kontrol et

        Queue<Node> q = new LinkedList<>();
        q.add(root);    

        while( !q.isEmpty() ){
            Node temp = q.poll();      // İlk değeri alır ve aldıktan sonra Queue'dan siler
            System.out.println(temp.value);    // İşte biz burada print yaptık, eğer başka bir şekilde kullanacaksanız bu satırı değiştirerek modifiye edebilirsiniz 
            
            if(temp.left != null){
                q.add(temp.left);
            }
            if (temp.right!=null) {
                q.add(temp.right);
            }
        }

    }





    // Şimdi bir de DeepFirstSeacrh var. Onun 3 yöntemi var -> preOrder, postOrder, inOrder
    // 3'ünün tek farkı sout'ların farklı kodlarda yazılması

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
        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    

    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node root) { // Left -root - right şeklinde
        // 1-3-4-5-7-8-9

        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
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
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value+ " ");
    }








    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }


}












class Node{

    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

}
