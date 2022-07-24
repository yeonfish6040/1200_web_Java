package Java_class_7;

public class Class2 {
	Class2(){
		try {
			Class2 c2 = new Class2();
		}catch(StackOverflowError e) {
			Class2 c2 = new Class2();
		}
		
	}
}
