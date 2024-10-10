package _28_4RedBlackTree;


// Root her zaman siyah
// Yeni eklenen node'lar her zaman kırmızı olarak eklenir
// Root'tan leaf'e kadar her leaf'te aynı sayıda black node olması lazım 
// İki veya daha siyah node olabilir ama iki tane arka arkaya kırmızı node olamaz 

// Eklenen her node red rengiyle ekleniyor 
// Eğer red red çakışması olur ise yani hem parent hem de eklenen red ise:
// Amca Red ise recolor(renk değişimi), yani hem amca hem baba rengi değişir
// Amca Black ya da Amca yok ise :
//      LL -> Right Rotation
//      RL -> LeftRight(LR) Rotation
//      RR -> Left rotation
//      LR -> RightLeft(RL) rotation


// n tane node bulunduran bir Red-Black treenin yüksekliği O(logn)'dir
// searching aynı BST'te olduğu gibi O(logn)




//! Deletion:
// Deletion da önce transplant() adında bir fonksiyon ile aşağıdaki işlemler yapılır:
// Case 1: Silinecek Node'un parent'i yoksa
//       Silinecek Nodu'u root yap
// Case 2: Silinecek Node soldaysa, 
//       parent'ın solunu silinecek node'un çocuğu yap yani silineceği sil yerine çocuğu yaz
// Case 3: Silinecek Node sağdaysa
//       parent'ın sağını silinecek node'un çocuğu yap yani silineceği sil yerine çocuğu yaz

//* Şimdi deletion'a bakalım:
// Case 1: Left child boşsa
//        Right child ile silinecek elemanı transplant() yap 




// ************
// Kırmızı node sileceksen problem yok direkt sil
// Eğer Black node sileceksen her leaf'te aynı sayıda siyah node olması gerektiği için işler biraz karışacak 

// Önce sadece BST gibi silinecek elemanı sil 




//! Height:
// BST -> en kötü O(n)      en iyi O(logn)
// AVL -> her zaman O(logn)
// Splay -> en kötü O(n)
// 234 -> en kötü O(logn)
// Red-Black -> O(logn)



public class RedBlackTree {
    

    //public void transplant(Node silinecek, Node childOfSilinecek){}

}


