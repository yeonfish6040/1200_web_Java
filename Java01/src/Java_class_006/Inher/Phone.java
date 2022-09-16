package Java_class_006.Inher;

public class Phone {
	String color;
	String company;
	String model;
	
	void sendTextMessage(String str) {
		if (str.length() > 80) {
			System.out.println("글이 너무 깁니다.");
		}else {
			System.out.println(str);
		}
	}
}
