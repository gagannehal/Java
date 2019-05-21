package map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapExample {

	public static void main(String[] args) {
		//Maintains order of insertion
		
		LinkedHashMap<String, String> map1 = new LinkedHashMap<>();

		map1.put("Key1", "Value1"); 
		map1.put("Key2", "Value2");
		map1.put("Key3", "Value3");
		map1.put("Key4", "Value4");
		map1.put("Key5", "Value5");

		System.out.println("Size of map : " + map1.size());

		Set<Map.Entry<String,String>> entries = map1.entrySet();
		
		for(Map.Entry<String,String> entry : entries) {
			System.out.println("Key - "+entry.getKey()+" ; Value - "+entry.getValue());
		}
	}
	
//Methods - https://www.javatpoint.com/java-linkedhashmap
//Interview - https://javahungry.blogspot.com/2015/08/how-linkedhashmap-works-internally-in-java.html

}
