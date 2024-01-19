package _20Sorting._2MergeSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Merge {

    // Merge Sort, recursion kullandığımız ilk sıralama algoritması olacak


    // Merge Sort kullanmadan önce mergeSort fonksiyonunda kullanmak için 'merge' fonksitonu yazacağız ve orada olay şöyle olacak:
    // Array hep ikiye bölüne bölüne tek eleman kalana kadar bölünecek ve şöyle bir hal alacak

    //                  5,4,7,1,3,2,8,6
    //             5,4,7,1             3,2,8,6
    //           5,4      7,1        3,2       8,6
    //         5    4    7    1    3    2     8    6 

    // Sonra en alttan başlayarak komşu iki arrayi sıralamaya başlayacağız:
    //                  5,4,7,1,3,2,8,6
    //             5,4,7,1             3,2,8,6
    //           4,5      1,7        2,3       6,8
    
    // Sonra yine en alttaki komşu 2 array sort edilerek birleştirilir
    //                  5,4,7,1,3,2,8,6
    //             1,4,5,7             2,3,6,8

    // Sonra yine en alttaki komşu 2 array sort edilerek birleştirilir
    //                  1,2,3,4,5,6,7,8         
    
    

    //! Merge sort'un Space Complexity'si O(n)'dir.
    //! Time complexity'si: array'i ikiye bölerek ayrıştırırken O(n), birleştirirken O(logn). Yani Time Complexity = O(n*logn)


    public static void main(String[] args) {

        // int[] arr1 = {1,3,7,8};
        // int[] arr2 = {2,4,5,6};

        // double start = System.nanoTime();
        // merge(arr1, arr2);
        // double end = System.nanoTime();

        // System.out.println(end-start);
        // System.out.println(Arrays.toString(merge(arr1, arr2)));

        int[] array = {1,3,7,8,2,4,5,6};

        double start = System.nanoTime();
        mergeSort(array);
        double end = System.nanoTime();
        System.out.println(end-start);

        System.out.println(Arrays.toString(mergeSort(array)));
        
    }




    public static int[] mergeSort(int[] arr){

        if(arr.length == 1) return arr;

        int midIndex = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length));

        return merge(left, right);
    }




    // Önce merge sort içersinde kullanacağımız merge fonksiyonunu yazacağız:
    public static int[] merge(int[] arr1 , int[] arr2){
        // parametre olarak aldığımız 2 array sorted olmak ZORUNDA

        int[] combined = new int[arr1.length + arr2.length];
        
        int index = 0;
        int i = 0;
        int j = 0;  // for kullanmadığımız için bunların hepsini manuel olarak her işlemde artırmamız lazım

        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                combined[index] = arr1[i];
                index++;    // Combined'a her eleman eklediğimiz yerde index'i artırmamız lazım
                i++;
            }else{
                combined[index] = arr2[j];
                index++;    // Combined'a her eleman eklediğimiz yerde index'i artırmamız lazım
                j++;
            }
        }
        // While loop iki arrayden birisi boşalınca çalışmayı durdurur
        // Yani hala dolu olan array var demektir bu yüzden o dolu olan array elemanlarını da combined array'ine eklememiz lazım
        // Bunun için iki array'i de teker teker kontrol etmemiz lazım
        while(i < arr1.length){
            combined[index] = arr1[i];
            index++;    // Combined'a her eleman eklediğimiz yerde index'i artırmamız lazım
            i++;
        }
        while(j < arr2.length){
            combined[index] = arr2[j];
            index++;
            j++;
        }

        return combined;
    }
    
}

