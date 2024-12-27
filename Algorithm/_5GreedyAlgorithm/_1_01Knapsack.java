package Algorithm._5GreedyAlgorithm;

// Problemin tanımı:
// Hırsızın birisi kapasitesi w olan bir çuval(knapsack) ile müzeye giriyor. n tane çalabileceği item var
// vi item'ın değeri ; wi ise item'ın ağırlığı
// elindeki çuvalı toplam değeri en fazla olacak şekilde doldurması lazım, tabi alabileceği maksimum ağırlık önceden belli(W)

// Burada iki farklı türü var problemin: 1) 0-1 Knapsack, 2)Fractional Knapsack
// 0-1 Knapsack: Bir item'ı ya alır(1) ya almaz(0), yani parçasını alamaz
// Fractional Knapsack: İtem'ı parçalara ayırıp kullanabilir.

// Zor olan problem 0-1 Knapsack'tir. Ve incelersek:
// Eğer her item için 'Per Unit Price' yani her birisi için Birim Fiyat hesaplarsak
// Ve ardından birim değeri en yüksek olandan başlarsak çuvalı doldurmaya problem çözülür. 


//! Time Complexity: O(n^2)dir çünkü:
// En kötü senaryoda; tüm eşyaların ağırlıkları toplamı, çantanın alabileceği ağırlıkla eşittir ve bu yüzden bir while ve bir for ile bütün eşyaları taramamız gerekir



public class _1_01Knapsack {


    
}
