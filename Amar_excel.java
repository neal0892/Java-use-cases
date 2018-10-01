package com.neeraj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Amar_excel {

	public static void main(String[] args) {
		String inputPath = "C:/Users/569882/workspace/test/src/com/neeraj/COSMOS_User_Detail.csv";
		int groupByColumn = 0  ;
		readFile(inputPath, groupByColumn);
	}

	public static void readFile(String s1,int groupByColumn) {
		String[] temp = null;
		Map<String, Integer> hm = null;
		int count = 0;
		try (FileReader fr = new FileReader(s1); BufferedReader fb = new BufferedReader(fr);) {
			String s = null;
			String[] eachRow = new String[11];
			hm = new TreeMap<String, Integer>();
			while ((s = fb.readLine()) != null) {
				eachRow = s.split(","); // took an entire now and converted to
										// string array
				// System.out.println("asdad" + eachRow.length + eachRow[0]);
				if (temp != null && temp[groupByColumn].equals(eachRow[groupByColumn])) {
					for (int i = 1; i <= 10; i++) {
						if (!(temp[i].contains(eachRow[i])))
							temp[i] = temp[i] + ";" + eachRow[i];
					}
					count++;
				} else {
					if (temp != null) {
						for (String s2 : temp)
							System.out.print(s2 + " ,");//added a comma after every string to make output csv
						// }
						System.out.println();
					}
					temp = eachRow; // copied the array to temp array
					count = 1;

				}
				// for (String entry : eachRow) {

				// String[] prevRow = eachRow;
				// System.out.println(eachRow[0]+ eachRow[10]);
				// System.out.println(eachRow);
				// hm.put(name, count);
				// System.out.println(eachRow[0] + " " + count);
			}

			for (Entry<String, Integer> es : hm.entrySet()) {
				System.out.println(es.getKey() + " and count is  " + es.getValue());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
