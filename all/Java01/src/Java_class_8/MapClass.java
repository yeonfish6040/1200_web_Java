package Java_class_8;

import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

import MyUtil.Stopwatch;

public class MapClass {
	public static void main(String[] argv) {
		HashMap hm = new HashMap();
		hm.put("Name", "Lebron");
		hm.put("age", 34);
		hm.put("Country", "Korea");
		System.out.println(hm);
		System.out.println(hm.size());
		System.out.println(hm.containsKey("Country"));
		
		// Map 에서 데이터를 꺼내기
		/*
		 * 키를 꺼낸다
		 * 그후 키로 Value를 구한다.
		 */
		
		Set keySet = hm.keySet();
		System.out.println(keySet);
		Iterator it = keySet.iterator();
		while(it.hasNext()) {
			System.out.println(hm.get(it.next()));
		}
		
		// 2. key와 value를 쌍으로 꺼내는 방법
		Set entryset = hm.entrySet();
		System.out.println(entryset);
		Iterator it2 = entryset.iterator();
		while(it2.hasNext()) {
			Map.Entry entry = (Map.Entry)it2.next();
			System.out.println(entry);
		}
	}
}

