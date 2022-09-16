package Java_class_006.HomeWork;

import java.util.stream.IntStream;

import MyUtil.Colors;
import MyUtil.Shapes;

public class Seats {
	// seatData[0] = row a
	// seatData[1] = row b
	// seatData[0][0] = row a column 1st
	// seatData[0][1] = row a column 2nd
	// ...
	// seatData[0][0][0] = a-1 seat book status
	// seatData[0][0][1] = a-1 seat booker name
	static String[][][] seatData = { 
			{ 
				{"0", "none"}, 
				{"0", "none"}, 
				{"0", "none"}, 
				{"0", "none"}, 
				{"0", "none"} 
			},{ 
				{"0", "none"}, 
				{"0", "none"}, 
				{"0", "none"}, 
				{"0", "none"}, 
				{"0", "none"} 
			} 
		};
	
	static int price = 10000;
	
	static char row;
	
	static int seatRemain() {
		int empty_seats = 0;
		for(String[][] i:seatData) {
			for(String[] j:i) {
				if(j[0] == "0") {
					empty_seats++;
				}
			}
		}
		if (empty_seats < 10) {
			if (empty_seats == 1) price = 100000000;
			else price = 20000;
		}
		return empty_seats;
	}
	
	static String reserve(String row, int column, String booker) {
		String status = getBookStatus(booker);
		if(!status.equalsIgnoreCase("unBooked")) {
			return "alreadyBooked";
		}
		
		String data;
		if(row.equalsIgnoreCase("a")) {
			if(seatData[0][column][0] == "0") {
				data = "bookingOk";
				seatData[0][column][0] = "1";
				seatData[0][column][1] = booker;
			}else {
				data = "alreadyBooked";
			}
		}else {
			if(seatData[1][column][0] == "0") {
				data = "bookingOk";
				seatData[1][column][0] = "1";
				seatData[1][column][1] = booker;
			}else {
				data = "alreadyBooked";
			}
		}
		
		return data;
	}
	
	static String getBookStatus(String name) {
		String userBookSeat = "unBooked";
		for(int i=0;i<2;i++) {
			for(int j=0;j<5;j++) {
				if(seatData[i][j][1] == name) {
					if(i == 0) row = 'A';
					else row = 'B';
					userBookSeat = row+String.valueOf(j+1); 
				}
			}
		}
		return userBookSeat;
		
	}
	
	static void seatStatusReport(String name) {
		int seatsleft = seatRemain();
		int seatsbooked = 10-seatsleft;
		String bookedSeat = getBookStatus(name);
		System.out.println("남은 좌석: "+seatsleft+", 예약된 좌석: "+seatsbooked+", 표 값: "+price);
		if(bookedSeat != "unBooked") {
			System.out.println("예약한 좌석: "+bookedSeat);
		}else {
			System.out.println("좌석을 예약하지 않음");
		}
		printPicture();
		
	}
	
	static void printPicture() {
		String seatDataShow = "";
		for(String[][] i:seatData) {
			for(String[] j:i) {
				if(j[0] == "0") {
					seatDataShow += "!";
				}else {
					seatDataShow += "@";
				}
			}
			seatDataShow += "%";
		}
		seatDataShow = seatDataShow.substring(0, seatDataShow.length()-1);
		String[] pictureTemp = seatDataShow.split("%");
		String[] pictureA = pictureTemp[0].split("");
		String[] pictureB = pictureTemp[1].split("");
		int i = 0;
		for (String t:pictureA) {
			pictureA[i] = t.replace("!", Colors.GREEN+"O"+Colors.END).replace("@", Colors.RED+"X"+Colors.END);
			i++;
		}
		i = 0;
		for (String t:pictureB) {
			pictureB[i] = t.replace("!", Colors.GREEN+"O"+Colors.END).replace("@", Colors.RED+"X"+Colors.END);
			i++;
		}
		System.out.println(Colors.YELLOW+Shapes.S_SQUARE+"  무대  "+Colors.END+"\n\n  A B");
		i = 0;
		for(String f:pictureA) {
			System.out.println((i+1)+" "+pictureA[i]+" "+pictureB[i]);
			i++;
		}
	}
	
}
