import java.util.Arrays;

public class InsertionSortExample 
{  
    public static int[] insertionSort(int array[]) 
    {  
        for (int j = 1; j < array.length; j++) 
        {  
            int key = array[j];  
            int i = j-1;  
            while ((i > -1) && (array[i] > key )) 
            {  
                array [i+1] = array[i];  
                i--;  
            }  
            array[i+1] = key;  
        } 
        return array; 
    }  

    
    public static int[] insertSortOptimized(int array[])
    {
        for (int i = 1; i < array.length; i++) 
        {
            int x = array[i];
 
            // Find location to insert
            // using binary search
            int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);
 
            // Shifting array to one
            // location right
            System.arraycopy(array, j, array, j + 1, i - j);
 
            // Placing element at its 
            // correct location
            array[j] = x;
        }
        return array;
    }
}    