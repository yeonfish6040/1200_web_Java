package Java_class_8;

import java.util.HashSet;
import java.util.Iterator;

import MyUtil.Stopwatch;

public class SetClass {
	public static void main(String[] main) {
		
		Stopwatch.Flag();
		
		HashSet hs = new HashSet();
		for(int i=0;i<1;i++) {
			hs.add(i);
		}
		
		System.out.println(hs);

//		hs.get(1); set은 인덱스가 없음
		Iterator it = hs.iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o.toString()+":"+o.getClass().getSimpleName());
		}
		
		Stopwatch.Flag();
		
		System.out.println(Stopwatch.getDuration(0,1));
	}
}
