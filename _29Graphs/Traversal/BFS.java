package _29Graphs.Traversal;

//  A       B   

//  C       D       G

//  E       F

// Breadth First Search, satır satır yazar: -> A B C D G E F
// Queue kullanır, poll(ilk gireni alır ve siler)

// Depth First Search, sütun sütun yazar: -> A C E F D B G
// Stack kullanır, pop(en üsttekini alır ve siler) ile...




//! Floyd-Warshall:
// Node'lar arsıdnaki en kısa mesafeyi buluyor
// Dinamik bir proglamlamadır. (Dinamik prog: bir işlemi daha sonradan kullanabilmem için saklama, f.e Fibonacci)
// Bir matris kullanarak yapıyor ve ağırlıklı graf kulllanır yani matrise ağırlıkları yazıyor 
// Durmadan kendini günceller
// Direkt gidemediğin nodelara sonsuz yazılır
// Matris doldurulduktan sonra Warshall Methodu: Gidilmek istenen yeri(2->5) farklı şekillerde her olasılığı dener(2->1->5 veya 2->3->5 gibi) ve en kısa olanı yazar
// Ana mantığı tamamen budur
//* Avantajları:
// Graphlar arasındaki en kısa mesafeyi buluyor yani her iki şehir arasdınaki en kısa mesafeyi bulmak istediğimizde çok kullanışlıdır
// Dinamik proglama kullanır yani alt bir problemi çözerek daha büyük bir problemi çözmemizi sağlıyor
// Negatif ağırlıklara izin verebiliyor, bazı diğer algoritmalar negatif ağırlıklarla başa çıkamıyor, ancak negatif değerler verildiğinde %100 kesin sonucu vermeyebiliyor 
// Hafızayı etkin kullanıyor ve hafızada az yer kaplıyor

// Tüm node'ları kullanarak hesap yağtığı için çok zaman alıyor -> O(n^3)
// Negatif ağırlıklarda yanlış sonuçlar verebiliyor
// Yalnızca ağırlıklı edge'lerde çalışır, ağırlıksız bağlantılarda kullanılamaz
//  




//! Topological Sort:








public class BFS {


    
}
