package Java_class_007.Inter2;

public class Calculate implements CalcInterface {
	int left, center, right;
	
	public void setOperand(int first, int second, int third) {
		left = first;
		center = second;
		right = third;
	}
	
	public int sum() {
		System.out.println(left+center+right);
		return (left+center+right);
	}
	
	public double avg() {
		System.out.println((left+center+right)/3d);
		return (left+center+right)/3d;
	}

}
