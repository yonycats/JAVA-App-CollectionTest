package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T01ArrayListTest {
	public static void main(String[] args) {
		
		// Default Capacity = 10
		List<Object> list1 = new ArrayList<Object>();
		
		// add() 메서드를 사용하여 데이터를 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);
		list1.add('k');
		list1.add(true);
		list1.add(12.34);
		
		// size() => 데이터 갯수
		System.out.println("size => " + list1.size());
		System.out.println("list1 => " + list1);
		
		// get() 으로 데이터 가져오기
		System.out.println("1번째 데이터 : " + list1.get(0));
		
		// 데이터 끼워넣기
		list1.add(0, "zzz");
		System.out.println("zzz 끼워넣기 후 : " + list1);
		
		// 데이터 변경하기
		String temp = (String)list1.set(0, "YYY");
		System.out.println("temp : " + temp);
		System.out.println("첫번째 데이터를 YYY로 데이터를 변경한 후 : " +list1);
		
		// 데이터 삭제하기
		list1.remove(0);
		System.out.println("첫번째 데이터 삭제 후 : " + list1);
		
		list1.remove("bbb");
		System.out.println("bbb 데이터 삭제 후 : " + list1);
		System.out.println("-----------------------------------");
		
	}
}
