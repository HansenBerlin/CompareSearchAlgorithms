public class MergeSort 
{

	// This code is contributed by Rajat Mishra
	static void merge(int arr[], int l, int m, int r)
	{
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];
		
		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) 
		{
			if (L[i] <= R[j]) 
			{
				arr[k] = L[i];
				i++;
			}
			else 
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}
	}

	// This code is contributed by Rajat Mishra
	static int[] sort(int arr[], int l, int r)
	{
		if (l < r) 
		{
			int m = (l + r) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
		return arr;
	}


	// This code is contributed by Andreas Schmietendorf	
	public static int[] getSplit(int[] collection, int low, int high) {
		if (low<high) {
			int middle = (low+high+1)/2;
			getSplit(collection, low, middle-1);
			getSplit(collection, middle, high);
			getMerge(collection, low, middle, high);
		}
		return collection;
	}

	// This code is contributed by Andreas Schmietendorf		
	public static void getMerge(int[] collection, int low, int middle,int high) {
		int[] temp = new int[high-low+1];
		for (int i=0, j=low, k=middle; i<temp.length; i++) {
			if ((k > high) || (j<middle) && (collection[j] < collection[k])) {
				temp[i] = collection[j]; j++;
			}else {
				temp[i]=collection[k];
				k++;
			}
		}
		for(int i=0; i<temp.length; i++) { 
			collection[low+i] = temp[i];
		}
	}
}

