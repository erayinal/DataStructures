package _28_3_234Tree;

//


// 2 - 3 - 4 Agacindan Dügüm Silme Algoritması: İki yol vardır

//1) • Cocuksuz ise direkt sil.
//2) • Çocuklu ise KBEK (veya KKEB) dügümü yerine yaz ve sil. (KBEK=kendisinden büyük en küçük)(KKEB=kendisinden küçük en büyük)

//   İki durumda da silinecek dügümü ararken (root haric) 1 elemanlı dügüm için "sırasıyla" aşağıdaki kurallardan birini uygulamaya çalis :
//   • Rule 1 : Kardesten ödünç almaya calis. (Çocuklarıyla birlikte getir)
//            Eğer kardeşler eşit sayıda eleman içeriyorsa hangisinden aldığımız farketmez ama birisinde daha fazla eleman varsa, fazla olandan al
//   • Rule 2 : Babadan ödünç almaya çalış ve
//            [kardes, babadan 1, kendin] 3 elemanli bir dügüm olustur.
//   • Rule 3 : Baba tek elemanli root ve kardes de tek elemanli ise
//            [kardes, root, kendin] 3 elemanli bir root dügüm olustur.
//            Bu durumda again seviyesi 1 azalir.




//! Rule 1: remove(30)
//               20·40
//           ↙    ↓        ↘
//         10     30      50·51·52

//               20·50
//           ↙     ↓        ↘
//         10    30·40      51·52 

//               20·50
//           ↙     ↓        ↘
//         10      40      51·52 



//! Rule 2: remove(40)
//              ·20·40·
//            ↙    ↓      ↘
//         10      30      50

//                40
//             ↙      ↘
//        10·20·30     50  

//                40
//             ↙      ↘
//          10·20      50  



//! Rule 3: remove(40)
// Burada KBEK elemanı(42) bulmaya giderken geçtiğimiz her elemanı yukarıdaki 3 kurala göre eleman sayısını artırmamız lazım
//                                      40
//                      ↙                             ↘
//                 20                                     50
//            ↙          ↘                          ↙                  ↘
//        14               32                     43                  62·70·79
//       ↙    ↘          ↙    ↘                ↙      ↘           ↙     ↙    ↘       ↘   
//    10       18      25      33            42       47      52·60    66     74      81




public class _234Tree {
    
    
}
