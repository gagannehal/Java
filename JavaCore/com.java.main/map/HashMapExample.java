package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {

		HashMap<String, String> map1 = new HashMap<>();

		System.out.println(map1.put("Key1", "Value1")); // null
		map1.put("Key2", "Value2");
		map1.put("Key3", "Value3");
		map1.put("Key4", "Value4");
		map1.put("Key5", "Value5");
		System.out.println(map1.put("Key1", "Value6")); // it will update the value and will return the old value

		System.out.println("Size of map : " + map1.size());

		// Ways to iterate a HashMap

		// 1. Using Map.entrySet()
		Set<Map.Entry<String, String>> entries = map1.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			System.out.println("Key : " + entry.getKey() + " ; Value : " + entry.getValue());
		}

		// 2. Using KeySet
		Set<String> keys = map1.keySet();
		for (String key : keys) {
			System.out.println("Key : " + key + " ; Value : " + map1.get(key));
		}

		// 3. Using Iterator (benefit - entry can be removed while iteration)
		Iterator<Map.Entry<String, String>> itr = map1.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			System.out.println("Key : " + entry.getKey() + "; Value : " + entry.getValue());
		}
	}

}

// Methods - https://www.javatpoint.com/java-hashmap
//Some Questions :- http://www.java67.com/2017/08/top-10-java-hashmap-interview-questions.html
