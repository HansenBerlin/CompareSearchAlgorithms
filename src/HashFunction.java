public class HashFunction 
{
	private int primeSize;
	private int tableSize;

	public HashFunction(int startTableSize)
	{
		tableSize = startTableSize;
	}

	public int hashWithBitShift(String str) 
    {
		int hash = 0;
        for (int i = 0; i < str.length(); i++) 
        {
			hash = str.charAt(i) + ((hash << 5) - hash);
		}
		System.out.println("BitShift: " + hash);
		return hash;
	}

	public int doubleHashing(String str)
    {
		primeSize = getPrime();
        int hashVal = str.hashCode();
        hashVal %= tableSize;
		if (hashVal < 0) hashVal += tableSize;
		System.out.println("Double Hash: " + (primeSize - hashVal % primeSize));

        return primeSize - hashVal % primeSize;
	}
	
	public int getPrime()
    {
        for (int i = tableSize - 1; i >= 1; i--)
        {
            int fact = 0;
            for (int j = 2; j <= (int) Math.sqrt(i); j++)
                if (i % j == 0) fact++;
            if (fact == 0) return i;
        }
        return 3;
    }
    
}
