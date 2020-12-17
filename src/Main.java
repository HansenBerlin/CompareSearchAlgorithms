import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main 
{
    private static String alignRight = "%40s%s%n";

    public static void main(String[] args) throws Exception 
    {
        Random rand = new Random();
        int[] sortThis;
        int exponent = 10;
        
        for (int i = 16384; i < 131073; i*=2) 
        {
            sortThis = new int[i];

            for (int j = 0; j < sortThis.length; j++) sortThis[j] = rand.nextInt(1000001);

            System.out.println("\n" + "\n" + "Length of array to be sorted: " + i + " which is 2^" + exponent++);
            System.out.println("**************************************************************************************");
            System.out.println("Sorting Algo                Time passed in ms           extrapolation for next run");
            System.out.println("**************************************************************************************" + "\n");            
            
            System.out.print(printBenchmarkValues(runSortingFunction(CallAlgo.QuickSort.ordinal(), sortThis.clone()), "Quick Sort", 2));
            System.out.print(printBenchmarkValues(runSortingFunction(CallAlgo.MergeOne.ordinal(), sortThis.clone()), "Merge Sort by R. Mishra", 2));
            System.out.print(printBenchmarkValues(runSortingFunction(CallAlgo.MergeTwo.ordinal(), sortThis.clone()), "Merge Sort by A. Schmietendorf", 2));
            System.out.print(printBenchmarkValues(runSortingFunction(CallAlgo.JavaBuiltIn.ordinal(), sortThis.clone()), "Build in Java Collection Sort", 2));
            System.out.print(printBenchmarkValues(runSortingFunction(CallAlgo.InsertionOptimized.ordinal(), sortThis.clone()), "Insertion Sort optimized", 4));
            System.out.print(printBenchmarkValues(runSortingFunction(CallAlgo.Insertion.ordinal(), sortThis.clone()), "Insertion Sort", 4));
            System.out.print(printBenchmarkValues(runSortingFunction(CallAlgo.SelectionOptimized.ordinal(), sortThis.clone()), "Selection Sort optimized", 4));
            System.out.print(printBenchmarkValues(runSortingFunction(CallAlgo.Selection.ordinal(), sortThis.clone()), "Selection Sort", 4));
            System.out.print(printBenchmarkValues(runSortingFunction(CallAlgo.BubbleSortTwo.ordinal(), sortThis.clone()), "Bubble Sort by D. Fischer", 4));
            System.out.print(printBenchmarkValues(runSortingFunction(CallAlgo.BubbleSort.ordinal(), sortThis.clone()), "Bubble Sort", 4));

        } 
    }


    private static long runSortingFunction(int functionToRun, int[] sortThis)
    {
        long startTime = System.currentTimeMillis();
        switch (functionToRun) 
        {
            case 0:
                MergeSort.sort(sortThis, 0, sortThis.length-1);
                break;      
            case 1:
                MergeSort.getSplit(sortThis, 0, sortThis.length-1);
                break;   
            case 2:
                InsertionSortExample.insertionSort(sortThis);
                break; 
            case 3:
                InsertionSortExample.insertSortOptimized(sortThis);
                break;   
            case 4:
                SelectionSortExample.selectionSort(sortThis);
                break;  
            case 5:
                SelectionSortExample.minMaxSelectionSort(sortThis, sortThis.length);
                break; 
            case 6:
                BubbleSort.bubbleSort(sortThis);
                break; 
            case 7:
                BubbleSort.bubblesortAlternative(sortThis);
                break; 
            case 8:
                QuickSort.sort(sortThis, 0, sortThis.length-1);
                break;    
            case 9:
                List<Integer> arrayAsList = Arrays.stream(sortThis).boxed().collect(Collectors.toList());
                Collections.sort(arrayAsList);
                break;                
            default:
                break;
        }
        return System.currentTimeMillis() - startTime;
    }


    private static String printBenchmarkValues(long benchmarkingTime, String testedFunction, int expectedFactor)
    {  
        alignRight = "%" +(40-testedFunction.length()-Long.toString(benchmarkingTime).length())+ "s%s%n";
        return testedFunction + ": " + String.format(alignRight, "", benchmarkingTime + " ms           " 
        + benchmarkingTime + "*" + expectedFactor + " = " + benchmarkingTime*expectedFactor + " ms");
    }

    enum CallAlgo 
    {
        MergeOne,
        MergeTwo,
        Insertion,
        InsertionOptimized,
        Selection,
        SelectionOptimized,
        BubbleSort,
        BubbleSortTwo,
        QuickSort,
        JavaBuiltIn
      }
}
