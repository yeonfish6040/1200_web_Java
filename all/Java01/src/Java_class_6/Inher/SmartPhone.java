package Java_class_6.Inher;

public class SmartPhone extends Phone {
	void sendTextMessage(String str) {
		System.out.println(str);
		System.out.println("예전폰이었다면");
		super.sendTextMessage(str);
	}
	
	void sendTextMessage(int i) {
		System.out.println("Text : Integer");
	}
}
