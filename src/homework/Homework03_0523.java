package homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Homework03_0523 {
	private Scanner sc = new Scanner(System.in);
	private Map<String, HotelVO> hotelMap = new HashMap<String, HotelVO>();
	
	public static void main(String[] args) {
		Homework03_0523 obj = new Homework03_0523();
		obj.hotelOpen();
	}

	public void hotelOpen() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		System.out.println();
		
		while (true) {
			menu();
			int sel = sc.nextInt();
			sc.nextLine();

			switch (sel) {
			case 1 : checkIn();		
				break;
			case 2 : checkOut();		
				break;
			case 3 : roomState();		
				break;
			case 4 : hotelClose();	
				return;
			default :
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
			}
		}
	}


	private void hotelClose() {
		System.out.println();
		System.out.println("**************************");
		System.out.println("호텔 문을 닫았습니다.");
		System.out.println("**************************");
	}

	private void roomState() {
		Set<String> guestList = hotelMap.keySet();
		
		System.out.println();
		if (guestList.size() == 0) {
			System.out.println("투숙객이 없습니다.");
		} else {
			Iterator<String> list = guestList.iterator();
			
			while (list.hasNext()) {
				String room = list.next();
				String name = hotelMap.get(room).getName();
				System.out.println("방번호 : " + room + ", 투숙객 : " + name);
			}
			System.out.println();
		}
		
	}

	private void checkOut() {
		System.out.println();
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.println("방번호 입력 => ");
		String room = sc.nextLine();
		
		
		if (!hotelMap.containsKey(room)) {
			System.out.println(room + "번방에는 체크인한 사람이 없습니다.");
			System.out.println();
			return;
		}
		else if (hotelMap.containsKey(room)) {
			hotelMap.remove(room);
			System.out.println("체크아웃 되었습니다.");
			System.out.println();
		}
		
	}

	private void checkIn() {
		System.out.println();
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.println("방번호 입력 => ");
		String room = sc.nextLine();
		
		if (hotelMap.containsKey(room)) {
			System.out.println(room + "번방에는 이미 사람이 있습니다.");
			System.out.println();
			return;
		}
		else if (!hotelMap.containsKey(room)) {
			System.out.println();
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.println("이름 입력 => ");
			String name = sc.nextLine();

			hotelMap.put(room, new HotelVO(room, name));
			System.out.println("체크인 되었습니다.");
			System.out.println();
		} 
		
	}

	public void menu() {
		System.out.println("*******************************************");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
		System.out.println("*******************************************");
		System.out.print("메뉴선택 => ");
	}

	
}

class HotelVO {
	private String room;
	private String name;
	/**
	 * @param room
	 * @param name
	 */
	public HotelVO(String room, String name) {
		super();
		this.room = room;
		this.name = name;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "HotelVO [room=" + room + ", name=" + name + "]";
	}
}
