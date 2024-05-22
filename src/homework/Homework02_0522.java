package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Homework02_0522 {
	/*
 로또를 구매하는 프로그램 작성하기
 
 사용자는 로또를 구매할 때 구매할 금액을 입력하고
 입력한 금액에 맞게 로또번호를 출력한다.
 (단, 로또 한장의 금액은 1000원이고 거스름돈도 계산하여
      출력한다.)

	==========================
         Lotto 프로그램
	--------------------------
	 1. Lotto 구입
	 2. 프로그램 종료
	==========================		 
	메뉴선택 : 1  <-- 입력
			
	 Lotto 구입 시작
		 
	(1000원에 로또번호 하나입니다.)
	금액 입력 : 2500  <-- 입력
			
	행운의 로또번호는 아래와 같습니다.
	로또번호1 : 2,3,4,5,6,7
	로또번호2 : 20,21,22,23,24,25
			
	받은 금액은 2500원이고 거스름돈은 500원입니다.
			
   	 ==========================
         Lotto 프로그램
	--------------------------
	  1. Lotto 구입
	  2. 프로그램 종료
	==========================		 
	메뉴선택 : 2  <-- 입력
		
	감사합니다 
*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("==========================");
			System.out.println("     Lotto 프로그램");
			System.out.println("--------------------------");
			System.out.println(" 1. Lotto 구입");
			System.out.println(" 2. 프로그램 종료");
			System.out.println("==========================");
			System.out.println("메뉴 선택 : ");

			int sel = sc.nextInt();

			if (sel==1) {
				System.out.println("Lotto 구입 시작");
				System.out.println("(1000원에 로또번호 하나입니다.)");
				System.out.println("금액입력 : ");
				
				sel = sc.nextInt();
				int money = sel;
				
				// 로또에 중복 값이 들어가면 안되므로, 중복을 허용하지 않는 Set을 사용
				List<Set> lottoList = new ArrayList<Set>();
				
				while (money >= 1000) {
					Set<Integer> lotto = new TreeSet<Integer>();
					while(lotto.size() < 6) {
						int num = (int) (Math.random()*45+1);
						lotto.add(num);
					}
					lottoList.add(lotto);
					money = money-1000;
				}

				for (int i=0; i<lottoList.size();i++) {
					for (int j = 0; j < lottoList.size();i++) {
						System.out.println("로또번호 "+(++j)+" : " + lottoList.get(i));
					}
				}
				System.out.println();
				System.out.println("받은 금액은 " + sel + "원이고, 거스름돈은 " + money + "원 입니다.");
				System.out.println();

			} else if (sel==2) {
				System.out.println();
				System.out.println("감사합니다.");
				break;
			}
		}
		
	}
}
