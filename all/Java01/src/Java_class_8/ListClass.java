package Java_class_8;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Date;
import java.util.Iterator;

import MyUtil.Stopwatch;

public class ListClass {
	public static void main(String[] argv) {
		
		ArrayList al = new ArrayList();
		al.add("1");
		al.add("100");
		al.add("myblog");
		al.add(1, "new one");
		System.out.println(al+" size(): "+al.size());
		al.remove(2);
		System.out.println(al);
		System.out.println(al.get(2));
		System.out.println("myblog 선생님 계시나요? "+al.contains("myblog"));
		
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
		
		Iterator it = al.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		ArrayList al2 = new ArrayList();
		al2.add("Student");
		al2.add(50);
		Cat cat1 = new Cat();
		al2.add(cat1);
		
		for(int i=0;i<al2.size();i++) {
			System.out.println(al2.get(i).getClass());
			System.out.println(al2.get(i).getClass().getSimpleName());
			if(al2.get(i).getClass().getSimpleName().equals("Cat")) {
				System.out.println("웬 고양이가 들어있어");
			}
		}
		
		Stopwatch.Flag();
		LinkedList ll01 = new LinkedList();
		for(int i=0;i<100000000;i++) {
			ll01.add("1");
		}
		Stopwatch.Flag();
		
		Stopwatch.Flag();
		ArrayList al01 = new ArrayList();
		for(int i=0;i<100000000;i++) {
			al01.add("1");
		}
		Stopwatch.Flag();
		
		System.out.println(Stopwatch.getDuration(0,1));
		System.out.println(Stopwatch.getDuration(2,3));
		System.out.println(Stopwatch.getTimes());
		
		
	}
}
