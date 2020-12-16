import java.util.Random;


public class Main 
{
    private static String alignRight = "%40s%s%n";


    public static void main(String[] args) throws Exception 
    {
       
        Random rand = new Random();
        int[] sortThis;
        int exponent = 10;
        
        for (int i = 1024; i < 131073; i*=2) 
        {
            sortThis = new int[i];

            for (int j = 0; j < sortThis.length; j++) sortThis[j] = rand.nextInt(1000001);

        System.out.println("\n" + "\n" + "Length of array to be sorted: " + i + " which is 2^" + exponent);
            System.out.println("**************************************************************************************");
            exponent++;

            System.out.println("Sorting Algo                Time passed in ms           extrapolation for next run");

            System.out.println("**************************************************************************************" + "\n");            
            
            System.out.print(printBenchmarkValues(runSortingFunction(1, sortThis.clone()), "Merge Sort by R. Mishra", 2));
            System.out.print(printBenchmarkValues(runSortingFunction(2, sortThis.clone()), "Merge Sort by A. Schmietendorf", 2));
            System.out.print(printBenchmarkValues(runSortingFunction(3, sortThis.clone()), "Insertion Sort", 4));
            System.out.print(printBenchmarkValues(runSortingFunction(4, sortThis.clone()), "Selection Sort", 4));
            System.out.print(printBenchmarkValues(runSortingFunction(5, sortThis.clone()), "Bubble Sort", 4));
            System.out.print(printBenchmarkValues(runSortingFunction(6, sortThis.clone()), "Bubble Sort by D. Fischer", 4));

        }   
    }


    private static long runSortingFunction(int functionToRun, int[] sortThis)
    {
        long startTime = System.currentTimeMillis();
        switch (functionToRun) 
        {
            case 1:
                MergeSort.sort(sortThis, 0, sortThis.length-1);
                break;      
            case 2:
                MergeSort.getSplit(sortThis, 0, sortThis.length-1);
                break;   
            case 3:
                InsertionSortExample.insertionSort(sortThis);
                break;  
            case 4:
                SelectionSortExample.selectionSort(sortThis);
                break;  
            case 5:
                BubbleSort.bubbleSort(sortThis);
                break; 
            case 6:
                BubbleSort.bubblesortAlternative(sortThis);
                break;    
            default:
                break;
        }
        return System.currentTimeMillis() - startTime;
    }


    private static String printBenchmarkValues(long benchmarkingTime, String testedFunction, int expectedFactor)
    {  
        printGraph(benchmarkingTime);
        alignRight = "%" +(40-testedFunction.length()-Long.toString(benchmarkingTime).length())+ "s%s%n";
        return testedFunction + ": " + String.format(alignRight, "", benchmarkingTime + " ms           " 
        + benchmarkingTime + "*" + expectedFactor + " = " + benchmarkingTime*expectedFactor + " ms");
    }


    private static void printGraph(long benchmarkingTime)
    {
        System.out.println(" ");
        for (int i = 0; i < benchmarkingTime; i+=10) 
        {
            System.out.print("|");            
        }
        System.out.println(" ");
    }
}
