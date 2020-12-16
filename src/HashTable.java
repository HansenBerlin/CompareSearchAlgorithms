import java.util.*;

public class HashTable 
{
	private Hashtable<String, String> table;
	
	public HashTable() 
	{
		table = new Hashtable<String, String>();	
	}

	
	public void getHashtable()
	{
		Enumeration<String> e;	
		String key;
		
		for (e=table.keys(); e.hasMoreElements();)
		{
			key = (String)e.nextElement();
			System.out.println("Key: " + table.get(key).hashCode());
			System.out.println("Value: " + table.get(key));
		}
	}
	
	
	public void setHashtableWithBitshiftAlgo()
	{		
		HashFunction hf = new HashFunction(10);

		table.put(String.valueOf(hf.hashWithBitShift("Daimler")), "Daimler");
		table.put(String.valueOf(hf.hashWithBitShift("Dainler")), "Dainler");
		table.put(String.valueOf(hf.hashWithBitShift("VW")), "VW");
		table.put(String.valueOf(hf.hashWithBitShift("V W")), "V W");
	}

	public void setHashtableWithDoubleHashingAndPrimes()
	{		
		HashFunction hf = new HashFunction(10);

		table.put(String.valueOf(hf.doubleHashing("Daimler")), "Daimler");
		table.put(String.valueOf(hf.doubleHashing("Dainler")), "Dainler");
		table.put(String.valueOf(hf.doubleHashing("VW")), "VW");
		table.put(String.valueOf(hf.doubleHashing("V W")), "V W");
	}
}


