package global.sesec.person.ui;

import java.util.ArrayList;
import java.util.Scanner;

import global.sesec.person.dao.PersonDAO;
import global.sesec.person.vo.Person;

public class PersonMain {

	public static void main(String[] args) {
		//DB관련 처리를 담당하는 클래스의 객체 생성
		PersonDAO dao = new PersonDAO();
		
		//DAO객체의 메소드를 이용하여 데이터 처리
		
		//검색할 회원의 번호를 입력받는다
		//검색한다
		//결과가 없으면 "해당 번호의 회원이 없습니다." 라고 출력
		//결과가 있으면 "번호 : 1 이름 : 홍길동  나이: 20" 형식으로 출력
		Scanner scan = new Scanner(System.in);
/*		System.out.print("검색할 회원 번호 : ");
		int num = scan.nextInt();
		
		Person p = dao.selectPerson(num);
		if (p == null) {
			System.out.println("회원이 없습니다.");
		}
		else {
			System.out.print("번호:" + p.getNum() + " ");
			System.out.print("이름:" + p.getName() + " ");
			System.out.println("나이:" + p.getAge());
		}*/
		
		System.out.print("검색할 이름 : ");
		String name = scan.next();
		
		ArrayList<Person> list = dao.selectPersonByName(name);
		
		if () {
			System.out.println("해당되는 회원이 없습니다.");
		}
		else {
			System.out.println(list);
		}
		
		
		
		
		
		
		
		
		
//		Person pe;
//		pe = new Person();
//		pe.setNum(2);
//		pe.setAge(20);
//		
//		int n = dao.updatePerson(pe);
//		if (n != 0) {
//			System.out.println("수정되었습니다.");
//		}
//		else {
//			System.out.println("해당 회원이 없습니다.");
//		}

	}

}

