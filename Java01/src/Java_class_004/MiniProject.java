package Java_class_004;

import MyUtil.Colors;
import MyUtil.Shapes;
import java.util.Random;
import java.util.Scanner;

public class MiniProject {
	/*
	 * 1. 보물상자에서 무기를 5종류 중 하나 랜덤으로 획득한다
	 * 2. 길을 가다가 늑대, 산적, 드래곤 중 하느를 만단다.
	 * 3. 무기를 가지고 둘 중 하나의 에너지가 0이하가 될 때까지 싸운다.
	 * 4. 승리 또는 패배에 따라 메시지를 출력한다
	 */
	

	public static void main(String[] args) {
//		String[] str = {"a", "b", "c"};
//		int a = getArrayLength(str);
//		System.out.println("Array str의 element 개수는 "+a+"개 입니다");
		
		// 1-1. 게임 시작을 알려준다
		Colors.p("운명의 데스티니 게임 start", 25);
		
		// define Random and Scanner
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		// just chat
		System.out.println(Colors.CYAN+"그냥 걷는중..."+Colors.END);
		System.out.println("\"어? 이게 뭐지?\"");
		System.out.println();
		
		// 1-2. 보물상자를 발견했다는 메시지를 출력하고 아무키 + 엔터를 기다린다.
		System.out.println(Shapes.S_SQUARE+Colors.YELLOW+"보물상자를 발견했다!"+Colors.END);
		
		
		// 1-3. 보물상자에서 랜덤으로 1개의 무기를 획득한다.
		//	각 무기는 무기이름, 최소데미지, 최대 데미지를 가짐
		
		// set weapon info using 2-d array
		String[][] weapon = {{"휴지", "1", "3"}, {"목검", "3", "5"}, {"대검", "5", "10"}, {"대포", "0", "50"}, {"에픽밸붕검", "50", "100"}};
		// get weapon array using Random
		String[] my_weapon = weapon[rd.nextInt(5)];
		// just chat
		System.out.println("\"보물상자다! 열어보도롤 하자\" "+Colors.CYAN+"-아무키나 입력 후 ENTER를 눌러 열기-"+Colors.END);
		// wait until user skip
		sc.next();
		System.out.println();
		// just chat
		System.out.println(Colors.CYAN+"뒤적뒤적..."+Colors.END);
		// notice weapon name
		System.out.println("보물상자를 열어보니 "+Colors.BLUE+my_weapon[0]+Colors.END+"(이)가 있었다! 뭔가 필요할 것 같아 주머니에 넣어두었다");
		
		System.out.println();
		// just chat
		System.out.println(Colors.CYAN+"다시 걷는중...\n"+Colors.END);
		
		// set monster info using 2-d array
		String[][] monster = {{"늑대", "1", "3"}, {"산적", "5", "10"}, {"드래곤", "1", "100"}};
		// get monster array using Random
		String[] my_monster = monster[rd.nextInt(3)];
		// notice monster info and my weapon info
		System.out.println("어쩐지! 필요할 것 같더라! 몬스터 "+Colors.RED+my_monster[0]+Colors.END+"을(를) 만났다! 왠지 "+my_monster[1]+"부터 "+my_monster[2]+"까지의 공격력을 가졌을 것 같다! \n(나는 "+my_weapon[1]+"부터 "+my_weapon[2]+"까지인데...)");
		
		// set default hp
		float[] hp = {100.0f, 100.0f};
		
		// just chat and wait for user skip
		System.out.println("싸움을 시작하도록 하자 "+Colors.CYAN+"-아무키나 입력 후 ENTER를 눌러 다음으로-"+Colors.END);
		sc.next();
		
		// define critical
		float critical = 0.0f;
		// define damage
		float[] gotdam = {0.0f, 0.0f};
		while (true) {
			//user part
			{
				
				// 3. 공격, 회복 선택. 회복이라면 0~30사이를 회복한다.
				// define choice
				int choice = 1;
				while(true) {
					for(int i=0;i<15;i++) {
						System.out.println();
					}
					// get user choice attack/heal
					System.out.print("공격할거면 1를 회복할 거면 2를 입력해주세요: ");
					choice = sc.nextInt();
					System.out.println();
					// check input is ok
					if (choice == 1 || choice == 2) {
						break;
					}else {
						continue;
					}
				}
				for(int i=0;i<15;i++) {
					System.out.println();
				}
				// if user decide to attack monster
				if (choice == 1) {
					// make critical ratio
					critical = rd.nextFloat()*100;
					// get damage for monter
					gotdam = cal_damage(my_weapon[1], my_weapon[2], critical);
					// monster: noooooo!!!!!
					hp[1] -= gotdam[0];
					// if monster's hp is lower than 0, set monster hp to zero
					if (hp[1] < 0) {
						hp[1] = 0;
					};
					// if gotdam[1](if critical) is 1.0f, notice critical damage and monster hp 
					if(gotdam[1] == 1.0f) {
						System.out.println(Colors.RED+"크리티컬"+Colors.END+"이 들어갔다!");
						System.out.println(Colors.CYAN+my_weapon[0]+Colors.END+"으로 "+Colors.RED+Shapes.S_BOLD+gotdam[0]+Colors.END+"만큼의 데미지를 입혔다. \n"+my_monster[0]+"의 에너지가 "+hp[1]+"만큼 남았다 "+Colors.CYAN+"-아무키나 입력 후 ENTER를 눌러 다음으로-"+Colors.END);
					}else {
						// if nomal attack, just notice damage and monster's hp
						System.out.println("일반 공격이다. "+Colors.CYAN+my_weapon[0]+Colors.END+"으로 "+Colors.CYAN+gotdam[0]+Colors.END+"만큼의 피해를 입혔다. \n"+my_monster[0]+"의 에너지가 "+hp[1]+"만큼 남았다 "+Colors.CYAN+"-아무키나 입력 후 ENTER를 눌러 다음으로-"+Colors.END);
					}
					bar((int)hp[0], (int)hp[1]);
					// if monster dead, break.
					if (hp[1] == 0) break;
					// wait for user skip
					sc.next();
				}else {
					// if user decided to heal
					
					for(int i=0;i<15;i++) {
						System.out.println();
					}
					
					// get number to heal
					int heal = rd.nextInt(31);
					// heal
					hp[0] += heal;
					// if healed user hp is over than 100, set user hp to 100
					if (hp[0] > 100) {
						hp[0] = 100;
					}
					// notice uesr hp and heal amount
					System.out.println("당신은 "+heal+"만큼 회복하여 "+hp[0]+"만큼의 에너지를 가지게 되었다! "+Colors.CYAN+"-아무키나 입력 후 ENTER를 눌러 다음으로-"+Colors.END);
					bar((int)hp[0], (int)hp[1]);
					sc.next();
				}
				
			}
			//monster
			{
				for(int i=0;i<15;i++) {
					System.out.println();
				}
				// set critical to 0 (prevent many critical)
				critical = 0.0f;
				// get damage for user
				gotdam = cal_damage(my_monster[1], my_monster[2], critical);
				// user: ahhhhhhh!!!!!!
				hp[0] -= gotdam[0];
				// if user hp is lower than 0, set user hp to 0
				if (hp[0] < 0) {
					hp[0] = 0;
				};
				// if critical(?)
				if(gotdam[1] == 1.0f) {
					// amazing! 1 in 1000000 percent critical
					System.out.println("10000000분에 1의 확율을 뚫고 "+Colors.RED+"크리티컬"+Colors.END+"이 들어왔다!");
					// KILL USER!!
					System.out.println("적의 엄청난 "+Colors.YELLOW+"운빨"+Colors.END+"에 의해 당신은 "+Colors.RED+Shapes.S_BOLD+"즉사"+Colors.END+"하였다!! "+Colors.CYAN+"-아무키나 입력 후 ENTER를 눌러 다음으로-"+Colors.END);
					hp[0] = 0;
				}else {
					// just notice user hp and damage
					System.out.println("일반 공격이다. "+Colors.RED+my_monster[0]+Colors.END+"에 의해 "+gotdam[0]+"만큼의 피해를 입었다. \n나의 에너지가 "+hp[0]+"만큼 남았다 "+Colors.CYAN+"-아무키나 입력 후 ENTER를 눌러 다음으로-"+Colors.END);
				}
				bar((int)hp[0], (int)hp[1]);
				// if user dead, break
				if (hp[0] == 0) break;
				sc.next();
			}
		}
		System.out.println();
		
		// show who win
		if (hp[0] > hp[1]) {
			// user win!
			System.out.println("\"당신 정말 강하군...\" "+my_monster[0]+"(이)가 말했습니다");
			System.out.println("\"하지만 암흑대륙에는 나보다 강한자가 "+(rd.nextInt(8000)+3000)+"명 더 있다!\"");
		}else {
			// user lose...
			System.out.println("내가 지다니....");
		}
		
		
		
	}
	
//	public static int getArrayLength(String[] args) {
//		int result = 0;
//		result = args.length;
//		return result;
//	}
	
