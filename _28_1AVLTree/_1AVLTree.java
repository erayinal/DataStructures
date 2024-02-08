package _28AVLTree;

//AVL Tree'lerde aslında bir Binary Search Tree'nin bir türüdür yani BST'nin bütün özellikleri AVL'de de vardır
// Ama AVL Tree'lerde ek olarak özellikler vardır

//AVL Tree'lerde sağdaki nodeların yüksekliği ile soldaki Nodeların yüksekliği arasındaki fark birden fazla olmaz 
// Eklemek, bulmak, silmek çok kolay


//! L-L condition'da Right Rotation yaparız:
//                        70
//                     ↙      ↘
//                  50           90
//                 ↙  ↘        ↙    ↘
//              30     60    80       100
//            ↙
//         20
//       ↙              
//    10
// Burada hatalı olan(disbalanced) Node 30Nodu'dur çünkü sağ node'ları ile sağ node'ları arasında 1den fazla fark var bu yüzden:
// Hatalı olan 30Node'u ve sub-node'ları(20,10), bir L-L conditiondur bu yüzden Right Rotate olmalı(↻):
//                        70
//                     ↙      ↘
//                  50           90
//                 ↙  ↘        ↙    ↘
//              20     60    80       100
//            ↙   ↘
//         10       30  Şeklinde olur


// Daha karışık bir örneğe bakalım:
//                        70
//                     ↙      ↘
//                  50           90
//                 ↙  ↘     
//              30     60    
//            ↙
//         20
// Bu yukarıdaki AVL Tree'de hatalı olan(disbalanced) node 70'tir çünkü sağ sub-tree ile sol sub-tree arasındaki yükseklik farkı 1den fazla 
// bu yüzden 70-50-30 arasında bir Rotate Right olmalı.
// peki neden 70-50-60 seçmedik, çünkü 30'un bir de right çocuğu var
// Right Rotate yapınca şu şekilde olur:
//                        50
//                     ↙      ↘
//                  30           70
//                 ↙           ↙     ↘
//              20           60        90
// Şimdi bunlara göre gidelim ve rotateLeft(disbalanced) methodunu yazalım




//! L-R Condition: 

//                        70
//                     ↙      ↘
//                  50           90
//                 ↙  ↘        ↙    ↘
//              30     60    80       100
//            ↙
//         20
//            ↘                
//              25
// Öncelikle disbalanced node belirlenir ve L-R Condition olduğu anlaşılır, sonrasında
// Burada da önce Left Rotation(↺) sonrasında Right Rotation(↻) yapılır
// Right Rotation(↻) yapıldıktan sonra:
//                        70
//                     ↙      ↘
//                  50           90
//                 ↙  ↘        ↙    ↘
//              30     60    80       100
//            ↙
//         25
//       ↙                
//     20       
//Şeklinde olur ve daha sonrasında Rihgt Rotation yapılır. Right Rotationdan sonraki hali:
//                        70
//                     ↙      ↘
//                  50           90
//                 ↙  ↘        ↙    ↘
//              25     60    80       100
//            ↙   ↘
//         20       30      //Şeklinde olur 
// Şimdi gidip helpRotateLeft(disbalanced) methodunu yazalım. Bu method gerçek rotateLeft methodu değildir sadece L-R durumuna yardımcı bir methoddur




//! L-L Condition:
//                    70
//                 ↙      ↘
//              50           90
//                              ↘
//                                100
//                                    ↘
//                                      110
//Burada disbalancedNode'un 90 oludunu hemen görebiliyoruz
// Burada Left Rotation yapmamız lazım. Left Rotation'dan sonra:
//                    70
//                 ↙      ↘
//              50          100
//                         ↙     ↘
//                      90        110  //Şeklinde olur
//Şimdi gidip asıl olan rotateLeft(disbalancedNode) methodunu yazalım




//! R-L Condition:
//                        70
//                     ↙      ↘
//                  50           90
//                                  ↘
//                                    100
//                                  ↙
//                               95  
// Burada hemen görecebileeğimiz üzere disbalanced Node 90dır 
// Burada önce Right Rotation sonra LEft Rotation yapmamız lazım. Right Rotation'dan sonra: 
//                        70
//                     ↙      ↘
//                  50           90
//                                  ↘
//                                    95
//                                       ↘
//                                        100 
// Şimdi bu yukarıdaki Tree'ye Left rotation uygulayabiliriz: 
//                        70
//                     ↙      ↘
//                  50           95
//                              ↙   ↘
//                           90       100
// Şimdi gidip helpRotateRight(disbalancedNode) methodunu yazalım    


