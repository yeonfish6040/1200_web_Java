package Java_class_002;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		print p = new print();
		p.t("Random test");
		
		Random rd = new Random();
		
		// Random Number test
		p.p("nextInt(100): "+rd.nextInt(100));
		p.p("nextInt(): "+rd.nextInt());
		p.p("nextFloat: "+rd.nextFloat());
		p.p("nextDouble: "+rd.nextDouble());
		
		// Random Alphabet Test
		int rChar = 1;
		rChar = rd.nextInt(26)+'a';
		System.out.println((char)rChar);
		rChar = rd.nextInt(26)+'A';
		System.out.println((char)rChar);
		rChar = rd.nextInt(10)+'0';
		System.out.println((char)rChar);
		
	}

}
