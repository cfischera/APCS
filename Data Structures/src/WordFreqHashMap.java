/**
 * This Class tests the HashMap Object as a word reader
 * and counter. To be used in comparison to a TreeMap.
 * @author ColinFischer
 * Date Last Modified: 25 January 2017
 */

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordFreqHashMap
{
	private HashMap<String, Integer> m;
	
	/**
	 * This main method tests the output and functionality of a
	 * HashMap when reading from a text file.
	 */
	public static void main(String[] args)
	{
		WordFreqHashMap wf = new WordFreqHashMap();
		wf.loadMap(wf.getMap(), "inFile.txt");
		System.out.println(wf.getMap());
		/*
		wf.loadMap(wf.getMap(), "inFile2.txt");
		System.out.println(wf.getMap());
		wf.loadMap(wf.getMap(), "inFile2.txt");
		System.out.println(wf.getMap());
		*/
	}
	
	/**
	 * This Constructor creates a HashMap with specified Generic Types
	 * for keys: String and for values: Integer.
	 */
	public WordFreqHashMap()
	{
		m = new HashMap<String, Integer>();
	}
	
	/**
	 * Reads String Objects from a text file. Sets each unique String
	 * as a key and a value equal to how many times that String appears.
	 */
	public void loadMap(HashMap<String, Integer> m, String fileName)
	{
		try
		{
			Scanner sc = new Scanner (new File(fileName));
			while (sc.hasNext())
			{
				String word = sc.next();
				Integer i = (Integer)m.get(word);
				if(i==null)
				{
					m.put(word, new Integer(1));
				}
				else
				{
					m.put(word, new Integer(i.intValue()+1));
				}
			}
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
	}
	
	/**
	 * Returns the Class's HashMap Object.
	 */
	public HashMap<String, Integer> getMap()
	{
		return m;
	}
}