import java.util.Random;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        /*
        HashTable testTableOne = new HashTable();
        testTableOne.setHashtableWithBitshiftAlgo();

        HashTable testTableTwo = new HashTable();
        testTableTwo.setHashtableWithDoubleHashingAndPrimes();

        testTableOne.getHashtable();
        System.out.println("*******************************************************");
        testTableTwo.getHashtable();
        */

        long startTime;
        Random rand = new Random();
        int[] sortThis;
        int exponent = 10;
        
        for (int i = 1024; i < 131073; i*=2) 
        {
            sortThis = new int[i];

            for (int j = 0; j < sortThis.length; j++) sortThis[j] = rand.nextInt(1000001);

            System.out.println("\n" + "***************************************************");
            System.out.println("Length of array to be sorted: " + i + " which is 2^" + exponent);
            System.out.println("***************************************************");
            exponent++;


            startTime = System.currentTimeMillis();
            MergeSort.sort(sortThis.clone(), 0, sortThis.length-1);
            System.out.println("MergeSort:      " + (System.currentTimeMillis()-startTime) + " ms (/2 is: " + (System.currentTimeMillis()-startTime)/2 + ")");

            startTime = System.currentTimeMillis();
            InsertionSortExample.insertionSort(sortThis.clone());
            System.out.println("InsertionSort:  " + (System.currentTimeMillis()-startTime) + " ms (/4 is: " + (System.currentTimeMillis()-startTime)/4 + ")");

            startTime = System.currentTimeMillis();
            SelectionSortExample.selectionSort(sortThis.clone());
            System.out.println("Selection Sort: " + (System.currentTimeMillis()-startTime) + " ms (/4 is: " + (System.currentTimeMillis()-startTime)/4 + ")");           

            startTime = System.currentTimeMillis();
            BubbleSort.bubbleSort(sortThis.clone());
            System.out.println("BubbleSort:     " + (System.currentTimeMillis()-startTime) + " ms (/4 is: " + (System.currentTimeMillis()-startTime)/4 + ")");
            
        }
        

        


        //for (int i : sortThisTwo) System.out.print("[" + i + "] "); 
    }
}




















// djb2 hashfunction
// schnelle berechnung, kollisionen vermeiden, gleiche verteilung nicht nötig in produktivumgebung
// Thema Security, welche Kriterien?
// Chaining im Kollisionen zu vermeiden (Linked Lists mit Pointern an den jeweiligen Positionen)
// linear probing als Methode, geht bei collision einfach einen weiter (wird aber irgendwann ineffizient weil cluster entstehen)
// alternative double hasing, geht immer x schritte weiter (wie in josephus)

// Avalanche Effekt: wenn nur ein einziger Byte geändert wird muss der komplette Hashwert ein anderer sein && birthday effekt
// Strict Avalanche Criterion (SAC): mind 50 % der Bits müssen bei einem anderen Input geändert werden

// md5 security, hash algos dürfen auch nicht zu schnell sein
// sha1 und 2
// hash ist one way verschlüsselung, kann nicht wieder entschlüsselt werden
// warum immer Mod? immer in der länge des arrays (oder was auch immer), dann gibt es keinen Überlauf

// Alternativ: eigene Hashfunktion mit größerem Datentyp (long oder so), evtl oneway algo?
// Hashcodes aus java nie als key für irgendwas verwenden!

// chosen prefix collsion attack (prefixes ausgewählt und 2 gleiche hashes generiert.), Komplexität für SHA 1 und 2 bei 2^63

// Beispiel Passwörter: Hash der beim Anbieter gespeichert ist wird abgeglichen, wenn collision da ist geht auch anderes passwort

// eigene java classes!




