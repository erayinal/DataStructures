package _28_2SplayTree;

//Splay Tree, BinarySearchTree'nin bir çeşididir
// Kendini AVL'de olduğu gibi balanced etmez 
// Implement etmek çok kolay 
// Endüstrideki en çok kullanılan veri yapısıdır 
// Elemanlara çok hızlı ulaşır
// Splay tree'ler bir nevi CASH'ler gibidir 
// Bu Tree'de height, balanced ya da diğer yardımcı elemanlara gerek yok Node sınıfının içerisinde 
// Splay Treenin verimliliği, her ekleme, silme ve hatta arama sırasında ulaşılan en alt konum p'de gerçekleştirilen, splaying adı verilen belirli bir move-to-root işleminden kaynaklanmaktadır.
//* Yani aslında temel olay: daha fazla kullanılan Node'ların root'a daha yakın olmasını sağlar
// Yani splay tree'lerde ne kadar işlem yaparsak o kadar süre kazanırız çünkü tüm çok kullandığımız elemanlar root'a yaklaşacak

// Eklediğimiz elemanı önce Tree'nin en altına ekler daha sonra kök yapar
// Bu sadece ekleme için geçerli değil arama yaptığımızda bile arama yapılan elemanı köke getirir, yani en son işlem yapılan eleman köke gelir 
// Burada da AVL gibi lef ve right rotation işlemleri vardır, bazı durumlarda bunlar birden fazla kullanılabiliyor o yüzden recursion olarak yazılabiliyor


public class _1SplayTree {


    
}





class SplayTree{

    Node root;


    //Zig 
    public Node rightRotate(Node x){
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    //Zag
    public Node leftRotate(Node x){
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    // Şimdi asıl olay Splay dediğimzi işlemde dönecek
    public Node splay(Node root, int value){

        //Base case: Root boşsa
        if(root == null || root.value == value){
            return root;
        }

        if(value > root.value){

            if(root.left == null) return root;

            //Zig-Zig(Left-Left)
            if(value < root.left.value){
                root.left.left = splay(root.left.left, value);
                root = rightRotate(root);
            }
            //Zig-Zag(Left-Right)
            else if(value > root.left.value){
                root.left.right = splay(root.left.right, value);
                if(root.left.right != null){
                    root.left = leftRotate(root.left);
                }
            }
            

        }



        return root;
    }

}





class Node {

    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

}


