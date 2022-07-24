package Java_class_7;

public class Class1 {
	
	Class1(){
		System.out.println("Class1 Created");
		try {
			Class2 c = new Class2();
		}catch(StackOverflowError e) {
			Class2 c = new Class2();
		}
		
	}

	public static void main(String[] args) {
		Class1 c1 = new Class1();
	}

}
