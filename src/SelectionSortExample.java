public class SelectionSortExample 
{  
    public static int[] selectionSort(int[] arr)
    {  
        for (int i = 0; i < arr.length - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.length; j++)
            {  
                if (arr[j] < arr[index])
                {  
                    index = j; 
                }  
            }  
            int smallerNumber = arr[index];   
            arr[index] = arr[i];  
            arr[i] = smallerNumber;  
        }  
        return arr;
    }  


    public static int[] minMaxSelectionSort(int[] arr, int n) 
    { 
        for (int i = 0, j = n - 1; i < j; i++, j--)  
        { 
            int min = arr[i], max = arr[i]; 
            int min_i = i, max_i = i; 
            for (int k = i; k <= j; k++)  
            { 
                if (arr[k] > max) 
                { 
                    max = arr[k]; 
                    max_i = k; 
                }  
                else if (arr[k] < min)  
                { 
                    min = arr[k]; 
                    min_i = k; 
                } 
            } 
  
            swap(arr, i, min_i); 
  
            // Shifting the max. The equal condition 
            // happens if we shifted the max to arr[min_i]  
            // in the previous swap. 
            if (arr[min_i] == max)  
                swap(arr, j, min_i); 
            else
                swap(arr, j, max_i); 
        }
        return arr; 
    } 
    
  
    static int[] swap(int []arr, int i, int j) 
    { 
        int temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
        return arr; 
    }  
       
}  