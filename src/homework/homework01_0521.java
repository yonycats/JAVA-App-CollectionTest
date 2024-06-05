package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Homework01_0521 {
	public static void main(String[] args) {
		
		/*
		학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는
		  Student클래스를 만든다.
		  생성자는 학번, 이름, 국어, 영어, 수학 점수만 매개변수로 받아서 처리한다.
		  // 학번은 문자로 정의할 것 (String)
		  
		  이 Student객체들은 List에 저장하여 관리한다.
		  List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과
		  총점의 역순으로 정렬하는 부분을 프로그램 하시오.
		  (총점이 같으면 학번의 내림차순으로 정렬되도록 한다.) => 총점이 같은 값 추가해놓기
		  (학번 정렬기준은 Student클래스 자체에서 제공하도록 하고, => Comparable 사용
		   총점 정렬기준은 외부클래스에서 제공하도록 한다.) => Comparator 사용
		*/
		
		List<Student> strData = new ArrayList<Student>();
		
		strData.add(new Student("F001", "양요섭", 50, 70, 50)); // 총점 170
		strData.add(new Student("C001", "윤두준", 80, 50, 70)); // 총점 200
		strData.add(new Student("A001", "이기광", 70, 60, 30)); // 총점 160
		strData.add(new Student("E001", "손동운", 40, 90, 70)); // 총점 200
		strData.add(new Student("D001", "이도현", 60, 80, 60)); // 총점 200
		strData.add(new Student("B001", "유재석", 50, 70, 70)); // 총점 190
		
		
		
		// 학번의 오름차순으로 정렬하여 출력
		// (학번 정렬기준은 Student클래스 자체에서 제공)
		Collections.sort(strData);
		
		System.out.println("학번순으로 출력");
		for (Student student : strData) {
			System.out.println(student);
		}
		System.out.println("=================================================");
		
		
		
		// 총점의 역순으로 정렬 (총점이 같으면 학번의 내림차순으로 정렬)
		// (총점 정렬기준은 외부클래스에서 제공)
		Collections.sort(strData, new SortRankDesc());
		
		System.out.println("총점의 역순으로 출력(총점이 같으면 학번의 내림차순으로)");
		for (Student student : strData) {
			System.out.println(student);
		}
		System.out.println("=================================================");
		
		
	
		// 등수 매기기 (같은 점수는 같은 등수)
		int rankNum = 1;
        for (int i = 0; i < strData.size(); i++) {
            if (i!=0 && strData.get(i).getSumScore() < strData.get(i - 1).getSumScore()) {
            	rankNum = i + 1;
            }
            strData.get(i).setRank(rankNum);
        }
        
		System.out.println("등수 매기기 (같은 점수는 같은 등수)");
		for (Student student : strData) {
			System.out.println(student);
		}
		System.out.println("=================================================");
		
	}
	
}

class Student implements Comparable<Student> {

	String strNum;
	String name;
	int korScore;
	int engScore;
	int mathScore;
	int sumScore;
	int rank;
	

	public Student(String strNum, String name, int korScore, int engScore, int mathScore) {
		super();
		this.strNum = strNum;
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
		sumScore = korScore+engScore+mathScore;
	}

	public String getStrNum() {
		return strNum;
	}

	public void setStrNum(String strNum) {
		this.strNum = strNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	public int getSumScore() {
		return sumScore;
	}
	
	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [strNum=" + strNum + ", name=" + name + ", korScore=" + korScore + ", engScore=" + engScore
				+ ", mathScore=" + mathScore + ", sumScore=" + sumScore + ", rank=" + rank + "]";
	}

	
	// 학번의 오름차순으로 정렬하여 출력
	// (학번 정렬기준은 Student클래스 자체에서 제공)
	@Override
	public int compareTo(Student o) {
		return getStrNum().compareTo(o.getStrNum());
	}

}


// 총점의 역순으로 정렬 (총점이 같으면 학번의 내림차순으로 정렬)
// (총점 정렬기준은 외부클래스에서 제공)
class SortRankDesc implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		
		if(o1.getSumScore() > o2.getSumScore()) {
			return -1;
		} else if(o1.getSumScore() == o2.getSumScore()) {
			return o1.getStrNum().compareTo(o2.getStrNum())*-1;
		} else return 1;
	}
	
}