	// calculate damage to give
	public static float[] cal_damage(String min, String max, float cri_ratio) {
		// type casting string to int
		int i_min = Integer.parseInt(min);
		int i_max = Integer.parseInt(max);
		
		// define Random
		Random rd = new Random();
		// get damage between i_min and i_max
		int damage = rd.nextInt((i_max-i_min)+1)+i_min;
		// get float to decide cri or nomal
		float cri = rd.nextFloat()*100;
		// define f_damage to calculate critical
		float f_damage = (float)damage;
		// define if_cri to know if it is cri or not
		float if_cri = 0.0f;
		// if cri
		if (cri <= cri_ratio) {
			// make damage to damage*1.5
			f_damage = damage*1.5f;
			if_cri = 1.0f;
			// 1/9999999 <== if monster
		}
		// make values to result
		float[] result = {f_damage, if_cri};
		// return
		return result;
	}
	
	// print prograss bar
	public static void bar(int user, int monster) {
		String[] progress_bar = {"[", "["};
		int[] full = {(user/5), (monster/5)};
		int[] empty = {20-full[0], 20-full[1]};
		
		for (int i=0;i<full[0];i++) {
			if (user < 30) {
				progress_bar[0] += Colors.B_RED+" "+Colors.END;
			}else {
				progress_bar[0] += Colors.B_GREEN+" "+Colors.END;
			}
			
		}
		for (int i=0;i<empty[0];i++) {
			progress_bar[0] += " ";
		}
		progress_bar[0] += "]";
		
		for (int i=0;i<full[1];i++) {
			if (monster < 30) {
				progress_bar[1] += Colors.B_RED+" "+Colors.END;
			}else {
				progress_bar[1] += Colors.B_GREEN+" "+Colors.END;
			}
		}
		for (int i=0;i<empty[1];i++) {
			progress_bar[1] += " ";
		}
		progress_bar[1] += "]";
		
		String str = "나: "+progress_bar[0]+" "+user+"hp\n"+"적: "+progress_bar[1]+" "+monster+"hp";
		System.out.println(str);
	}// 

}
