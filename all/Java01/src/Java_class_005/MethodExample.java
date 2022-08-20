package Java_class_005;

public class MethodExample {

	public static void main(String[] args) {
		Calc c = new Calc();
		c.add(3, 5);
		c.add(3.0f, 5.0f);
		c.add(1, 2, 10);
		
		int rn = c.add(105);
		System.out.println("Return Add: "+rn);
		
		int[] ints = {1, 2, 3, 4};
		int rn1 = c.add(ints);
		System.out.println("Return Add(int[]): "+rn1);
		
//		String[] strs = {"1", "2", "3", "4"};
		String[] strs = {"drive ", "your ", "way "};
		String rn2 = c.add(strs);
		System.out.println("Return Add(String[]): "+rn2);
	}

}

class Calc {
	public void add(int a, int b) {
		System.out.println("Add Int: "+(a+b));
	}
	public void add(double a, double b) {
		System.out.println("Add Double: "+(a+b));
	}
	public void add(int a, int b, int c) {
		System.out.println("Add 3 int: "+(a+b+c));
	}
	public int add(int i) {
		return i+100000;
	}
	public int add(int[] i) {
		int result = 0;
		for(int j:i) {
			result += j;
		}
		return result;
	}
	public String add(String[] i) {
		String result = "";
		for(String j:i) {
			result += j;
		}
		return result;
	}
}