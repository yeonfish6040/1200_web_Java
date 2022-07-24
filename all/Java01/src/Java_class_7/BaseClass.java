package Java_class_7;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class BaseClass {
	public static void main(String[] argv) throws InterruptedException {
//		String str1 = "";
//		StringBuffer str2 = new StringBuffer("");
//		long t1 = System.currentTimeMillis();
//		
//		for(int i=0;i<100000;i++) {
//			str1 = str1+i;
//		}
//		//5967
//		
//		long t2 = System.currentTimeMillis();
//		
//		for(int i=0;i<100000;i++) {
//			str2.append(i);
//		}
//		//3
//		
//		long t3 = System.currentTimeMillis();
//		
//		System.out.println("String: "+(t2-t1)+"\nStringBuffer: "+(t3-t2));
		
		StringBuffer sb1 = new StringBuffer("abcdefg");
		StringBuffer sb2 = new StringBuffer("abcdefg");
		System.out.println(sb1==sb2);
		
		// StringBuffer에 값 비교하는 법
		System.out.println(sb1.toString().equals(sb2.toString()));
		
		// StringBuffer insert, delete
		sb1.delete(4, 6);
		System.out.println(sb1);
		
		sb1.insert(2, "asdfagasdggadg");
		System.out.println(sb1);
		
		sb1.delete(3,4);
		System.out.println(sb1);
		
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss"); 
		System.out.println(sf.format(d));
//		while(true) {
//			Date d = new Date();
//			System.out.print("\r"+d);
//			Thread.sleep(100);
//		}
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.DAY_OF_YEAR));
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.MONTH)+1);
		
	}
}
