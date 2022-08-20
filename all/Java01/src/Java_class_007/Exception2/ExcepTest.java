package Java_class_007.Exception2;

import java.util.Random;

public class ExcepTest {

	public static void main(String[] args) throws Exception {
		Excep c = new Excep();
		for(int i=0;i<10;i++) {
			try {
					c.getVariable();
			} catch(Exception e) {
				System.out.println(e.toString());
			}
		}		
	}

}


class Excep {
	public static void getVariable() throws Exception {
		Random rd = new Random();
		int i = rd.nextInt(100);
		if(i>70) {
			throw new MyException("Critical!! 대박!");
		}else if(i<30) {
			throw new MyException("Ah bad news... 폭망ㅠㅠ");
		}else {
			System.out.println("So So");
		}
	}
}

class MyException extends Exception {
	MyException(String msg){
		super(msg);
		System.out.println("야 드디어 내 예외 떴다");
	}
}