package Java_class_6.HomeWork;

import java.util.Scanner;
		
import MyUtil.Colors;
import MyUtil.Shapes;

public class MainProgram {
	public static void main(String[] args) {
		
		// define Scanner
		Scanner sc = new Scanner(System.in);
		while(true) {			
			// get userName : only recognize user using name <= too danger
			System.out.print("성함을 입력하여 주세요: ");
			String userName = sc.next();
			System.out.println("안녕하세요! "+Shapes.S_BOLD+userName+Shapes.END+"님! 현재 자리예약 상황입니다. \n");
			
			// start program with printing Seats status
			Seats.seatStatusReport(userName);
			
			if(Seats.seatRemain() == 0) {
				System.out.println("남은 좌석이 없습니다.");
				break;
			}
			
			// user choice
			int choice = 0;
			while(true) {
				System.out.print("자리를 예약하실건가요? (yes/no) - ");
				String userInput = sc.next();
				if(userInput.equalsIgnoreCase("yes")) {
					choice = 1;
				}else if(userInput.equalsIgnoreCase("no")) {
					choice = 2;
				}else continue;
				
				break;
			}
			
			if(choice == 1) {
				while(true) {
					System.out.print("열, 행을 쉼표로 구분하여 입력하여 주세요. 예) A,2 : ");
					String userInput = sc.next();
					if(userInput.matches("^[aAbB]{1}[,][1-5]{1}$")) {
						String result = Seats.reserve(userInput.split(",")[0], Integer.parseInt(userInput.split(",")[1])-1, userName);
						if(result.equalsIgnoreCase("bookingOk")) {
							System.out.println("자리예약을 성공하였습니다! "+userInput.split(",")[0]+userInput.split(",")[1]);
						}else {
							System.out.println("자리예약을 실패하였습니다.. "+userInput.split(",")[0]+userInput.split(",")[1]);
						}
					}else continue;
					Seats.seatStatusReport(userName);
					break;
				}
				
			}else if(choice == 2) {
				System.out.println("bye");
			}else {
				System.out.println("ERR.VAR.CHOICE");
				return;
			}
		}
		
	}
}
