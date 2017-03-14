/**
 * This Class tests the functionality and outputs of 
 * TreeMaps, HashMaps, and TreeSets.
 * @author ColinFischer
 * Date Last Modified: 7 March 2017
 */

import java.util.*;
import java.io.*;

public class SetsAndMaps
{
	/**
	 * Tests a TreeMap, HashMap, and TreeSet with data from
	 * text files; displays their toString methods.
	 */
	public static void main(String[] args)
	{
		SetsAndMaps driver = new SetsAndMaps();
		TreeMap treeMap = new TreeMap();
		HashMap hashMap = new HashMap();
		TreeSet treeSet = new TreeSet();
		driver.loadMap(treeMap, "treeMap.txt");
		driver.loadMap(hashMap, "hashMap.txt");
		driver.loadSet(treeSet, "treeSet.txt");
		System.out.println(treeMap);
		System.out.println(hashMap);
		System.out.println(treeSet);
	}
	
	/**
	 * Adds data to a Map from a text file, delimited by commas.
	 */
	private void loadMap(Map m, String fileName)
	{
		String preData = "";
		try
		{
			Scanner sc = new Scanner(new File(fileName));
			while(sc.hasNextLine())
			{
				preData +=""+sc.nextLine();
			}
			String[] postData = preData.split(",");
			for(int i=0;i<postData.length-1;i+=2)
			{
				m.put(postData[i], postData[i+1]);
			}
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File was not found.");
		}
	}

	
	/**
	 * Adds data to a Set from a text file, delimited by commas.
	 */
	private void loadSet(Set s, String fileName)
	{
		String preData = "";
		try
		{
			Scanner sc = new Scanner(new File(fileName));
			while(sc.hasNextLine())
			{
				preData +=""+sc.nextLine();
			}
			String[] postData = preData.split(",");
			for(int i=0;i<postData.length;i++)
				s.add(postData[i]);
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File was not found.");
		}
	}
}