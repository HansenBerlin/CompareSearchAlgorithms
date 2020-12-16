public class BinSuche 
{
	public BinSuche() 
	{
	}
	
	public static int[] getTestField()
	{
		final int LENGTH = 10000;
		int[] test = new int[LENGTH];
		for (int i=0; i<LENGTH; i++)
		{
			test[i] = 2 * i;
		}
		return test;
	}

	
	static int getSearchLin (int list[], int searchValue)
	{
		int n = list.length-1;
		int left = 0;
		for (int i = left; i <= n; i++)
		{
			if (searchValue == list[i]) return i;
		}
		return -1;
	}

	
	static int getSearchBin (int list[], int searchValue)
	{
		int left = 0;
		int right = list.length-1;

		while (right >= 0 && left <= right)
		{
			int pos = (left+right)/2;

			if (searchValue == list[pos]) return pos; 

			if (searchValue < list[pos]) right = pos - 1;
			else left = pos + 1;
		}
		return -1;
	}
	
	
	static int getSearchBinRek (int list[], int searchValue, int low, int high) 
	{
		if (low > high)	return -1; // kein Ergebnis
		
		int middle = (low + high) / 2;

		if (searchValue == list[middle]) return middle; 

		if (searchValue < list[middle]) return getSearchBinRek(list, searchValue, low, middle-1);
		else return getSearchBinRek(list, searchValue, middle+1, high);		
	}	
}
