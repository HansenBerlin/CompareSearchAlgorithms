class BubbleSort
{
	public static int[] bubbleSort(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
		return arr;
	}

	// Daniel Fischer SoF
	public static int[] bubblesortAlternative(int[] a) {
		int lastSwap = a.length-1;
		for(int i=1; i<a.length; i++) {
		  boolean is_sorted = true;
		  int currentSwap = -1;
	  
		  for(int j=0; j < lastSwap; j++) {
			if(a[j] > a[j+1]) {
			   int temp = a[j];
			   a[j] = a[j+1];
			   a[j+1] = temp;
			   is_sorted = false;
			   currentSwap = j;
			}
		  }
	  
		  if(is_sorted) return a;
		  lastSwap = currentSwap;
		}
		return a;
	  }
}
