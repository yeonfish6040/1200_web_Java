package Java_class_5;

import java.util.Random;
import java.util.Scanner;

public class Day05_20min {

	public static void main(String[] args) throws InterruptedException {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		Department dm = new Department("강남점");
		dm.setAmt(3000);
		dm.setVisitors(300);
		
		// 10번 try 매출액은 -1000~2000, 방문 고객은 -100~200사이로
		// 각 try 마다 오픈상태와 현재의 맥출액, 방문고객을 출력
		// 오픈상태가 false이면 매출액과 방문고객 대신, "망했음"을 출력한다
		int rAmt, rVisitors;
		for(int i=0;i<10;i++) {
			rAmt = (rd.nextInt(3000)+1)-1000;
			rVisitors = (rd.nextInt(300)+1)-100;
			dm.addAmt(rAmt);
			dm.addVisitors(rVisitors);
			if (!dm.isOpen()) {
				for(int j=0;j<15;j++) {
					System.out.println();
				}
				System.out.println("망함");
				break;
			}
			for(int j=0;j<15;j++) {
				System.out.println();
			}
			System.out.println("상태: 오픈\n"+"매출액: "+dm.getAmt()+"\n"+"방문객: "+dm.getVisitors());
			Thread.sleep(100);
		}
	}

}

class Department {
	/* 1. name: 지점 이름. 생성시 지정 가능
	 * 2. pran_name: 백화점의 이름. 수정 불가능. 최초에 지정되어 있음 "신세계"
	 * 3. amt: 매출액. 초기값은 0. 직접 수정 불가능.
	 * 4. visitors: 방문고객수, 초기값은 0. 직접 수정 불가능
	 * 5. open_a: 현재 지점의 오픈 상태(True, False)
	 * 6. open_b: 전체 지점의 오픈 지침(True, False)
	 */
	
	// Field Declaration
	String name;
	final String pran_name = "신세계";
	private int amt = 0;
	private int visitors = 0;
	boolean open_a = true;
	static boolean open_b = true;
	Department(String name) {
		this.name = name;
	}
	
	// isOpen : a와 b가 모두 true 일때만 true
	public boolean isOpen() {
		if (open_a&&open_b) return true;
		else return false;
	}
	
	// setAmt(int amt): 현재의 amt를 세팅한다
	public void setAmt(int amt) {
		this.amt = amt;
	}
	
	// setVisitors(int visitors) 현재의 visitors를 세팅한다
	public void setVisitors(int visitors) {
		this.visitors = visitors;
	}
	
	// get amt or visitors
	public int getAmt() { return amt; }
	public int getVisitors() { return visitors; }
	
	// addAmt, amt가 음수라면 open_a를 false로 전환한다
	public void addAmt(int amt) {
		this.amt += amt;
		if (this.amt < 0) open_a = false;
	}
	
	// addVisitors
	public void addVisitors(int visitors) {
		this.visitors += visitors;
		if (this.visitors < 0) open_b = false;
	}
	
}