//! INSERT 
// Tree'ye bir eleman ekledikten sonra bir önceki elemanın balanced olup olmadığını kontrol ederiz, balance ise bir öncekine bir öncekine ve root'a kadar kontol ederiz
// Eğer geriye doğru giderken bir disbalanced bir durumla karşılaşırsak: bu seferde hangi tip disbalanced olduğunu belirlememiz lazım(LL,LR,RR,RL)





public class _1AVLTree {

    public static void main(String[] args) {

        AVLTree avl = new AVLTree();
        avl.insert(70);
        avl.insert(50);
        avl.insert(90);
        avl.insert(100);
        avl.insert(110);

        System.out.println(avl.getRoot().right.left.value);
        
    }
    
}



class AVLTree {

    private Node root;

    public AVLTree(){
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

       
    





    //! Helper Methods:
    public int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }


    public Node rotateRight(Node disbalanceNode){
        Node newRoot = disbalanceNode.left;
        disbalanceNode.left = disbalanceNode.left.right;
        newRoot.right = disbalanceNode;
        disbalanceNode.height = 1 + Math.max(getHeight(disbalanceNode.left), getHeight(disbalanceNode.right)); // left veya right'ın en yükseğini aldık. Aynısını newRoot içinde kopyalayıp yağıştıralım
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    } 
    

    public Node rotateLeft(Node disbalancedNode){
        Node newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left; //Burada disbalanced'ın right'ını null yapıyoruz yani altındakileri silip 90'ı yalnız bırakıyoruz
        newRoot.left = disbalancedNode;
        //Ve rotateRight'ta da yaptığımız kodu kopyalayıp birebir aynısını yapıştırıyorum:
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right)); // left veya right'ın en yükseğini aldık. Aynısını newRoot içinde kopyalayıp yağıştıralım
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }


    // bu method ile hangi tip disbalanced olduğunu anlayacağız(LL,LR,RR,RL):
    public int getBalanceType(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right); 
    }


    // Insert method: İlk kod helper method olacak ikinci kod asıl kod olacak:
    private Node insert(Node currentNode, int value){
        if(currentNode == null){
            Node newNode = new Node();
            newNode.value = value;
            newNode.height = 1;
            return newNode;
        }
        else if(value < currentNode.value){
            currentNode.left = insert(currentNode.left, value);
        }
        else{
            currentNode.right = insert(currentNode.right, value);
        }

        //insert etttikten sonra balance olup olmadığını kontol etmemiz lazım ama kontrol etmeden önce height'i güncellemeye ihtiyacımız var
        currentNode.height = 1 + Math.max(getHeight(currentNode.left), getHeight(currentNode.right));
        int balance = getBalanceType(currentNode);

        if(balance>1 && value<currentNode.left.value){ //bu iki şartın sağlanması bize L-L Condition olduğunu gösterir yani Right Rotation yapalıyız:
            return rotateRight(currentNode);
        }
        else if(balance>1 && value>currentNode.left.value){    // Bu iki şart = L-R Condition yani önce left sonra right rotation yapmalıyız
            currentNode.left = rotateLeft(currentNode.left);
            return rotateRight(currentNode);
        }
        else if (balance<-1 && value>currentNode.right.value){  // Bu iki şart = R-R Condition yani Left Rotation yapmalıyız:
            return rotateLeft(currentNode);
        }
        else if(balance<-1 && value<currentNode.right.value){   // Bu iki şart = R-L Condition yani önce Right sonra Left rotation yapılmalı 
            currentNode.right = rotateRight(currentNode.right);
            return rotateLeft(currentNode);
        }

        return currentNode;
    }
    public void insert(int value){
        root = insert(root, value);
    }





}




class Node {

    int value;
    int height;
    Node left;
    Node right;

    
    // public Node(int value){
    //     this.value = value;
    //     this.height = 1;
    // }

}



