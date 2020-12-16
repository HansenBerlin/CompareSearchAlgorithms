public class LinSuche 
{

	public LinSuche() 
	{
		int[] listeA = {11,22,33,44,55,66,67,78,90,122};
		int ergA = search (listeA, 333,0,9);

		System.out.println("Gesuchter Wert an Position "+ergA);
		String[] listeB = {"Mueller", "Schmietendorf", "Zech", "Schulze", "Maier", "Zeppenfeldt"};
		int ergB = searchWord (listeB, "Schmietendorf",0,5);
		System.out.println("Gesuchter Wert an Position "+ergB);
	}

	
	static int search (int list[], int searchValue, int left, int right)
	{
		int i;
		for (i = left; i <= right; i++)
		{
			if (searchValue == list[i]) return i;
		}
		return -1;
	}
	
	
	static int searchWord (String list[], String searchValue, int left, int right)
	{
		int i;
		for (i = left; i <= right; i++)
		{
			if (list[i].contains(searchValue)) return i;
		}
		return -1;
	}

}
