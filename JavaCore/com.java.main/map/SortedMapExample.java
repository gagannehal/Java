package map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapExample {

	public static void main(String[] args) {
		
		//Maintains order of insertion
		
		SortedMap<String, String> map1 = new TreeMap<>();

		map1.put("Key1", "Value1"); 
		map1.put("Key2", "Value2");
		map1.put("Key5", "Value3");
		map1.put("Key4", "Value4");
		map1.put("Key3", "Value5");

		System.out.println("Size of map : " + map1.size());

		Set<Map.Entry<String,String>> entries = map1.entrySet();
		
		for(Map.Entry<String,String> entry : entries) {
			System.out.println("Key - "+entry.getKey()+" ; Value - "+entry.getValue());
		}
	}

}
