package _20Sorting._1BasicSort._3InsertionSort;

public class _3HeightInsertionSort {

    public static void main(String[] args) {

        
        

    }


    public static void insertionSort(int[] heights) {
        for (int i = 1; i < heights.length; i++) {
            int key = heights[i];
            int j = i - 1;
            
            while (j >= 0 && heights[j] > key) {
                heights[j + 1] = heights[j];
                j--;
            }

            heights[j + 1] = key;
        }
}
    
}
