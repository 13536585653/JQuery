package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		/*
		 * List<String> list = new ArrayList<String>() ; list.add("AA") ;
		 * list.add("BB") ; list.add("CC") ; list.add("EE") ;
		 * 
		 * for (String s : list) { System.out.println(s); }
		 */

		Map<String, String> map = new HashMap<String, String>();

		map.put("1001", "AAA");
		map.put("1002", "BBB");
		map.put("1003", "CCC");
		map.put("1004", "DDD");
		
		/*
		Set<Entry<String, String>> set = map.entrySet() ;
		for (Entry<String, String> entry : set) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		*/
		
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

}
